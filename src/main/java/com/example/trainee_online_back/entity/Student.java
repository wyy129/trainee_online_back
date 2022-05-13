package com.example.trainee_online_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 学生表
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student implements Serializable {
    /**
     * 学生id
     */
    @TableId(type = IdType.AUTO)
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
     * 学院 id;对应college表里面college_id外键
     */
    private Integer collegeId;

    /**
     * 专业id
     */
    private Integer majorId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
            && (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getMajorId() == null ? other.getMajorId() == null : this.getMajorId().equals(other.getMajorId()));
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
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getMajorId() == null) ? 0 : getMajorId().hashCode());
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
        sb.append(", collegeId=").append(collegeId);
        sb.append(", majorId=").append(majorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}