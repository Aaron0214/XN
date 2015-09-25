package com.xc.xnode.friend.domain;

import java.io.Serializable;

public class Friend implements Serializable {
    private Integer userId;

    private Integer frienfId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFrienfId() {
        return frienfId;
    }

    public void setFrienfId(Integer frienfId) {
        this.frienfId = frienfId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Friend other = (Friend) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getFrienfId() == null ? other.getFrienfId() == null : this.getFrienfId().equals(other.getFrienfId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getFrienfId() == null) ? 0 : getFrienfId().hashCode());
        return result;
    }
}