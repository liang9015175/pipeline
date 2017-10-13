package customer;

import customer.annotion.Task;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @项目名称：
 * @类描述：
 * @创建人：songliangliang
 * @创建时间：2017/10/13
 */
@Component
public class config implements BeanFactoryPostProcessor,ApplicationContextAware {
    private ApplicationContext applicationContext;
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ClassPathBeanDefinitionScanner scanner=new ClassPathBeanDefinitionScanner((BeanDefinitionRegistry) configurableListableBeanFactory);
        scanner.setResourceLoader(applicationContext);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Task.class));
        scanner.scan("classpath*:");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
