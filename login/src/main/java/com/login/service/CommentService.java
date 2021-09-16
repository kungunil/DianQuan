package com.login.service;

import com.login.entity.Comment;
import com.login.util.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    PageBean<Comment> queryComment(String keywords, int pageNum);
    PageBean<Comment> queryAllComment(int pageNum);
    Comment queryOne(Integer id);
}
