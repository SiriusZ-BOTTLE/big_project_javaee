package stpc.bbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_user_following", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserUserFollowingEntityPK.class)
public class MapUserUserFollowingEntity {
    private String userId0;
    private String userId1;

    @Id
    @Column(name = "user_id_0")
    public String getUserId0() {
        return userId0;
    }

    public void setUserId0(String userId0) {
        this.userId0 = userId0;
    }

    @Id
    @Column(name = "user_id_1")
    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserUserFollowingEntity that = (MapUserUserFollowingEntity) o;

        if (userId0 != null ? !userId0.equals(that.userId0) : that.userId0 != null) return false;
        if (userId1 != null ? !userId1.equals(that.userId1) : that.userId1 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId0 != null ? userId0.hashCode() : 0;
        result = 31 * result + (userId1 != null ? userId1.hashCode() : 0);
        return result;
    }
}
