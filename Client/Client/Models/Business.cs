using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Business
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("name")] private string name { get; set; }
        [JsonPropertyName("location")] private string location { get; set; }
        [JsonPropertyName("mail")] private string mail { get; set; }
        [JsonPropertyName("service")] private string service { get; set; }
    }
}