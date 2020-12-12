using System;
using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Business
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("name")] public string Name { get; set; }
        [JsonPropertyName("locations")] public List<Location> Locations { get; set; }
        [JsonPropertyName("mail")] public string Mail { get; set; }
        [JsonPropertyName("services")] public List<string> Services { get; set; }
        [JsonPropertyName("employees")] public List<string> Employees { get; set; }
        [JsonPropertyName("businessOwnerID")] public string BusinessOwnerId { get; set; }

        public Business()
        {
            Locations = new List<Location>();
        }
    }
}