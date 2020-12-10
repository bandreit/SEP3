package sep3.rest.appmngt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.BusinessList;
import sep3.rest.appmngt.model.BusinessOwner;
import sep3.rest.appmngt.service.BusinessListService;
import sep3.rest.appmngt.service.BusinessOwnerService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/SEP3")
public class BusinessListController {
    @Autowired
    private BusinessListService businessListService;

    @GetMapping("/businessList")
    public ResponseEntity<List<Business>> getBusinessList() {
        try {
            List<Business> businessList = businessListService.getAllBusiness();
            return ResponseEntity.ok(businessList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
