import { HttpStatus, Inject, Injectable } from "@nestjs/common";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { Page } from "../../common/constant/page";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentUpdateRequestDto } from "../model/dto/request/equipment-update-request.dto";
import { EquipmentService } from "./equipment-service.interface";
import { EquipmentRepository } from "../repository/equipment-repository.interface";

@Injectable()
export class EquipmentImplService implements EquipmentService {
  constructor(@Inject("EquipmentRepository") private readonly equipmentRepository: EquipmentRepository) {}

  async saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    if (equipmentRequestDto === null) {
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

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((equipment) => new EquipmentResponseDto(equipment)),
      ),
    );
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

  async updateEquipment(equipmentUpdateRequestDto: EquipmentUpdateRequestDto): Promise<DefaultResponse<string>> {
    if (equipmentUpdateRequestDto.equipmentId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const equipment = await this.findByEquipmentId(equipmentUpdateRequestDto.equipmentId);

    if (equipment === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Update Target Not Found");
    }

    await this.equipmentRepository.updateEquipment(
      equipmentUpdateRequestDto.equipmentId,
      equipmentUpdateRequestDto.toEntity(equipmentUpdateRequestDto),
    );

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", equipment.equipmentId);
  }

  async deleteEquipment(equipmentId: string): Promise<DefaultResponse<string>> {
    if (equipmentId !== null) {
      const findByEquipmentId = await this.findByEquipmentId(equipmentId);

      if (findByEquipmentId === null) {
        return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Not Found");
      }

      const deleteResult = await this.equipmentRepository.delete({ equipmentId: equipmentId });

      if (deleteResult === null) {
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
