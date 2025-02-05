﻿using System.Collections.Generic;
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
        public const string _endpoint = "https://localhost:8083/SEP3";
        public async Task addAppointment(Appointment appointment)
        {
            using (HttpClient client = new HttpClient())
            {
                string serializedContent = JsonSerializer.Serialize(appointment);
                StringContent content = new StringContent(serializedContent, Encoding.UTF8, "application/json");

                await client.PostAsync($"{_endpoint}/appointment", content);
            }
        }

        public async Task<List<Appointment>> getAppointments(string serviceId)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpResponseMessage response = await client.GetAsync($"{_endpoint}/appointments?serviceId={serviceId}");
                string reply = await response.Content.ReadAsStringAsync();
                
                List<Appointment> appointments =  JsonSerializer.Deserialize<List<Appointment>>(reply);
                return appointments;
            }
        }
        
        public async Task<List<Appointment>> getAppointmentsByUserId(string userId)
        {
            using (HttpClient client = new HttpClient())
            {
                HttpResponseMessage response = await client.GetAsync($"{_endpoint}/user-appointments?userId={userId}");
                string reply = await response.Content.ReadAsStringAsync();
                
                List<Appointment> appointments =  JsonSerializer.Deserialize<List<Appointment>>(reply);
                return appointments;
            }
        }

        public async Task deleteAppointment(string appointmentId)
        {
            using (HttpClient client = new HttpClient())
            { 
                await client.DeleteAsync($"{_endpoint}/appointment?appointmentId={appointmentId}");
            }
        }
    }
}