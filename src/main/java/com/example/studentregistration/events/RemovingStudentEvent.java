package com.example.studentregistration.events;

import com.example.studentregistration.Student;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RemovingStudentEvent extends ApplicationEvent {

    private Student student;

    public RemovingStudentEvent(Object source, Student student) {
        super(source);
        this.student = student;

    }
}
