package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.Service;
import sep3.rest.appmngt.service.ServiceService;

import java.io.IOException;
import java.util.List;


/**
 * The type Service controller.
 */
@RestController
@RequestMapping("/SEP3")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
     * Add service response entity.
     *
     * @param service the service
     * @return the response entity
     */
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

    /**
     * Gets services by business id.
     *
     * @param businessId the business id
     * @return the services by business id
     */
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

    /**
     * Gets services by title.
     *
     * @param title the title
     * @return the services by title
     */
    @GetMapping("/servicesByTitle")
    public ResponseEntity<List<Service>> getServicesByTitle(@RequestParam String title) {
        try {
            List<Service> returnedServices = serviceService.getServiceByTitle(title);
            return ResponseEntity.ok(returnedServices);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Gets all services.
     *
     * @return the all services
     */
    @GetMapping("/services")
    public ResponseEntity<List<Service>> getAllServices() {
        try {
            List<Service> returnedServices = serviceService.getAllServices();
            return ResponseEntity.ok(returnedServices);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Delete service response entity.
     *
     * @param serviceId the service id
     * @return the response entity
     */
    @DeleteMapping("/services")
    public ResponseEntity deleteService(@RequestParam String serviceId)
    {
        try {
            serviceService.deleteService(serviceId);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
