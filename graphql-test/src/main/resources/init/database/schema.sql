drop table if exists equipments;
drop table if exists team;
drop table if exists role;
drop table if exists people;
drop table if exists software;
drop table if exists supply;

create table equipment (
    equipment_id varchar(255) not null PRIMARY KEY comment 'ID',
    used_by varchar(255) not null comment '사용자',
    count   int not null comment '수량',
    new_or_used varchar(10) not null
);

create table team (
    team_id BIGINT not null AUTO_INCREMENT PRIMARY KEY comment 'ID',
    manager varchar(255) not null comment '팀 관리자',
    office  varchar(5) not null comment '사무실 호수',
    extension_number varchar(5) not null,
    mascot varchar(10) not null,
    cleaning_duty varchar(10) not null comment '청소 당번 요일',
    project varchar(10) not null comment '프로젝트 명'
);

create table role (
    id varchar(255) not null PRIMARY KEY comment 'ID',
    job varchar(255) not null comment '구분',
    requirement  varchar(255) not null
);

create table people (
    people_id BIGINT not null AUTO_INCREMENT PRIMARY KEY comment 'ID',
    team_id BIGINT not null comment 'TEAM 번호',
    last_name varchar(255) not null comment '성',
    first_name varchar(255) not null comment '이름',
    sex varchar(6) not null comment '성별',
    blood_type varchar(2) not null comment '혈액형',
    serve_years int not null comment '경력 년수',
    role varchar(100) not null comment '역할',
    hometown varchar(255) not null comment '출신지',

    foreign key (team_id)
        references team (team_id)
);

create table software (
    software_id varchar(255) not null PRIMARY KEY comment 'ID',
    used_by varchar(255) not null comment '사용자',
    developed_by varchar(255) not null comment '개발사',
    description varchar(255) not null comment '상세 정보'
);

create table supply (
    supply_id varchar(255) not null PRIMARY KEY comment 'ID',
    team_id BIGINT not null comment 'TEAM 번호',

    foreign key (team_id)
        references team (team_id)
);

