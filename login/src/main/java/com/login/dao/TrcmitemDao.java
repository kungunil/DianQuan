package com.login.dao;

import com.login.entity.Item;

import java.util.List;

public interface TrcmitemDao {
    List<Item> getAllByRank();
    int findTotalCount();
}
