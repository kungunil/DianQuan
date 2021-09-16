package com.login.service;

import com.login.entity.Item;
import com.login.util.PageBean;

public interface TrcmitemService {
    PageBean<Item> queryRanks(int pageNum);
}
