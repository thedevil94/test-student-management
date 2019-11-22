package com.huucong.controller;

import com.huucong.model.ClassRoom;
import com.huucong.model.Student;
import com.huucong.service.ClassRoomService;
import com.huucong.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassRoomService classRoomService;
    @ModelAttribute(value = "classRoom")
    Iterable<ClassRoom> classRoom (){
        return classRoomService.findAll();
    }

    @GetMapping("/student")
    public ModelAndView listStudent(@PageableDefault(size = 5) Pageable pageable){
        Page<Student> students = studentService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students",students);
        return modelAndView;
    }

    @GetMapping("/create-student")
    public ModelAndView createFormStudents(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/create-student")
    public ModelAndView createStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @GetMapping("/edit-student/{id}")
    public ModelAndView editFormStudent(@PathVariable int id){
        Student student = studentService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/student/edit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/edit-student")
    public ModelAndView editStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.remove(id);
        return "redirect:/student";
    }

    @GetMapping("/searchByCategory")
    public ModelAndView getStudentByClassroom(@RequestParam("srch") String search, @PageableDefault(size = 4) Pageable pageable){
        ClassRoom classRoom = classRoomService.findById(Integer.parseInt(search));
        Page<Student> students = studentService.findAllByClassRoom(classRoom, pageable);
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("students", students);
        modelAndView.addObject("srch",search);
        return modelAndView;
    }
}
