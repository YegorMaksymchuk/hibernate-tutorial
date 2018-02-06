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

SELECT * FROM hibernate.developers;
SELECT * FROM hibernate.projects;

SELECT hibernate.projects.name ,count(hibernate.developers.id)
FROM hibernate.developers
INNER JOIN hibernate.projects
ON developers.id=projects.developer_id
GROUP BY projects.name;