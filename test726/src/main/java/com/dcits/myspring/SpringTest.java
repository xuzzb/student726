package com.dcits.myspring;

import com.dcits.myspring.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author xuzzb
 * @Create 2023/2/8
 */
public class SpringTest {
    public static void main(String[] args) {
//        XuzzApplicationContext xuzzApplicationContext = new XuzzApplicationContext(XuzzAppconfig.class);
//        UserService userService = (UserService)xuzzApplicationContext.getBean("userService");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User)context.getBean("user");
        System.out.println(user);
        user.tesst2();
        //        context.register();
//        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
//        beanDefinitionReader.register(UserService.class);
//
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
//        xmlBeanDefinitionReader.loadBeanDefinitions("");
//
//
//        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(context);
//        classPathBeanDefinitionScanner.scan("");

    }
}
