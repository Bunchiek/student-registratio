package com.example.studentregistration;

import lombok.*;
import org.springframework.shell.standard.ShellComponent;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

}
