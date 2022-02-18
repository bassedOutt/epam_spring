drop table if exists hibernate_sequence;
drop table if exists movie;
drop table if exists pricing;
drop table if exists seat;
drop table if exists session;
drop table if exists ticket;
drop table if exists user;
create table hibernate_sequence
(
    next_val bigint
) engine=InnoDB;
insert into hibernate_sequence
values (1);
create table movie
(
    id             bigint       not null,
    duration       integer      not null,
    en_description varchar(255),
    en_title       varchar(255) not null,
    image_url      varchar(255) not null,
    price          integer      not null,
    release_date   date,
    ua_description varchar(255),
    ua_title       varchar(255),
    primary key (id)
) engine=InnoDB;
create table pricing
(
    id    bigint           not null,
    name  varchar(255)     not null,
    price double precision not null,
    primary key (id)
) engine=InnoDB;
create table seat
(
    id          bigint  not null,
    is_vip      bit,
    seat_number integer not null,
    session_id  bigint  not null,
    ticket_id   bigint,
    user_id     bigint,
    primary key (id)
) engine=InnoDB;
create table session
(
    id         bigint not null,
    date       date   not null,
    end_time   time   not null,
    start_time time   not null,
    movie_id   bigint,
    pricing_id bigint,
    primary key (id)
) engine=InnoDB;
create table ticket
(
    id      bigint           not null,
    price   double precision not null,
    user_id bigint           not null,
    primary key (id)
) engine=InnoDB;
create table user
(
    id       bigint not null,
    email    varchar(255),
    is_admin bit    not null,
    name     varchar(255),
    password varchar(255),
    surname  varchar(255),
    primary key (id)
) engine=InnoDB;
alter table movie
    add constraint UK_ikav2f0gn35r7t9re3qg1yc98 unique (en_title);
alter table movie
    add constraint UK_l9018jw2iserk5ffyuxvijb7c unique (ua_title);
alter table pricing
    add constraint UK_fvfrrgihjk1bh54oqevf2jkh8 unique (name);
alter table user
    add constraint UK_ob8kqyqqgmefl0aco34akdtpe unique (email);
alter table seat
    add constraint FKs3j788vhlga7f2a0tbsbydmsd foreign key (session_id) references session (id);
alter table seat
    add constraint FK8ngrgsadp7q1lcakg3kkdmvqj foreign key (ticket_id) references ticket (id);
alter table seat
    add constraint FKe6phj7o3jw3cwn0egv9i4v3ma foreign key (user_id) references user (id);
alter table session
    add constraint FKd38hyauvpulqx795f234oe049 foreign key (movie_id) references movie (id);
alter table session
    add constraint FKt3q16mort1x8u84ob8iufgnd8 foreign key (pricing_id) references pricing (id);
alter table ticket
    add constraint FKdvt57mcco3ogsosi97odw563o foreign key (user_id) references user (id);