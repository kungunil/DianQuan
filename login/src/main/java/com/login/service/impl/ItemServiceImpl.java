package com.login.service.impl;

import com.github.pagehelper.PageHelper;
import com.login.dao.ItemDao;
import com.login.entity.Item;
import com.login.service.ItemService;
import com.login.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemDao itemDao;

    @Override// 分页方式查询和keywords有关的条目信息
    public PageBean<Item> findItemByKeywords(String keywords, int pageNum) {
        PageBean<Item> itemPageBean = new PageBean<>();
        itemPageBean.setKeywords(keywords);
        int totalCount = itemDao.findKeyCount(keywords);
        itemPageBean.setTotalCounts(totalCount);
        itemPageBean.setRows(5);
        //计算总页码:
        int totalPage = totalCount%itemPageBean.getRows() == 0 ? totalCount/itemPageBean.getRows() : totalCount/itemPageBean.getRows() +1;
        itemPageBean.setTotalPage(totalPage);
        PageHelper.startPage(pageNum,itemPageBean.getRows());
        List<Item> list = itemDao.findByKeyWords(keywords);
        itemPageBean.setList(list);
        return itemPageBean;
    }

    @Override
    public Item getOneItem(int id) {
        return itemDao.selectOne(id);
    }

}
