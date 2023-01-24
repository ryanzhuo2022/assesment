create table if not exists Customer (
    id int not null primary key auto_increment,
    name varchar(30)
);

create table if not exists Transaction (
    id int not null primary key auto_increment,
    amount double,
    transaction_date date,
    customer_id int
    );