package customer;

import customer.annotion.Task;
import lombok.Data;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
public abstract class TaskPipeline {
   public abstract Integer getId();
   protected abstract TaskStage execute (TaskStage taskStage);



}
