package com.huucong.controller;

import com.huucong.model.ClassRoom;
import com.huucong.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassRoomController {
    @Autowired
    private ClassRoomService classRoomService;
    @GetMapping("/classroom")
    public ModelAndView listClassRoom(){
        Iterable<ClassRoom> classRooms = classRoomService.findAll();
        ModelAndView modelAndView = new ModelAndView("/classroom/list");
        modelAndView.addObject("classRooms", classRooms);
        return modelAndView;
    }

    @GetMapping("/create-classroom")
    public ModelAndView createFormClassRoom(){
        ModelAndView modelAndView = new ModelAndView("/classroom/create");
        modelAndView.addObject("classroom", new ClassRoom());
        return modelAndView;
    }

    @PostMapping("/create-classroom")
    public ModelAndView crateClassRoom(@ModelAttribute("classroom") ClassRoom classroom){
        classRoomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("redirect:/classroom");
        modelAndView.addObject("classroom", new ClassRoom());
        return modelAndView;
    }

    @GetMapping("/edit-classroom/{id}")
    public ModelAndView editFormClassRoom(@PathVariable int id){
        ClassRoom classroom = classRoomService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/classroom/edit");
        modelAndView.addObject("classroom", classroom);
        return modelAndView;
    }
    @PostMapping("/edit-classroom")
    public ModelAndView editClassRoom(@ModelAttribute("classRoom") ClassRoom classroom){
        classRoomService.save(classroom);
        ModelAndView modelAndView = new ModelAndView("redirect:/classroom");
        modelAndView.addObject("classroom", classroom);
        return modelAndView;
    }

    @GetMapping("/delete-classroom/{id}")
    public String deleteClassRoom(@PathVariable int id){
        classRoomService.remove(id);
        return "redirect:/classroom";
    }
}
