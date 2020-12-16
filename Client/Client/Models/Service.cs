using System.ComponentModel.DataAnnotations;

namespace Client.Models
{
    public class Service
    {
        public string id { get; set; }
        public string pictureUrl { get; set; }
        [Required] public string title { get; set; }
        [Required] public string description { get; set; }
        [Required] public int duration { get; set; }
        public string businessId { get; set; }
    }
}