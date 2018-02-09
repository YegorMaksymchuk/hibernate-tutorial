--Projects
INSERT INTO hibernate.projects (name) VALUES('Hibernate');
INSERT INTO hibernate.projects (name) VALUES('WildFly');
INSERT INTO hibernate.projects (name) VALUES('AngularJS');

--Projects details
INSERT INTO hibernate.projects_details (project_id, description) VALUES(3,'AngularJS - it is cool JS framework.');
INSERT INTO hibernate.projects_details (project_id, description) VALUES(2,'WildFly - it is RedHat servlet container, old name JBoss.');
INSERT INTO hibernate.projects_details (project_id, description) VALUES(1,'Hibernate - it is popular ORM framework. Develop by RedHat in OpenSource.');

-- developers
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Ivan', 'Ivanon', 'Java Developer', 3000.00, 1);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Kolya', 'Nikolaev', 'Java  Developer', 4000.00, 1);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Mykola', 'Petrov', 'Java  Developer', 4000.00, 2);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Anna', 'Nikolaeva', 'Java Script Developer', 2000.00, 3);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Tatjana', 'Maksimova', 'Java Script Developer', 2000.00, 3);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Evgenija', 'Galevich', 'Java Script Developer', 2000.00, 3);

--skills
INSERT INTO hibernate.skills (skill) VALUES ('SQL');
INSERT INTO hibernate.skills (skill) VALUES ('UNIX');
INSERT INTO hibernate.skills (skill) VALUES ('MacOS');
INSERT INTO hibernate.skills (skill) VALUES ('Networks');
INSERT INTO hibernate.skills (skill) VALUES ('Cloud');
INSERT INTO hibernate.skills (skill) VALUES ('AWS');


--developer_skills
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (1,1);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (1,2);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,2);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,4);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,6);

