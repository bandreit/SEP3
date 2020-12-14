using System;
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

        public async Task<List<Service>> GetServicesByBusinessId(string businessId)
        {
            using (HttpClient client = new HttpClient())
            {
                List<Service> servicesByBusinessId = new List<Service>();
                HttpResponseMessage responseMessage = await client.GetAsync($"http://localhost:8083/SEP3/service?businessId={businessId}");
                String reply = await responseMessage.Content.ReadAsStringAsync();
                servicesByBusinessId = JsonSerializer.Deserialize<List<Service>>(reply);
                return servicesByBusinessId;
            }
        }

        public async Task<List<Service>> GetServicesByTitle(string title)
        {
            using (HttpClient client = new HttpClient())
            {
                List<Service> servicesByTitle = new List<Service>();
                HttpResponseMessage responseMessage = await client.GetAsync($"http://localhost:8083/SEP3/servicesByTitle?title={title}");
                String reply = await responseMessage.Content.ReadAsStringAsync();
                servicesByTitle = JsonSerializer.Deserialize<List<Service>>(reply);
                return servicesByTitle;
            }
        }

        public async Task<List<Service>> GetAllServices()
        {
            using (HttpClient client = new HttpClient())
            {
                List<Service> services = new List<Service>();
                HttpResponseMessage responseMessage = await client.GetAsync("http://localhost:8083/SEP3/services");
                String reply = await responseMessage.Content.ReadAsStringAsync();
                services = JsonSerializer.Deserialize<List<Service>>(reply);
                return services;
            }
        }
    }
}