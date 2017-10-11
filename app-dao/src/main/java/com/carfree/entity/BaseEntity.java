package com.carfree.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Title 公共entity
 * @Description
 * @Author yongSen.wang
 * @Create 2017-04-06 14:14
 * @Version V1.0
 */
public class BaseEntity implements Serializable {

    /**
     * 删除标记位，用于系统软删除(0:未删除,1删除)
     */
    private String delFlg;
    /**
     * 删除时间
     */
    private Date delDate;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private Timestamp createDate;
    /**
     * 最近修改人
     */
    private String updateName;
    /**
     * 最近修改时间
     */
    private Timestamp updateDate;

    /**
     * 分页的起始数目
     */
    private Integer offset;

    /**
     * 每页数量
     */
    private Integer limit;

    /**
     *删除，导出，审核通过
     */
    private Integer operationType;
    /**
     * 排序条件：字段名
     */
    private String sortName;
    /**
     * 顺序类型
     */
    private String sortType;

    public String getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

}
