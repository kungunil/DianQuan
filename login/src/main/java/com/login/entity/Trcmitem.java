package com.login.entity;

public class Trcmitem {
    private int itemId;
    private int iRank;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getiRank() {
        return iRank;
    }

    public void setiRank(int iRank) {
        this.iRank = iRank;
    }

    @Override
    public String toString() {
        return "Trcmitem{" +
                "itemId=" + itemId +
                ", iRank=" + iRank +
                '}';
    }
}
