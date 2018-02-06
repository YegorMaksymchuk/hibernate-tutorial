--Projects
INSERT INTO hibernate.projects (name) VALUES('Hibernate');
INSERT INTO hibernate.projects (name) VALUES('WildFly');
INSERT INTO hibernate.projects (name) VALUES('AngularJS');

-- developers
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Ivan', 'Ivanon', 'Java Developer', 3000.00, 1);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Kolya', 'Nikolaev', 'Java  Developer', 4000.00, 1);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Mykola', 'Petrov', 'Java  Developer', 4000.00, 2);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Anna', 'Nikolaeva', 'Java Script Developer', 2000.00, 3);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Tatjana', 'Maksimova', 'Java Script Developer', 2000.00, 3);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary, project_id) VALUES ( 'Evgenija', 'Galevich', 'Java Script Developer', 2000.00, 3);

--skills
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('SQL', 1);
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('UNIX', 2);
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('MacOS', 3);
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('Networks', 4);
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('Cloud', 5);
INSERT INTO hibernate.skills (skill, skill_idx) VALUES ('AWS', 6);


--developer_skills
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (1,1);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (1,2);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,2);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,4);
INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES (2,6);
--INSERT INTO hibernate.developer_skills (developer_id, skill_id) VALUES ();

SELECT * FROM hibernate.developers;

SELECT * FROM hibernate.projects;

SELECT * FROM hibernate.developer_skills;

SELECT developers.first_name, developers.last_name, skills.skill
FROM hibernate.developers
INNER JOIN hibernate.developer_skills
ON hibernate.developers.id=hibernate.developer_skills.developer_id
INNER JOIN hibernate.skills
ON hibernate.skills.id=hibernate.developer_skills.skill_id
