drop table CARRENT.USER ;

CREATE SCHEMA carrent authorization sa;

CREATE TABLE carrent.user (
                    userid  varchar(255) PRIMARY KEY,
                    password varchar(255),
                    fname VARCHAR(255) ,
                    lname varchar(255),
                    admin boolean,
                    email varchar(255));


INSERT INTO carrent.user values ('pri','12345','pri','che',true,'p.c@gmail.com');
INSERT INTO carrent.user values ('al','23456','S','var',false,'a.s@gmail.com');
INSERT INTO carrent.user values ('ada','34567','VJ','var',false,'a.vj@gmail.com');
INSERT INTO carrent.user values ('rad','45678','N','var',false,'r.n@gmail.com');
INSERT INTO carrent.user values ('pra','56789','N','var',false,'p.n@gmail.com');
INSERT INTO carrent.user values ('kun','67890','N','var',false,'k.n@gmail.com');
INSERT INTO carrent.user values ('blin','78901','N','var',false,'b.n@gmail.com');
INSERT INTO carrent.user values ('deep','89012','T','var',false,'d.t@gmail.com');
INSERT INTO carrent.user values ('rub','90123','T','var',false,'r.t@gmail.com');


// CAR table
drop table CARRENT.CAR ;
CREATE TABLE carrent.car (
                    ID INT auto_increment PRIMARY KEY,
                    year  varchar(255),
                    make varchar(255),
                    vehicleModel VARCHAR(255) ,
                    vehicleType varchar(255));

// LOCATION table
drop table CARRENT.LOCATION ;
CREATE TABLE carrent.location (
                    ID varchar(235)PRIMARY KEY,
                    address  varchar(255),
                    city varchar(255),
                    state VARCHAR(255) ,
                    zipcode varchar(255),
                    country varchar(255));