package reflectionManager;

import java.lang.reflect.Field;

public class Reflexao {

    private static boolean isObjectsEquals(Object o1, Object o2) {
        if (o1.getClass().getSimpleName().equals(o2.getClass().getSimpleName()))
            return true;
        else
            return false;
    }

    public static void update(Object o1, Object o2) throws NoSuchFieldException, IllegalAccessException {
        if (!isObjectsEquals(o1, o2)) {
            return;
        }

        Field[] objFields = o1.getClass().getDeclaredFields();

        for (Field f : objFields) {
            f.setAccessible(true);
            f.set(o1, f.get(o2));
        }
    }
}
