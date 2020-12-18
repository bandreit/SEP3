package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.Employee;
import sep3.rest.appmngt.service.BusinessService;
import sep3.rest.appmngt.service.UserService;

import java.io.IOException;
import java.util.List;

/**
 * The type Business controller.
 */
@RestController
@RequestMapping("/SEP3")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private UserService userService;

    /**
     * Add business response entity.
     *
     * @param business the business
     * @return the response entity
     */
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

    /**
     * Gets businesses.
     *
     * @return the businesses
     */
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

    /**
     * Gets business.
     *
     * @param businessId the business id
     * @return the business
     */
    @GetMapping("/this-business")
    public ResponseEntity<Business> getBusiness(@RequestParam String businessId) {
        try {
            Business returnedBusiness = businessService.getBusinessById(businessId);
            return ResponseEntity.ok(returnedBusiness);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Edit business response entity.
     *
     * @param business the business
     * @return the response entity
     */
    @PutMapping("/this-business")
    public ResponseEntity<Business> editBusiness(@RequestBody Business business){
        try {
            businessService.editBusiness(business);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Gets owned businesses.
     *
     * @param businessOwnerID the business owner id
     * @return the owned businesses
     */
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

    /**
     * Add employee response entity.
     *
     * @param businessId  the business id
     * @param employeeIds the employee ids
     * @param serviceId   the service id
     * @return the response entity
     */
    @PutMapping("/employee")
    public ResponseEntity addEmployee(@RequestParam String businessId, @RequestBody List<String> employeeIds, @RequestParam String serviceId) {
        try {
            businessService.addEmployee(employeeIds, businessId, serviceId);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Remove employee response entity.
     *
     * @param businessId the business id
     * @param employeeId the employee id
     * @return the response entity
     */
    @DeleteMapping("/employee")
    public ResponseEntity removeEmployee(@RequestParam String businessId, @RequestParam String employeeId) {
        try {
            businessService.removeEmployee(employeeId, businessId);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            List<Employee> returnedEmployee = userService.getAllEmployees();
            return ResponseEntity.ok(returnedEmployee);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }


}