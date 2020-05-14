package cn.edu.zucc.pb.qa.entity;

import javax.persistence.*;

@Entity
@Table(name = "map_user_article", schema = "db_big_pro_javaee", catalog = "")
@IdClass(MapUserArticleEntityPK.class)
public class MapUserArticleEntity {
    private String userId;
    private int articleId;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapUserArticleEntity that = (MapUserArticleEntity) o;

        if (articleId != that.articleId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + articleId;
        return result;
    }
}
