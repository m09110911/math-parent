package com.math.common.logger;

public interface Logger {

    /**
     * 获取当前日志级别
     *
     * @return 返回当前日志级别
     */
    Logger getLevel();

    /**
     * 设置日志级别
     *
     * @param level 新的日志级别
     */
    void setLevel(Level level);

    /**
     * 获取当前日志格式化器
     *
     * @return 返回当前日志格式化器
     */
    LogFormatter getFormatter();

    /**
     * 设置当前日志的 格式化器
     *
     * @param formatter 新的日志格式化器
     */
    void setFormatter(LogFormatter formatter);

    /**
     * 为当前日志添加日志监听器
     *
     * @param listener 日志监听器
     */
    void addListener(LogListener listener);

    /**
     * 移除当前日志的一个日志监听器
     *
     * @param listener 日志监听器
     */
    void removeListener(LogListener listener);


    /**
     * 记录一个debug级别的日志信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param message 日志信息
     */
    void debug(String message);

    /**
     * 记录一个debug级别的异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param throwable 异常信息
     */
    void debug(Throwable throwable);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param message   日志信息
     * @param throwable 异常信息
     */
    void debug(String message, Throwable throwable);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param format    日志格式化信息
     * @param throwable 异常信息
     * @param params    格式化参数
     */
    void debug(String format, Throwable throwable, Object... params);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param format 日志格式化信息
     * @param param  格式化参数
     */
    void debug(String format, Object param);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     */
    void debug(String format, Object param1, Object param2);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     */
    void debug(String format, Object param1, Object param2, Object param3);

    /**
     * 记录一个debug级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#DEBUG}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     * @param params 格式化参数
     */
    void debug(String format, Object param1, Object param2, Object param3, Object... params);


    /**
     * 记录一个info级别的日志信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param message 日志信息
     */
    void info(String message);

    /**
     * 记录一个 info 级别的异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param throwable 异常信息
     */
    void info(Throwable throwable);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param message   日志信息
     * @param throwable 异常信息
     */
    void info(String message, Throwable throwable);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param format    日志格式化信息
     * @param throwable 异常信息
     * @param params    格式化参数
     */
    void info(String format, Throwable throwable, Object... params);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param format 日志格式化信息
     * @param param  格式化参数
     */
    void info(String format, Object param);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     */
    void info(String format, Object param1, Object param2);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     */
    void info(String format, Object param1, Object param2, Object param3);

    /**
     * 记录一个info级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#INFO}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     * @param params 格式化参数
     */
    void info(String format, Object param1, Object param2, Object param3, Object... params);


    /**
     * 记录一个 warn 级别的日志信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param message 日志信息
     */
    void warn(String message);

    /**
     * 记录一个 warn 级别的异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param throwable 异常信息
     */
    void warn(Throwable throwable);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param message   日志信息
     * @param throwable 异常信息
     */
    void warn(String message, Throwable throwable);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param format    日志格式化信息
     * @param throwable 异常信息
     * @param params    格式化参数
     */
    void warn(String format, Throwable throwable, Object... params);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param format 日志格式化信息
     * @param param  格式化参数
     */
    void warn(String format, Object param);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     */
    void warn(String format, Object param1, Object param2);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     */
    void warn(String format, Object param1, Object param2, Object param3);

    /**
     * 记录一个warn级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#WARN}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     * @param params 格式化参数
     */
    void warn(String format, Object param1, Object param2, Object param3, Object... params);


    /**
     * 记录一个error级别的日志信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param message 日志信息
     */
    void error(String message);

    /**
     * 记录一个error级别的异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param throwable 异常信息
     */
    void error(Throwable throwable);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param message   日志信息
     * @param throwable 异常信息
     */
    void error(String message, Throwable throwable);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param format    日志格式化信息
     * @param throwable 异常信息
     * @param params    格式化参数
     */
    void error(String format, Throwable throwable, Object... params);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param format 日志格式化信息
     * @param param  格式化参数
     */
    void error(String format, Object param);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     */
    void error(String format, Object param1, Object param2);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     */
    void error(String format, Object param1, Object param2, Object param3);

    /**
     * 记录一个error级别的日志信息和异常信息
     * {@link com.math.common.logger.Level#ERROR}
     *
     * @param format 日志格式化信息
     * @param param1 格式化参数
     * @param param2 格式化参数
     * @param param3 格式化参数
     * @param params 格式化参数
     */
    void error(String format, Object param1, Object param2, Object param3, Object... params);

}
