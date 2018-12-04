package com.math.common.tools.object;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

public class ObjectUtil {


    private static List<Field> getAllField(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null && clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }


    public static Map<String, String> objToMap(Object obj) {
        return objToMap(obj, String::valueOf);
    }

    public static Map<String, Object> objectToMap(Object obj) {
        return objToMap(obj, Function.identity());
    }


    private static <T> Map<String, T> objToMap(Object obj, Function<Object, T> mapper) {
        List<Field> fields = getAllField(obj.getClass());
        Map<String, T> map = new HashMap<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null) {
                    continue;
                }
                map.put(field.getName(), mapper.apply(value));
            }
            return map;
        } catch (Exception e) {
            //先不管
        }
        return null;
    }


    public static <T> T mapToObject(Map<String, ? extends Object> map, Class<? extends T> clazz) {
        List<Field> fields = getAllField(clazz);
        try {
            T obj = clazz.newInstance();
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = map.get(field.getName());

                if (value == null || field.getName().equals("serialVersionUID")) {
                    continue;
                }
                if (value.getClass() == boolean.class) {
                    field.setBoolean(obj, (boolean) value);
                } else if (value.getClass() == float.class) {

                    field.setFloat(obj, (float) value);
                } else if (value.getClass() == double.class) {
                    field.setDouble(obj, (double) value);
                } else if (value.getClass() == int.class) {

                    field.setInt(obj, (int) value);
                } else if (value.getClass() == char.class) {

                    field.setChar(obj, (char) value);
                } else if (value.getClass() == byte.class) {
                    field.setFloat(obj, (float) value);
                }
                if (value.getClass() == long.class) {
                    field.setLong(obj, (long) value);
                }
                if (value.getClass() == short.class) {
                    field.setShort(obj, (short) value);
                } else {
                    field.set(obj, value);
                }
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
