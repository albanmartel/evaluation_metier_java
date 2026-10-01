DROP DATABASE IF EXISTS javaluation;
CREATE DATABASE IF NOT EXISTS javaluation DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
USE javaluation;

CREATE TABLE client_training_course (
  id_client int(11) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(100) NOT NULL,
  client_email varchar(150) NOT NULL,
  client_phone varchar(20) DEFAULT NULL,
  client_address varchar(255) DEFAULT NULL
);

CREATE TABLE order_line (
  id_order_line int(11) NOT NULL,
  id_order int(11) NOT NULL,
  id_course int(11) NOT NULL,
  unit_price decimal(10,2) NOT NULL,
  quantity int(11) DEFAULT 1
);

CREATE TABLE order_training_course (
  id_order int(11) NOT NULL,
  order_date datetime DEFAULT current_timestamp(),
  id_client int(11) NOT NULL,
  id_user int(11) NOT NULL
);

CREATE TABLE training_course (
  id_course int(11) NOT NULL,
  name_course varchar(100) NOT NULL,
  description_course text DEFAULT NULL,
  training_format varchar(50) NOT NULL,
  duration int(11) NOT NULL,
  price decimal(10,2) NOT NULL
);

INSERT INTO training_course (id_course, name_course, description_course, training_format, duration, price) VALUES
(1, 'Java', 'Java SE 8: Syntaxe', 'Présentiel', 5, 20.00),
(2, 'Java avancé', 'Java SE 8: Poo Dao', 'Distantiel', 6, 20.00),
(3, 'Spring', 'Spring Core/Mvc/Security', 'Ditantiel', 3, 20.00),
(4, 'Php frameworks', 'Symphony', 'Présentiel', 10, 15.00),
(5, 'C#', 'DotNet Core', 'Présentiel', 6, 20.00),
(6, 'C++', 'C++ base', 'Présentiel', 7, 22.00),
(7, 'C++ avancé', 'Programmation C++ avec des interfaces graphiques', 'Distantiel', 4, 24.00),
(8, 'Python base', 'Les types natifs, les conditions', 'Présentiel', 11, 20.00),
(9, 'python avancé', 'Exceptions, les threads & Poo', 'Distantiel', 7, 25.00),
(10, 'Les bases du réseau', 'L\'ipv4, rj45, le routage', 'Distantiel', 8, 18.00),
(11, 'Anglais', 'Anglais technique, écrire un email, lire de la documentation technique', 'Présentiel', 5, 15.00),
(12, 'Technique de recherche d\'emploi', 'Recherche d\'emploi, réseaux sociaux, suivi de recherche', 'Distantiel', 12, 10.00);

CREATE TABLE user_training_course (
  id_user int(11) NOT NULL,
  login varchar(100) NOT NULL,
  password varchar(255) NOT NULL
);


ALTER TABLE client_training_course
  ADD PRIMARY KEY (id_client);

ALTER TABLE order_line
  ADD PRIMARY KEY (id_order_line),
  ADD KEY id_order_line (id_order_line),
  ADD KEY order_line_ibfk_1 (id_order),
  ADD KEY order_line_ibfk_2 (id_course);

ALTER TABLE order_training_course
  ADD PRIMARY KEY (id_order),
  ADD KEY id_client (id_client),
  ADD KEY id_user (id_user);

ALTER TABLE training_course
  ADD PRIMARY KEY (id_course);

ALTER TABLE user_training_course
  ADD PRIMARY KEY (id_user),
  ADD UNIQUE KEY login (login);


ALTER TABLE client_training_course
  MODIFY id_client int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE order_line
  MODIFY id_order_line int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE order_training_course
  MODIFY id_order int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE training_course
  MODIFY id_course int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

ALTER TABLE user_training_course
  MODIFY id_user int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE order_line
  ADD CONSTRAINT order_line_ibfk_1 FOREIGN KEY (id_order) REFERENCES order_training_course (id_order),
  ADD CONSTRAINT order_line_ibfk_2 FOREIGN KEY (id_course) REFERENCES training_course (id_course);

ALTER TABLE order_training_course
  ADD CONSTRAINT order_training_course_ibfk_1 FOREIGN KEY (id_client) REFERENCES client_training_course (id_client),
  ADD CONSTRAINT order_training_course_ibfk_2 FOREIGN KEY (id_user) REFERENCES user_training_course (id_user);
