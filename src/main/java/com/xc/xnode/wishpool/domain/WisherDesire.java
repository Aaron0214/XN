package com.xc.xnode.wishpool.domain;

import java.io.Serializable;
import java.util.Date;

public class WisherDesire implements Serializable {
    private Integer wisherId;

    private Integer wishId;

    private Date createDate;

    private static final long serialVersionUID = 1L;

    public Integer getWisherId() {
        return wisherId;
    }

    public void setWisherId(Integer wisherId) {
        this.wisherId = wisherId;
    }

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
        WisherDesire other = (WisherDesire) that;
        return (this.getWisherId() == null ? other.getWisherId() == null : this.getWisherId().equals(other.getWisherId()))
            && (this.getWishId() == null ? other.getWishId() == null : this.getWishId().equals(other.getWishId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWisherId() == null) ? 0 : getWisherId().hashCode());
        result = prime * result + ((getWishId() == null) ? 0 : getWishId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }
}