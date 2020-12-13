using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Business
    {
        [JsonPropertyName("id")] public string Id { get; set; }
        [JsonPropertyName("name")] [Required] public string Name { get; set; }
        [JsonPropertyName("locations")] [ValidateComplexType] public List<Location> Locations { get; set; }
        [JsonPropertyName("mail")] [Required] public string Mail { get; set; }
        [JsonPropertyName("services")] public List<string> Services { get; set; }
        [JsonPropertyName("employees")] public List<string> Employees { get; set; }
        [JsonPropertyName("businessOwnerID")] public string BusinessOwnerId { get; set; }

        public Business()
        {
            Locations = new List<Location>();
            Services = new List<string>();
            Employees = new List<string>();
        }
    }
}