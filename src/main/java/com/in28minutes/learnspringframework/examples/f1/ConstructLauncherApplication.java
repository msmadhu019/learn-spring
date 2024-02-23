package com.in28minutes.learnspringframework.examples.f1;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private final SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All are initialised..!!");
    }

    @PostConstruct
    public void initialize() {
        System.out.println("Initializing Post construct");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Im ready");
    }
}

@Configuration
@ComponentScan
public class ConstructLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ConstructLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
