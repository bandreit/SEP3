using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Location
    {
        [JsonPropertyName("streetNumber")] public string StreetNumber { get; set; }
        [JsonPropertyName("streetName")] public string StreetName { get; set; }
    }
}