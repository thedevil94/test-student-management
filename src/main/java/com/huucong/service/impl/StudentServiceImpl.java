package com.huucong.service.impl;

import com.huucong.model.ClassRoom;
import com.huucong.model.Student;
import com.huucong.repository.StudentRepository;
import com.huucong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void remove(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Page<Student> findAllByClassRoom(ClassRoom classRoom, Pageable pageable) {
        return studentRepository.findAllByClassRoom(classRoom, pageable);
    }
}
