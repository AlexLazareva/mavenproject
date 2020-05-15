create table if not exists paysystem.pay_data
(
    id serial not null
        constraint pay_data_pk
            primary key,
    client_id integer not null
        constraint pay_data_client_id_fk
            references paysystem.paysystem.client
            on delete cascade,
    target_account varchar not null,
    sum numeric not null,
    date timestamp not null
);

comment on table paysystem.pay_data is 'Таблица, содержащая информацию об оплатах';

comment on column paysystem.pay_data.id is 'Идентификатор оплаты';

comment on column paysystem.pay_data.client_id is 'Идентификатор клиента';

comment on column paysystem.pay_data.target_account is 'Целевой счет';

comment on column paysystem.pay_data.sum is 'Сумма оплаты';

comment on column paysystem.pay_data.date is 'Дата/время оплаты';

alter table paysystem.pay_data owner to postgres;

create unique index if not exists pay_data_id_uindex
    on paysystem.pay_data (id);