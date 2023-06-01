
-- 1. 기존 테이블 삭제
drop table if exists Resident;
drop table if exists Birth_Death_Report_Resident;
drop table if exists Family_Relationship;
drop table if exists Household;
drop table if exists Household_Movement_Address;
drop table if exists Household_Composition_Resident;
drop table if exists Certificate_Issue;
drop table if exists Users;
drop table if exists Authoroties;

-- 2. 테이블 생성
create table Resident
(
    resident_serial_number       bigint       not null  auto_increment,
    name                         varchar(100) not null,
    resident_registration_number varchar(300) not null,
    gender_code                  varchar(20)  not null,
    birth_date                   datetime     not null,
    birth_place_code             varchar(20)  not null,
    registration_base_address    varchar(500) not null,
    death_date                   datetime     null,
    death_place_code             varchar(20)  null,
    death_place_address          varchar(500) null,
    primary key (resident_serial_number)
);

create table Birth_Death_Report_Resident
(
    resident_serial_number           bigint     not null,
    birth_death_type_code            varchar(20) not null,
    report_resident_serial_number    bigint     not null,
    birth_death_report_date          date        not null,
    birth_report_qualifications_code varchar(20) null,
    death_report_qualifications_code varchar(20) null,
    email_address                    varchar(50) null,
    phone_number                     varchar(20) not null,
    primary key (resident_serial_number, birth_death_type_code)
);

create table Family_Relationship
(
    base_resident_serial_number   bigint     not null,
    family_resident_serial_number bigint     not null,
    family_relationship_code      varchar(20) not null,
    primary key (base_resident_serial_number, family_resident_serial_number)
);

create table Household
(
    household_serial_number           bigint      not null  auto_increment,
    household_resident_serial_number  bigint      not null,
    household_composition_date        date         not null,
    household_composition_reason_code varchar(20)  not null,
    current_house_movement_address    varchar(500) not null,
    primary key (household_serial_number)
);

create table Household_Movement_Address
(
    household_serial_number    bigint      not null,
    house_movement_report_date date         not null,
    house_movement_address     varchar(500) not null,
    last_address_yn            varchar(1)   default 'Y' not null,
    primary key (household_serial_number, house_movement_report_date)
);

create table Household_Composition_Resident
(
    household_serial_number                  bigint     not null,
    resident_serial_number                   bigint     not null,
    report_date                              date        not null,
    household_relationship_code              varchar(20) not null,
    household_composition_change_reason_code varchar(20) not null,
    primary key (household_serial_number, resident_serial_number)
);

create table Certificate_Issue
(
    certificate_confirmation_number bigint      not null   auto_increment,
    resident_serial_number          bigint         not null,
    certificate_type_code           varchar(50) not null,
    certificate_issue_date          date        not null,
    primary key (certificate_confirmation_number)
);

create table Users(
                      member_id                   VARCHAR(50)     not null,
                      name                        varchar(50)     not null,
                      pwd                         varchar(100)    not null,
                      primary key (member_id)
);

create table Authoroties(
                            member_id                   varchar(50)     not null,
                            authority                   varchar(50)     not null,
                            primary key (member_id)
);

insert into Users values('admin', '관리자', 'admin');
insert into Users values('member', '사용자', 'member');
insert into Authoroties values('admin', 'ROLE_ADMIN');
insert into Authoroties values ('member', 'ROLE_MEMBER');


-- 3. resident 테이블 데이터 추가
insert into Resident values(1, '남길동', '130914-1234561', '남', '19130914072200', '자택', '경기도 성남시 분당구 대왕판교로645번길', '20210429090300', '주택', '강원도 고성군 금강산로 290번길');
insert into Resident values(2, '남석환', '540514-1234562', '남', '19540514173000', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null);
insert into Resident values(3, '박한나', '551022-1234563', '여', '19551022111500', '병원', '서울특별시 중구 세종대로 110번길', null, null, null);
insert into Resident values(4, '남기준', '790510-1234564', '남', '19790510204500', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null);
insert into Resident values(5, '이주은', '820821-1234565', '여', '19820821012800', '병원', '경기도 수원시 팔달구 효원로 1번길', null, null, null);
insert into Resident values(6, '이선미', '851205-1234566', '여', '19851205220100', '병원', '경기도 수원시 팔달구 효원로 1번길', null, null, null);
insert into Resident values(7, '남기석', '120315-1234567', '남', '20120315145900', '병원', '경기도 성남시 분당구 대왕판교로645번길', null, null, null);

commit;


-- 4. birth_death_report_resident 테이블 데이터 추가
insert into Birth_Death_Report_Resident values (7, '출생', 4, '20120317', '부', null, 'nam@nhnad.co.kr', '010-1234-5678');
insert into Birth_Death_Report_Resident values (1, '사망', 2, '20200502', '비동거친족', null, null, '010-2345-6789');

commit;


-- 5. family_relationship 테이블 데이터 추가
insert into Family_Relationship values(1, 2, '자녀');
insert into Family_Relationship values(2, 1, '부');
insert into Family_Relationship values(2, 3, '배우자');
insert into Family_Relationship values(2, 4, '자녀');
insert into Family_Relationship values(3, 2, '배우자');
insert into Family_Relationship values(3, 4, '자녀');
insert into Family_Relationship values(4, 2, '부');
insert into Family_Relationship values(4, 3, '모');
insert into Family_Relationship values(4, 5, '배우자');
insert into Family_Relationship values(4, 7, '자녀');
insert into Family_Relationship values(5, 4, '배우자');
insert into Family_Relationship values(5, 7, '자녀');
insert into Family_Relationship values(7, 4, '부');
insert into Family_Relationship values(7, 5, '모');

commit;


-- 6. household 테이블 데이터 추가
insert into Household values(1, 4, '20091002', '세대분리', '경기도 성남시 분당구 대왕판교로 645번길');

commit;


-- 7. household_movement_address 테이블 데이터 추가
insert into Household_Movement_Address values(1, '20071031', '서울시 동작구 상도로 940번길', 'N');
insert into Household_Movement_Address values(1, '20091031', '경기도 성남시 분당구 불정로 90번길', 'N');
insert into Household_Movement_Address values(1, '20130305', '경기도 성남시 분당구 대왕판교로 645번길', 'Y');

commit;


-- 8. household_composition_resident 테이블 데이터 추가
insert into Household_Composition_Resident values(1, 4, '20091002', '본인', '세대분리');
insert into Household_Composition_Resident values(1, 5, '20100215', '배우자', '전입');
insert into Household_Composition_Resident values(1, 7, '20120317', '자녀', '출생등록');
insert into Household_Composition_Resident values(1, 6, '20151129', '동거인', '전입');

commit;


-- 9. certificate_issue 테이블 데이터 추가
insert into Certificate_Issue values(1234567891011121, 4, '가족관계증명서', '20211025');
insert into Certificate_Issue values(9876543210987654, 4, '주민등록등본', '20211025');

commit;