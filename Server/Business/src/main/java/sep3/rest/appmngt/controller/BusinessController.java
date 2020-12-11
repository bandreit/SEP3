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

    @GetMapping("/owned-business")
    public ResponseEntity<List<Business>> getOwnedBusinesses(@RequestParam String businessOwnerID) {
        try {
            List<Business> returnedBusiness = businessService.getOwnedBusinesses(businessOwnerID);
            return ResponseEntity.ok(returnedBusiness);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/employee")
    public ResponseEntity addEmployee(@RequestParam String businessId, @RequestParam String employeeId) {
        try {
            businessService.addEmployee(employeeId, businessId);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/removeEmployee")
    public ResponseEntity removeEmployee(@RequestParam String businessId, @RequestParam String employeeId) {
        try {
            businessService.removeEmployee(employeeId, businessId);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }


}