using System.Collections.Generic;
using System.Net;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IAppointmentService
    {
        Task addAppointment(Appointment appointment);
        Task<List<Appointment>> getAppointments(string serviceId);
    }
}