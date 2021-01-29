create table account
(
    account_no bigint  not null,
    balance    integer not null,
    bank_id    integer,
    primary key (account_no)
);

create table admin
(
    username varchar(255) not null,
    password varchar(255),
    primary key (username)
);

create table admin
(
    username varchar(255) not null,
    password varchar(255),
    primary key (username)
);

create table bank
(
    id        integer not null auto_increment,
    bank_name varchar(255),
    primary key (id)
);

create table booking
(
    id                varchar(255) not null,
    flight_booking_id varchar(255),
    user_id           integer,
    primary key (id)
);

create table booking
(
    id                varchar(255) not null,
    flight_booking_id varchar(255),
    user_id           integer,
    primary key (id)
);

create table flight
(
    no             integer not null auto_increment,
    airline        varchar(255),
    business_seats integer not null,
    economy_seats  integer not null,
    model          varchar(255),
    type           varchar(255),
    primary key (no)
);

create table flight_booking
(
    id                       varchar(255) not null,
    business_seats_available integer,
    date                     date,
    economy_seats_available  integer,
    scheduled_flight_id      integer,
    primary key (id)
);

create table flight_booking
(
    id                       varchar(255) not null,
    business_seats_available integer,
    date                     date,
    economy_seats_available  integer,
    scheduled_flight_id      integer,
    primary key (id)
);

create table flight_schedule
(
    id                 integer not null auto_increment,
    arrival_time       time    not null,
    business_seat_cost integer not null,
    departure_time     time    not null,
    destination        varchar(255),
    economy_seat_cost  integer not null,
    flight_no          integer,
    fri                bit     not null,
    mon                bit     not null,
    sat                bit     not null,
    source             varchar(255),
    sun                bit     not null,
    thu                bit     not null,
    tue                bit     not null,
    wed                bit     not null,
    primary key (id)
);

create table news_feed
(
    id   integer not null auto_increment,
    date date    not null,
    news varchar(255),
    primary key (id)
);

create table passenger
(
    id         integer not null auto_increment,
    age        integer,
    booking_id varchar(255),
    gender     varchar(255),
    name       varchar(255),
    primary key (id)
);

create table user
(
    id              integer not null auto_increment,
    address         varchar(255),
    age             integer not null,
    answer          varchar(255),
    email           varchar(255),
    gender          varchar(255),
    name            varchar(20),
    password        varchar(255),
    phone           varchar(255),
    secret_question varchar(255),
    primary key (id)
);

select *
from account;