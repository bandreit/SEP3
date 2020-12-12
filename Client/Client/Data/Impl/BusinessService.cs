using System;
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

        public Task<HttpStatusCode> AddEmployee(string employeeId, string businessId)
        {
            throw new NotImplementedException();
        }

        public Task<User> RemoveEmployee(string employeeId, string businessId)
        {
            throw new NotImplementedException();
        }
    }
}