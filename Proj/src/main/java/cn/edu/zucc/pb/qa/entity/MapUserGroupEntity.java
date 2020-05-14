package cn.edu.zucc.pb.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_group", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserGroupEntityPK.class)
public class MapUserGroupEntity {
    private String userId;
    private int groupId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserGroupEntity that = (MapUserGroupEntity) o;

        if (groupId != that.groupId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + groupId;
        return result;
    }
}
