import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import sep3.rest.appmngt.model.User;
import sep3.rest.appmngt.service.UserService;
import sep3.rest.appmngt.service.UserServiceImpl;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class UserServiceTest {
    private final UserService userService = new UserServiceImpl();

    public UserServiceTest() throws IOException {
    }

    @Test
    void Test() throws IOException {
        User user = new User(null, "UseryUser", "passwordyPassword", "email@ejav.com", "Horsens", "BusinessOwner", "Firstname", "Lastname", "+52221081");
        User resUser = userService.addUser(user);
        assertThat(resUser.getUserName(), is(user.getUserName()));
        assertThat(resUser.getPassword(), is(user.getPassword()));
        assertThat(resUser.getEmail(), is(user.getEmail()));
        assertThat(resUser.getCity(), is(user.getCity()));
        assertThat(resUser.getRole(), is(user.getRole()));
        assertThat(resUser.getFirstName(), is(user.getFirstName()));
        assertThat(resUser.getLastName(), is(user.getLastName()));
        assertThat(resUser.getPassword(), is(user.getPassword()));
        assertThat(resUser.getUserName(), notNullValue());
    }

}
