package com.huucong.repository;

import com.huucong.model.ClassRoom;
import com.huucong.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer> {
    Page<Student> findAllByClassRoom(ClassRoom classRoom, Pageable pageable);
}
