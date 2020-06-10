package stpc.bbs.formbean;

public class CommentListRequest {

    Integer objectId;//目标对象id
    String commentType;//评论类型

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }
}
