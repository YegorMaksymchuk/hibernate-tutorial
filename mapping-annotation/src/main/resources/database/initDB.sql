CREATE SCHEMA hibernate DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS hibernate.developers (
  id         BIGINT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  specialty  VARCHAR(100) NOT NULL,
  salary     DECIMAL      NOT NULL
);

CREATE TABLE IF NOT EXISTS hibernate.projects (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(100) NOT NULL,
  idx          INT                DEFAULT NULL,
  developer_id BIGINT             DEFAULT NULL,
  FOREIGN KEY (developer_id) REFERENCES developers (id)
);