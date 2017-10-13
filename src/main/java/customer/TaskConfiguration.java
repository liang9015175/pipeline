package customer;

import customer.annotion.Task;
import customer.stage.UserStage;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */

@Configuration
public class TaskConfiguration  {


    @Bean
    public TaskFactory setList(TaskPipeline... tasks){
        TaskFactory taskFactory = new TaskFactory();
        if(tasks!=null&&tasks.length!=0){
            for (TaskPipeline taskPipeline:tasks){
                taskFactory.getList().add(taskPipeline);

            }
        }
        return taskFactory;
    }

}
