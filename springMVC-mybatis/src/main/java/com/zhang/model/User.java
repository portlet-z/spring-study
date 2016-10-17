package com.zhang.model;

/**
 * @author zhangxinzheng
 * @Date 2016/4/20
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer gender;
//    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

//    public String getRemark() {
//        return remark;
//    }

//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
}
