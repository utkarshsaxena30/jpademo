package com.btimfl.jpa.jpademo.dao;

import com.btimfl.jpa.jpademo.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
