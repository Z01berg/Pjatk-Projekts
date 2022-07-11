-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-06-17 15:48:06.76

-- tables
-- Table: Aktor
CREATE TABLE Aktor (
    ID integer  NOT NULL,
    name varchar2(20)  NOT NULL,
    second_name varchar2(20)  NOT NULL,
    country varchar2(20)  NOT NULL,
    CONSTRAINT Aktor_pk PRIMARY KEY (ID)
) ;

-- Table: Cast
CREATE TABLE Cast (
    movie_ID integer  NOT NULL,
    Aktor_ID integer  NOT NULL
) ;

-- Table: Sala
CREATE TABLE Sala (
    ID integer  NOT NULL,
    Numer varchar2(32)  NOT NULL,
    seats_no integer  NOT NULL,
    CONSTRAINT Sala_pk PRIMARY KEY (ID)
) ;

-- Table: employee
CREATE TABLE employee (
    ID integer  NOT NULL,
    name varchar2(30)  NOT NULL,
    second_name varchar2(30)  NOT NULL,
    username varchar2(32)  NOT NULL,
    password varchar2(100)  NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (ID)
) ;

-- Table: movie
CREATE TABLE movie (
    ID integer  NOT NULL,
    title varchar2(256)  NOT NULL,
    director varchar2(256)  NOT NULL,
    description varchar2(2000)  NOT NULL,
    duration_min integer  NOT NULL,
    CONSTRAINT movie_pk PRIMARY KEY (ID)
) ;

-- Table: screening
CREATE TABLE screening (
    ID integer  NOT NULL,
    movie_ID integer  NOT NULL,
    screening_start timestamp  NOT NULL,
    Sala_ID integer  NOT NULL,
    CONSTRAINT screening_pk PRIMARY KEY (ID)
) ;

-- Table: seats
CREATE TABLE seats (
    ID integer  NOT NULL,
    "row" integer  NOT NULL,
    "number" integer  NOT NULL,
    Sala_ID integer  NOT NULL,
    CONSTRAINT seats_pk PRIMARY KEY (ID)
) ;

-- Table: ticket
CREATE TABLE ticket (
    ID integer  NOT NULL,
    employee_ID integer  NOT NULL,
    resevation_date timestamp  NULL,
    ticket_type_ID integer  NOT NULL,
    seats_ID integer  NOT NULL,
    paid char(1)  NULL,
    screening_ID integer  NOT NULL,
    CONSTRAINT ticket_pk PRIMARY KEY (ID)
) ;

-- Table: ticket_type
CREATE TABLE ticket_type (
    ID integer  NOT NULL,
    ticket_type varchar2(32)  NOT NULL,
    CONSTRAINT ticket_type_pk PRIMARY KEY (ID)
) ;

-- foreign keys
-- Reference: Cast_Aktor (table: Cast)
ALTER TABLE Cast ADD CONSTRAINT Cast_Aktor
    FOREIGN KEY (Aktor_ID)
    REFERENCES Aktor (ID);

-- Reference: Cast_movie (table: Cast)
ALTER TABLE Cast ADD CONSTRAINT Cast_movie
    FOREIGN KEY (movie_ID)
    REFERENCES movie (ID);

-- Reference: screening_Sala (table: screening)
ALTER TABLE screening ADD CONSTRAINT screening_Sala
    FOREIGN KEY (Sala_ID)
    REFERENCES Sala (ID);

-- Reference: screening_movie (table: screening)
ALTER TABLE screening ADD CONSTRAINT screening_movie
    FOREIGN KEY (movie_ID)
    REFERENCES movie (ID);

-- Reference: seats_Sala (table: seats)
ALTER TABLE seats ADD CONSTRAINT seats_Sala
    FOREIGN KEY (Sala_ID)
    REFERENCES Sala (ID);

-- Reference: ticket_employee (table: ticket)
ALTER TABLE ticket ADD CONSTRAINT ticket_employee
    FOREIGN KEY (employee_ID)
    REFERENCES employee (ID);

-- Reference: ticket_screening (table: ticket)
ALTER TABLE ticket ADD CONSTRAINT ticket_screening
    FOREIGN KEY (screening_ID)
    REFERENCES screening (ID);

-- Reference: ticket_seats (table: ticket)
ALTER TABLE ticket ADD CONSTRAINT ticket_seats
    FOREIGN KEY (seats_ID)
    REFERENCES seats (ID);

-- Reference: ticket_ticket_type (table: ticket)
ALTER TABLE ticket ADD CONSTRAINT ticket_ticket_type
    FOREIGN KEY (ticket_type_ID)
    REFERENCES ticket_type (ID);

-- End of file.

