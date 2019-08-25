create table users
(
    id_user     int auto_increment primary key,
    uuid       varchar(40)                                not null,
    first_name  varchar(200) charset utf8mb4               not null,
    last_name   varchar(200) charset utf8mb4               not null,
    email      varchar(200) charset utf8mb4               not null,
    password   varchar(45) charset utf8mb4                not null,
    locale     varchar(10)                                null,
    status     enum ('ACTIVE', 'INACTIVE') charset latin1 not null,
    create_time datetime                                   not null,
    update_time datetime                                   null,
    constraint EMAIL_UNIQUE
        unique (email),
    constraint uuid_UNIQUE
        unique (uuid)
)
    engine = InnoDB;