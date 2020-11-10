package sep3.rest.appmngt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sep3.rest.appmngt.mediator.ConnectionManager;

import java.io.IOException;

@SpringBootApplication
public class BusinessApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
