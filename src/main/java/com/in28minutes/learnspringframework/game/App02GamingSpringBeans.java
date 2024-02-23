package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class App02GamingSpringBeans {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(App02GamingSpringBeans.class)) {
            context.getBean(GameRunner.class).run();
        }
    }
}
