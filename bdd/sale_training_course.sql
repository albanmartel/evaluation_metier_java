CREATE TABLE user_training_course(
   id_user INT AUTO_INCREMENT,
   login VARCHAR(100) NOT NULL,
   password VARCHAR(255) NOT NULL,
   PRIMARY KEY(id_user),
   UNIQUE(login)
);

CREATE TABLE client_training_course(
   id_client INT AUTO_INCREMENT,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(100) NOT NULL,
   client_email VARCHAR(150) NOT NULL,
   client_phone VARCHAR(20),
   client_address VARCHAR(255),
   PRIMARY KEY(id_client)
);

CREATE TABLE training_course(
   id_course INT AUTO_INCREMENT,
   name_course VARCHAR(100) NOT NULL,
   description_course TEXT,
   training_format VARCHAR(50) NOT NULL,
   duration INT NOT NULL,
   price DECIMAL(10,2) NOT NULL,
   PRIMARY KEY(id_course)
);

CREATE TABLE order_training_course(
   id_order INT AUTO_INCREMENT,
   order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   id_client INT NOT NULL,
   id_user INT NOT NULL,
   PRIMARY KEY(id_order),
   FOREIGN KEY(id_client) REFERENCES client_training_course(id_client),
   FOREIGN KEY(id_user) REFERENCES user_training_course(id_user)
);

CREATE TABLE To_order_line(
   id_order INT,
   id_course INT,
   unit_price DECIMAL(10,2) NOT NULL,
   quantity INT DEFAULT 1,
   PRIMARY KEY(id_order, id_course),
   FOREIGN KEY(id_order) REFERENCES order_training_course(id_order),
   FOREIGN KEY(id_course) REFERENCES training_course(id_course)
);
