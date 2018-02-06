CREATE SCHEMA hibernate DEFAULT CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS hibernate.projects (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  name         VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS hibernate.developers (
  id         BIGINT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50)  NOT NULL,
  last_name  VARCHAR(100) NOT NULL,
  specialty  VARCHAR(100) NOT NULL,
  salary     DECIMAL      NOT NULL,
  project_id BIGINT ,
  FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE IF NOT EXISTS hibernate.skills (
  id           BIGINT PRIMARY KEY AUTO_INCREMENT,
  skill        VARCHAR(100) NOT NULL,
  skill_idx    INT(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS hibernate.developer_skills(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
skill_id BIGINT NOT NULL,
developer_id BIGINT NOT NULL,
  FOREIGN KEY (developer_id) REFERENCES developers (id),
  FOREIGN KEY (skill_id) REFERENCES skills (id)
);

DROP TABLE hibernate.skills
DROP SCHEMA hibernate;