package stpc.bbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_object_liking", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserObjectLikingEntityPK.class)
public class MapUserObjectLikingEntity {
    private int objectId;
    private String userId;
    private String type;

    @Id
    @Column(name = "object_id")
    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserObjectLikingEntity that = (MapUserObjectLikingEntity) o;

        if (objectId != that.objectId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
