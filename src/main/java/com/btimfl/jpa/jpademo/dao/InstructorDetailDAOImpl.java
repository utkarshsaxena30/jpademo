package com.btimfl.jpa.jpademo.dao;

import com.btimfl.jpa.jpademo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }
}
