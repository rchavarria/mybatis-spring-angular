package es.rchavarria.library.controller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.rchavarria.library.domain.Teacher;
import es.rchavarria.library.rest.domain.SimpleTeacher;
import es.rchavarria.library.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(TeacherQueriesController.class);

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<SimpleTeacher> getAllTeachers() {
        LOGGER.info("all teachers will be returned");
        List<SimpleTeacher> teachers = new LinkedList<SimpleTeacher>();
        
        for(Teacher teacher : teacherService.requestAllTeachers().getTeachers()) {
            teachers.add(SimpleTeacher.fromTeacher(teacher));
        }
        
        return teachers;
    }

}
