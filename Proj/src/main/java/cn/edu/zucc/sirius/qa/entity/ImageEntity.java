package cn.edu.zucc.sirius.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "image", schema = "db_big_pro_javaee", catalog = "")
public class ImageEntity {
    private int imageId;
    private Integer objectId;
    private String imageType;
    private String imageUrl;

    @Id
    @Column(name = "image_id")
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    @Basic
    @Column(name = "object_id")
    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    @Basic
    @Column(name = "image_type")
    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageEntity that = (ImageEntity) o;

        if (imageId != that.imageId) return false;
        if (objectId != null ? !objectId.equals(that.objectId) : that.objectId != null) return false;
        if (imageType != null ? !imageType.equals(that.imageType) : that.imageType != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = imageId;
        result = 31 * result + (objectId != null ? objectId.hashCode() : 0);
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
