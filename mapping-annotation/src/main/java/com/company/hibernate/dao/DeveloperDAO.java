package com.company.hibernate.dao;

import com.company.hibernate.model.Developer;

import java.math.BigDecimal;
import java.util.List;

public interface DeveloperDAO extends GenericDAO<Developer, Long> {
    List<Developer> getAllBySpecialty(String specialty);

    List<Developer> getDeveloperWithSalaryAbove(BigDecimal salary);

    List<Developer> getAllDeveloperSQL();

    List<Developer> getAllBySalary(BigDecimal salary);
}
