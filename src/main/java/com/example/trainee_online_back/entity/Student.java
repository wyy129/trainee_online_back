package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 学生表
 * @TableName student
 */
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 用户名
     */
    private String studentUsername;

    /**
     * 密码
     */
    private String studentPassword;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别;0是无，1是男，2是女
     */
    private Integer studentGender;

    /**
     * 学生状态
     */
    private String studentStatue;

    /**
     * 成绩
     */
    private String studentScore;

    /**
     * 学院 id;对应college表里面college_id外键
     */
    private Integer collegeId;

    /**
     * 专业id
     */
    private Integer majorId;

    /**
     * 毕设id;对应project表里面project_id外键
     */
    private Integer projectId;

    private static final long serialVersionUID = 1L;

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

    /**
     * 用户名
     */
    public String getStudentUsername() {
        return studentUsername;
    }

    /**
     * 用户名
     */
    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    /**
     * 密码
     */
    public String getStudentPassword() {
        return studentPassword;
    }

    /**
     * 密码
     */
    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    /**
     * 学生姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 学生姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 学生性别;0是无，1是男，2是女
     */
    public Integer getStudentGender() {
        return studentGender;
    }

    /**
     * 学生性别;0是无，1是男，2是女
     */
    public void setStudentGender(Integer studentGender) {
        this.studentGender = studentGender;
    }

    /**
     * 学生状态
     */
    public String getStudentStatue() {
        return studentStatue;
    }

    /**
     * 学生状态
     */
    public void setStudentStatue(String studentStatue) {
        this.studentStatue = studentStatue;
    }

    /**
     * 成绩
     */
    public String getStudentScore() {
        return studentScore;
    }

    /**
     * 成绩
     */
    public void setStudentScore(String studentScore) {
        this.studentScore = studentScore;
    }

    /**
     * 学院 id;对应college表里面college_id外键
     */
    public Integer getCollegeId() {
        return collegeId;
    }

    /**
     * 学院 id;对应college表里面college_id外键
     */
    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

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
     * 毕设id;对应project表里面project_id外键
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 毕设id;对应project表里面project_id外键
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
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
        Student other = (Student) that;
        return (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getStudentUsername() == null ? other.getStudentUsername() == null : this.getStudentUsername().equals(other.getStudentUsername()))
            && (this.getStudentPassword() == null ? other.getStudentPassword() == null : this.getStudentPassword().equals(other.getStudentPassword()))
            && (this.getStudentName() == null ? other.getStudentName() == null : this.getStudentName().equals(other.getStudentName()))
            && (this.getStudentGender() == null ? other.getStudentGender() == null : this.getStudentGender().equals(other.getStudentGender()))
            && (this.getStudentStatue() == null ? other.getStudentStatue() == null : this.getStudentStatue().equals(other.getStudentStatue()))
            && (this.getStudentScore() == null ? other.getStudentScore() == null : this.getStudentScore().equals(other.getStudentScore()))
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getStudentUsername() == null) ? 0 : getStudentUsername().hashCode());
        result = prime * result + ((getStudentPassword() == null) ? 0 : getStudentPassword().hashCode());
        result = prime * result + ((getStudentName() == null) ? 0 : getStudentName().hashCode());
        result = prime * result + ((getStudentGender() == null) ? 0 : getStudentGender().hashCode());
        result = prime * result + ((getStudentStatue() == null) ? 0 : getStudentStatue().hashCode());
        result = prime * result + ((getStudentScore() == null) ? 0 : getStudentScore().hashCode());
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentUsername=").append(studentUsername);
        sb.append(", studentPassword=").append(studentPassword);
        sb.append(", studentName=").append(studentName);
        sb.append(", studentGender=").append(studentGender);
        sb.append(", studentStatue=").append(studentStatue);
        sb.append(", studentScore=").append(studentScore);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", majorId=").append(majorId);
        sb.append(", projectId=").append(projectId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}