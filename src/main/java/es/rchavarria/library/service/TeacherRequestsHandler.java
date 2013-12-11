package es.rchavarria.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.domain.Teacher;
import es.rchavarria.library.event.AllTeachersEvent;
import es.rchavarria.library.persistence.LibraryRepository;

public class TeacherRequestsHandler implements TeacherService {

    @Autowired
    private final LibraryRepository repository;
    
    public TeacherRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllTeachersEvent requestAllTeachers() {
        List<Teacher> teachers = repository.listTeachers();
        return new AllTeachersEvent(teachers);
    }

}