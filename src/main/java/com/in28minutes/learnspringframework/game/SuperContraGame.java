package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole{
    public void up() {
        System.out.println("Look Up");
    }

    public void left() {
        System.out.println("Run");
    }

    public void down() {
        System.out.println("Go Deeper");
    }

    public void right() {
        System.out.println("Jump");
    }


}
