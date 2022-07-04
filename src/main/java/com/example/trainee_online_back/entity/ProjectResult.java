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
    @TableId(type = IdType.AUTO)
    private Integer projectResultId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 毕业设计id
     */
    private Integer projectInfoId;

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

    /**
     * 修改次数;大于3，则不允许修改选择的毕设选题
     */
    private String revise;

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
        return (this.getProjectResultId() == null ? other.getProjectResultId() == null : this.getProjectResultId().equals(other.getProjectResultId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProjectInfoId() == null ? other.getProjectInfoId() == null : this.getProjectInfoId().equals(other.getProjectInfoId()))
            && (this.getEarly() == null ? other.getEarly() == null : this.getEarly().equals(other.getEarly()))
            && (this.getMetaphase() == null ? other.getMetaphase() == null : this.getMetaphase().equals(other.getMetaphase()))
            && (this.getLast() == null ? other.getLast() == null : this.getLast().equals(other.getLast()))
            && (this.getEarlyTeacher() == null ? other.getEarlyTeacher() == null : this.getEarlyTeacher().equals(other.getEarlyTeacher()))
            && (this.getMetaphaseTeacher() == null ? other.getMetaphaseTeacher() == null : this.getMetaphaseTeacher().equals(other.getMetaphaseTeacher()))
            && (this.getLastTeacher() == null ? other.getLastTeacher() == null : this.getLastTeacher().equals(other.getLastTeacher()))
            && (this.getResultScore() == null ? other.getResultScore() == null : this.getResultScore().equals(other.getResultScore()))
            && (this.getRevise() == null ? other.getRevise() == null : this.getRevise().equals(other.getRevise()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectResultId() == null) ? 0 : getProjectResultId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProjectInfoId() == null) ? 0 : getProjectInfoId().hashCode());
        result = prime * result + ((getEarly() == null) ? 0 : getEarly().hashCode());
        result = prime * result + ((getMetaphase() == null) ? 0 : getMetaphase().hashCode());
        result = prime * result + ((getLast() == null) ? 0 : getLast().hashCode());
        result = prime * result + ((getEarlyTeacher() == null) ? 0 : getEarlyTeacher().hashCode());
        result = prime * result + ((getMetaphaseTeacher() == null) ? 0 : getMetaphaseTeacher().hashCode());
        result = prime * result + ((getLastTeacher() == null) ? 0 : getLastTeacher().hashCode());
        result = prime * result + ((getResultScore() == null) ? 0 : getResultScore().hashCode());
        result = prime * result + ((getRevise() == null) ? 0 : getRevise().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectResultId=").append(projectResultId);
        sb.append(", userId=").append(userId);
        sb.append(", projectInfoId=").append(projectInfoId);
        sb.append(", early=").append(early);
        sb.append(", metaphase=").append(metaphase);
        sb.append(", last=").append(last);
        sb.append(", earlyTeacher=").append(earlyTeacher);
        sb.append(", metaphaseTeacher=").append(metaphaseTeacher);
        sb.append(", lastTeacher=").append(lastTeacher);
        sb.append(", resultScore=").append(resultScore);
        sb.append(", revise=").append(revise);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}