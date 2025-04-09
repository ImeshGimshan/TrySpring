package org.cyklon.tryoutspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFirstClass {
    private String myVar;

    public MyFirstClass(String myVar){
        this.myVar = myVar;
    }

    @Bean
    public String sayHello(){
        return "Hello" + myVar;
    }
}
