package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sep3.rest.appmngt.model.BusinessOwner;
import sep3.rest.appmngt.service.BusinessOwnerService;

import java.io.IOException;

@RestController
@RequestMapping("/SEP3")
public class BusinessOwnerController {
    @Autowired
    private BusinessOwnerService businessOwnerService;

    @GetMapping("/business-owner")
    public ResponseEntity<BusinessOwner> getBusinessOwner(@RequestParam String id) {
        try {
            BusinessOwner businessOwner = businessOwnerService.getBusinessOwner(id);
            return ResponseEntity.ok(businessOwner);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
