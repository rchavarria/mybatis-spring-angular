package es.rchavarria.library.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.rchavarria.library.core.domain.DetailedTeacher;
import es.rchavarria.library.core.event.AllTeachersEvent;
import es.rchavarria.library.core.persistence.LibraryRepository;

public class TeacherRequestsHandler implements TeacherService {

    @Autowired
    private final LibraryRepository repository;
    
    public TeacherRequestsHandler(LibraryRepository repository) {
        this.repository = repository;
    }
    
    public AllTeachersEvent requestAllTeachers() {
        List<DetailedTeacher> teachers = repository.listTeachers();
        return new AllTeachersEvent(teachers);
    }

}
