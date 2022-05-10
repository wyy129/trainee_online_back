package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 教师表
 * @TableName teacher
 */
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 教师用户名
     */
    private String teacherUsername;

    /**
     * 教师密码
     */
    private String teacherPassword;

    /**
     * 教师姓名
     */
    private String teacherName;

    private static final long serialVersionUID = 1L;

    /**
     * 教师id
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 教师id
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 教师用户名
     */
    public String getTeacherUsername() {
        return teacherUsername;
    }

    /**
     * 教师用户名
     */
    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    /**
     * 教师密码
     */
    public String getTeacherPassword() {
        return teacherPassword;
    }

    /**
     * 教师密码
     */
    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    /**
     * 教师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 教师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
        Teacher other = (Teacher) that;
        return (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()))
            && (this.getTeacherUsername() == null ? other.getTeacherUsername() == null : this.getTeacherUsername().equals(other.getTeacherUsername()))
            && (this.getTeacherPassword() == null ? other.getTeacherPassword() == null : this.getTeacherPassword().equals(other.getTeacherPassword()))
            && (this.getTeacherName() == null ? other.getTeacherName() == null : this.getTeacherName().equals(other.getTeacherName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        result = prime * result + ((getTeacherUsername() == null) ? 0 : getTeacherUsername().hashCode());
        result = prime * result + ((getTeacherPassword() == null) ? 0 : getTeacherPassword().hashCode());
        result = prime * result + ((getTeacherName() == null) ? 0 : getTeacherName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", teacherId=").append(teacherId);
        sb.append(", teacherUsername=").append(teacherUsername);
        sb.append(", teacherPassword=").append(teacherPassword);
        sb.append(", teacherName=").append(teacherName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}