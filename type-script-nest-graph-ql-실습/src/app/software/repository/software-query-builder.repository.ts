import { Injectable } from "@nestjs/common";
import { SoftwareRepository } from "./software-repository.interface";
import { InjectRepository } from "@nestjs/typeorm";
import { SoftwareEntity } from "../model/entities/software.entity";
import { Repository } from "typeorm";
import { SoftwareSearchRequestDto } from "../model/dto/request/software-search-request.dto";

@Injectable()
export class SoftwareQueryBuilderRepository implements SoftwareRepository {
  constructor(@InjectRepository(SoftwareEntity) private readonly softwareRepository: Repository<SoftwareEntity>) {}

  async dynamicQuerySearchAndPagingByDto(softwareSearchRequestDto: SoftwareSearchRequestDto): Promise<[SoftwareEntity[], number]> {
    const selectQueryBuilder = this.softwareRepository
      .createQueryBuilder("software")
      .limit(softwareSearchRequestDto.getLimit())
      .offset(softwareSearchRequestDto.getOffset());

    if (softwareSearchRequestDto.usedBy) {
      selectQueryBuilder.andWhere("software.usedBy = :usedBy", { usedBy: `${softwareSearchRequestDto.usedBy}` });
    }

    if (softwareSearchRequestDto.developedBy) {
      selectQueryBuilder.andWhere("software.developedBy = :developedBy", { developedBy: `${softwareSearchRequestDto.developedBy}` });
    }

    if (softwareSearchRequestDto.description) {
      selectQueryBuilder.andWhere("software.description = :description", { description: `${softwareSearchRequestDto.description}` });
    }

    return await selectQueryBuilder.getManyAndCount();
  }
}
