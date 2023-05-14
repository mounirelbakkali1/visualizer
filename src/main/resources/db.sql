create table admin (
                       id bigserial not null,
                       password varchar(255),
                       username varchar(255),
                       primary key (id)
);

create table information (
                             id serial not null,
                             age varchar(255) not null,
                             date_en DATE DEFAULT NOW() not null,
                             emotion varchar(255) not null,
                             heure TIME WITHOUT TIME ZONE   DEFAULT CURRENT_TIMESTAMP not null,
                             sexe varchar(255) not null,
                             primary key (id)
);


INSERT INTO information (date_en, heure, emotion, age, sexe)
VALUES
    ('2023-05-09', '12:00:27', 'Neutral', '(15-20)', 'Female'),
    ('2023-05-09', '12:00:28', 'Neutral', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:28', 'Neutral', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:28', 'Neutral', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:29', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:29', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:29', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:30', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:30', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:30', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:31', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:31', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:31', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:31', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:32', 'Happy', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:32', 'Happy', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:32', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:33', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:33', 'Neutral', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:33', 'Happy', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:33', 'Happy', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:34', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:34', 'Happy', '(25-32)', 'Female'),
    ('2023-05-09', '12:00:34', 'Happy', '(15-20)', 'Female'),
    ('2023-05-09', '12:00:34', 'Neutral', '(15-20)', 'Female'),
    ('2023-05-09', '12:00:35', 'Neutral', '(4-6)', 'Female'),
    ('2023-05-09', '12:00:35', 'Sad', '(8-12)', 'Female'),
    ('2023-05-09', '12:00:35','Neutral','(25-32)','Female'),
    ('2023-05-09', '12:00:35','Neutral','(8-12','Female'),
    ('2023-05-09', '12:00:36','Neutral','(15-20)','Female');

