package cn.edu.zucc.sirius.qa.formbean;

public class ImagesListRequest {

    Integer objectId;//目标对象id
    String imageType;//图片类型

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
