package com.login.service;

import com.login.entity.Item;
import com.login.util.PageBean;


public interface ItemService {
    PageBean<Item> findItemByKeywords(String keywords, int pageNum);
    Item getOneItem(int id);
}
