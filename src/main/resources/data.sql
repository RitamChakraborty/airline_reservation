insert into admin(username, password)
values ('ritam', 'password');

insert into user(password, name, email, address, phone)
values ('k.afrin', 'Afrin Kardashian', 'kardashian.afrin@gmail.com', 'Saltlake City, UT', '9876543210'),
       ('g.kunal', 'Kunal Goel', 'goel.kunal@gmail.com', 'Downtown Manhattan, LA', '8765432109'),
       ('g.pallavi', 'Pallavi Gupta', 'gupta.pallavi@gmail.com', 'Austin, Tx', '7654321098'),
       ('m.shuktika', 'Shuktika Mahanty', 'mathanty.shuktika@gmail.com', 'Mountain View, CA', '6543210987');

insert into flight(airline, model, type, seats_economy, seats_business)
values ('British Airways', 'Boing 777', 'International', 200, 50),
       ('Lufthansa', 'Airbus A380', 'International', 500, 200),
       ('Emirates', 'Boing 747', 'International', 250, 75),
       ('IndiGo', 'Airbus A300', 'Domestic', '50', 10);