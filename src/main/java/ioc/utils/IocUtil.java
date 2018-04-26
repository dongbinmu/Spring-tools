package ioc.utils;

import ioc.IocContext;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by dongbin on 2018/4/26.
 */
public class IocUtil {

    public static void inject() {
        Map<Class<?>, Object> beanContext = IocContext.applicationContext;
        try {
            for (Map.Entry<Class<?>, Object> entry : beanContext.entrySet()) {
                Class<?> clazz = entry.getKey();
                Object obj = entry.getValue();
                Field[] fields = clazz.getDeclaredFields();

                for (Field field : fields) {
                    Class<?> fieldClazz = field.getType();
                    field.setAccessible(true);
                    Object fieldObj = beanContext.get(fieldClazz);
                    field.set(obj,fieldObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
