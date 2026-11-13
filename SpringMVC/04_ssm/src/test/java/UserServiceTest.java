import com.jeang.config.SpringConfig;
import com.jeang.domain.User;
import com.jeang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetById() {
        User user = userService.getById(1);
        System.out.println(user.toString());
    }

    @Test
    public void testGetAll() {
        List<User> list = userService.getAll();
        System.out.println(list);
    }
}
