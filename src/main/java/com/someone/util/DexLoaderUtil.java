package com.someone.util;

/*
  @Author Someone
 * @Date 2024/09/03 14:00
 */

import dalvik.system.DexClassLoader;

public class DexLoaderUtil {

    public static Class<?> loadDexClass(String dexPath, String classPath, String optimizedDirectory) throws ClassNotFoundException {
        DexClassLoader dexClassLoader = new DexClassLoader(dexPath, optimizedDirectory, null, GlobalUtilSetting.getContext().getClassLoader());
        return dexClassLoader.loadClass(classPath);
    }
}
