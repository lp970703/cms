package com.briup.cms.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cms_article")
@ApiModel
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "信息id")
    private int id;

    @ApiModelProperty(value = "信息作者",required = true)
    private String author;

    @ApiModelProperty(value = "点击次数",hidden = true)
    private int clickTimes;  //jpa会把驼峰命名规则clickTimes变成click_times  解决方法：1、修改数据库的字段名。2、修改配置文件，让配置文件跳过这个jpa修改

    @ApiModelProperty(value = "信息内容",required = true)
    private String content;

    @ApiModelProperty(value = "发布时间",hidden = true)
    private Date publishDate;  //会解析成publish_date

    @ApiModelProperty(value = "信息标题",required = true)
    private String title;

    @ManyToOne   //来一个多对一的主键，这样就能够建立与category的关系，多个文章对应单个栏目
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClickTimes() {
        return clickTimes;
    }

    public void setClickTimes(int clickTimes) {
        this.clickTimes = clickTimes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
