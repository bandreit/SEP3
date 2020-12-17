using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class ServiceService : IServiceService
    {
        public const string _endpoint = "https://localhost:8083/SEP3";

        public async Task addService(Service service)
        {
            using (HttpClient client = new HttpClient())
            {
                string serializedContent = JsonSerializer.Serialize(service);
                StringContent content = new StringContent(serializedContent, Encoding.UTF8, "application/json");

                await client.PostAsync($"{_endpoint}/service", content);
            }
        }

        public async Task<List<Service>> GetServicesByBusinessId(string businessId)
        {
            using (HttpClient client = new HttpClient())
            {
                List<Service> servicesByBusinessId = new List<Service>();
                HttpResponseMessage responseMessage =
                    await client.GetAsync($"{_endpoint}/service?businessId={businessId}");
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
                HttpResponseMessage responseMessage =
                    await client.GetAsync($"{_endpoint}/servicesByTitle?title={title}");
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
                HttpResponseMessage responseMessage = await client.GetAsync($"{_endpoint}/services");
                String reply = await responseMessage.Content.ReadAsStringAsync();
                services = JsonSerializer.Deserialize<List<Service>>(reply);
                return services;
            }
        }

        public async Task<Service> getServiceById(string serviceId)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpResponseMessage responseMessage = await client.GetAsync($"{_endpoint}/services");
                String reply = await responseMessage.Content.ReadAsStringAsync();
                List<Service> services = JsonSerializer.Deserialize<List<Service>>(reply);
                Service service = services.FirstOrDefault(x => x.id == serviceId);
                return service;
            }
        }

        public async Task DeleteService(string serviceId)
        {
            using (HttpClient client = new HttpClient())
            {
                await client.DeleteAsync($"{_endpoint}/services?serviceId={serviceId}");
            }
        }
    }
}