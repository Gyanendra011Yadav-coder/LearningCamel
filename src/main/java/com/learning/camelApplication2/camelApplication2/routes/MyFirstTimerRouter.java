package com.learning.camelApplication2.camelApplication2.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Component
public class MyFirstTimerRouter extends RouteBuilder {

    @Autowired
    CurrentTime currentTime;

    @Override
    public void configure() throws Exception {
        from("timer: myCamelApplication-TimerRouter")
                .transform().constant(currentTime.getTime())
                .to("log: myCamelApplication-TimerRouter");
//                .log("${body}")
//                .to("file/tmp/camelFiles/camelCreated");
    }
}

@Component
class CurrentTime{
    public String getTime(){
        return "Current time is"+ LocalTime.now();
    }
}
