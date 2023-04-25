-- krjenni

Create table DOC_report(
    username varchar(50),
    symptoms varchar(100),
    doctor_suggestions varchar(255) default "Please Wait",
    predictions varchar(50) default null,
    foreign key(username) references user_details(username)

)

--sohan
create table admin_details(
    username varchar(50) NOT NULL,
    usr_password varchar(10) NOT NULL,
    PRIMARY KEY(username)
);

--krishv
create table user_details(
    fullname varchar(40),
    username varchar(10),
    age int,
    email varchar(40),
    phone_num char(10),
    passsword varchar(20),
    gender varchar(7),
    primary key(username)
);

--likith
create table Doctor_Details(
Full_Name varchar(40) not null,
UserName varchar(40) not null,
Government_Registration_Number char(10) not null,
Age int not null,
Email varchar(30) not null,
Phone_Number char(10) not null,
Doc_Resume blob not null,
Doc_Password varchar(10) not null,
primary key(username));

