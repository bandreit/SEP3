using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IServiceService
    {
        Task addService(Service service);
    }
}