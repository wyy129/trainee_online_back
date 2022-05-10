package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 专业表
 * @TableName major
 */
public class Major implements Serializable {
    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 专业名称
     */
    private String majorName;

    /**
     * 学院id;关联college表
     */
    private Integer collegeId;

    private static final long serialVersionUID = 1L;

    /**
     * 专业id
     */
    public Integer getMajorId() {
        return majorId;
    }

    /**
     * 专业id
     */
    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    /**
     * 专业名称
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 专业名称
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 学院id;关联college表
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * 学院id;关联college表
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
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
        Major other = (Major) that;
        return (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getMajorName() == null ? other.getMajorName() == null : this.getMajorName().equals(other.getMajorName()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getMajorName() == null) ? 0 : getMajorName().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", majorId=").append(majorId);
        sb.append(", majorName=").append(majorName);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}