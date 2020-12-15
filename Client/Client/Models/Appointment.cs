namespace Client.Models
{
    public class Appointment
    {
        public string id { get; set; }
        public string serviceId { get; set; }
        public string scheduledTime { get; set; }
        public string name { get; set; }
        public string email { get; set; }
        public string phone { get; set; }
        public string selectedLocation { get; set; }
        public string selectedEmployeeId { get; set; }
    }
}