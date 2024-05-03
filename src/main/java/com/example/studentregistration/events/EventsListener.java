package com.example.studentregistration.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventsListener {

    @EventListener()
    public void listener(AddingStudentEvent event){
        log.info("Student added");
        System.out.println(event.getStudent());
    }


    @EventListener()
    public void listener(RemovingStudentEvent event){
        log.info("Student removed");
        System.out.println("student id: " + event.getStudent().getId());
    }



}
