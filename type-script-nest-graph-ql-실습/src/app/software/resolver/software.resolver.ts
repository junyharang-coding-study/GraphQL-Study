import { Args, Int, Mutation, Query, Resolver } from "@nestjs/graphql";
import { SoftwareEntity } from "../model/entities/software.entity";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { SoftwareService } from "../service/software-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { RoleEntity } from "../../role/model/entities/role.entity";
import { SoftwareRequestDto } from "../model/dto/request/software-request.dto";
import { SoftwareResponseDto } from "../model/dto/response/software-response.dto";
import { SoftwareUpdateRequestDto } from "../model/dto/request/software-update-request.dto";

@Resolver(() => SoftwareEntity)
export class SoftwareResolver {
  constructor(@Inject("SoftwareService") private readonly softwareService: SoftwareService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveSoftware(
    @Args("input", { type: () => SoftwareRequestDto }) @Body() softwareRequestDto: SoftwareRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.softwareService.saveSoftware(softwareRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[RoleEntity[], number]>>)
  async getSoftwareList(
    @Args("usedBy", { type: () => String, nullable: true }) usedBy: string,
    @Args("developedBy", { type: () => String, nullable: true }) developedBy: string,
    @Args("description", { type: () => String, nullable: true }) description: string,
    @Args("pageNumber", { type: () => Int, nullable: true }) pageNumber: number,
    @Args("perPageSize", { type: () => Int, nullable: true }) perPageSize: number,
    @Args("orderBy", { type: () => Boolean, nullable: true }) orderBy: boolean,
  ): Promise<DefaultResponse<SoftwareResponseDto>> {
    return this.softwareService.getSoftwareList(usedBy, developedBy, description, pageNumber, perPageSize, orderBy);
  }

  @Query(() => DefaultResponse<SoftwareResponseDto>)
  async getSoftware(@Args("softwareId", { type: () => String }) softwareId: string): Promise<DefaultResponse<SoftwareResponseDto>> {
    return this.softwareService.getSoftware(softwareId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateSoftware(
    @Args("input", { type: () => SoftwareUpdateRequestDto }) @Body() softwareUpdateRequestDto: SoftwareUpdateRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.softwareService.updateSoftware(softwareUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<string>>)
  async deleteSoftware(@Args("softwareId", { type: () => String }) softwareId: string): Promise<DefaultResponse<string>> {
    return this.softwareService.deleteSoftware(softwareId);
  }
}
