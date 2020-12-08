using System.Text.Json.Serialization;

namespace Client.Models
{
    public class User
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("userName")] public string UserName { get; set; }
        [JsonPropertyName("password")] public string Password { get; set; }
        [JsonPropertyName("email")] public string Email { get; set; }
        [JsonPropertyName("city")] public string City { get; set; }
        [JsonPropertyName("role")] public string Role { get; set; }
        [JsonPropertyName("firstName")] public string FirstName { get; set; }
        [JsonPropertyName("lastName")] public string LastName { get; set; }
        [JsonPropertyName("phone")] public string Phone { get; set; }
        
    }
}