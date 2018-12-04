package com.math.common.logger;

public enum Level {
    DEBUG("debug"),
    INFO("info "),
    WARN("warn "),
    ERROR("error"),
    ;
    public String level;

    Level(String level) {
        this.level = level;
    }

    public Boolean isEqualOrGreaterThan(Level level) {
        return ordinal() >= level.ordinal();
    }

    public Boolean isEqualOrLowerThan(Level level) {
        return ordinal() <= level.ordinal();
    }

}
