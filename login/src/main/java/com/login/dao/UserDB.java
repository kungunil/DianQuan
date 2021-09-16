package com.login.dao;

import com.login.entity.Item;
import com.login.entity.User;
import common.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private Connection con=null;
    public User getUserByName(String username){
        con = DBConnection.getConnection();
        User user =null;
        try {
            PreparedStatement statement = con.prepareStatement("select user_id as u_id,username,password,telephone,email,question,answer,type from user where username=?");
            statement.setString(1,username);
            ResultSet set = statement.executeQuery();

            while (set.next()){
                 user = new User(set.getInt(1),set.getString(2),
                        set.getString(3),set.getString(4),set.getString(5),
                        set.getString(6),set.getString(7),set.getInt(8));

            }
            set.close();
            statement.close();
        }catch (Exception e){
            System.out.println("查询出错了");
        }finally {
            DBConnection.closeConnection();
        }
        return user;
    }
    //查询和关键字有关的条目数
    public int selectKeyCounts(String keywords){
        con = DBConnection.getConnection();
        int count =0;
        try {
            PreparedStatement statement = con.prepareStatement("select count(*) from item where title like \"%\"?\"%\" or introduction like \"%\"?\"%\" or username like \"%\"?\"%\"");
            statement.setString(1,keywords);
            statement.setString(2,keywords);
            statement.setString(3,keywords);
            ResultSet set = statement.executeQuery();
            while (set.next()){
               count = set.getInt(1);
            }
            set.close();
            statement.close();
        }catch (Exception e){
            System.out.println("查询出错了");
        }finally {
            DBConnection.closeConnection();
        }
        return count;
    }
    public int selectTopListCounts(){
        con = DBConnection.getConnection();
        int count =0;
        try {
            PreparedStatement statement = con.prepareStatement("select count(*) from t_rcmitem");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                count = set.getInt(1);
            }
            set.close();
            statement.close();
        }catch (Exception e){
            System.out.println("查询出错了");
        }finally {
            DBConnection.closeConnection();
        }
        return count;
    }

    public List<Item> getKeyData(String keywords,int start,int rows){
        con = DBConnection.getConnection();
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("select * from item where title like \"%\"?\"%\" or introduction like \"%\"?\"%\" or username like \"%\"?\"%\" limit ? ,  ?");
            statement.setString(1,keywords);
            statement.setString(2,keywords);
            statement.setString(3,keywords);
            statement.setInt(4,start);
            statement.setInt(5,rows);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Item item = new Item();
                item.setItem_id(set.getInt(1));
                item.setTitle(set.getString(2));
                item.setIntroduction(set.getString(3));
                item.setUsername(set.getString(4));
                item.setDate(set.getTimestamp(5));
                item.setUser_id(set.getInt(6));
                list.add(item);
                System.out.println("_____________item:"+item);
            }
            set.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询出错了");
        }finally {
            DBConnection.closeConnection();
        }
        return list;
    }
    //排行榜查询
    public List<Item> getTopList(){
        con = DBConnection.getConnection();
        List<Item> list = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement(" select i.* from t_rcmitem as t,item i where t.itemid=i.item_id order by t.irank DESC ");
            ResultSet set = statement.executeQuery();
            while (set.next()){
                Item item = new Item();
                item.setItem_id(set.getInt(1));
                item.setTitle(set.getString(2));
                item.setIntroduction(set.getString(3));
                item.setUsername(set.getString(4));
                item.setDate(set.getTimestamp(5));
                item.setUser_id(set.getInt(6));
                list.add(item);
                System.out.println("_____________item:"+item);
            }
            set.close();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询出错了");
        }finally {
            DBConnection.closeConnection();
        }
        return list;
    }
}
