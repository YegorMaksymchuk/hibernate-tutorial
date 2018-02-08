SELECT * FROM hibernate.developers;

SELECT * FROM hibernate.projects;

SELECT * FROM hibernate.developer_skills;

SELECT developers.first_name, developers.last_name, skills.skill
FROM hibernate.developers
INNER JOIN hibernate.developer_skills
ON hibernate.developers.id=hibernate.developer_skills.developer_id
INNER JOIN hibernate.skills
ON hibernate.skills.id=hibernate.developer_skills.skill_id

DROP SCHEMA hibernate;