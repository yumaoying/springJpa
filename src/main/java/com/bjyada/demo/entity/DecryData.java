package com.bjyada.demo.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/10/18.
 */
@Entity
@Table
public class DecryData {
    private Integer id;
    private Integer value;
    private Long time;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "DecryData{" +
                "id=" + id +
                ", value=" + value +
                ", time='" + time + '\'' +
                '}';
    }
}
