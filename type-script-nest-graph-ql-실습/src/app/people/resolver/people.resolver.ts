import { Args, Mutation, Query, Resolver } from "@nestjs/graphql";
import { PeopleEntity } from "../model/entities/people.entity";
import { Body, Inject, UsePipes, ValidationPipe } from "@nestjs/common";
import { PeopleService } from "../service/people-service.interface";
import { DefaultResponse } from "../../common/constant/default.response";
import { PeopleRequestDto } from "../model/dto/request/people-request.dto";
import { PeopleSearchRequestDto } from "../model/dto/request/people-search-request.dto";
import { PeopleResponseDto } from "../model/dto/response/people.response.dto";
import { PeopleUpdateRequestDto } from "../model/dto/request/people-update-request.dto";

@Resolver(() => PeopleEntity)
export class PeopleResolver {
  constructor(@Inject("PeopleService") private readonly peopleService: PeopleService) {}

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<number>)
  async savePeople(@Args("input", { type: () => PeopleRequestDto }) @Body() peopleRequestDto: PeopleRequestDto): Promise<DefaultResponse<number>> {
    return this.peopleService.savePeople(peopleRequestDto);
  }

  @Query(() => DefaultResponse<Promise<[PeopleEntity[], number]>>)
  async getPeopleList(
    @Args("peopleSearchRequestDto", { type: () => PeopleSearchRequestDto }) peopleSearchRequestDto: PeopleSearchRequestDto,
  ): Promise<DefaultResponse<PeopleResponseDto>> {
    return this.peopleService.getPeopleList(peopleSearchRequestDto);
  }

  @Query(() => DefaultResponse<PeopleResponseDto>)
  async getPeople(@Args("peopleId", { type: () => String }) peopleId: number): Promise<DefaultResponse<PeopleResponseDto>> {
    return this.peopleService.getPeople(peopleId);
  }

  @UsePipes(new ValidationPipe({ transform: true }))
  @Mutation(() => DefaultResponse<string>)
  async updatePeople(
    @Args("input", { type: () => PeopleUpdateRequestDto }) @Body() peopleUpdateRequestDto: PeopleUpdateRequestDto,
  ): Promise<DefaultResponse<number>> {
    return this.peopleService.updatePeople(peopleUpdateRequestDto);
  }

  @Mutation(() => Promise<DefaultResponse<number>>)
  async deletePeople(@Args("peopleId", { type: () => String }) peopleId: number): Promise<DefaultResponse<number>> {
    return this.peopleService.deletePeople(peopleId);
  }
}
