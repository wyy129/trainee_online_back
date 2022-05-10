package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 学院表
 * @author wyy
 * @TableName college
 */
public class College implements Serializable {
    /**
     * 学院id
     */
    private Integer collegeId;

    /**
     * 学院名字
     */
    private String collegeName;

    /**
     * 学院说明
     */
    private String collegeExplan;

    /**
     * 学生人数
     */
    private String studentNumber;

    private static final long serialVersionUID = 1L;

    /**
     * 学院id
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * 学院id
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    /**
     * 学院名字
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 学院名字
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 学院说明
     */
    public String getCollegeExplan() {
        return collegeExplan;
    }

    /**
     * 学院说明
     */
    public void setCollegeExplan(String collegeExplan) {
        this.collegeExplan = collegeExplan;
    }

    /**
     * 学生人数
     */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
     * 学生人数
     */
    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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
        College other = (College) that;
        return (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getCollegeName() == null ? other.getCollegeName() == null : this.getCollegeName().equals(other.getCollegeName()))
            && (this.getCollegeExplan() == null ? other.getCollegeExplan() == null : this.getCollegeExplan().equals(other.getCollegeExplan()))
            && (this.getStudentNumber() == null ? other.getStudentNumber() == null : this.getStudentNumber().equals(other.getStudentNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getCollegeName() == null) ? 0 : getCollegeName().hashCode());
        result = prime * result + ((getCollegeExplan() == null) ? 0 : getCollegeExplan().hashCode());
        result = prime * result + ((getStudentNumber() == null) ? 0 : getStudentNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collegeId=").append(collegeId);
        sb.append(", collegeName=").append(collegeName);
        sb.append(", collegeExplan=").append(collegeExplan);
        sb.append(", studentNumber=").append(studentNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}