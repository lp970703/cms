package com.briup.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "cms_link")
@ApiModel
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "链接ID")
    private int id;
    @ApiModelProperty(value = "链接名字",required = true)  //必须要输入那么就一定是required = true，如果是隐藏就hidden = true
    private String name;
    @ApiModelProperty(value = "链接ID",required = true)
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
