package stpc.bbs.formbean;

public class UserxStatistics {
    Integer postNumber;//发布数
    Integer followNumber;//关注数
    Integer followedNumber;//被关注数

    public Integer getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Integer postNumber) {
        this.postNumber = postNumber;
    }

    public Integer getFollowNumber() {
        return followNumber;
    }

    public void setFollowNumber(Integer followNumber) {
        this.followNumber = followNumber;
    }

    public Integer getFollowedNumber() {
        return followedNumber;
    }

    public void setFollowedNumber(Integer followedNumber) {
        this.followedNumber = followedNumber;
    }
}
