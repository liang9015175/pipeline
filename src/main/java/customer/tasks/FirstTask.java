package customer.tasks;

import customer.TaskPipeline;
import customer.TaskStage;
import customer.annotion.Task;
import customer.stage.UserStage;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
@Component
@Data
public class FirstTask extends TaskPipeline{
    private Integer id=2;
    public TaskStage execute(TaskStage taskStage) {
        UserStage userStage=(UserStage)taskStage;
        userStage.setId(1);
        userStage.setAge(1);
        userStage.setUsername("1");
        return userStage;
    }
}
