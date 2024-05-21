# DROP TABLE IF EXISTS Publisher;
#
# CREATE TABLE Publisher (
# 	`publisher_id`	INTEGER	NOT NULL AUTO_INCREMENT,
# 	`name`	VARCHAR(20)	NOT NULL,
# 	`email`	VARCHAR(65)	NOT NULL,
# 	`phone_number`	CHAR(11)	NOT NULL,
# 	`business_number`	CHAR(10)	NOT NULL,
# 	UNIQUE (`business_number`),
# 	UNIQUE (`email`),
# 	UNIQUE (`phone_number`),
#     PRIMARY KEY (`publisher_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ;
#
# DROP TABLE IF EXISTS `Book`;
#
# CREATE TABLE `Book` (
# 	`book_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`title`	VARCHAR(100)	NOT NULL,
# 	`ISBN`	VARCHAR(11)	NOT NULL,
# 	`publisher_id`	INTEGER	NOT NULL,
# 	`genre_id`	INTEGER	NOT NULL,
# 	`price`	INTEGER	NOT NULL,
# 	`pub_date`	TIMESTAMP	NOT NULL,
# 	`author`	VARCHAR(20)	NOT NULL,
# 	`pages`	INTEGER	NOT NULL,
# 	`size`	VARCHAR(100)	NOT NULL,
#     PRIMARY KEY (`book_id`)
# )  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Member`;
#
# CREATE TABLE `Member` (
# 	`member_id`	INTEGER	NOT NULL AUTO_INCREMENT,
# 	`name`	VARCHAR(20)	NOT NULL,
# 	`username`	VARCHAR(20)	NOT NULL,
# 	`password`	VARCHAR(65)	NOT NULL,
# 	`role`	ENUM('INVENTORY', 'PUBLISHER', 'ADMIN')	NOT NULL,
# 	`phone_number`	CHAR(11) NOT NULL,
# 	`email`	VARCHAR(65)	NOT NULL,
# 	UNIQUE (`username`),
#     PRIMARY KEY (`member_id`)
# )  ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Inventory_Manager`;
#
# CREATE TABLE `Inventory_Manager` (
# 	`inventory_manager_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`entry_date`	TIMESTAMP	NOT NULL,
# 	`emp_number`	INTEGER	NOT NULL,
# 	`inventory_id`	INTEGER	NOT NULL,
# 	`member_id`	INTEGER	NOT NULL,
#     PRIMARY KEY (`inventory_manager_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Inventory`;
#
# CREATE TABLE `Inventory` (
# 	`inventory_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`location`	VARCHAR(20)	NOT NULL,
# 	`capacity`	INTEGER	NOT NULL,
# 	UNIQUE (`location`),
#     PRIMARY KEY (`inventory_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Area`;
#
# CREATE TABLE `Area` (
# 	`area_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`area_name`	VARCHAR(100)	NOT NULL,
# 	`capacity`	INTEGER	NOT NULL,
# 	`inventory_id`	INTEGER	NULL,
# 	`publisher_id`	INTEGER	NULL,
# 	`reserved`	INTEGER	NULL,
#     `quantity` INTEGER	NULL,
#     PRIMARY KEY (`area_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `in_warehousing`;
#
# CREATE TABLE `in_warehousing` (
# 	`in_warehousing_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`date`	TIMESTAMP	NOT NULL,
# 	`status`	ENUM('PENDING','ACCEPTED', 'REJECTED','COMPLETED')	NOT NULL,
# 	`publisher_manager_id`	INTEGER NULL,
# 	`inventory_manager_id`	INTEGER NULL,
#     PRIMARY KEY (`in_warehousing_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Publisher_Manager`;
#
# CREATE TABLE `Publisher_Manager` (
# 	`publisher_manager_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`member_id`	INTEGER	NOT NULL,
# 	`publisher_id`	INTEGER	NOT NULL,
#     PRIMARY KEY (`publisher_manager_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `Genre`;
#
# CREATE TABLE `Genre` (
# 	`genre_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`name`	VARCHAR(50)	NOT NULL,
#     PRIMARY KEY (`genre_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `book_area`;
#
# CREATE TABLE `book_area` (
# 	`book_area_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`area_id`	INTEGER	NOT NULL,
# 	`book_id`	INTEGER	NOT NULL,
# 	`quantity`	INTEGER	NULL,
# 	`reserved`	INTEGER	NULL,
#     PRIMARY KEY (`book_area_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `order`;
#
# CREATE TABLE `order` (
# 	`order_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`quantity`	INTEGER	NOT NULL,
# 	`book_id`	INTEGER	NOT NULL,
# 	`in_warehousing_id`	INTEGER NULL,
# 	`ex_warehousing_id`	INTEGER NULL,
#     PRIMARY KEY (`order_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `ex_warehousing`;
#
# CREATE TABLE `ex_warehousing` (
# 	`ex_warehousing_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`address`	VARCHAR(100)	NOT NULL,
# 	`receiver`	VARCHAR(100)	NOT NULL,
# 	`receiver_phone`	VARCHAR(11)	NOT NULL,
# 	`receiver_email`	VARCHAR(65)	NOT NULL,
# 	`date`	TIMESTAMP	NOT NULL,
# 	`status`	ENUM('PENDING', 'ACCEPTED', 'REJECTED', 'WAITING', 'COMPLETED')	NOT NULL,
# 	`publisher_manager_id`	INTEGER NULL,
# 	`inventory_manager_id`	INTEGER NULL,
#     PRIMARY KEY (`ex_warehousing_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
# DROP TABLE IF EXISTS `order_area`;
#
# CREATE TABLE `order_area` (
# 	`order_area_id`	INTEGER	NOT NULL  AUTO_INCREMENT,
# 	`book_area_id`	INTEGER,
# 	`order_id`	INTEGER,
#     PRIMARY KEY (`order_area_id`)
# ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
#
#
# ALTER TABLE `Book` ADD CONSTRAINT `FK_Publisher_TO_Book_1` FOREIGN KEY (
# 	`publisher_id`
# )
# REFERENCES `Publisher` (
# 	`publisher_id`
# );
#
# ALTER TABLE `Book` ADD CONSTRAINT `FK_Genre_TO_Book_1` FOREIGN KEY (
# 	`genre_id`
# )
# REFERENCES `Genre` (
# 	`genre_id`
# );
#
# ALTER TABLE `Inventory_Manager` ADD CONSTRAINT `FK_Inventory_TO_InventoryManager_1` FOREIGN KEY (
# 	`inventory_id`
# )
# REFERENCES `Inventory` (
# 	`inventory_id`
# );
#
# ALTER TABLE `Inventory_Manager` ADD CONSTRAINT `FK_Member_TO_InventoryManager_1` FOREIGN KEY (
# 	`member_id`
# )
# REFERENCES `Member` (
# 	`member_id`
# );
#
# ALTER TABLE `Area` ADD CONSTRAINT `FK_Inventory_TO_Area_1` FOREIGN KEY (
# 	`inventory_id`
# )
# REFERENCES `Inventory` (
# 	`inventory_id`
# );
#
# ALTER TABLE `Area` ADD CONSTRAINT `FK_Publisher_TO_Area_1` FOREIGN KEY (
# 	`publisher_id`
# )
# REFERENCES `Publisher` (
# 	`publisher_id`
# );
#
# ALTER TABLE `in_warehousing` ADD CONSTRAINT `FK_PublisherManager_TO_in_warehousing_1` FOREIGN KEY (
# 	`publisher_manager_id`
# )
# REFERENCES `Publisher_Manager` (
# 	`publisher_manager_id`
# ) ON DELETE SET NULL;
#
# ALTER TABLE `in_warehousing` ADD CONSTRAINT `FK_InventoryManager_TO_in_warehousing_1` FOREIGN KEY (
# 	`inventory_manager_id`
# )
# REFERENCES `Inventory_Manager` (
# 	`inventory_manager_id`
# ) ON DELETE SET NULL;
#
# ALTER TABLE `Publisher_Manager` ADD CONSTRAINT `FK_Member_TO_PublisherManager_1` FOREIGN KEY (
# 	`member_id`
# )
# REFERENCES `Member` (
# 	`member_id`
# );
#
# ALTER TABLE `Publisher_Manager` ADD CONSTRAINT `FK_Publisher_TO_PublisherManager_1` FOREIGN KEY (
# 	`publisher_id`
# )
# REFERENCES `Publisher` (
# 	`publisher_id`
# );
#
# ALTER TABLE `book_area` ADD CONSTRAINT `FK_Area_TO_book_area_1` FOREIGN KEY (
# 	`area_id`
# )
# REFERENCES `Area` (
# 	`area_id`
# );
#
# ALTER TABLE `book_area` ADD CONSTRAINT `FK_Book_TO_book_area_1` FOREIGN KEY (
# 	`book_id`
# )
# REFERENCES `Book` (
# 	`book_id`
# );
#
# ALTER TABLE `order` ADD CONSTRAINT `FK_Book_TO_order_1` FOREIGN KEY (
# 	`book_id`
# )
# REFERENCES `Book` (
# 	`book_id`
# );
#
# ALTER TABLE `order` ADD CONSTRAINT `FK_in_warehousing_TO_order_1` FOREIGN KEY (
# 	`in_warehousing_id`
# )
# REFERENCES `in_warehousing` (
# 	`in_warehousing_id`
# );
#
# ALTER TABLE `order` ADD CONSTRAINT `FK_ex_warehousing_TO_order_1` FOREIGN KEY (
# 	`ex_warehousing_id`
# )
# REFERENCES `ex_warehousing` (
# 	`ex_warehousing_id`
# );
#
# ALTER TABLE `ex_warehousing` ADD CONSTRAINT `FK_PublisherManager_TO_ex_warehousing_1` FOREIGN KEY (
# 	`publisher_manager_id`
# )
# REFERENCES `Publisher_Manager` (
# 	`publisher_manager_id`
# ) ON DELETE SET NULL;
#
# ALTER TABLE `ex_warehousing` ADD CONSTRAINT `FK_InventoryManager_TO_ex_warehousing_1` FOREIGN KEY (
# 	`inventory_manager_id`
# )
# REFERENCES `Inventory_Manager` (
# 	`inventory_manager_id`
# ) ON DELETE SET NULL;
#
# ALTER TABLE `order_area` ADD CONSTRAINT `FK_book_area_TO_order_area_1` FOREIGN KEY (
# 	`book_area_id`
# )
# REFERENCES `book_area` (
# 	`book_area_id`
# );
#
# ALTER TABLE `order_area` ADD CONSTRAINT `FK_order_TO_order_area_1` FOREIGN KEY (
# 	`order_id`
# )
# REFERENCES `order` (
# 	`order_id`
# );
#
use libradb;

INSERT INTO member values (2, '박민혁', 'admin2', 'admin2', 'inventory', '0987654321', 'test@gmail.com');

# INSERT INTO publisher (name, email, phone_number, business_number) values ('휨2출판사', 'admin2@heem.com','01012345672', '1234567892');
INSERT INTO inventory_manager(inventory_manager_id, entry_date, emp_number, inventory_id, member_id) VALUES (2, '2024-05-21', 2, 2, 2);

# INSERT INTO publisher (name, email, phone_number, business_number) values ('신세계2출판사', 'admin2@ssg.com','01012245672', '12334567893');


# INSERT INTO inventory_manager (member_id, inventory_id) values (2, 2);

INSERT INTO `genre` (name) values ('소설');

# INSERT INTO `book` (title, ISBN, publisher_id, genre_id, price, pub_date, author, pages, size) values ('희민이의 책', '12345678910', 1, 1, 10000, '2021-06-01', '희민', 100, 'A4');

# insert into in_warehousing (date, status, publisher_manager_id) values
#     ('2021-06-01', 'PENDING', 1);
#
# insert into in_warehousing (date, status, publisher_manager_id) values
#     ('2021-06-01', 'PENDING', 1);

insert into ex_warehousing(address, receiver, receiver_phone, receiver_email, date, status, publisher_manager_id,
                           inventory_manager_id)
VALUES ('서울', '박민혁', '01011112222', 'test@test', '2024-05-21', 'PENDING', null, '2');

insert into ex_warehousing(address, receiver, receiver_phone, receiver_email, date, status, publisher_manager_id,
                           inventory_manager_id)
VALUES ('서울2', '박민혁2', '01011112222', 'test2@test', '2024-05-21', 'PENDING', null, '2');

insert into ex_warehousing(address, receiver, receiver_phone, receiver_email, date, status, publisher_manager_id,
                           inventory_manager_id)
VALUES ('서울3', '박민혁3', '01011112223', 'test3@test', '2024-05-21', 'PENDING', null, '2');


INSERT INTO `order` (quantity, book_id, ex_warehousing_id) values (10, 1, 1);

INSERT INTO `order` (quantity, book_id, ex_warehousing_id) values (10, 1, 1);

select
    quantity, ISBN, title, author
from `order` o
         left join
     book on o.book_id = book.book_id
where
    ex_warehousing_id = 1;
