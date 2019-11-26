package com.briup.cms.service.impl;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.ILinkDao;
import com.briup.cms.exception.CustomerException;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements ILinkService {
    @Autowired
    private ILinkDao linkDao;

    @Override
    public void saveOrUpdate(Link link) throws CustomerException {
        //引用变量必须要判断参数是否为空
        if(link == null){
            throw new CustomerException(CodeUtil.BAD_CODE,"参数为空");   //util下面有一个接口，这个接口有一个异常的状态码，相当于接口直接用这个变量
        }
        linkDao.save(link);   //这个本来就有查询和更新的操作，所以添加与修改都可以用
    }

    @Override
    public void deleteLink(int id) throws CustomerException {
        //因为参数是基本数据类型所以不需要排空
        linkDao.deleteById(id);
    }

    @Override
    public Link findById(int id) throws CustomerException {
        //默认方法解决不了，写一个自己的方法   在ILinkDao完成
        return linkDao.queryById(id);
    }

    @Override
    public List<Link> findAll() throws CustomerException {
        return linkDao.findAll();
    }
}
