package com.thomas.products.gof.wrapper;

/**
 * @author leno 装饰角色
 */
public class MessageBoardDecorator implements MessageBoardHandler {

   private MessageBoardHandler handler;
 
   public MessageBoardDecorator(MessageBoardHandler handler) {
      this.handler = handler;
   }

   public String filter(String msg) {
      return handler.filter(msg);
   }
}