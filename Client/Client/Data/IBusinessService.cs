﻿using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data.Impl
{
    public interface IBusinessService
    {
        Task<HttpStatusCode> AddBusiness(Business business);
        Task<HttpStatusCode> AddEmployee(string employeeId, string businessId);
        Task RemoveEmployee(string employeeId, string businessId);
        Task<List<Employee>> GetAllEmployees();
    }
}