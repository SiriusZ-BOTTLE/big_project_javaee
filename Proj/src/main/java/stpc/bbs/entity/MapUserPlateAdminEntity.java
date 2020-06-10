package stpc.bbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_plate_admin", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserPlateAdminEntityPK.class)
public class MapUserPlateAdminEntity {
    private String userId;
    private int plateId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "plate_id")
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

        MapUserPlateAdminEntity that = (MapUserPlateAdminEntity) o;

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
