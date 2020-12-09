package sep3.db.model;

public interface BusinessModel {
    Business addBusiness(Business business,String id);
    Service addService(Service service, String id);
    Employee addEmployee(Employee employee, String businessId);
    void removeEmployee(String id);
}
