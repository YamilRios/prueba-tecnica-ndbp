CREATE DATABASE DB_BACK;

CREATE TABLE client ( 
   id INT NOT NULL PRIMARY KEY, 
   age INT NOT NULL,
   identification VARCHAR(255) NOT NULL, 
   name VARCHAR(255) NOT NULL, 
   password VARCHAR(255) NOT NULL, 
   gender VARCHAR(255) NOT NULL, 
   address VARCHAR(255) NOT NULL, 
   telephone VARCHAR(255) NOT NULL, 
   clientId VARCHAR(20) NOT NULL,
   state BOOLEAN,
);

CREATE TABLE account(
  account_number VARCHAR(255) NOT NULL PRIMARY KEY,
  account_type VARCHAR(255) NOT NULL,
  balance VARCHAR(255) NOT NULL,
  state BOOLEAN,
  client_fk INT,
  foreign key (client_fk) references client(id)
)

CREATE TABLE movement(
  movement_id VARCHAR(255) NOT NULL PRIMARY KEY,
  date DATE,
  movement_type VARCHAR(255) NOT NULL,
  amount DOUBLE NOT NULL,
  account_fk VARCHAR(255) NOT NULL,
  initial_balance DOUBLE NOT NULL,
  avaliable_balance DOUBLE NOT NULL,
  foreign key (account_fk) references account(account_number)
)