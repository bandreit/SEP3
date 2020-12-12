using System.Collections.Generic;
using System.Net.Http;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IServiceService
    {
        Task addService(Service service);
        Task<List<Service>> GetServicesByBusinessId(string businessId);
    }
}