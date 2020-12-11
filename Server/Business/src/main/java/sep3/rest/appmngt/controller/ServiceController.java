package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sep3.rest.appmngt.model.Service;
import sep3.rest.appmngt.service.ServiceService;

import java.io.IOException;


@RestController
@RequestMapping("/SEP3")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @PostMapping("/service")
    public ResponseEntity<Service> addService(@RequestBody Service service) {
        try {
            serviceService.addService(service);
            return ResponseEntity.ok(service);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
