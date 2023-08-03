show databases;
use bus_system;

create table Passenger(ID varchar(8),
Name varchar(15),
Contact_No int,
City varchar(15),
Street varchar(10),
Bldg varchar(15),
primary key(ID));

ALTER TABLE Passenger add constraint correct check (City in ("dubai","sharjah","abu dhabi","ajman"));

create table Student(
ID char(13),
primary key(ID),
foreign key(ID) references Passenger(ID));

create table Driver(Name varchar(20),
Contact int,
D_ID char(15),
primary key(D_ID));

create table Bus(BusNo int,
ID char(15),
Capacity int,
Plate_No varchar(5),
primary key(BusNo),
foreign key(ID) references Driver(D_ID));

ALTER TABLE Bus add constraint capacity1 check (Capacity<50);

create table Professor(ID char(15),
primary key(ID),foreign key(ID) references Passenger(ID));

create table Absent(ID char(15),
Name varchar(20),
Date date,
City varchar(15),
Street varchar(15),
Bldg varchar(50),
primary key(ID,Date),
foreign key(ID) references Passenger(ID));

create table Reserved(ID varchar(13) ,
Date date ,
BusNo int ,
Semesters int,
enddate date,
primary key(Date,ID),
foreign key(BusNo) references Bus(BusNo),
foreign key(ID) references Passenger(ID));

create table Route(
BusNo int ,
City varchar(20),
Location varchar(50) ,
primary key(BusNo, Location),
foreign key(BusNo) references Bus(BusNo));

create table Admin(User_ID char(8),
Name varchar(15),
primary key(User_ID));

create table Announcements(Date date,
Time time,
User_ID varchar(8),
Info varchar(100),
primary key(Date,Time,User_ID),
foreign key (User_ID) references Admin(User_ID));

create table manages(BusNo int,
D_ID varchar(15),
User_ID varchar(8),
primary key(BusNo,D_ID,User_ID),
foreign key(D_ID) references Driver(D_ID),
foreign key(User_ID) references Admin(User_ID),
foreign key(BusNo) references Bus(BusNo));

create table payment_status(
ID char(13) primary key,
amount int,
dues int,
foreign key (ID) references Student(ID));

create table Payment_history(
ID char(13) primary key,
Date date,
Amount int);

delimiter :
create trigger route1 after insert on Reserved 
for each row
begin 
	if new.BusNo is not null then
	insert into Route(BusNo,city,location) select r.BusNo,p.City,p.Street from Reserved r,Passenger p where r.BusNo=new.BusNo and r.ID=p.ID;
    end if;
END :
delimiter ;
select * from Route;

delimiter :
create trigger student after insert on Passenger 
for each row
begin
	if new.ID is not null and new.ID like '%U' then
    insert into Student values(new.ID);
    end if;
end :
select * from Student;

delimiter :
create trigger professor after insert on Passenger 
for each row 
begin
	if new.ID is not null and new.ID like '%P' then
    insert into Professor values(new.ID);
    end if;
end :
select * from Professor;

delimiter :
create procedure amt_check(in amount double)
begin
select Id from Makes m,Payment p where p.Amount<amount and m.Date=p.Date; 
end :

delimiter :
create procedure buslist(in busno int)
	begin
     select distinct r.BusNo,p.ID,p.Name from Reserved r, Passenger p where r.BusNo=busno and r.ID=p.ID;
end :

delimiter :
create trigger due_calc
after insert on reserved
for each row
begin
   if new.Semesters is not null and new.Semesters in(select Semesters from reserved,payment_status where reserved.ID=payment_status.ID) then
        update payment_status
        set dues=2000*(select count(new.Semesters) from reserved);
	end if;
end:

delimiter :
create trigger payment_total
after insert on Payment_history 
for each row
begin
    if new.amount and new.Amount is not null then
       update payment_status
       set amount=amount+new.Amount
       where payment_status.ID=new.ID;
    end if;
end:
delimiter ;

delimiter :
create trigger ID_update_pay
after insert on Payment_history 
for each row
begin
    if new.ID is not null and new.ID not in(select ID from payment_status) then
    insert into payment_status values(new.ID,new.Amount,0);
    end if;
end:
delimiter ;

#Passenger
insert into Passenger values('2021A7PS0048U','Ilfa Shaheed',0501363714,'dubai','30th Street','Al Wasl Bldg P550');
insert into Passenger values('2021A7PS0025U','Ria Sanjay',0502163004,'sharjah','Damascus Street','Shehnaz Bldg A320');
insert into Passenger values('2021A7PS0004U','Laya Shri Elango',0509007201,'ajman','Gajjar Street','Al Hosn Bldg Q8590');
insert into Passenger values('2021A7PS0005P','Angela Arul',0555870283,'abu dhabi','21st Street','Black Bldg C4451');
insert into Passenger values('2021A7PS0018P','SRK Vishal',0567954202,'dubai','Rawabi Street','Al jazeera Bldg A650');
insert into Passenger values('2021A7PS0008P','Akash Rajasekar',0565246823,'sharjah','18th Street','Diamond Bldg U7880');


select * from Professor;

#Driver
insert into Driver values('Manav Kumar',0501363714,'2021A7PS0001D');
insert into Driver values('Fernandes Gomez',0544768620,'2021A7PS0002D');
insert into Driver values('Abdullah Ahmed',0544672717,'2021A7PS0003D');

#Bus
insert into Bus values(4,20,'A0123');
insert into Bus values(5,30,'B0000');
insert into Bus values(7,40,'BB142');
desc Admin;

#Reserved
insert into Reserved values('2021A7PS0025U','2023-04-05',4,2,'2023-05-04');

#Admin
insert into Admin values('2003A7PS0010A','Johann James');
insert into Admin values('2002A7PS0030A','Karthika Krishnan');
insert into Admin values('2013A7PS0050A','Meena Khan');


