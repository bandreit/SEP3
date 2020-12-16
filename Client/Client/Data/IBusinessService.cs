using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public interface IBusinessService
    {
        Task<HttpStatusCode> AddBusiness(Business business);
        Task<HttpStatusCode> AddEmployee(string employeeId, string businessId);
        Task RemoveEmployee(string employeeId, string businessId);
        Task<List<Employee>> GetAllEmployees();
        Task<IList<Business>> GetBusinessesAsync();
        Task<IList<Business>> GetOwnedBusinessesAsync(string userClaimValue);
        Task<Business> GetBusiness(string id);
        Task EditBusiness(Business newBusiness);

        Task<List<Employee>> GetEmpoyeesDetails(List<string> employeesIds);
    }
}