package com.dcits.spring.context;

import com.dcits.spring.anno.XuzzComponent;
import com.dcits.spring.anno.XuzzCompontentScan;
import com.dcits.spring.anno.XuzzScope;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 作为Spring的容器类
 */
public class XuzzApplicationContext {
    //将参数配置类作为初始参数传入
    private Class config;
    //beanDefination存放map
    private Map<String,XuzzBeanDefination> beanDefinationMap =
            new ConcurrentHashMap<>();
    private Map<String,Object> singletonMap = new ConcurrentHashMap<>();

    public XuzzApplicationContext(Class config){
        this.config = config;
        //开始对输入的配置参数信息进行扫描
        scan(config);
        for(Map.Entry<String,XuzzBeanDefination> entry : beanDefinationMap.entrySet()){
            String beanName = entry.getKey();
            XuzzBeanDefination beanDefination = entry.getValue();
            if(beanDefination.getScope().equals("singleton")){
                Object bean= createBean(beanName,beanDefination);
                //将bean存起来
                singletonMap.put(beanName,bean);
            }
        }
    }
    public Object createBean(String beanName,XuzzBeanDefination beanDefination){
        Class clazz = beanDefination.getType();
        Object bean= null;
        try {
            bean = clazz.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return  bean;
    }
    private void scan(Class config) {
        if (config.isAnnotationPresent(XuzzCompontentScan.class)) {
            //获取扫描路径
            XuzzCompontentScan compontentScan = (XuzzCompontentScan) config.getAnnotation(XuzzCompontentScan.class);
            String path = compontentScan.value();
            //获取对应的扫描路径，---需要对应到对应的编译路径
            path = path.replace(".","/");

            //通过对应的类加载器进行路径获取
            ClassLoader classLoader = XuzzApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            //获取到对应的路径后，开始转换为对应的文件信息
            File classFileDir = new File(resource.getFile());

            //判断是文件还是目录，目录则获取目录下的所有文件
            if (classFileDir.isDirectory()) {
                File[] classFiles = classFileDir.listFiles();
                //遍历这些对应的class文件
                for(File classFile : classFiles){
                    //开始进行类加载
                    String classPath = classFile.getAbsolutePath();
                    classPath = classPath.substring(classPath.indexOf("com"),classPath.indexOf(".class"));
                    classPath = classPath.replace("\\",".");
                    try {
                        Class clazz = classLoader.loadClass(classPath);//将获取到的类加载出来

                        //开始解析类，判断类的模式，类的对应模型，类的对应类型
                        if (clazz.isAnnotationPresent(XuzzComponent.class)) {
                            XuzzComponent xuzzComponent = (XuzzComponent)clazz.getAnnotation(XuzzComponent.class);
                            String beanName = xuzzComponent.value();
                            //表示需要进行注入的类，对需要注入的类，用beanDefination进行存放，放入一个map中
                            XuzzBeanDefination xuzzBeanDefination = new XuzzBeanDefination();
                            xuzzBeanDefination.setType(clazz);
                            //判断单利模式
                            if (clazz.isAnnotationPresent(XuzzScope.class)) {
                                XuzzScope xuzzScope = (XuzzScope) clazz.getAnnotation(XuzzScope.class);
                                xuzzBeanDefination.setScope(xuzzScope.value());
                            }else{
                                //默认单例
                                xuzzBeanDefination.setScope("singleton");
                            }
                            //懒加载判断模式相似
                            beanDefinationMap.put(beanName,xuzzBeanDefination);
                        }

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    public Object getBean(String beanName){
        XuzzBeanDefination beanDefination = beanDefinationMap.get(beanName);
        if (beanDefination.getScope().equals("singleton")) {
            return singletonMap.get(beanName);
        }else {
            return createBean(beanName,beanDefination);
        }
    }



}
