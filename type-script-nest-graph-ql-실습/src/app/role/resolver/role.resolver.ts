import { Args, Mutation, Query, Resolver } from "@nestjs/graphql";
import { RoleEntity } from "../model/entities/role.entity";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { RoleService } from "../service/role-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { RoleRequestDto } from "../model/dto/request/role-request.dto";
import { RoleSearchRequestDto } from "../model/dto/request/role-search-request.dto";
import { RoleResponseDto } from "../model/dto/response/role-response.dto";
import { RoleUpdateRequestDto } from "../model/dto/request/role-update-request.dto";

@Resolver(() => RoleEntity)
export class RoleResolver {
  constructor(@Inject("RoleService") private readonly roleService: RoleService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async saveRole(@Args("input", { type: () => RoleRequestDto }) @Body() roleRequestDto: RoleRequestDto): Promise<DefaultResponse<string>> {
    return this.roleService.saveRole(roleRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[RoleEntity[], number]>>)
  async getRoleList(
    @Args("roleSearchRequestDto", { type: () => RoleSearchRequestDto }) roleSearchRequestDto: RoleSearchRequestDto,
  ): Promise<DefaultResponse<RoleResponseDto>> {
    return this.roleService.getRoleList(roleSearchRequestDto);
  }

  @Query(() => DefaultResponse<RoleResponseDto>)
  async getRole(@Args("roleId", { type: () => String }) roleId: string): Promise<DefaultResponse<RoleResponseDto>> {
    return this.roleService.getRole(roleId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updateRole(
    @Args("input", { type: () => RoleUpdateRequestDto }) @Body() roleUpdateRequestDto: RoleUpdateRequestDto,
  ): Promise<DefaultResponse<string>> {
    return this.roleService.updateRole(roleUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<string>>)
  async deleteRole(@Args("roleId", { type: () => String }) roleId: string): Promise<DefaultResponse<string>> {
    return this.roleService.deleteRole(roleId);
  }
}
