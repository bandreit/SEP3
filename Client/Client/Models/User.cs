using System.Text.Json.Serialization;

namespace Client.Models
{
    public class User
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("userName")] public string UserName { get; set; }
        [JsonPropertyName("domain")] public string Domain { get; set; }
        [JsonPropertyName("city")] public string City { get; set; }
        [JsonPropertyName("role")] public string Role { get; set; }
        [JsonPropertyName("securityLevel")] public int SecurityLevel { get; set; }
        [JsonPropertyName("password")] public string Password { get; set; }
    }
}