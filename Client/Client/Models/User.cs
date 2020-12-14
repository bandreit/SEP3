using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class User
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("userName")] [Required] public string UserName { get; set; }
        [JsonPropertyName("password")] [Required] public string Password { get; set; }
        [JsonPropertyName("email")] [Required] public string Email { get; set; }
        [JsonPropertyName("city")] [Required] public string City { get; set; }
        [JsonPropertyName("role")] public string Role { get; set; }
        [JsonPropertyName("firstName")] [Required] public string FirstName { get; set; }
        [JsonPropertyName("lastName")] [Required] public string LastName { get; set; }
        [JsonPropertyName("phone")] [Required] public string Phone { get; set; }
        
    }
}