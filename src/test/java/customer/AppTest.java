package customer;


import customer.stage.UserStage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppTest {
    @Autowired
    private TaskFactory taskFactory;
    @Test
    public void test(){
        TaskStage taskStage=new UserStage();
        TaskStage start = taskFactory.start(taskStage);
        System.out.println(start);
    }
}