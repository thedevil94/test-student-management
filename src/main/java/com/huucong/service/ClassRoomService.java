package com.huucong.service;

import com.huucong.model.ClassRoom;

public interface ClassRoomService {
    Iterable<ClassRoom> findAll();

    ClassRoom findById(int id);

    void save(ClassRoom classRoom);

    void remove(int id);
}
