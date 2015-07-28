package com.ktds.shoppingbell.define;

public interface URLProtocol {
    final String IP_ADDRESS = "http://10.225.152.180:8080/ShoppingBell";

    final String URL_MemberRegist   = "/member/regist";
    final String URL_PostList       = "/post/post";
    final String URL_PostDetailById = "/post/postDetail/"; //  /post/postDetail/{postId}
    final String URL_PostImageDownload = "/post/download/"; // /post/download/{postingId}/{fileId}

}