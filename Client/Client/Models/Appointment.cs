namespace Client.Models
{
    public class Appointment
    {
        public string id { get; set; }
        public string serviceId { get; set; }
        public string createdBy { get; set; }
        public string scheduledTime { get; set; }
        public Location selectedLocation { get; set; }
        public string selectedEmployeeId { get; set; }
    }
}