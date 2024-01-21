CREATE DATABASE humanfriends;
USE humanfriends;

create table cat (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

create table dog (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

create table hamster (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

create table horse (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

create table camel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

create table donkey (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

## Создаидим таблицы уровня выше
create table pet (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

create table packAnimal (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


## Создадим общую таблицу
create table humanFriend(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday Date
    );
    
    ## Заполним данными низкоуровневые таблицы
    
    insert into cat (Name, Command, Birthday) values
    ('Милано', 'Спать', '2022-04-01'),
    ('Марсик', 'Спать', '2018-06-08'),
	('Феликс', 'Спать', '2023-07-08'),
    ('Аська', 'Спать', '2021-05-15');
    
    select * from cat;
    
	insert into dog (Name, Command, Birthday) values
    ('Бустер', 'Дай лапу', '2022-04-03'),
    ('Алый', 'Дай лапу', '2018-06-08'),
	('Гром', 'Дай лапу', '2023-04-06'),
    ('Дружок', 'Дай лапу', '2021-03-17');
	
    select * from dog;
    
insert into hamster (Name, Command, Birthday) values
    ('Ириска', 'Бежать', '2022-04-05'),
    ('Пушок', 'Бежать', '2017-05-08'),
	('Лапочка', 'Бежать', '2023-01-06'),
    ('Борчик', 'Бежать', '2021-04-15');
	
    select * from hamster;    
    
insert into camel (Name, Command, LiftWeight, Birthday) values
    ('Азира', 'Пошел', 100, '2022-03-04'),
    ('Дубай', 'Пошел', 200, '2018-07-09'),
	('Ланцелот', 'Пошел', 400, '2021-08-01'),
    ('Джордж', 'Пошел', 50, '2020-04-11');
	
    select * from camel;  
   р
    insert into horse (Name, Command, liftWeight, Birthday) values
    ('Морланд', 'Галоп', 150, '2022-04-07'),
    ('Рыжая', 'Галоп', 50, '2018-08-06'),
	('Крез', 'Галоп', 200, '2023-01-03'),
    ('Марацелло', 'Галоп', 250, '2021-03-11');
	
    select * from horse;    
    
	insert into donkey (Name, Command, liftWeight, Birthday) values
    ('Затана', 'Жевать', 45, '2022-04-08'),
    ('Барбос', 'Жевать', 15, '2018-06-09'),
	('Блеки', 'Жевать', 20, '2023-02-06'),
    ('Жерар', 'Жевать', 100, '2021-08-14');
	
    select * from donkey;    
    
 
 ## Удаленим таблицы верблюдов
 delete from camel where id > 0;
 select * from camel;    
 
## Объединеним таблицы лошадей и ослов в одну таблицу.
create table packAnimalNew (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command, 
        Birthday
from horse union 
select  Name, 
        Command, 
        Birthday
from donkey;

select * from packAnimalNew;
 
## Создадим таблицы, в которой все животные в возрасте от 1 до 3 лет.
INSERT into pet (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from cat union 
select  Name, 
        Command, 
        Birthday
from dog union
select  Name, 
        Command, 
        Birthday
from hamster;
select * from pet;

INSERT into humanFriend (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from pet union 
select  Name, 
        Command, 
        Birthday
from packAnimalNew;
select * from humanFriend;

create table youngAnimals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select Name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) as age
from humanFriend
where Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) > 1 
	and Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) < 3;
select * from youngAnimals; 


## Объединим все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

create table newhumanFriend (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command,
        Birthday,
        'cat' as oldTable
from cat union 
select  Name, 
        Command, 
        Birthday,
        'dog' as oldTable
from dog union
select  Name, 
        Command, 
        Birthday,
        'hamster' as oldTable
from hamster union 
select  Name, 
        Command, 
        Birthday,
        'horse' as oldTable
from horse union 
select  Name, 
        Command, 
        Birthday,
        'donkey' as oldTable
from donkey;

select * from newhumanFriend;