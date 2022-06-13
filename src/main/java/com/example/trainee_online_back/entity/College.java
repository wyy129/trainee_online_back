package com.example.trainee_online_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 学院表
 * @author wyy
 * @TableName college
 */
@TableName(value ="college")
@Data
public class College implements Serializable {
    /**
     * 学院id
     */
    @TableId(type = IdType.AUTO)
    private Integer collegeId;

    /**
     * 学院名字
     */
    private String collegeName;

    /**
     * 学院说明
     */
    private String collegeExplan;

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
        College other = (College) that;
        return (this.getCollegeId() == null ? other.getCollegeId() == null : this.getCollegeId().equals(other.getCollegeId()))
            && (this.getCollegeName() == null ? other.getCollegeName() == null : this.getCollegeName().equals(other.getCollegeName()))
            && (this.getCollegeExplan() == null ? other.getCollegeExplan() == null : this.getCollegeExplan().equals(other.getCollegeExplan()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCollegeId() == null) ? 0 : getCollegeId().hashCode());
        result = prime * result + ((getCollegeName() == null) ? 0 : getCollegeName().hashCode());
        result = prime * result + ((getCollegeExplan() == null) ? 0 : getCollegeExplan().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}