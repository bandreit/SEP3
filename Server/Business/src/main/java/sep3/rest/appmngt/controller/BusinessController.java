package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.model.Service;
import sep3.rest.appmngt.service.BusinessService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/SEP3")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @PostMapping("/business")
    public ResponseEntity<Business> addBusiness(@RequestBody Business business) {
        try {
            Business returnedBusiness = businessService.addBusiness(business);
            return ResponseEntity.ok(returnedBusiness);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/business")
    public ResponseEntity<List<Business>> getBusinesses() {
        try {
            List<Business> returnedBusiness = businessService.getAllBusiness();
            return ResponseEntity.ok(returnedBusiness);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestParam String businessId, @RequestBody Employee employee) {
        try {
            Employee returnedEmployee = businessService.addEmployee(employee, businessId);
            return ResponseEntity.ok(returnedEmployee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}