package com.login.dao;

import com.login.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> queryComment(String keywords);
    List<Comment> selectAll();
    Comment selectOne(Integer id);
    int findTotalCount();
    int findKeyCount(String keywords);
}
