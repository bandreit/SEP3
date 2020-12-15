using System.Net;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public class AppointmentService : IAppointmentService
    {
        public const string _endpoint = "http://localhost:8083/SEP3";
        public async Task addAppointment(Appointment appointment)
        {
            using (HttpClient client = new HttpClient())
            {
                string serializedContent = JsonSerializer.Serialize(appointment);
                StringContent content = new StringContent(serializedContent, Encoding.UTF8, "application/json");

                await client.PostAsync($"{_endpoint}/appointment", content);
            }
        }
    }
}