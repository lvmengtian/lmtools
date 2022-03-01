package com.github.lvmt.lmtools.constructor.demo.model;

/**
 * @author lvmengtian <lvmengtian@kuaishou.com>
 * Created on 2022-02-28
 */
public class CommentInfo {
    // 评论信息id
    private String commentId;
    // 评论的商品id
    private String productId;
    // 评论者id
    private String userId;
    // 评论内容
    private String content;
    // 评论时间
    private long timestamp;

    // mock数据模拟下游请求
    public static CommentInfo mockCommentInfo() {
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setCommentId("jis3_FE");
        commentInfo.setProductId("FR3zdj_s3");
        commentInfo.setUserId("KISN_98h");
        commentInfo.setContent("鞋子挺舒服,还很好看");
        commentInfo.setTimestamp(System.currentTimeMillis());
        // 模拟下游请求耗时
        try {
            Thread.sleep(30L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return commentInfo;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CommentInfo{" +
                "commentId='" + commentId + '\'' +
                ", productId='" + productId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
