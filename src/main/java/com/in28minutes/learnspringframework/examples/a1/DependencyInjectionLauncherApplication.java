package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class Dependency01 {

}

@Component
class Dependency02 {

}

@Component
class YourBusinessClass {
    Dependency01 dependency01;

    Dependency02 dependency02;

    public YourBusinessClass(Dependency01 dependency01, Dependency02 dependency02) {
        System.out.println("Constructor Dependency Injection");
        this.dependency01 = dependency01;
        this.dependency02 = dependency02;
    }

    public String toString() {
        return "Using " + dependency01 + " and " + dependency02;
    }
}

@Configuration
@ComponentScan
public class DependencyInjectionLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
