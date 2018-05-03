package com.thomas.products.gof.wrapper.jdk8;


/**
 * @author leno 用户留言板的具体实现
 */
public class MessageBoard implements MessageBoardHandler {

   public void filter(String msg) {
      System.out.println("处理留言板上的内容：" + msg);
   }
}