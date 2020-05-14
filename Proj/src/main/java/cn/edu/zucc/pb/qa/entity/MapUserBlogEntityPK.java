package cn.edu.zucc.pb.qa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MapUserBlogEntityPK implements Serializable {
    private String userId;
    private int blogId;

    @Column(name = "user_id")
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "blog_id")
    @Id
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

        MapUserBlogEntityPK that = (MapUserBlogEntityPK) o;

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