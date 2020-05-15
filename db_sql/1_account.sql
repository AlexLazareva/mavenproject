create table if not exists paysystem.account
(
    id serial not null
        constraint account_pk
            primary key,
    account_number integer not null,
    sum integer default 0 not null
);

comment on table paysystem.account is 'Таблица, содержащая счета криентов';

comment on column paysystem.account.id is 'Идентификатор';

comment on column paysystem.account.account_number is 'Номер счета';

comment on column paysystem.account.sum is 'Сумма на счете';

alter table paysystem.account owner to postgres;

create unique index if not exists account_account_number_uindex
    on paysystem.account (account_number);

create unique index if not exists account_id_uindex
    on paysystem.account (id);