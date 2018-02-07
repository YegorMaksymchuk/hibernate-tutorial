package com.company.hibernate.dao;

import com.company.hibernate.model.Developer;
import com.company.hibernate.model.Skill;

import java.util.List;

public interface SkillDAO extends GenericDAO<Skill, Long> {

    List<Developer> getDevelopersWithSkill(String skill);
}
