package com.bjyada.demo.entity;

/**
 * Created by Administrator on 2017/10/18.
 */
public class JsonReturn {
    private String key;
    private String value;

    public JsonReturn() {
    }

    public JsonReturn(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "JsonReturn{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
