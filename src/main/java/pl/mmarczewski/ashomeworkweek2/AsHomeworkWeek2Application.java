package pl.mmarczewski.ashomeworkweek2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class AsHomeworkWeek2Application {

    public static void main(String[] args) {
        SpringApplication.run(AsHomeworkWeek2Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void checkIfOK(){
        System.out.println("Welcome!");
    }
}
