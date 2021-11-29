CREATE SCHEMA IF NOT EXISTS lab4db DEFAULT CHARACTER SET utf8 ;
USE lab4db;

DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS vaccination;
DROP TABLE IF EXISTS parent_info;
DROP TABLE IF EXISTS child;
DROP TABLE IF EXISTS child_group;
DROP TABLE IF EXISTS kindergarten;

CREATE TABLE kindergarten (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  street VARCHAR(200) NOT NULL,
  building_number INT NOT NULL,
  count_of_group INT NOT NULL)
ENGINE = InnoDB;

CREATE TABLE child_group (
  id INT NOT NULL AUTO_INCREMENT,
  kindergarten_id INT NOT NULL,
  name VARCHAR(200) NOT NULL,
  count_of_children INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_child_group_kindergarten1
    FOREIGN KEY (kindergarten_id)
    REFERENCES kindergarten (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE worker (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  surname VARCHAR(500) NOT NULL,
  date_of_employment DATE NOT NULL,
  child_group_id INT NOT NULL,
  status VARCHAR(20) NOT NULL,
  CONSTRAINT fk_worker_child_group1
    FOREIGN KEY (child_group_id)
    REFERENCES child_group (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE payment (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  worker_id INT NOT NULL,
  salary FLOAT NOT NULL,
  amount_of_remuneration FLOAT NULL,
  date_of_pay DATE NOT NULL,
  CONSTRAINT fk_payment_worker1
    FOREIGN KEY (worker_id)
    REFERENCES worker (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE child (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  surname VARCHAR(500) NOT NULL,
  certificate_of_birth INT NOT NULL,
  date_of_entry DATE NOT NULL,
  child_group_id INT NOT NULL,
  status VARCHAR(20) NOT NULL,
  CONSTRAINT fk_child_child_group1
    FOREIGN KEY (child_group_id)
    REFERENCES child_group (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE vaccination (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  child_id INT NOT NULL,
  name VARCHAR(100) NOT NULL,
  date_of_vaccination DATE NOT NULL,
  CONSTRAINT fk_vaccination_child1
    FOREIGN KEY (child_id)
    REFERENCES child (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE parent_info (
  id INT NOT NULL PRIMARY KEY,
  child_id INT NOT NULL,
  father_surname VARCHAR(500) NULL,
  father_name VARCHAR(500) NULL,
  father_patronymic VARCHAR(500) NULL,
  father_phone_number VARCHAR(10) NULL,
  mother_surname VARCHAR(500) NULL,
  mother_name VARCHAR(500) NULL,
  mother_patronymic VARCHAR(500) NULL,
  mother_phone_number VARCHAR(10) NULL,
  CONSTRAINT fk_parent_info_child1
    FOREIGN KEY (child_id)
    REFERENCES child (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX index_child_group ON child_group (kindergarten_id ASC);
CREATE INDEX index_worker ON worker (child_group_id ASC);
CREATE INDEX index_child ON  child (child_group_id ASC);
 
INSERT INTO kindergarten (id, name, street, building_number, count_of_group) VALUES
(1, '№1 Сонечко', 'Городоцька', 23, 30),
(2, '№2 Метелик', 'П. Куліша', 48, 15),
(3, '№3 Райдуга', 'І. Франка', 10, 40),
(4, '№4 Квітка', 'Личаківська', 41, 30),
(5, '№5 Еколенд', 'Червоної Калини', 51, 20),
(6, '№6', 'Сихівська', 40, 40),
(7, '№40 Ромашка', 'Наукова', 34, 25),
(8, '№33', 'Кульпарківська', 103, 30),
(9, '№9 Зірка', 'Широка', 44, 15),
(10, '№10', 'Сяйво', 28, 35);

INSERT INTO child_group (id, kindergarten_id, name, count_of_children) VALUES
(1, 1, 'Ромашка', 20),
(2, 2, 'Метелик', 14),
(3, 3, 'Казка', 18),
(4, 4, 'Бджілка', 13),
(5, 5, 'Троянда', 22),
(6, 6, 'Струмок', 30),
(7, 7, 'Сонечко', 27),
(8, 8, 'Річечка', 23),
(9, 9, 'Кошеня', 19),
(10, 10, 'Ведмежа', 21);

INSERT INTO worker (id, name, surname, date_of_employment, child_group_id, child_group_kindergarten_id, status) VALUES
(1, 'Анастасія', 'Іванчук', '2001-11-11', 1, 1, 'FIRED'),
(2, 'Надія', 'Тарасенко', '2010-10-10', 2, 2, 'FIRED'),
(3, 'Поліна', 'Шевченко', '2015-09-01', 3, 3, 'FIRED'),
(4, 'Ангеліна', 'Кравчук', '2010-12-12', 4, 4, 'FIRED'),
(5, 'Аліна', 'Янукович', '2002-05-05', 5, 5, 'WORKING'),
(6, 'Валерія', 'Віденська', '2007-07-07', 6, 6, 'WORKING'),
(7, 'Софія', 'Домбровська', '2009-09-09', 7, 7, 'WORKING'),
(8, 'Кіра', 'Франко', '2001-09-11', 8, 8, 'WORKING'),
(9, 'Марія', 'Чуприк', '2016-09-16',  9, 9, 'WORKING'),
(10, 'Ксенія', 'Верес', '2015-03-01', 10, 10, 'ON VACATION');

INSERT INTO payment (id, worker_id, salary, amount_of_remuneration, date_of_pay) VALUES
(1, 5, 4500, 500, '2020-10-05'),
(2, 6, 5000, NULL, '2020-10-05'),
(3, 7, 4200, NULL, '2020-10-05'),
(4, 8, 3800, 1000, '2020-10-05'),
(5, 9, 5500, NULL, '2020-10-05');

INSERT INTO child (id, name, surname, certificate_of_birth, date_of_entry, child_group_id, child_group_kindergarten_id, status) VALUES
(1, 'Андрій', 'Андрієнко', 123456, '2015-09-01', 1, 1, 'RELEASE'),
(2, 'Марія', 'Козленко', 234567, '2016-09-01', 2, 2, 'RELEASE'),
(3, 'Максим', 'Максименко', 345678, '2017-09-01', 3, 3, 'STUDYING'),
(4, 'Анастасія', 'Труш', 456789, '2015-09-01', 4, 4, 'RELEASE'),
(5, 'Микита', 'Микитюк', 567890, '2016-09-01', 5, 5, 'RELEASE'),
(6, 'Ольга', 'Нестай', 678901, '2017-09-01', 6, 6, 'STUDYING'),
(7, 'Антон', 'Ліненко', 789012, '2018-09-01', 7, 7, 'STUDYING'),
(8, 'Яна', 'Пономаренко', 890123, '2018-11-11', 8, 8, 'STUDYING'),
(9, 'Олег', 'Олешків', 901234, '2017-04-04', 9, 9, 'STUDYING'),
(10, 'Вероніка', 'Шевченко', 212345, '2016-09-01', 10, 10, 'RELEASE');

INSERT INTO vaccination (id, child_id, name, date_of_vaccination) VALUES
(1, 3, 'Холера', '2017-09-21'),
(2, 6, 'Холера', '2017-09-21'),
(3, 7, 'Скарлатина', '2018-09-21'),
(4, 8, 'Скарлатина', '2018-09-21'),
(5, 9, 'Холера', '2017-09-21');

INSERT INTO parent_info (child_id, father_surname, father_name, father_patronymic, father_phone_number, mother_surname, mother_name, mother_patronymic, mother_phone_number) VALUES
(3, 'Максименко', 'Михайло', 'Михайлович','0671234567', 'Максименко', 'Ольга', 'Юріївна', '0671502846'),
(6, 'Нестай', 'Григорій', 'Григорович', '0980987654', 'Максименко', 'Наталія', 'Анатоліївна', '0661230984'),
(7, 'Ліненко', 'Володимир', 'Володимирович', '0661272047', 'Ліненко', 'Тетяна', 'Анатоліївна', '0671232343'),
(8, NULL, NULL, NULL, NULL, 'Пономаренко', 'Олена', 'Олегівна', '0981475964'),
(9, 'Олешків', 'Данило', 'Дмитрович', '0670492740', NULL, NULL, NULL, NULL);