package ioc;

import ioc.annotation.Component;
import ioc.utils.IocUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dongbin on 2018/4/26.
 */
public class IocContext {

    public static final Map<Class<?>, Object> applicationContext = new ConcurrentHashMap<>();


    static{
        String packageName = "ioc";
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initBean(String packageName) throws IOException {
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
        while (urls.hasMoreElements()) {
            addClassByAnnotation(urls.nextElement().getPath(), packageName);
        }

        IocUtil.inject();
    }

    private static void addClassByAnnotation(String filePath, String packageName) {
        try {
            File[] files = getClassFile(filePath);
            if (files != null) {
                for (File f : files) {
                    String fileName = f.getName();
                    if(f.isFile()){
                        Class<?> clazz = Class.forName(packageName + "." + fileName.substring(0, fileName.lastIndexOf(".")));
                        if(clazz.isAnnotationPresent(Component.class)) {
                            applicationContext.put(clazz, clazz.newInstance());
                        }
                    }else {
                        addClassByAnnotation(f.getPath(),packageName + "." + fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles(file -> (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory());
    }


}
