package com.example.laptop.pandatv.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public class Tutils {
    private static Class<?> aClass;
    private static Type gener;
    private static Type[] actual;

    public static <T>T setT(Object o,int i){
        try {
            aClass = o.getClass();
            gener = aClass.getGenericSuperclass();
            actual = ((ParameterizedType) gener).getActualTypeArguments();
            Type type = actual[i];
            return ((Class<T>)type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

}
