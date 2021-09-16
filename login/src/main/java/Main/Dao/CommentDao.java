package Main.Dao;

import Main.bean.Comment;

import java.util.List;

public interface CommentDao {
    public Comment getCmtById(int id);
    public List<Comment> getAllComments();
    public int delCmtById(int id);
    public int saveComment(Comment comment);
    public int updateCmt(Comment cmt);

    public List<Comment> queryForPageItems(int begin, int pageSize);
    public Integer queryForPageTotalCount();
}
