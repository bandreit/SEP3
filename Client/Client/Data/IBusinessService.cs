using System.Net;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public interface IBusinessService
    {
        Task<HttpStatusCode> AddBusiness(Business business);
        Task<HttpStatusCode> AddEmployee(string employeeId, string businessId);
        Task<User> RemoveEmployee(string employeeId, string businessId);
    }
}