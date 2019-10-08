
import com.ssm.template.pojos.User;
import com.ssm.template.services.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml",
        "classpath:spring-context-druid.xml",
        "classpath:spring-context-mybatis.xml",
        "classpath:spring-context-tx.xml"})
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void getUser(){

        System.out.println(userService.addUser(new User("", "hehe", "123456")));
    }
}
