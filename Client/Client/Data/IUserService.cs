using System.Threading.Tasks;
using Client.Models;

namespace Client.Data
{
    public interface IUserService
    {
        Task<User> ValidateUser(string userName, string Password);
        Task RegisterUser(User user);
    }
}