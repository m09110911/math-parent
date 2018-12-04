package com.math.common.json;

public class Node {

    private Integer code;

    private String msg;

    public Node(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Node{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
