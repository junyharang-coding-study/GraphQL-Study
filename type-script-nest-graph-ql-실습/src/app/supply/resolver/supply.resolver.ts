import { Args, Int, Mutation, Query, Resolver } from "@nestjs/graphql";
import { SupplyEntity } from "../model/entities/supply.entity";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { SupplyService } from "../service/supply-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { SupplyRequestDto } from "../model/dto/request/supply-request.dto";
import { SupplySearchRequestDto } from "../model/dto/request/supply-search-request.dto";
import { SupplyUpdateRequestDto } from "../model/dto/request/supply-update-request.dto";
import { SupplyResponseDto } from "../model/dto/response/supply-response.dto";

@Resolver(() => SupplyEntity)
export class SupplyResolver {
  constructor(@Inject("SupplyService") private readonly supplyService: SupplyService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveSupply(@Args("input", { type: () => SupplyRequestDto }) @Body() supplyRequestDto: SupplyRequestDto): Promise<DefaultResponse<string>> {
    return this.supplyService.saveSupply(supplyRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[SupplyEntity[], number]>>)
  async getSupplyList(
    @Args("teamId", { type: () => String, nullable: true }) teamId: number,
    @Args("pageNumber", { type: () => Int, nullable: true }) pageNumber: number,
    @Args("perPageSize", { type: () => Int, nullable: true }) perPageSize: number,
    @Args("orderBy", { type: () => Boolean, nullable: true }) orderBy: boolean,
  ): Promise<DefaultResponse<SupplyResponseDto>> {
    return this.supplyService.getSupplyList(teamId, pageNumber, perPageSize, orderBy);
  }

  @Query(() => DefaultResponse<SupplyResponseDto>)
  async getSupply(@Args("supplyId", { type: () => String }) supplyId: string): Promise<DefaultResponse<SupplyResponseDto>> {
    return this.supplyService.getSupply(supplyId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateSupply(
    @Args("input", { type: () => SupplyUpdateRequestDto }) @Body() supplyUpdateRequestDto: SupplyUpdateRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.supplyService.updateSupply(supplyUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<number>>)
  async deleteSupply(@Args("supplyId", { type: () => String }) supplyId: string): Promise<DefaultResponse<string>> {
    return this.supplyService.deleteSupply(supplyId);
  }
}
