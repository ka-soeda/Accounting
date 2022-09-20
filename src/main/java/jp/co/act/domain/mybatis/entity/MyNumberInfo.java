package jp.co.act.domain.mybatis.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;

public class MyNumberInfo {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String fileUploadCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String fileId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long myNumber;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String deleteFlg;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateDate;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFileUploadCount() {
        return fileUploadCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFileUploadCount(String fileUploadCount) {
        this.fileUploadCount = fileUploadCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getFileId() {
        return fileId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getMyNumber() {
        return myNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMyNumber(Long myNumber) {
        this.myNumber = myNumber;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDeleteFlg() {
        return deleteFlg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}