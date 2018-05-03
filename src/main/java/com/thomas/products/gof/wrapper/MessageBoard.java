package com.thomas.products.gof.wrapper;

/**
 * @author leno 用户留言板的具体实现
 */
public class MessageBoard implements MessageBoardHandler {
   public String filter(String msg) {
      return "处理留言板上的内容：" + msg;
   }
}