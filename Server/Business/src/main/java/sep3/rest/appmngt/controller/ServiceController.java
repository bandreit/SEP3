package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.Service;
import sep3.rest.appmngt.service.ServiceService;

import java.io.IOException;
import java.util.List;


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

    @GetMapping("/service")
    public ResponseEntity<List<Service>> getServicesByBusinessId(@RequestParam String businessId) {
        try {
            List<Service> returnedServices = serviceService.getServicesByBusinessId(businessId);
            return ResponseEntity.ok(returnedServices);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
