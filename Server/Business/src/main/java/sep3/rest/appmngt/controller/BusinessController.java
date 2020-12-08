package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.BusinessOwner;
import sep3.rest.appmngt.network.BusinessWithBusinessOwnerIdPackage;
import sep3.rest.appmngt.service.BusinessOwnerService;
import sep3.rest.appmngt.service.BusinessService;

import java.io.IOException;

@RestController
@RequestMapping("/SEP3")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @PostMapping("/business")
    public ResponseEntity<Business> addBusiness(@RequestParam String id,@RequestBody Business business) {
        try {
            Business retunedBusiness = businessService.addBusiness(business,id);
            return ResponseEntity.ok(retunedBusiness);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}