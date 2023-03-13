-- since we will run the script multiply time add a drop statement at the begining of the file
drop user expensetracker;
drop database expense_tracker_db;

-- user the predefine template of postgres
create user expense_tracker with password 'password';
create database expense_tracker_db with template=template0  owner=expensetracker;

\connect expense_tracker_db;

-- before creating any dbase object, we grant  privileges to user
alter  default privileges  grant  all on tables  to expensetracker;

-- as we will use sequence to generate primary key, grant sequences as well
alter  default privileges grant all on sequences to expensetracker;

-- for this rest api, we need three tables, user-account, categories, and for recording transactions
-- user-account table
create table  expense_tracker_users(
    user_id integer primary key not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    email varchar(20) not null,
    password text not null);

-- categories table
create table expense_tracker_categories(
    category_id integer primary key not null,
    user_id integer not null,
    title varchar(20) not null,
    description varchar(20) not null);

-- using auto table statement; add foreign key constrain for user_id referencing expense_tracker_users table
alter table expense_tracker_categories add constraint  category_user_fk
foreign key (user_id) references expense_tracker_users(user_id);

-- transaction table
create table expense_tracker_transaction(
    transaction_id integer primary key  not null ,
    category_id integer not null,
    user_id integer not null,
    amount numeric(10,2) not null,
    note varchar(50) not null,
--     store transaction date in mili-seconds
     transaction_date bigint not null );

-- add foreign key constraints for category_id
alter table  expense_tracker_transaction add constraint transaction_catgegory_fk
foreign key (category_id) references expense_tracker_categories(category_id);

-- add foreign key constraints for user_id
alter table  expense_tracker_transaction add constraint transaction_user_fk
foreign key (user_id) references expense_tracker_users(user_id);

-- create sequence  for all the three tables, this is for generating primary key values
create sequence expense_tracker_users_seq increment 1 start 1;
create sequence expense_tracker_category_seq increment 1 start 1;
create sequence expense_tracker_transaction_seq increment 1 start 1000;
