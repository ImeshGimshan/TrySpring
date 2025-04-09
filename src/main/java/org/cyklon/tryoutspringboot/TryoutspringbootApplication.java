package org.cyklon.tryoutspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TryoutspringbootApplication {

    public static void main(String[] args) {

        var ctx = SpringApplication.run(TryoutspringbootApplication.class, args);
        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellStory());
    }

}
