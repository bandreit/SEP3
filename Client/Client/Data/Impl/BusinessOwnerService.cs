using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;


namespace Client.Data.Impl
{
    public class BusinessOwnerService : IBusinessOwnerService
    {
        private readonly HttpClient client;

        public BusinessOwnerService()
        {
            client = new HttpClient();
        }

        public async Task<BusinessOwner> GetBusinessOwner(string id)
        {
            HttpResponseMessage responseMessage =
                await client.GetAsync(
                    $"http://localhost:8083/SEP3/validate?id={id}");
            String reply = await responseMessage.Content.ReadAsStringAsync();
            BusinessOwner result = JsonSerializer.Deserialize<BusinessOwner>(reply);
            return result;
        }
    }
}