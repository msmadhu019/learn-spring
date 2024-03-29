package com.in28minutes.learnspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Named
class DataService {

}

@Named
class BusinessService {
    private DataService dataService;

    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Injection");
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
