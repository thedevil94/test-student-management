package com.huucong.service;

import com.huucong.model.ClassRoom;
import com.huucong.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> findAll(Pageable pageable);

    Student findById(int id);

    void save(Student student);

    void remove(int id);

    Page<Student> findAllByClassRoom(ClassRoom classRoom, Pageable pageable);

}
