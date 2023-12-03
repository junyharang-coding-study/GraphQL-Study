import { HttpStatus, Injectable, Logger } from "@nestjs/common";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { EquipmentRepository } from "../repository/equipment.repository";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { Page } from "../../common/constant/page";

@Injectable()
export class EquipmentServiceImpl {
  private logger = new Logger("equipment-service-impl.ts");
  constructor(private readonly equipmentRepository: EquipmentRepository) {}

  async saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    this.logger.log("EquipmentServiceImpl - saveForEquipment 동작");
    if (equipmentRequestDto === null || !equipmentRequestDto) {
      // DTO undefined
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    this.logger.log(`EquipmentRequestDto 타입: ${typeof EquipmentRequestDto}`);
    this.logger.log(equipmentRequestDto);

    const equipment = equipmentRequestDto.toEntity(equipmentRequestDto);

    this.logger.log(`equipment 타입: ${typeof equipment}`);
    this.logger.log(equipment);

    const savedEquipment = await this.equipmentRepository.saveEquipment(equipment);

    this.logger.log(`savedEquipment 타입: ${typeof savedEquipment}`);
    this.logger.log(savedEquipment);

    if (savedEquipment.equipmentId === undefined) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedEquipment.equipmentId);
  }

  async getEquipmentList(usedBy: string, newOrUsed: string, page: number, perPageSize: number): Promise<DefaultResponse<EquipmentResponseDto[]>> {
    this.logger.log("EquipmentServiceImpl - getEquipmentList 동작");

    const equipmentSearchRequestDto = EquipmentSearchRequestDto.toDto(usedBy, newOrUsed, page, perPageSize);

    if (equipmentSearchRequestDto === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    this.logger.log(`equipmentSearchRequestDto 값: ${typeof equipmentSearchRequestDto}`);
    console.log(equipmentSearchRequestDto);

    const result = await this.equipmentRepository.dynamicQuerySearchAndPagingByDto(equipmentSearchRequestDto);

    this.logger.log(`result 값: ${result}`);

    if (result === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(equipmentSearchRequestDto.perPageSize, result[1]),
      result[0].map((equipment) => EquipmentResponseDto.toDto(equipment)),
    );
  }

  async getEquipment(equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>> {
    if (equipmentId !== null) {
      const equipment = await this.equipmentRepository.findByEquipmentId(equipmentId);

      if (equipment !== null) {
        return DefaultResponse.responseWithData(HttpStatus.OK, "OK", EquipmentResponseDto.toDto(equipment));
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

  deleteEquipment(equipmentId: string): DefaultResponse<string> {
    if (equipmentId !== null && typeof equipmentId === "string") {
      const equipment = this.equipmentRepository.delete({ equipmentId: equipmentId });

      if (equipment !== null) {
        return DefaultResponse.responseWithData(HttpStatus.OK, "OK", equipmentId);
      }

      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
  }
}
