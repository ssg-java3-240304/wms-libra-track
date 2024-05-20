
INSERT INTO member values (1, '우희민', 'admin', 'admin', 'admin', '12345678910', 'dddd@gmail.com');

INSERT INTO publisher (name, email, phone_number, business_number) values ('흼출판사', 'admin@heem.com','01012345678', '1234567891');

INSERT INTO publisher (name, email, phone_number, business_number) values ('신세계출판사', 'admin@ssg.com','01012245678', '1233456789');


INSERT INTO publisher_manager (member_id, publisher_id) values (1, 1);

INSERT INTO `genre` (name) values ('소설');

INSERT INTO `book` (title, ISBN, publisher_id, genre_id, price, pub_date, author, pages, size) values ('희민이의 책', '12345678910', 1, 1, 10000, '2021-06-01', '희민', 100, 'A4');

insert into in_warehousing (date, status, publisher_manager_id) values
    ('2021-06-01', 'PENDING', 1);

insert into in_warehousing (date, status, publisher_manager_id) values
    ('2021-06-01', 'PENDING', 1);

INSERT INTO `order` (quantity, book_id, in_warehousing_id) values (10, 1, 1);

INSERT INTO `order` (quantity, book_id, in_warehousing_id) values (10, 1, 1);

select
    quantity, ISBN, title, author
from `order` o
         left join
     book on o.book_id = book.book_id
where
        in_warehousing_id = 1;
