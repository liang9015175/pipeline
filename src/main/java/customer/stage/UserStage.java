package customer.stage;

import customer.TaskStage;
import lombok.Data;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
@Data
public class UserStage implements TaskStage{
    private Integer id;
    private String username;
    private Integer age;
}
