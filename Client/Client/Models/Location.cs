using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Location
    {
        [JsonPropertyName("streetNumber")] [Required] public string StreetNumber { get; set; }
        [JsonPropertyName("streetName")] [Required] public string StreetName { get; set; }
    }
}