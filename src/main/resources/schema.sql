
drop table if exists item;
create table item (
    id bigint unsigned not null,
    name varchar(40) not null unique
) engine = InnoDB;

insert into item values
(1, 'Pride and Prejudice'),
(2, 'Mein Kampf'),
(3, 'Of Mice and Men'),
(4, 'Python for Data Analysis'),
(5, 'R in a Nutshell'),
(6, 'JavaScript & jQuery'),
(7, 'The Book of CSS');

drop table if exists customer;
create table customer (
    id bigint unsigned not null auto_increment primary key,
    name varchar(40) not null,
    unique index name_idx (name)
) engine = InnoDB;

drop table if exists checkout;
create table checkout (
    id bigint unsigned not null auto_increment primary key,
    customer_id bigint not null references customer(id),
    item_id bigint not null references item(id),
    current boolean not null default true
) engine = InnoDB;

insert into customer values (NULL, 'Joan Baez');
select @last := last_insert_id();

insert into checkout VALUES
(NULL, @last, 1, true),
(NULL, @last, 3, true);

insert into customer values (NULL, 'Bob Dylan');
select @last := last_insert_id();

insert into checkout VALUES
(NULL, @last, 4, true),
(NULL, @last, 5, true),
(NULL, @last, 6, true),
(NULL, @last, 7, true);

insert into customer values (NULL, 'Pete Seeger');
select @last := last_insert_id();

insert into checkout VALUES
(NULL, @last, 3, false);

insert into customer values (NULL, 'Johnny Cash');