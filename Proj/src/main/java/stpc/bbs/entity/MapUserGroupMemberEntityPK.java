package stpc.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MapUserGroupMemberEntityPK implements Serializable {
    private String userId;
    private int groupId;

    @Column(name = "user_id")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "group_id")
    @Id
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

        MapUserGroupMemberEntityPK that = (MapUserGroupMemberEntityPK) o;

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
