package com.math.common.json;

import com.math.common.json.impl.DefaultJsonFormatter;
import com.math.common.tools.object.ObjectUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * 对象转json
 */
public final class JsonSerializer {

    private final static Set<Class<?>> existClass = new HashSet<>();


    private final OutputStream out;

    private int level = 0;

    private final boolean formatted;

    private final int tabSize;

    private final JsonFormatter formatter;

    private final static String CHARSET = "UTF-8";

    public JsonSerializer(OutputStream out, boolean formatted, JsonFormatter formatter) {
        this.out = out;
        this.formatted = formatted;
        this.tabSize = formatted ? FORMATTED_DEFAULT_SIZE : 0;
        this.formatter = formatter;
    }

    public JsonSerializer(OutputStream out, boolean formatted) {
        this(out, formatted, new DefaultJsonFormatter());
    }

    public JsonSerializer(OutputStream out) {
        this(out, true, new DefaultJsonFormatter());
    }


    public void outPrint(Object obj) throws IOException {
        if (obj == null) {
            printNull();
            return;
        }
        final Class<?> type = obj.getClass();

        if (type == String.class) {
            printString((String) obj);
        } else if (Collection.class.isAssignableFrom(type)) {
            Collection<Object> collections = (Collection<Object>) obj;
            printCollection(collections);
        } else if (Map.class.isAssignableFrom(type)) {
            Map<String, Object> map = (Map<String, Object>) obj;
            printMap(map);
        } else if (Date.class.isAssignableFrom(type)) {
            printDate((Date) obj);
        } else if (LocalDateTime.class.isAssignableFrom(type)) {
            printDate((LocalDateTime) obj);
        } else if (LocalDate.class.isAssignableFrom(type)) {
            printDate((LocalDate) obj);
        } else if (LocalTime.class.isAssignableFrom(type)) {
            printDate((LocalTime) obj);
        } else if (type == Double.class) {
            printDouble((Double) obj);
        } else if (type == Float.class) {
            printDouble(((Float) obj).doubleValue());
        } else if (type == Long.class) {
            printLong((Long) obj);
        }else if (type == Integer.class) {
            printLong(((Integer) obj).longValue());
        } else if (type == Short.class) {
            printLong(((Short) obj).longValue());
        } else if (type == Byte.class) {
            printLong(((Byte) obj).longValue());
        } else if (type == Boolean.class) {
            printBoolean((Boolean) obj);
        } else {
            outPrintObj(obj);
        }
    }

    private void outPrintObj(Object obj) throws IOException {
        printMap(ObjectUtil.objectToMap(obj));
    }

    private void printBoolean(Boolean booleanValue) throws IOException {
        out.write(booleanValue.toString().getBytes(CHARSET));
    }

    private void printLong(Long longValue) throws IOException {
        out.write(longValue.toString().getBytes(CHARSET));
    }

    private void printDouble(Double doubleValue) throws IOException {
        out.write(formatter.format(doubleValue).getBytes(CHARSET));
    }

    private void printDate(Date date) throws IOException {
        out.write(formatter.format(date).getBytes(CHARSET));
    }

    private void printDate(LocalDateTime localDateTime) throws IOException {
        out.write(formatter.format(localDateTime).getBytes(CHARSET));
    }

    private void printDate(LocalDate localDate) throws IOException {
        out.write(formatter.format(localDate).getBytes(CHARSET));
    }

    private void printDate(LocalTime localTime) throws IOException {
        out.write(formatter.format(localTime).getBytes(CHARSET));
    }

    private void printMap(Map<String, Object> map) throws IOException {
        out.write(BEGIN_OBJECT);
        level++;

        boolean first = true;
        for (final Map.Entry<String, Object> entry : map.entrySet()) {

            if (first) {
                first = false;
            } else {
                out.write(SEPARATOR);
            }

            if (formatted) {
                out.write(NEW_LINE);
                printIndent();
            }

            outPrint(entry.getKey());
            if (formatted) {
                out.write(SPACE);
            }

            out.write(ASSIGN);

            if (formatted) {
                out.write(SPACE);
            }

            outPrint(entry.getValue());
        }

        level--;

        if (formatted && !first) {
            out.write(NEW_LINE);
            printIndent();
        }

        out.write(END_OBJECT);
    }

    private void printCollection(Collection<Object> collections) throws IOException {
        out.write(BEGIN_LIST);
        boolean first = true;
        level++;
        for (final Object obj : collections) {
            if (first) {
                first = false;
            } else {
                out.write(SEPARATOR);
            }

            if (formatted) {
                out.write(NEW_LINE);
                printIndent();
            }
            outPrint(obj);
        }

        if (formatted && !first) {
            out.write(NEW_LINE);
            printIndent();
        }

        level--;
        out.write(END_LIST);
    }

    private void printString(String str) throws IOException {
        out.write(BEGIN_STRING);
        out.write(str.getBytes(CHARSET));
        out.write(END_STRING);
    }

    private void printNull() throws IOException {
        out.write("null".getBytes(CHARSET));
    }

    private void printIndent() throws IOException {
        switch (tabSize * level) {
            case 16:
                out.write(SPACE);
            case 15:
                out.write(SPACE);
            case 14:
                out.write(SPACE);
            case 13:
                out.write(SPACE);
            case 12:
                out.write(SPACE);
            case 11:
                out.write(SPACE);
            case 10:
                out.write(SPACE);
            case 9:
                out.write(SPACE);
            case 8:
                out.write(SPACE);
            case 7:
                out.write(SPACE);
            case 6:
                out.write(SPACE);
            case 5:
                out.write(SPACE);
            case 4:
                out.write(SPACE);
            case 3:
                out.write(SPACE);
            case 2:
                out.write(SPACE);
            case 1:
                out.write(SPACE);
            case 0:
                return;
            default:
                final int count = tabSize * level;
                for (int i = 0; i < count; i++) {
                    out.write(SPACE);
                }
        }
    }


    private int
            BEGIN_OBJECT = '{',
            END_OBJECT = '}',
            BEGIN_LIST = '[',
            END_LIST = ']',
            BEGIN_STRING = '"',
            END_STRING = '"',
            ASSIGN = ':',
            SEPARATOR = ',',
            NEW_LINE = '\n', //换行
            SPACE = ' '; //空格


    private static final int FORMATTED_DEFAULT_SIZE = 2;

}
