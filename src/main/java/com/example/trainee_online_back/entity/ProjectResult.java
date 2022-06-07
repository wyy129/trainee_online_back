package com.example.trainee_online_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 毕设结果表
 * @TableName project_result
 */
@TableName(value ="project_result")
@Data
public class ProjectResult implements Serializable {
    /**
     * 毕设结果id
     */
    private Integer resultId;

    /**
     * 学生id
     */
    private Integer studentId;

    /**
     * 毕业设计id
     */
    private Integer projectId;

    /**
     * 前期内容
     */
    private String early;

    /**
     * 中期内容
     */
    private String metaphase;

    /**
     * 最终内容
     */
    private String last;

    /**
     * 前期导师回复
     */
    private String earlyTeacher;

    /**
     * 中期导师回复
     */
    private String metaphaseTeacher;

    /**
     * 最终导师回复
     */
    private String lastTeacher;

    /**
     * 成绩
     */
    private String resultScore;

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
        ProjectResult other = (ProjectResult) that;
        return (this.getResultId() == null ? other.getResultId() == null : this.getResultId().equals(other.getResultId()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getEarly() == null ? other.getEarly() == null : this.getEarly().equals(other.getEarly()))
            && (this.getMetaphase() == null ? other.getMetaphase() == null : this.getMetaphase().equals(other.getMetaphase()))
            && (this.getLast() == null ? other.getLast() == null : this.getLast().equals(other.getLast()))
            && (this.getEarlyTeacher() == null ? other.getEarlyTeacher() == null : this.getEarlyTeacher().equals(other.getEarlyTeacher()))
            && (this.getMetaphaseTeacher() == null ? other.getMetaphaseTeacher() == null : this.getMetaphaseTeacher().equals(other.getMetaphaseTeacher()))
            && (this.getLastTeacher() == null ? other.getLastTeacher() == null : this.getLastTeacher().equals(other.getLastTeacher()))
            && (this.getResultScore() == null ? other.getResultScore() == null : this.getResultScore().equals(other.getResultScore()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResultId() == null) ? 0 : getResultId().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getEarly() == null) ? 0 : getEarly().hashCode());
        result = prime * result + ((getMetaphase() == null) ? 0 : getMetaphase().hashCode());
        result = prime * result + ((getLast() == null) ? 0 : getLast().hashCode());
        result = prime * result + ((getEarlyTeacher() == null) ? 0 : getEarlyTeacher().hashCode());
        result = prime * result + ((getMetaphaseTeacher() == null) ? 0 : getMetaphaseTeacher().hashCode());
        result = prime * result + ((getLastTeacher() == null) ? 0 : getLastTeacher().hashCode());
        result = prime * result + ((getResultScore() == null) ? 0 : getResultScore().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resultId=").append(resultId);
        sb.append(", studentId=").append(studentId);
        sb.append(", projectId=").append(projectId);
        sb.append(", early=").append(early);
        sb.append(", metaphase=").append(metaphase);
        sb.append(", last=").append(last);
        sb.append(", earlyTeacher=").append(earlyTeacher);
        sb.append(", metaphaseTeacher=").append(metaphaseTeacher);
        sb.append(", lastTeacher=").append(lastTeacher);
        sb.append(", resultScore=").append(resultScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}