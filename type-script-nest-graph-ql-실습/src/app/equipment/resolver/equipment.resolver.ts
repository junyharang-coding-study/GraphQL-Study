import { Args, Int, Mutation, Query, Resolver } from "@nestjs/graphql";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentUpdateRequestDto } from "../model/dto/request/equipment-update-request.dto";
import { EquipmentService } from "../service/equipment-service.interface";

@Resolver(() => EquipmentEntity)
export class EquipmentResolver {
  constructor(@Inject("EquipmentService") private readonly equipmentService: EquipmentService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveEquipment(
    @Args("input", { type: () => EquipmentRequestDto }) @Body() equipmentRequestDto: EquipmentRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.equipmentService.saveForEquipment(equipmentRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[EquipmentEntity[], number]>>)
  async getEquipmentList(
    @Args("usedBy", { type: () => String, nullable: true }) usedBy: string,
    @Args("newOrUsed", { type: () => String, nullable: true }) newOrUsed: string,
    @Args("page", { type: () => Int, nullable: true }) page: number,
    @Args("perPageSize", { type: () => Int, nullable: true }) perPageSize: number,
    @Args("orderBy", { type: () => Boolean, nullable: true }) orderBy: boolean,
  ): Promise<DefaultResponse<EquipmentResponseDto>> {
    return this.equipmentService.getEquipmentList(usedBy, newOrUsed, page, perPageSize, orderBy);
  }

  @Query(() => DefaultResponse<EquipmentResponseDto>)
  async getEquipment(@Args("equipmentId", { type: () => String }) equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>> {
    return this.equipmentService.getEquipment(equipmentId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateEquipment(
    @Args("input", { type: () => EquipmentUpdateRequestDto }) @Body() equipmentUpdateRequestDto: EquipmentUpdateRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.equipmentService.updateEquipment(equipmentUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<string>>)
  async deleteEquipment(@Args("equipmentId", { type: () => String }) equipmentId: string): Promise<DefaultResponse<string>> {
    return this.equipmentService.deleteEquipment(equipmentId);
  }
}
