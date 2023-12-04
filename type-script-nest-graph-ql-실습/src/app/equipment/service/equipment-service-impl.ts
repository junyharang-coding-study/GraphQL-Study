import { HttpStatus, Injectable } from "@nestjs/common";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { EquipmentRepository } from "../repository/equipment.repository";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { Page } from "../../common/constant/page";
import { EquipmentEntity } from "../model/entities/equipment.entity";

@Injectable()
export class EquipmentServiceImpl {
  constructor(private readonly equipmentRepository: EquipmentRepository) {}

  async saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    if (equipmentRequestDto === null || !equipmentRequestDto) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const findByEquipmentIdEntity = await this.findByEquipmentId(equipmentRequestDto.equipmentId);

    if (findByEquipmentIdEntity !== null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Target ID For Save is Already in the DB");
    }

    const savedEquipment = await this.equipmentRepository.saveEquipment(equipmentRequestDto.toEntity(equipmentRequestDto));

    if (savedEquipment === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedEquipment.equipmentId);
  }

  async getEquipmentList(
    usedBy: string,
    newOrUsed: string,
    page: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<EquipmentResponseDto>> {
    const equipmentSearchRequestDto = EquipmentSearchRequestDto.toDto(usedBy, newOrUsed, page, perPageSize, orderBy);

    const result = await this.equipmentRepository.dynamicQuerySearchAndPagingByDto(equipmentSearchRequestDto);

    if (result.length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    const responseDtoPage = new Page(
      equipmentSearchRequestDto.perPageSize,
      result.length,
      result.map((equipment) => new EquipmentResponseDto(equipment)),
    );

    return DefaultResponse.responseWithPaginationAndData(HttpStatus.OK, "Success", responseDtoPage);
  }

  async getEquipment(equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>> {
    if (equipmentId !== null) {
      const equipment = await this.findByEquipmentId(equipmentId);

      if (equipment !== null) {
        return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new EquipmentResponseDto(equipment));
      }

      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
  }

  async updateEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    if (EquipmentRequestDto === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const findByEquipmentId = await this.equipmentRepository.findByEquipmentId(equipmentRequestDto.equipmentId);

    if (findByEquipmentId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    await this.equipmentRepository.updateEquipment(equipmentRequestDto.equipmentId, equipmentRequestDto.toEntity(equipmentRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", findByEquipmentId.equipmentId);
  }

  async deleteEquipment(equipmentId: string): Promise<DefaultResponse<string>> {
    if (equipmentId !== null && typeof equipmentId === "string" && equipmentId.length >= 1) {
      const findByEquipmentId = await this.findByEquipmentId(equipmentId);

      if (findByEquipmentId === null) {
        return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Not Found");
      }

      const equipment = await this.equipmentRepository.delete({ equipmentId: equipmentId });

      if (equipment === null) {
        return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
      }
      return DefaultResponse.responseWithData(HttpStatus.OK, "OK", equipmentId);
    }

    return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
  }

  private findByEquipmentId(equipmentId: string): Promise<EquipmentEntity> {
    return this.equipmentRepository.findByEquipmentId(equipmentId);
  }
}
