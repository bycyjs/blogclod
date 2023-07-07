import com.bycyjs.service.bojo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    @org.junit.jupiter.api.Test
    void t() {

        User example = new User();

        Field[] fields = example.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println("Field name: " + field.getName());
        }

    }

    @org.junit.jupiter.api.Test
    void t2() {
        Object object = new User();
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            System.out.println("name:"+f.getName());

        }
        System.out.println("类名:"+object.getClass().getName());
    }



    @org.junit.jupiter.api.Test
    void t3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=new User();
        user.setUsername("test");
        user.setPassword("test");
        Object object=user;
        String pack=object.getClass().getName();
        Method getPassword = object.getClass().getMethod("getPassword", new Class[]{});
        Object invoke = getPassword.invoke(object, new Object[]{});
        System.out.println(invoke);

    }
}
