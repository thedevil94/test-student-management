package com.huucong.service.impl;

import com.huucong.model.ClassRoom;
import com.huucong.repository.ClassRoomRepository;
import com.huucong.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.repository.ClassRepository;

public class ClassRoomServiceImpl implements ClassRoomService {
    @Autowired
    private ClassRoomRepository classRoomRepository;
    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public ClassRoom findById(int id) {
        return classRoomRepository.findOne(id);
    }

    @Override
    public void save(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void remove(int id) {
        classRoomRepository.delete(id);
    }
}
