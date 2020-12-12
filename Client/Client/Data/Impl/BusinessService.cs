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
        private readonly HttpClient client;

        public BusinessService()
        {
            client = new HttpClient();
        }

        public async Task<HttpStatusCode> AddBusiness(Business business)
        {
            string familySerialized = JsonSerializer.Serialize(business);

            StringContent content = new StringContent(
                familySerialized,
                Encoding.UTF8,
                MediaTypeNames.Application.Json
            );
            HttpResponseMessage responseMessage =
                await client.PostAsync("http://localhost:8083/SEP3/business", content);
            String reply = await responseMessage.Content.ReadAsStringAsync();
            BusinessOwner result = JsonSerializer.Deserialize<BusinessOwner>(reply);
            return responseMessage.StatusCode;
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