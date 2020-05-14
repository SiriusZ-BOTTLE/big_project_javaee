package cn.edu.zucc.pb.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_blog", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserBlogEntityPK.class)
public class MapUserBlogEntity {
    private String userId;
    private int blogId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "blog_id")
    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserBlogEntity that = (MapUserBlogEntity) o;

        if (blogId != that.blogId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + blogId;
        return result;
    }
}
