package com.example.studentregistration.events;

import com.example.studentregistration.Student;
import com.example.studentregistration.StudentsRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.shell.ShellApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@ConditionalOnProperty("app.autoFilling.enabled")
public class AutoFillingListener {

    private final StudentsRegistration registration;

    public AutoFillingListener(StudentsRegistration registration) {
        this.registration = registration;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void listener(){

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Max","White",32));
        students.add(new Student(2,"Alex","Black",30));
        students.add(new Student(3,"Tom","Green",31));

        registration.setStudents(students);
    }

}
