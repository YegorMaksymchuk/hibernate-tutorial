-- developers
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Ivan', 'Ivanon', 'Java Developer', 3000.00);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Kolya', 'Nikolaev', 'Java  Developer', 4000.00);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Mykola', 'Petrov', 'Java  Developer', 4000.00);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Anna', 'Nikolaeva', 'Java Script Developer', 2000.00);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Tatjana', 'Maksimova', 'Java Script Developer', 2000.00);
INSERT INTO hibernate.developers (first_name, last_name , specialty, salary) VALUES ( 'Evgenija', 'Galevich', 'Java Script Developer', 2000.00);

--Projects
INSERT INTO hibernate.projects (name, developer_id) VALUES('Hibernate',1);
INSERT INTO hibernate.projects (name, developer_id) VALUES('Hibernate',2);
INSERT INTO hibernate.projects (name, developer_id) VALUES('WildFly',3);
INSERT INTO hibernate.projects (name, developer_id) VALUES('AngularJS4',4);
INSERT INTO hibernate.projects (name, developer_id) VALUES('AngularJS5',5);
INSERT INTO hibernate.projects (name, developer_id) VALUES('AngularJS5.1',6);



SELECT * FROM hibernate.developers;
SELECT * FROM hibernate.projects;

SELECT hibernate.projects.name ,count(hibernate.developers.id)
FROM hibernate.developers
INNER JOIN hibernate.projects
ON developers.id=projects.developer_id
group by projects.name;