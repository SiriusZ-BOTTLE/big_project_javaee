package cn.edu.zucc.sirius.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_group_member", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserGroupMemberEntityPK.class)
public class MapUserGroupMemberEntity {
    private String userId;
    private int groupId;
    private Byte isAdmin;

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

    @Basic
    @Column(name = "is_admin")
    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserGroupMemberEntity that = (MapUserGroupMemberEntity) o;

        if (groupId != that.groupId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (isAdmin != null ? !isAdmin.equals(that.isAdmin) : that.isAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + groupId;
        result = 31 * result + (isAdmin != null ? isAdmin.hashCode() : 0);
        return result;
    }
}
