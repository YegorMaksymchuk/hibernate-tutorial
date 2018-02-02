-- developers
INSERT INTO hibernate.developers VALUES (1, 'Ivan', 'Ivanon', 'Java Developer', 3000.00);
INSERT INTO hibernate.developers VALUES (2, 'Kolya', 'Nikolaev', 'C++ Developer', 4000.00);

-- skills
INSERT INTO hibernate.skills VALUES (1, 'Java');
INSERT INTO hibernate.skills VALUES (2, 'SQL');
INSERT INTO hibernate.skills VALUES (3, 'JDBC');

--projects
INSERT INTO hibernate.projects (name) VALUES ( 'Openshift');
INSERT INTO hibernate.projects (name, developer_id) VALUES ( 'Eclipse',2);
INSERT INTO hibernate.projects (name, developer_id) VALUES ( 'Hibernate',1);