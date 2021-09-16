package com.login.service.impl;

import com.github.pagehelper.PageHelper;
import com.login.dao.TrcmitemDao;
import com.login.entity.Item;
import com.login.entity.Trcmitem;
import com.login.service.TrcmitemService;
import com.login.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrcmitemServiceImpl implements TrcmitemService {

    @Resource
    private TrcmitemDao trcmitemDao;

    @Override
    public PageBean<Item> queryRanks(int pageNum) {
        PageBean<Item> itemPageBean = new PageBean<>();
        int totalCounts = trcmitemDao.findTotalCount();
        itemPageBean.setTotalCounts(totalCounts);
        itemPageBean.setRows(5);
        //计算总页码:
        int totalPage = totalCounts%itemPageBean.getRows() == 0 ? totalCounts/itemPageBean.getRows() :
                totalCounts/itemPageBean.getRows() +1;
        itemPageBean.setTotalPage(totalPage);
        PageHelper.startPage(pageNum,itemPageBean.getRows());
        List<Item> list = trcmitemDao.getAllByRank();
        System.out.println("------------------list的值为:"+list);
        itemPageBean.setList(list);
        return itemPageBean;
    }
}
