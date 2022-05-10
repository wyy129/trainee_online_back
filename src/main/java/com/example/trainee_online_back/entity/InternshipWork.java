package com.example.trainee_online_back.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 周记表
 * @TableName internship_work
 */
public class InternshipWork implements Serializable {
    /**
     * 周记id
     */
    private Integer workId;

    /**
     * 周记标题
     */
    private String workTitle;

    /**
     * 周记内容
     */
    private String workContent;

    /**
     * 创建时间
     */
    private Date workCreadtime;

    /**
     * 学生id
     */
    private Integer studentId;

    private static final long serialVersionUID = 1L;

    /**
     * 周记id
     */
    public Integer getWorkId() {
        return workId;
    }

    /**
     * 周记id
     */
    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    /**
     * 周记标题
     */
    public String getWorkTitle() {
        return workTitle;
    }

    /**
     * 周记标题
     */
    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    /**
     * 周记内容
     */
    public String getWorkContent() {
        return workContent;
    }

    /**
     * 周记内容
     */
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    /**
     * 创建时间
     */
    public Date getWorkCreadtime() {
        return workCreadtime;
    }

    /**
     * 创建时间
     */
    public void setWorkCreadtime(Date workCreadtime) {
        this.workCreadtime = workCreadtime;
    }

    /**
     * 学生id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 学生id
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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
        InternshipWork other = (InternshipWork) that;
        return (this.getWorkId() == null ? other.getWorkId() == null : this.getWorkId().equals(other.getWorkId()))
            && (this.getWorkTitle() == null ? other.getWorkTitle() == null : this.getWorkTitle().equals(other.getWorkTitle()))
            && (this.getWorkContent() == null ? other.getWorkContent() == null : this.getWorkContent().equals(other.getWorkContent()))
            && (this.getWorkCreadtime() == null ? other.getWorkCreadtime() == null : this.getWorkCreadtime().equals(other.getWorkCreadtime()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkId() == null) ? 0 : getWorkId().hashCode());
        result = prime * result + ((getWorkTitle() == null) ? 0 : getWorkTitle().hashCode());
        result = prime * result + ((getWorkContent() == null) ? 0 : getWorkContent().hashCode());
        result = prime * result + ((getWorkCreadtime() == null) ? 0 : getWorkCreadtime().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workId=").append(workId);
        sb.append(", workTitle=").append(workTitle);
        sb.append(", workContent=").append(workContent);
        sb.append(", workCreadtime=").append(workCreadtime);
        sb.append(", studentId=").append(studentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}