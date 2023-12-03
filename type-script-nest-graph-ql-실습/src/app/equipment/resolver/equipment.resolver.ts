import { Args, Int, Mutation, Query, Resolver } from "@nestjs/graphql";
import { Body, Logger, UsePipes, ValidationPipe } from "@nestjs/common";
import { DefaultResponse } from "../../common/constant/default.response";
import { EquipmentResponseDto } from "../model/dto/response/equipment.response.dto";
import { EquipmentRequestDto } from "../model/dto/request/equipment-request.dto";
import { EquipmentEntity } from "../model/entities/equipment.entity";
import { EquipmentServiceImpl } from "../service/equipment-service-impl";

@Resolver(() => EquipmentEntity)
export class EquipmentResolver {
  private log = new Logger("equipment.resolver.ts");
  constructor(private readonly equipmentService: EquipmentServiceImpl) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveForEquipment(
    @Args("input", { type: () => EquipmentRequestDto }) @Body() equipmentRequestDto: EquipmentRequestDto,
  ): Promise<DefaultResponse<string>> {
    this.log.log("saveForEquipment 동작");
    return this.equipmentService.saveForEquipment(equipmentRequestDto);
  }

  // @UsePipes(new ValidationPipe({ transform: true }))
  @Query(() => DefaultResponse<EquipmentResponseDto[]>)
  async getEquipmentList(
    @Args("usedBy", { type: () => String, nullable: true }) usedBy: string,
    @Args("newOrUsed", { type: () => String, nullable: true }) newOrUsed: string,
    @Args("page", { type: () => Int, nullable: true }) page: number,
    @Args("perPageSize", { type: () => Int, nullable: true }) perPageSize: number,
  ): Promise<DefaultResponse<EquipmentResponseDto[]>> {
    return this.equipmentService.getEquipmentList(usedBy, newOrUsed, page, perPageSize);
  }

  @Query(() => DefaultResponse<EquipmentResponseDto>)
  async getEquipment(@Args("equipmentId", { type: () => String }) equipmentId: string): Promise<DefaultResponse<EquipmentResponseDto>> {
    return this.equipmentService.getEquipment(equipmentId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateEquipment(
    @Args("input", { type: () => EquipmentRequestDto }) @Body() equipmentRequestDto: EquipmentRequestDto,
  ): Promise<DefaultResponse<string>> {
    this.log.log("updateEquipment 동작");
    return this.equipmentService.updateEquipment(equipmentRequestDto);
  }

  @Mutation(() => DefaultResponse<string>)
  async deleteEquipment(@Args("equipmentId", { type: () => String }) equipmentId: string): Promise<DefaultResponse<string>> {
    return this.equipmentService.deleteEquipment(equipmentId);
  }
}
