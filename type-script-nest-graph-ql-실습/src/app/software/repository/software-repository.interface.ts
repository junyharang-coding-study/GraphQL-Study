import { SoftwareSearchRequestDto } from "../model/dto/request/software-search-request.dto";
import { SoftwareEntity } from "../model/entities/software.entity";

export interface SoftwareRepository {
  dynamicQuerySearchAndPagingByDto(softwareSearchRequestDto: SoftwareSearchRequestDto): Promise<[SoftwareEntity[], number]>;
}
