
import com.ssm.template.dao.ItemDAO;
import com.ssm.template.pojos.User;
import com.ssm.template.services.impl.ItemService;
import com.ssm.template.services.impl.UserService;
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
    private ItemService itemService;

    @org.junit.Test
    public void text(){
        for (int i = 0 ; i > 1000; i++){
            new Thread(){
                @Override
                public void run() {
                    itemService.getItems("1");
                }
            }.start();
        }
    }
}
