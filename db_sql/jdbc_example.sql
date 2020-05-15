-- SELECT

select * from paysystem.paysystem.account;
select account_number from paysystem.paysystem.account;
select distinct(sum) from paysystem.paysystem.account;

-- WHERE
select * from paysystem.paysystem.account where account_number = 1;
select * from paysystem.paysystem.account where sum = 0;

-- INSERT

insert into paysystem.paysystem.account (account_number) values (2);
insert into paysystem.paysystem.account (account_number) values (3);

-- DELETE

delete from paysystem.paysystem.account;
delete from paysystem.paysystem.account where account_number = '3';

-- UPDATE

update paysystem.paysystem.account set sum = 10;
update paysystem.paysystem.account set sum = 100 where account_number = 2;