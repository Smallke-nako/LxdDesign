package com.example.lxd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @TableName warning
 */
@TableName(value ="warning")
public class Warning implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *图片名称
     */
    private String imagename;

    /**
     *图片
     */
    private byte[] image;
    /**
     * 记录未佩戴人数
     */
    private String person;
    /**
     * 记录时间
     */
    private String recorddata;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     */
    public String getImagename() {
        return imagename;
    }

    /**
     *
     */
    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    /**
     *
     */
    public byte[] getImage() {
        return image;
    }

    /**
     *
     */
    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getRecorddata() {
        return recorddata;
    }

    public void setRecorddata(String recorddata) {
        this.recorddata = recorddata;
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
        Warning other = (Warning) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getImagename() == null ? other.getImagename() == null : this.getImagename().equals(other.getImagename()))
            && (Arrays.equals(this.getImage(), other.getImage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getImagename() == null) ? 0 : getImagename().hashCode());
        result = prime * result + (Arrays.hashCode(getImage()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", imagename=").append(imagename);
        sb.append(", image=").append(image);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
