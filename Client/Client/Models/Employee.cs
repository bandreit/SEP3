using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace Client.Models
{
    public class Employee : User
    {
        [JsonPropertyName("serviceIdList")] public List<string> serviceIdList { get; set; }
    }
}