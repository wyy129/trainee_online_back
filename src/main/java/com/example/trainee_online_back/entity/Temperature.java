package com.example.trainee_online_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 体温表
 * @TableName temperature
 */
@TableName(value ="temperature")
@Data
public class Temperature implements Serializable {
    /**
     * 体温id
     */
    @TableId(type = IdType.AUTO)
    private Integer temperatureId;

    /**
     * 是否危险;1是危险，0是安全
     */
    private String isRisk;

    /**
     * 体温度数
     */
    private String temperatureValue;

    /**
     * 上报时候地址
     */
    private String temperatureAddress;

    /**
     * 症状
     */
    private String temperatureSymptom;

    /**
     * 创建时间
     */
    private Date temperatureCreadetime;

    /**
     * 学生id;关联student表里面student_id
     */
    private Integer studentId;

    /**
     * 逻辑删除;是否逻辑删除 删除为1，未删除0
     */
    private Integer deleted;

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
        Temperature other = (Temperature) that;
        return (this.getTemperatureId() == null ? other.getTemperatureId() == null : this.getTemperatureId().equals(other.getTemperatureId()))
            && (this.getIsRisk() == null ? other.getIsRisk() == null : this.getIsRisk().equals(other.getIsRisk()))
            && (this.getTemperatureValue() == null ? other.getTemperatureValue() == null : this.getTemperatureValue().equals(other.getTemperatureValue()))
            && (this.getTemperatureAddress() == null ? other.getTemperatureAddress() == null : this.getTemperatureAddress().equals(other.getTemperatureAddress()))
            && (this.getTemperatureSymptom() == null ? other.getTemperatureSymptom() == null : this.getTemperatureSymptom().equals(other.getTemperatureSymptom()))
            && (this.getTemperatureCreadetime() == null ? other.getTemperatureCreadetime() == null : this.getTemperatureCreadetime().equals(other.getTemperatureCreadetime()))
            && (this.getStudentId() == null ? other.getStudentId() == null : this.getStudentId().equals(other.getStudentId()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTemperatureId() == null) ? 0 : getTemperatureId().hashCode());
        result = prime * result + ((getIsRisk() == null) ? 0 : getIsRisk().hashCode());
        result = prime * result + ((getTemperatureValue() == null) ? 0 : getTemperatureValue().hashCode());
        result = prime * result + ((getTemperatureAddress() == null) ? 0 : getTemperatureAddress().hashCode());
        result = prime * result + ((getTemperatureSymptom() == null) ? 0 : getTemperatureSymptom().hashCode());
        result = prime * result + ((getTemperatureCreadetime() == null) ? 0 : getTemperatureCreadetime().hashCode());
        result = prime * result + ((getStudentId() == null) ? 0 : getStudentId().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", temperatureId=").append(temperatureId);
        sb.append(", isRisk=").append(isRisk);
        sb.append(", temperatureValue=").append(temperatureValue);
        sb.append(", temperatureAddress=").append(temperatureAddress);
        sb.append(", temperatureSymptom=").append(temperatureSymptom);
        sb.append(", temperatureCreadetime=").append(temperatureCreadetime);
        sb.append(", studentId=").append(studentId);
        sb.append(", deleted=").append(deleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}