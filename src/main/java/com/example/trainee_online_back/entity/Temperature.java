package com.example.trainee_online_back.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 体温表
 * @TableName temperature
 */
public class Temperature implements Serializable {
    /**
     * 体温id
     */
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

    private static final long serialVersionUID = 1L;

    /**
     * 体温id
     */
    public Integer getTemperatureId() {
        return temperatureId;
    }

    /**
     * 体温id
     */
    public void setTemperatureId(Integer temperatureId) {
        this.temperatureId = temperatureId;
    }

    /**
     * 是否危险;1是危险，0是安全
     */
    public String getIsRisk() {
        return isRisk;
    }

    /**
     * 是否危险;1是危险，0是安全
     */
    public void setIsRisk(String isRisk) {
        this.isRisk = isRisk;
    }

    /**
     * 体温度数
     */
    public String getTemperatureValue() {
        return temperatureValue;
    }

    /**
     * 体温度数
     */
    public void setTemperatureValue(String temperatureValue) {
        this.temperatureValue = temperatureValue;
    }

    /**
     * 上报时候地址
     */
    public String getTemperatureAddress() {
        return temperatureAddress;
    }

    /**
     * 上报时候地址
     */
    public void setTemperatureAddress(String temperatureAddress) {
        this.temperatureAddress = temperatureAddress;
    }

    /**
     * 症状
     */
    public String getTemperatureSymptom() {
        return temperatureSymptom;
    }

    /**
     * 症状
     */
    public void setTemperatureSymptom(String temperatureSymptom) {
        this.temperatureSymptom = temperatureSymptom;
    }

    /**
     * 创建时间
     */
    public Date getTemperatureCreadetime() {
        return temperatureCreadetime;
    }

    /**
     * 创建时间
     */
    public void setTemperatureCreadetime(Date temperatureCreadetime) {
        this.temperatureCreadetime = temperatureCreadetime;
    }

    /**
     * 学生id;关联student表里面student_id
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 学生id;关联student表里面student_id
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    /**
     * 逻辑删除;是否逻辑删除 删除为1，未删除0
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * 逻辑删除;是否逻辑删除 删除为1，未删除0
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
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