package com.briup.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "cms_category")
@ApiModel  //这个是在写controller的时候，发现传过来的参数是pojo类的对象，想要对参数在swagger中声明，那么就用@Apixxx来进行声明，并写声明属性
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "栏目id")
    private int id;

    @ApiModelProperty(value = "栏目编码")
    private long code;

    @ApiModelProperty(value = "栏目名称")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
