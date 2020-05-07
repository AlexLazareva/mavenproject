create table client
(
    id         serial  not null
        constraint client_pk
            primary key,
    login      varchar not null,
    pswd       varchar not null,
    firstname  varchar not null,
    secondname varchar,
    surname    varchar not null,
    account_id integer default 0
);

comment on table client is 'Клиент';

comment on column client.id is 'Идентификатор пользователя';

comment on column client.login is 'Логин';

comment on column client.pswd is 'Пароль';

comment on column client.firstname is 'Имя';

comment on column client.secondname is 'Отчество';

comment on column client.surname is 'Фамилия';

alter table client
    owner to postgres;

create unique index client_id_uindex
    on client (id);

create unique index client_login_uindex
    on client (login);