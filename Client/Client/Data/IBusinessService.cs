using System.Collections.Generic;
using System.Net;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public interface IBusinessService
    {
        Task<HttpStatusCode> AddBusiness(Business business);
        Task<IList<Business>> GetBusinessesAsync();
    }
}