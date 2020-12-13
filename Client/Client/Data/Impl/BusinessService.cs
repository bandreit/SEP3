using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Net.Mime;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class BusinessService : IBusinessService
    {
        private HttpClient client;

        public BusinessService()
        {
            client = new HttpClient();
        }

        public async Task<HttpStatusCode> AddBusiness(Business business)
        {
            string familySerialized = JsonSerializer.Serialize(business);
            HttpClient client = new HttpClient();

            StringContent content = new StringContent(
                familySerialized,
                Encoding.UTF8,
                MediaTypeNames.Application.Json
            );
            HttpResponseMessage responseMessage =
                await client.PostAsync("http://localhost:8083/SEP3/business", content);
            return responseMessage.StatusCode;
        }

        public async Task<IList<Business>> GetBusinessesAsync()
        {
            string requestURI = "http://localhost:8083/SEP3/business";

            HttpClient client = new HttpClient();
            List<Business> businesses = new List<Business>();

            HttpResponseMessage responseMessage =
                await client.GetAsync(requestURI);

            String reply = await responseMessage.Content.ReadAsStringAsync();
            businesses = JsonSerializer.Deserialize<List<Business>>(reply);
            
            return businesses;
        }

        public async Task<HttpStatusCode> AddEmployee(string employeeId, string businessId)
        {
            string uri = "http://localhost:8083/SEP3/employee?";
            if (employeeId != null && businessId != null)
            {
                uri += $"businessId={businessId}&employeeId={employeeId}";
            }

            HttpResponseMessage responseMessage = await client.PostAsync(uri, null);
            return responseMessage.StatusCode;
        }

        public async Task RemoveEmployee(string employeeId, string businessId)
        {
            await client.DeleteAsync(
                $"http://localhost:8083/SEP3/employee?businessId={businessId}&employeeId={employeeId}");
        }

        public async Task<List<Employee>> GetAllEmployees()
        {
            string message = await client.GetStringAsync("http://localhost:8083/SEP3/employee");
            List<Employee> result = JsonSerializer.Deserialize<List<Employee>>(message);
            return result;
        }
    }
}