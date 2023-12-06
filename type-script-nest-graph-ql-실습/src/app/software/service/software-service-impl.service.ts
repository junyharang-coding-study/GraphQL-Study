import { HttpStatus, Inject, Injectable } from "@nestjs/common";
import { SoftwareService } from "./software-service.interface";
import { SoftwareEntity } from "../model/entities/software.entity";
import { Repository } from "typeorm";
import { SoftwareRepository } from "../repository/software-repository.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { SoftwareResponseDto } from "../model/dto/response/software-response.dto";
import { SoftwareSearchRequestDto } from "../model/dto/request/software-search-request.dto";
import { SoftwareRequestDto } from "../model/dto/request/software-request.dto";
import { SoftwareUpdateRequestDto } from "../model/dto/request/software-update-request.dto";
import { Page } from "../../common/constant/page";
import { InjectRepository } from "@nestjs/typeorm";

@Injectable()
export class SoftwareServiceImpl implements SoftwareService {
  constructor(
    @InjectRepository(SoftwareEntity) private readonly softwareRepository: Repository<SoftwareEntity>,
    @Inject("SoftwareQueryBuilderRepository") private readonly softwareQueryBuilderRepository: SoftwareRepository,
  ) {}

  async saveSoftware(softwareRequestDto: SoftwareRequestDto): Promise<DefaultResponse<string>> {
    if (softwareRequestDto === null) {
      return DefaultResponse.response(HttpStatus.NO_CONTENT, "Failed Create");
    }

    const softwareId = softwareRequestDto.softwareId;

    if ((await this.softwareRepository.findOne({ where: { softwareId } })) !== null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Target ID For Save is Already in the DB");
    }

    const saveSoftware = await this.softwareRepository.save(softwareRequestDto.toEntity(softwareRequestDto));

    if (saveSoftware === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
    }

    return DefaultResponse.responseWithData(HttpStatus.CREATED, "Success Create", saveSoftware.softwareId);
  }

  async getSoftwareList(
    usedBy: string,
    developedBy: string,
    description: string,
    pageNumber: number,
    perPageSize: number,
    orderBy: boolean,
  ): Promise<DefaultResponse<SoftwareResponseDto>> {
    const result = await this.softwareQueryBuilderRepository.dynamicQuerySearchAndPagingByDto(
      SoftwareSearchRequestDto.toDto(usedBy, developedBy, description, pageNumber, perPageSize, orderBy),
    );

    if (result[0].length === 0) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithPaginationAndData(
      HttpStatus.OK,
      "Success",
      new Page(
        result[0].length,
        result[1],
        result[0].map((software: SoftwareEntity) => new SoftwareResponseDto(software)),
      ),
    );
  }

  async getSoftware(softwareId: string): Promise<DefaultResponse<SoftwareResponseDto>> {
    if (softwareId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const software = await this.softwareRepository.findOne({ where: { softwareId } });

    if (software === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Data Not Found");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", new SoftwareResponseDto(software));
  }

  async updateSoftware(softwareUpdateRequestDto: SoftwareUpdateRequestDto): Promise<DefaultResponse<string>> {
    const softwareId = softwareUpdateRequestDto.softwareId;

    if (softwareId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    if ((await this.softwareRepository.findOne({ where: { softwareId } })) === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Update Target Data Not Found");
    }

    await this.softwareRepository.update(softwareId, softwareUpdateRequestDto.toEntity(softwareUpdateRequestDto));

    return DefaultResponse.responseWithData(HttpStatus.OK, "Success Update", softwareId);
  }

  async deleteSoftware(softwareId: string): Promise<DefaultResponse<string>> {
    if (softwareId === null) {
      return DefaultResponse.response(HttpStatus.BAD_REQUEST, "Bad Request");
    }

    const deleteTarget = await this.softwareRepository.findOne({ where: { softwareId } });

    if (deleteTarget === null) {
      return DefaultResponse.response(HttpStatus.NOT_FOUND, "Delete Target Data Not Found");
    }

    const deleteResult = await this.softwareRepository.delete(softwareId);

    if (deleteResult === null) {
      return DefaultResponse.response(HttpStatus.INTERNAL_SERVER_ERROR, "Delete Failed");
    }

    return DefaultResponse.responseWithData(HttpStatus.OK, "OK", softwareId);
  }
}
