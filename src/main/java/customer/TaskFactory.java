package customer;

import com.sun.javafx.collections.transformation.SortableList;
import com.sun.javafx.collections.transformation.SortedList;
import lombok.Data;

import java.util.Comparator;
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
@Data
public class TaskFactory {
    private List<TaskPipeline> list=new SortedList<TaskPipeline>(new Vector<TaskPipeline>(), new Comparator<TaskPipeline>() {
        public int compare(TaskPipeline o1, TaskPipeline o2) {
            return o1.getId()-o2.getId();
        }
    }, SortableList.SortMode.LIVE);
    private Map<String,TaskPipeline> map=new ConcurrentHashMap<String, TaskPipeline>();
    public TaskStage start(TaskStage stage){
        TaskStage first = getList().get(0).execute(stage);
        return first;
    }
}
