package com.briup.cms.web.controller;

import com.briup.cms.bean.Article;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/article")
@RestController
@Api(description = "信息管理")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @PostMapping("/add ")
    @ApiOperation(value = "新增信息",notes = "category.code category.name不需要输入") //这里面value只有一个的时候是可以省略，如果不是一个的时候就不能省略，请看其他的controller就可以知道.这里面的notes是提示信息，就是说明了不需要他前端人员输入
    public Message addArticle(Article article){   //传回来的是article是一个对象，又因为关联了category，所以接口的参数也包含了category的id code name，但是我们只需要她的id
        articleService.addArticle(article);
        return MessageUtil.success();
    }

}


