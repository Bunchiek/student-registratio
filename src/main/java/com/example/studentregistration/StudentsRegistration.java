package com.example.studentregistration;

import com.example.studentregistration.events.AddingStudentEvent;
import com.example.studentregistration.events.AutoFillingListener;
import com.example.studentregistration.events.RemovingStudentEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
@Getter
@Setter
public class StudentsRegistration {

    private List<Student> students = new ArrayList<>();

    private final ApplicationEventPublisher publisher;


    @ShellMethod(key = "a")
    public void addStudent(@ShellOption(value = "f")String firstName, @ShellOption(value = "l")String lastName, @ShellOption(value = "a")int age){
        int id = 1;
        if(!students.isEmpty()){
            id = students.stream().max(Comparator.comparing(Student::getId)).orElseThrow().getId() + 1;
        }
        Student student = Student.builder().firstName(firstName).lastName(lastName).age(age).id(id).build();
        students.add(student);
        publisher.publishEvent(new AddingStudentEvent(this,student));
    }

    @ShellMethod(key = "s")
    public void showStudents(){
        students.forEach(System.out::println);
    }

    @ShellMethod(key = "d")
    public void deleteStudent(int id){
        Student toDelete = students.stream()
                .filter(s->s.getId()==id).findAny().get();
        students.remove(toDelete);
        publisher.publishEvent(new RemovingStudentEvent(this, toDelete));
    }

    @ShellMethod(key = "c")
    public String clearStudent(){
        students.clear();
        return "All student removed";
    }

}
