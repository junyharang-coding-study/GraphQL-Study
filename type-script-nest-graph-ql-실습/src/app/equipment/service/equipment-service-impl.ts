import { HttpStatus, Injectable } from "@nestjs/common";
import { EquipmentService } from "./equipment-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { validate } from "class-validator";
import { EquipmentRepository } from "../repository/equipment.repository";
import { Equipment } from "../model/entities/equipment";
import { EquipmentSearchRequestDto } from "../model/dto/request/equipment-search-request.dto";
import { EquipmentQueryBuilderRepository } from "../repository/equipment.query.builder.repository";
import { Page } from "../../common/constant/page";

@Injectable()
export class EquipmentServiceImpl implements EquipmentService {
  constructor(
    private readonly equipmentRepository: EquipmentRepository,
    private readonly equipmentQueryBuilderRepository: EquipmentQueryBuilderRepository,
  ) {}

  async saveForEquipment(equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    if (equipmentRequestDto === undefined || !equipmentRequestDto) {
      // DTO undefined
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const validationError = await validate(equipmentRequestDto);

    if (validationError.length > 0) {
      // 유효성 검사 실패 혹은
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Validation failed");
    }

    const savedEquipment = await this.equipmentRepository.save(Equipment.toEntity(equipmentRequestDto));

    if (savedEquipment.equipmentId === undefined) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", savedEquipment.equipmentId);
  }

  async getEquipmentList(usedBy: string, newOrUsed: string, page: number, perPageSize: number): Promise<DefaultResponse<EquipmentResponseDto[]>> {
    const equipmentSearchRequestDto = EquipmentSearchRequestDto.toDto(usedBy, newOrUsed, page, perPageSize);

    const result = await this.equipmentQueryBuilderRepository.dynamicQueryByDto(equipmentSearchRequestDto);

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
      const equipment = this.equipmentRepository.findByEquipmentId(equipmentId);

      if (equipment !== null) {
        return DefaultResponse.responseWithData(HttpStatus.OK, "OK", EquipmentResponseDto.toDto(await equipment));
      }

      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
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
