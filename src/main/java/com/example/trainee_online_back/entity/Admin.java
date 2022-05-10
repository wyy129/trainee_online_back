package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 管理员表
 * @author wyy
 * @TableName admin
 */
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员账号
     */
    private String adminUsername;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员姓名
     */
    private String adminName;

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 管理员id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 管理员账号
     */
    public String getAdminUsername() {
        return adminUsername;
    }

    /**
     * 管理员账号
     */
    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    /**
     * 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 管理员密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
        Admin other = (Admin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getAdminUsername() == null ? other.getAdminUsername() == null : this.getAdminUsername().equals(other.getAdminUsername()))
            && (this.getAdminPassword() == null ? other.getAdminPassword() == null : this.getAdminPassword().equals(other.getAdminPassword()))
            && (this.getAdminName() == null ? other.getAdminName() == null : this.getAdminName().equals(other.getAdminName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getAdminUsername() == null) ? 0 : getAdminUsername().hashCode());
        result = prime * result + ((getAdminPassword() == null) ? 0 : getAdminPassword().hashCode());
        result = prime * result + ((getAdminName() == null) ? 0 : getAdminName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", adminUsername=").append(adminUsername);
        sb.append(", adminPassword=").append(adminPassword);
        sb.append(", adminName=").append(adminName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}