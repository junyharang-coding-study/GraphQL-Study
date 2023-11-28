import { Seeder } from "typeorm-extension";
import { DataSource } from "typeorm";
import { PeopleEntity } from "../../app/people/model/entities/people.entity";
import { Role } from "../../common/enum/people.role.enum";
import { BloodType } from "../../common/enum/people.blood-type.enum";
import { Sex } from "../../common/enum/people.sex.enum";

export default class PeopleSeeder implements Seeder {
  async run(dataSource: DataSource): Promise<any> {
    const peopleRepository = dataSource.getRepository(PeopleEntity);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Alex",
        firstName: "Davidson",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 2,
        role: Role.developer,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Lindsay",
        firstName: "West",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 3,
        role: Role.designer,
        hometown: "Arizona",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(0),
        lastName: "Nathan",
        firstName: "Jenkins",
        sex: Sex.male,
        bloodType: BloodType.B,
        serveYears: 1,
        role: Role.planner,
        hometown: "Texas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Christine",
        firstName: "Harris",
        sex: Sex.female,
        bloodType: BloodType.B,
        serveYears: 2,
        role: Role.developer,
        hometown: "Ohio",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(0),
        lastName: "Page",
        firstName: "Adams",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 5,
        role: Role.developer,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Herbert",
        firstName: "Ford",
        sex: Sex.male,
        bloodType: BloodType.A,
        serveYears: 2,
        role: Role.designer,
        hometown: "Messachusetts",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Dennis",
        firstName: "Marshall",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 1,
        role: Role.planner,
        hometown: "Colorado",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Isabella",
        firstName: "Martin",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 3,
        role: Role.developer,
        hometown: "Georgia",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Alfred",
        firstName: "Clarke",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 4,
        role: Role.designer,
        hometown: "Pennsylvania",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Tyler",
        firstName: "Philips",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 1,
        role: Role.designer,
        hometown: "Virginia",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Noelle",
        firstName: "Holmes",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 5,
        role: Role.planner,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Kate",
        firstName: "Owen",
        sex: Sex.female,
        bloodType: BloodType.B,
        serveYears: 2,
        role: Role.developer,
        hometown: "Maine",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Priscilla",
        firstName: "Walker",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 2,
        role: Role.developer,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Shirley",
        firstName: "Grant",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 1,
        role: Role.developer,
        hometown: "Messachusetts",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Byron",
        firstName: "Barnes",
        sex: Sex.male,
        bloodType: BloodType.A,
        serveYears: 3,
        role: Role.designer,
        hometown: "Idaho",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Toby",
        firstName: "Lewis",
        sex: Sex.male,
        bloodType: BloodType.A,
        serveYears: 1,
        role: Role.planner,
        hometown: "New York",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Barbara",
        firstName: "White",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 4,
        role: Role.developer,
        hometown: "Ohio",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Arnold",
        firstName: "Armstrong",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 5,
        role: Role.designer,
        hometown: "Nevada",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Eleanor",
        firstName: "Smith",
        sex: Sex.female,
        bloodType: BloodType.B,
        serveYears: 2,
        role: Role.planner,
        hometown: "Texas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Nina",
        firstName: "Dawson",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 1,
        role: Role.developer,
        hometown: "Virginia",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Jamie",
        firstName: "Reynolds",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 1,
        role: Role.designer,
        hometown: "Arizona",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Myrtle",
        firstName: "Hamilton",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 1,
        role: Role.developer,
        hometown: "Maine",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Zelda",
        firstName: "Hall",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 3,
        role: Role.developer,
        hometown: "Tennessee",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Edgar",
        firstName: "Willson",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 2,
        role: Role.designer,
        hometown: "Texas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Naomi",
        firstName: "Taylor",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 5,
        role: Role.developer,
        hometown: "Oklahoma",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Brian",
        firstName: "Hunt",
        sex: Sex.male,
        bloodType: BloodType.B,
        serveYears: 2,
        role: Role.planner,
        hometown: "Indiana",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Katherine",
        firstName: "Bennett",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 3,
        role: Role.designer,
        hometown: "Utah",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Violet",
        firstName: "Pearson",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 5,
        role: Role.designer,
        hometown: "Pennsylvania",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Margaret",
        firstName: "Davies",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 2,
        role: Role.developer,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Raymond",
        firstName: "Cook",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 1,
        role: Role.planner,
        hometown: "Kansas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Garth",
        firstName: "Roberts",
        sex: Sex.male,
        bloodType: BloodType.A,
        serveYears: 4,
        role: Role.designer,
        hometown: "Minnesota",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Victoria",
        firstName: "Brown",
        sex: Sex.female,
        bloodType: BloodType.B,
        serveYears: 4,
        role: Role.planner,
        hometown: "Georgia",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Russel",
        firstName: "Jones",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 2,
        role: Role.designer,
        hometown: "Nebraska",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Sally",
        firstName: "Fox",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 5,
        role: Role.planner,
        hometown: "Messachusetts",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Chloe",
        firstName: "Bailey",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 5,
        role: Role.developer,
        hometown: "New York",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Will",
        firstName: "McDonald",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 1,
        role: Role.developer,
        hometown: "Wyoming",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Grant",
        firstName: "Cole",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 4,
        role: Role.designer,
        hometown: "Pennsylvania",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Audrey",
        firstName: "Fisher",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 2,
        role: Role.designer,
        hometown: "Ohio",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Amber",
        firstName: "Russel",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 5,
        role: Role.developer,
        hometown: "Kansas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(4),
        lastName: "Peter",
        firstName: "Payne",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 3,
        role: Role.planner,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Margot",
        firstName: "Watson",
        sex: Sex.female,
        bloodType: BloodType.AB,
        serveYears: 2,
        role: Role.planner,
        hometown: "Virginia",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Nancy",
        firstName: "Brooks",
        sex: Sex.female,
        bloodType: BloodType.A,
        serveYears: 1,
        role: Role.developer,
        hometown: "California",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Oliver",
        firstName: "Simpson",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 3,
        role: Role.designer,
        hometown: "Arizona",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(3),
        lastName: "Pansy",
        firstName: "Moore",
        sex: Sex.female,
        bloodType: BloodType.B,
        serveYears: 2,
        role: Role.planner,
        hometown: "Minnesota",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Leroy",
        firstName: "Elliott",
        sex: Sex.male,
        bloodType: BloodType.AB,
        serveYears: 2,
        role: Role.developer,
        hometown: "Indiana",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(5),
        lastName: "Barbara",
        firstName: "Murphy",
        sex: Sex.female,
        bloodType: BloodType.O,
        serveYears: 1,
        role: Role.developer,
        hometown: "Texas",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(2),
        lastName: "Simon",
        firstName: "Henderson",
        sex: Sex.male,
        bloodType: BloodType.A,
        serveYears: 4,
        role: Role.designer,
        hometown: "Pennsylvania",
      },
    ]);

    await peopleRepository.insert([
      {
        team: Promise.resolve(1),
        lastName: "Ned",
        firstName: "Butler",
        sex: Sex.male,
        bloodType: BloodType.O,
        serveYears: 2,
        role: Role.planner,
        hometown: "Messachusetts",
      },
    ]);
  }
}
