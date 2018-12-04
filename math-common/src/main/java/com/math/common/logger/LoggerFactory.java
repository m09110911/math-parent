package com.math.common.logger;

public interface LoggerFactory {

    Logger create(Class<?> clazz);

    Logger create(String name);

}

