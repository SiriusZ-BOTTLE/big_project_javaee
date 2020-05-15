package cn.edu.zucc.pb.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_post_collection", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserPostCollectionEntityPK.class)
public class MapUserPostCollectionEntity {
    private String userId;
    private int postId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "post_id")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserPostCollectionEntity that = (MapUserPostCollectionEntity) o;

        if (postId != that.postId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + postId;
        return result;
    }
}
