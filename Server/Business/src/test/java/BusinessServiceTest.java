
import org.junit.jupiter.api.Test;
import sep3.rest.appmngt.model.Business;
import sep3.rest.appmngt.model.Location;
import sep3.rest.appmngt.service.BusinessService;
import sep3.rest.appmngt.service.BusinessServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BusinessServiceTest {
    private final BusinessService businessService = new BusinessServiceImpl();

    public BusinessServiceTest() throws IOException {
    }

    @Test
    void getBusinessById() throws IOException {
        Business business = new Business(null, "Sabina's", "andreis@gmail.com", "5fda957b97f5d042d726a3c3");
        Business resBusiness = businessService.addBusiness(business);
        Business businessAfterEdit = businessService.getBusinessById(resBusiness.getId());
        assertThat(businessAfterEdit.getId(), is(resBusiness.getId()));
    }

    @Test
    void addBusiness() throws IOException {
        Business business = new Business(null, "Andrei's", "andreis@gmail.com", "5fda957b97f5d042d726a3c3");
        Business resBusiness = businessService.addBusiness(business);
        assertThat(resBusiness.getBusinessOwnerID(), is(business.getBusinessOwnerID()));
        assertThat(resBusiness.getName(), is(business.getName()));
        assertThat(resBusiness.getMail(), is(business.getMail()));
        assertThat(resBusiness.getServices(), emptyIterable());
        assertThat(resBusiness.getEmployees(), emptyIterable());
        assertThat(resBusiness.getLocations(), emptyIterable());
    }

    @Test
    void editBusiness() throws IOException {
        Business business = new Business(null, "2ndAndrei's", "andreis@gmail.com", "5fda957b97f5d042d726a3c3");
        Business resBusiness = businessService.addBusiness(business);
        assertThat(resBusiness.getLocations().size(), is(0));
        resBusiness.setName("Second's");
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location("streetAddress", "Number"));
        resBusiness.setLocations(locations);
        businessService.editBusiness(resBusiness);
        Business businessAfterEdit = businessService.getBusinessById(resBusiness.getId());
        assertThat(businessAfterEdit.getLocations().size(), is(1));
    }

    @Test
    void getAllBusinesses() throws IOException {
        // MOCK database needed
        int numberOfAllBusinesses = businessService.getAllBusiness().size();
        assertThat(numberOfAllBusinesses, is(businessService.getAllBusiness().size()));
    }

    @Test
    void getOwnedBusinesses() throws IOException {
        List<Business> allBusinesses = businessService.getAllBusiness();
        List<Business> allOwnedBusinessesFromDB = businessService.getOwnedBusinesses("5fae6476a93d05aab46d6537");
        allBusinesses.removeIf(business -> !(business.getBusinessOwnerID().equals("5fae6476a93d05aab46d6537")));
        int i = 0;
        for (Business business : allOwnedBusinessesFromDB) {
            assertThat(business.getId(), is(allBusinesses.get(i).getId()));
            i++;
        }
    }



}
