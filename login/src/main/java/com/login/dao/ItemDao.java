package com.login.dao;

import com.login.entity.Item;

import java.util.List;

public interface ItemDao {
    int findKeyCount(String keywords);
    List<Item> findByKeyWords(String keywords);
    Item selectOne(int id);

}
