package com.ktds.shoppingbell.vo;

/**
 * Created by 206-021 on 2015-07-24.
 */
public class PostVO {
    private String postingId;
    private String subject;
    private String content;
    private String emailId;
    private int postingLike;
    private String realName;
    private String randomName;
    private String createdDate;
    private String modifiedDate;
    private String numOfReply;
    private int hit;
    private String category;
    private String postingNickName;

    public String getPostingId() {
        return postingId;
    }

    public void setPostingId(String postingId) {
        this.postingId = postingId;
    }
}
