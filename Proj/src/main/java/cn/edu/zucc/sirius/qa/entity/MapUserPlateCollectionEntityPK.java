package cn.edu.zucc.sirius.qa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MapUserPlateCollectionEntityPK implements Serializable {
    private String userId;
    private int plateId;

    @Column(name = "user_id")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "plate_id")
    @Id
    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserPlateCollectionEntityPK that = (MapUserPlateCollectionEntityPK) o;

        if (plateId != that.plateId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + plateId;
        return result;
    }
}
