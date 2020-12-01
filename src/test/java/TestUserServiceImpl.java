import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void selectTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.queryOne("123123");
        System.out.println(user);
    }

    @Test
    public void selectTest1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = userDAO.queryOne("wuge");
        System.out.println(user);
    }

    @Test
    public void selectSave() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setUsername("123123");
        user.setPassword("123123");
        user.setRealname("123123");
        user.setSex("男");
        userService.save(user);
    }

    @Test
    public void selectSave1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User();
        user.setId("3");
        user.setUsername("123123");
        user.setPassword("123123");
        user.setRealname("123123");
        user.setSex("男");
        userDAO.save(user);
    }
}
