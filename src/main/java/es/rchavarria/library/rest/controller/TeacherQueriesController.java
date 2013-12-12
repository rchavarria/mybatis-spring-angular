package es.rchavarria.library.rest.controller;

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

import es.rchavarria.library.core.service.TeacherService;
import es.rchavarria.library.rest.domain.Teacher;

@Controller
@RequestMapping("/teachers")
public class TeacherQueriesController {

    private static Logger LOGGER = LoggerFactory.getLogger(TeacherQueriesController.class);

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Teacher> getAllTeachers() {
        LOGGER.info("all teachers will be returned");
        return teacherService.requestAllTeachers().getTeachers();
    }

}
