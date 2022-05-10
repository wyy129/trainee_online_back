package com.example.trainee_online_back.entity;

import java.io.Serializable;

/**
 * 毕业设计表
 * @TableName project
 */
public class Project implements Serializable {
    /**
     * 毕设id
     */
    private Integer projectId;

    /**
     * 毕设名称
     */
    private String projectName;

    /**
     * 毕设内容
     */
    private String projectContent;

    /**
     * 发布毕设教师id;关联teacher表里面teacher_id
     */
    private Integer teacherId;

    private static final long serialVersionUID = 1L;

    /**
     * 毕设id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 毕设id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 毕设名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 毕设名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 毕设内容
     */
    public String getProjectContent() {
        return projectContent;
    }

    /**
     * 毕设内容
     */
    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    /**
     * 发布毕设教师id;关联teacher表里面teacher_id
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 发布毕设教师id;关联teacher表里面teacher_id
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
        Project other = (Project) that;
        return (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectContent() == null ? other.getProjectContent() == null : this.getProjectContent().equals(other.getProjectContent()))
            && (this.getTeacherId() == null ? other.getTeacherId() == null : this.getTeacherId().equals(other.getTeacherId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectContent() == null) ? 0 : getProjectContent().hashCode());
        result = prime * result + ((getTeacherId() == null) ? 0 : getTeacherId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectContent=").append(projectContent);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}