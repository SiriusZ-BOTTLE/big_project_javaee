package cn.edu.zucc.sirius.qa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MapUserObjectLikingEntityPK implements Serializable {
    private int objectId;
    private String userId;

    @Column(name = "object_id")
    @Id
    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    @Column(name = "user_id")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserObjectLikingEntityPK that = (MapUserObjectLikingEntityPK) o;

        if (objectId != that.objectId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectId;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
