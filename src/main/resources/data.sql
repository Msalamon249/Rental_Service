insert into users (first_name, last_name, pesel)
values ('Lilla', 'Garrattley', '3333123198');
insert into users (first_name, last_name, pesel)
values ('Pris', 'Fawbert', '6385029379');
insert into users (first_name, last_name, pesel)
values ('Powell', 'Coomer', '7613509220');
insert into users (first_name, last_name, pesel)
values ('Stearne', 'Wallington', '6744890925');
insert into users (first_name, last_name, pesel)
values ('Trixy', 'Clemente', '7885194537');
insert into users (first_name, last_name, pesel)
values ('Vaclav', 'Greenhill', '1298213841');
insert into users (first_name, last_name, pesel)
values ('Vanni', 'Chansonnau', '5185150015');
insert into users (first_name, last_name, pesel)
values ('Aurora', 'Gask', '6957453244');
insert into users (first_name, last_name, pesel)
values ('Perren', 'De Paepe', '1824754495');
insert into users (first_name, last_name, pesel)
values ('Irvin', 'Jesper', '9538399904');
insert into users (first_name, last_name, pesel)
values ('Jobina', 'Rudham', '1933898956');
insert into users (first_name, last_name, pesel)
values ('Carola', 'Wintle', '6767393516');
insert into users (first_name, last_name, pesel)
values ('Dagny', 'Ende', '4514142933');
insert into users (first_name, last_name, pesel)
values ('Brandy', 'Prendergrast', '6695682152');
insert into users (first_name, last_name, pesel)
values ('Millicent', 'Noods', '4341426970');
insert into users (first_name, last_name, pesel)
values ('Emmet', 'Spaughton', '4466465585');
insert into users (first_name, last_name, pesel)
values ('Normy', 'McKelvey', '3182364985');
insert into users (first_name, last_name, pesel)
values ('Morlee', 'Fritchley', '8686273467');
insert into users (first_name, last_name, pesel)
values ('Madelene', 'Trelevan', '1246637794');
insert into users (first_name, last_name, pesel)
values ('Marshal', 'Ferbrache', '9366143576');
insert into users (first_name, last_name, pesel)
values ('Oby', 'Lyptrit', '1746959309');
insert into users (first_name, last_name, pesel)
values ('Carilyn', 'Hirjak', '4011317453');
insert into users (first_name, last_name, pesel)
values ('Beryl', 'Hawthorn', '7582077873');
insert into users (first_name, last_name, pesel)
values ('Moyra', 'Knevet', '6644339936');
insert into users (first_name, last_name, pesel)
values ('Maxim', 'Davidavidovics', '9835486055');
insert into users (first_name, last_name, pesel)
values ('Lucine', 'Friar', '6831278698');
insert into users (first_name, last_name, pesel)
values ('Keefer', 'Biggs', '8892563832');
insert into users (first_name, last_name, pesel)
values ('Gillian', 'Barefoot', '4744765616');
insert into users (first_name, last_name, pesel)
values ('Ernst', 'Wooffitt', '7535359488');
insert into users (first_name, last_name, pesel)
values ('Samantha', 'Derobert', '7635570886');



insert into category (name, description)
values ('Laptopy', 'Nulla nisl.');
insert into category (name, description)
values ('Telefony', 'Phasellus sit amet erat. Nulla tempus.');
insert into category (name, description)
values ('Samochody', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis.');
insert into category (name, description)
values ('Zegarki', 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.');



insert into ASSET(name, description, serial_number, category_id)
values ('Asus MateBook D', '15 calowy laptop, i5, 8GB DDR3, kolor czarny', 'ASMBD198723', 1);
insert into ASSET(name, description, serial_number, category_id)
values ('Apple iPhone X', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'MBP15X0925336', 2);
insert into ASSET(name, description, serial_number, category_id)
values ('Apple iPhone 8', 'Telefon z zestawem słuchawkowym lightning i ładowarką', 'APLX17287GHX21', 2);
insert into ASSET(name, description, serial_number, category_id)
values ('Apple MacBook Pro 2015', '13 calowy laptop, i5, 16GB DDR3, SSD256GB, kolor srebrny', 'APL8185652HGT7', 1);



insert into assignment(id, start_borrow, end_borrow, asset_id, user_id)
values (1, '2017-10-08 15:00:00', '2018-10-08 15:00:00', 1, 1),
       (2, '2018-10-09 12:00:00', null, 2, 1),
       (3, '2018-10-10 16:00:00', null, 3, 1);