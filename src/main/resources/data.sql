insert into admin(username, password)
values ('ritam', 'password');

insert into user(password, name, age, gender, email, address, phone, secret_question, answer)
values ('k.afrin', 'Afrin Kardashian', '22', 'Female', 'kardashian.afrin@gmail.com', 'Saltlake City, UT', '9876543210',
        'Your nickname', 'afrin'),
       ('g.kunal', 'Kunal Goel', '22', 'Male', 'goel.kunal@gmail.com', 'Downtown Manhattan, LA', '8765432109',
        'Your nickname', 'kunal'),
       ('g.pallavi', 'Pallavi Gupta', '22', 'Female', 'gupta.pallavi@gmail.com', 'Austin, Tx', '7654321098',
        'Your nickname', 'pallavi'),
       ('m.shuktika', 'Shuktika Mahanty', '22', 'Female', 'mathanty.shuktika@gmail.com', 'Mountain View, CA',
        '6543210987', 'Your nickname', 'shuktika');

insert into flight(airline, model, type, economy_seats, business_seats)
values ('Air India', 'Airbus A300', 'Domestic', '50', '10'),
       ('IndiGo', 'Boeing 737', 'Domestic', '100', '30'),
       ('SpiceJet', 'Airbus A321', 'Domestic', '150', '50'),
       ('Emirates', 'Boeing 777', 'International', '200', '50'),
       ('British Airways', 'Boeing 787', 'International', '250', '75');

insert into flight_schedule(flight_no, source, destination, economy_seat_cost, business_seat_cost, arrival_time,
                            departure_time, sun, mon, tue, wed, thu,
                            fri, sat)
values (1, 'Kolkata', 'Chennai', '3000', '5000', '10:00:00', '12:00:00', 1, 1, 1, 1, 1, 1, 1),
       (3, 'Hyderabad', 'Bangalore', '5000', '9000', '12:00:00', '14:00:00', 1, 1, 1, 1, 1, 1, 1),
       (4, 'Delhi', 'Dubai', '12000', '20000', '17:30:00', '19:00:00', 0, 1, 0, 1, 0, 1, 0),
       (5, 'Mumbai', 'London', '10000', '15000', '10:00:00', '13:00:00', 1, 0, 1, 0, 1, 0, 1);

insert
into news_feed(news, date)
values ('Due to fog some flights will get delayed', '2021-02-10'),
       ('Our agency will never call you for bank information', '2021-02-08');

insert into bank(bank_name)
values ('HSBC'),
       ('BNP Paribas'),
       ('Standard Chartered');

insert into account(account_no, balance, bank_id)
values ('12345', '100000', '1'),
       ('23456', '50000', '2'),
       ('34567', '10000', '3'),
       ('45678', '5000', '1'),
       ('56789', '1000', '2');