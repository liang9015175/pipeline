package customer.annotion;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Task {
    String id()  default "";
    String next() default "";
}
