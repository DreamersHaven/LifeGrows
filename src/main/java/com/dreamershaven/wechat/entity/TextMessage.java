package com.dreamershaven.wechat.entity;

/**
 * ClassName: TextMessage
 * @Description: 文本消息
 * @author dapengniao
 * @date 2016 年 3 月 7 日 下午 3:06:40
 */
public class TextMessage extends BaseMessage {  
    // 消息内容   
    private String Content;  

    public String getContent() {  
        return Content;  
    }  

    public void setContent(String content) {  
        Content = content;  
    }  
}
