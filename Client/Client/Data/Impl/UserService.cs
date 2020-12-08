using System;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class UserService : IUserService
    {
        public async Task<User> ValidateUser(string userName, string password)
        {
            HttpClient client = new HttpClient();

            HttpResponseMessage responseMessage =
                await client.GetAsync(
                    $"http://localhost:8083/SEP3/validate?username={userName}&password={password}");

            String reply = await responseMessage.Content.ReadAsStringAsync();

            if (responseMessage.StatusCode == HttpStatusCode.NotFound)
            {
                throw new Exception("User not found");
            }

            if (responseMessage.StatusCode == HttpStatusCode.Unauthorized)
            {
                throw new Exception("Incorrect password");
            }

            if (responseMessage.StatusCode == HttpStatusCode.BadRequest)
            {
                throw new Exception("We're having some problems with our server, please come back later");
            }

            User first = JsonSerializer.Deserialize<User>(reply);
            return first;
        }

        public async Task RegisterUser(User user)
        {
            HttpClient client = new HttpClient();
            string userSerialized = JsonSerializer.Serialize(user);
            StringContent content=new StringContent(
                userSerialized,
                Encoding.UTF8,
                "application/json"
            );
            var response = await client.PostAsync("http://localhost:8083/SEP3/newUser", content);
            Console.WriteLine(response.StatusCode);
        }
    }
}