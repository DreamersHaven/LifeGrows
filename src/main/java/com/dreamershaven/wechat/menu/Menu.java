package com.dreamershaven.wechat.menu;

import java.sql.Timestamp;

public class Menu {

    private String id;

    private String accountId;

    private String parentId;

    private String parentName;

    private String name;

    private String menuType;

    private String menuKey;

    private String url;

    private Integer menuSort;

    private String createdBy;

    private Timestamp createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String type) {
        this.menuType = type;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String key) {
        this.menuKey = key;
    }

    public Integer getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(Integer sort) {
        this.menuSort = sort;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
