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
values ('British Airways', 'Boing 777', 'International', 200, 50),
       ('Lufthansa', 'Airbus A380', 'International', 500, 200),
       ('Emirates', 'Boing 747', 'International', 250, 75),
       ('IndiGo', 'Airbus A300', 'Domestic', '50', 10);

insert into flight_schedule(flight_no, source, destination, cost, arrival_time, departure_time, sun, mon, tue, wed, thu,
                            fri, sat)
values ('1', 'Source_1', 'Destination_1', '5000', '01:00:00', '02:00:00', 1, 0, 0, 1, 1, 0, 0),
       ('2', 'Source_2', 'Destination_3', '6000', '02:00:00', '05:00:00', 0, 1, 0, 1, 1, 1, 1),
       ('3', 'Source_3', 'Destination_4', '7000', '03:00:00', '06:00:00', 0, 1, 0, 1, 0, 1, 0),
       ('4', 'Source_4', 'Destination_2', '8000', '04:00:00', '08:00:00', 1, 0, 1, 0, 1, 0, 1);

insert into news_feed(news, date)
values ('Some flights have been lost in Bermuda Triangle', '2021-01-21'),
       ('Very bad news', '2021-01-22'),
       ('Stay positive after such a bad news', '2021-01-23'),
       ('Hope for something good', '2021-01-24');

insert into bank(bank_name)
values ('HSBC'),
       ('BNP Paribas'),
       ('Standard Chartered');
