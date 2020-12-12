using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class ServiceService : IServiceService
    {
        public const string _endpoint = "http://localhost:8083/SEP3/service";

        public async Task addService(Service service)
        {
            using (HttpClient client = new HttpClient())
            {
                string serializedContent = JsonSerializer.Serialize(service);
                StringContent content = new StringContent(serializedContent, Encoding.UTF8, "application/json");

                await client.PostAsync(_endpoint, content);
            }
        }

        public async Task<List<Service>>GetServicesByBusinessId(string businessId)
        {
            using (HttpClient client = new HttpClient())
            {
                string message =
                    await client.GetStringAsync($"http://localhost:8083/SEP3/service?businessId={businessId}");
                List<Service> result = JsonSerializer.Deserialize<List<Service>>(message);
                return result;
            }
        }
    }
}