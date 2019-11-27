package com.briup.cms.service.impl;

import com.briup.cms.bean.Article;
import com.briup.cms.dao.IArticleDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.IArticleService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleServiceImpl implements IArticleService{

    @Autowired
    private IArticleDao articleDao;

    @Override
    public void addArticle(Article article) throws CustomerException {
        if(article == null){
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");
        }
        //下面要先设置两个，一个是点击量默认从0开始，另一个发布日期，要从写实时的日期
        article.setClickTimes(0);
        article.setPublishDate(new Date());
        articleDao.save(article);
    }
}
