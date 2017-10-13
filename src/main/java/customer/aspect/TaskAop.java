package customer.aspect;

import customer.TaskConfiguration;
import customer.TaskFactory;
import customer.TaskPipeline;
import customer.TaskStage;
import customer.annotion.Task;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
@EnableAspectJAutoProxy
@Component
@Aspect
public class TaskAop {
    private static final Logger LOGGER= Logger.getLogger(TaskAop.class);
    @Autowired
    private TaskFactory taskConfiguration;
    @Pointcut(value = "execution(public * customer.tasks.*.execute(*.*))")
    public void exec(){

    }
    @AfterReturning(pointcut = "exec()",returning = "result")
    public void doHandler(JoinPoint joinPoint, TaskStage result){
        //TODO next
        taskConfiguration.getList().get(0);
    }
    @AfterThrowing(pointcut = "exec()",throwing = "throwable")
    public void handleException(JoinPoint joinPoint,Throwable throwable){
        Task annotation = joinPoint.getTarget().getClass().getAnnotation(Task.class);
        if(annotation!=null){
            String id = annotation.id();
            LOGGER.error(id+"任务发生了异常");
            throw new RuntimeException(id+"发生异常");
        }
        throw new RuntimeException("发生了异常");
    }

}
