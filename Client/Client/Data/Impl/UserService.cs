using System;
using System.Net;
using System.Net.Http;
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
                    $"https://localhost:6969/authenticate?username={userName}&password={password}");

            String reply = await responseMessage.Content.ReadAsStringAsync();
            
            if (responseMessage.StatusCode == HttpStatusCode.NotFound)
            {
                throw new Exception("User not found");
            }

            if (responseMessage.StatusCode == HttpStatusCode.Unauthorized)
            {
                throw new Exception("Incorrect password");
            }

            User first = JsonSerializer.Deserialize<User>(reply);
            return first;
        }
    }
}