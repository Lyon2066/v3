package com.store.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 作为实体类的 基类
 */
public class BaseEntity implements Serializable {
    private String createUser;
    private Date createTime;
    private String  modifiedUser;
    private Date modifiedTime;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(createUser, that.createUser) && Objects.equals(createTime, that.createTime) && Objects.equals(modifiedUser, that.modifiedUser) && Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createUser, createTime, modifiedUser, modifiedTime);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

}
