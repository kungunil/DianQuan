package Main.Service;

import Main.Dao.CommentDao;
import Main.bean.Comment;
import Main.bean.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CmtService {
    @Autowired
    private CommentDao commentDao;

    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    public Comment getCmtById(int id) {
        return commentDao.getCmtById(id);
    }

    public int delCmtById(int id) {
        return commentDao.delCmtById(id);
    }


    public int updateCmt(Comment cmt) {
        return commentDao.updateCmt(cmt);
    }
    public Page<Comment> page(int pageNo, int pageSize) {
        Page<Comment> page = new Page<Comment>();
        if(pageSize>8){
            page.setPageSize(8);
        }else{
            page.setPageSize(pageSize);
        }

        Integer pageTotalCount  = commentDao.queryForPageTotalCount();
        Integer pageTotal = pageTotalCount / pageSize;

        if(pageTotalCount%pageSize>0){
            pageTotal++;
        }

        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }

        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setPageTotalCount(pageTotalCount);

        int begin = (page.getPageNo() - 1 ) * pageSize;


        List<Comment> comments = commentDao.queryForPageItems(begin,pageSize);
        page.setItems(comments);

        return page;
    }

}
