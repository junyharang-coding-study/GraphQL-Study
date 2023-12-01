import { Args, Mutation, Query, Resolver } from "@nestjs/graphql";
import { Body, UsePipes, ValidationPipe } from "@nestjs/common";
import { EquipmentService } from "../service/equipment-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";

@Resolver()
export class EquipmentResolver {
  constructor(private readonly equipmentService: EquipmentService) {}

  @UsePipes(ValidationPipe)
  @Mutation(() => DefaultResponse)
  async saveForEquipment(@Args("input") @Body() equipmentRequestDto: EquipmentRequestDto): Promise<DefaultResponse<string>> {
    return this.equipmentService.saveForEquipment(equipmentRequestDto);
  }

  @UsePipes(ValidationPipe)
  @Query(() => DefaultResponse)
  async getEquipmentList(
    @Args("usedBy") usedBy: string,
    @Args("newOrUsed") newOrUsed: string,
    @Args("page") page: number,
    @Args("perPageSize") perPageSize: number,
  ): Promise<DefaultResponse<EquipmentResponseDto[]>> {
    return this.equipmentService.getEquipmentList(usedBy, newOrUsed, page, perPageSize);
  }

  @Query(() => DefaultResponse)
  async getEquipment(@Args("equipmentId") equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>> {
    return this.equipmentService.getEquipment(equipmentId);
  }

  @Mutation(() => DefaultResponse)
  async deleteEquipment(@Args("equipmentId") equipmentId: string): Promise<DefaultResponse<string>> {
    return this.equipmentService.deleteEquipment(equipmentId);
  }
}
