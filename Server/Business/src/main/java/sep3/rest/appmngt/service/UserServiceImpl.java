package sep3.rest.appmngt.service;

import sep3.rest.appmngt.model.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {
    private final UserModel userModel = new UserModelImpl();
//    private final BusinessOwnerModel businessOwnerModel = new BusinessOwnerImpl();

    public UserServiceImpl() throws IOException {
    }


    @Override
    public User ValidateUser(String userName, String password) throws IOException {
        return userModel.ValidateUser(userName, password);
    }

    @Override
    public void addUser(User user) throws IOException {
//        if (user.getRole().equals("businessOwner")) {
//            BusinessOwner businessOwner = new BusinessOwner(user.getId(),user.getUserName(),user.getPassword(),user.getEmail(),
//                    user.getCity(),user.getRole(),user.getFirstName(),user.getLastName(),user.getPhone());
//            businessOwnerModel.addBusinessOwner(businessOwner);
//        }
    }
}
