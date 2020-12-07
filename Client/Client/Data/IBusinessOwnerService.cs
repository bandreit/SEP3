using System;
using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IBusinessOwnerService
    {
        Task<BusinessOwner> GetBusinessOwner(String id);
    }
}