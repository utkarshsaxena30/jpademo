package com.btimfl.jpa.jpademo.dao;

import com.btimfl.jpa.jpademo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailDAOImpl implements InstructorDetailDAO{

    private final EntityManager entityManager;

    InstructorDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}
