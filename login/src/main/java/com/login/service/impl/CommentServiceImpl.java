package com.login.service.impl;

import com.github.pagehelper.PageHelper;
import com.login.dao.CommentDao;
import com.login.entity.Comment;
import com.login.service.CommentService;
import com.login.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;
    @Override
    public PageBean<Comment> queryComment(String keywords,int pageNum) {


        PageBean<Comment> commentPageBean = new PageBean<>();
        commentPageBean.setKeywords(keywords);
        int totalCount = commentDao.findKeyCount(keywords);
        commentPageBean.setTotalCounts(totalCount);
        commentPageBean.setRows(2);
        //计算总页码:
        int totalPage = totalCount%commentPageBean.getRows() == 0 ? totalCount/commentPageBean.getRows() : totalCount/commentPageBean.getRows() +1;
        commentPageBean.setTotalPage(totalPage);
        PageHelper.startPage(pageNum,2);
        List<Comment> list = commentDao.queryComment(keywords);
        commentPageBean.setList(list);
        return commentPageBean;
    }

    @Override
    public PageBean<Comment> queryAllComment( int pageNum) {
        PageBean<Comment> commentPageBean = new PageBean<>();
        int totalCount = commentDao.findTotalCount();
        System.out.println("------------------totalCount:"+totalCount);
        commentPageBean.setTotalCounts(totalCount);
        System.out.println("================"+commentPageBean.getTotalCounts());
        commentPageBean.setRows(2);
        //计算总页码:
        int totalPage = totalCount%commentPageBean.getRows() == 0 ? totalCount/commentPageBean.getRows() : totalCount/commentPageBean.getRows() +1;
        commentPageBean.setTotalPage(totalPage);
        System.out.println("------------------totalPage:"+totalPage);

        PageHelper.startPage(pageNum,2);
        List<Comment> list = commentDao.selectAll();
        commentPageBean.setList(list);
        return commentPageBean;
    }

    @Override
    public Comment queryOne(Integer id) {
        return commentDao.selectOne(id);

    }

}
