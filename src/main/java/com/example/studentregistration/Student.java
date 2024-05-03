package com.example.studentregistration;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

}
