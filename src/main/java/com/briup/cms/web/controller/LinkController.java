package com.briup.cms.web.controller;

import com.briup.cms.bean.Link;
import com.briup.cms.dao.ILinkDao;
import com.briup.cms.service.ILinkService;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/link")
@Api(description = "连接管理")
public class LinkController  {
    @Autowired
    private ILinkService linkService;

    @PostMapping("/add")
    @ApiOperation("添加链接")
    public Message addLink(Link link){
        linkService.saveOrUpdate(link);
        return MessageUtil.success();   //这里一切要返回的数据都是要返回给前端
    }

    //新增和修改的时候用post，其他基本上都是get，我认为新增修改都是要给服务器传递数据，所以用post请求，但是其余的对服务器没有改变所以用get请求
    @GetMapping("/deleteById")
    @ApiOperation("根据id删除链接")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)   //给参数进行一些标注在swagger2中
    public Message deleteLink(int id){
        linkService.deleteLink(id);
        return MessageUtil.success();  //删除不需要携带数据，需要携带数据的时候在用带参数的
    }

    @GetMapping("/queryById")
    @ApiOperation("根据id查询数据")
    @ApiImplicitParam(name = "id",value = "链接id",paramType = "query",dataType = "int",required = true)
    public Message<Link> queryById(int id){
        Link link = linkService.findById(id);
        return MessageUtil.success(link);  //传回来需要数据，就是说data里面有数据，不是null，返回的正是要查询的link集合
    }

    @PostMapping("/update")
    @ApiOperation("修改链接")
    public Message update(Link link){
        linkService.saveOrUpdate(link);
        return MessageUtil.success();
    }

    //查询所有，因为有一个链接管理，而连接管理这个界面必须把所有的链接都得展示出来，所以需要这个接口功能去实现
    @GetMapping("/findAll")
    @ApiOperation("查询所有链接")
    public Message<List<Link>> findAll(){
        List<Link> list = linkService.findAll();
        return MessageUtil.success(list);
    }
}
