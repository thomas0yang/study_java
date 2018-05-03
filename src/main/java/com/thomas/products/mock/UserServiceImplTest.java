package com.thomas.products.mock;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Test;

public class UserServiceImplTest extends TestCase{
        @Test
        public void testQuery() {  
            User expectedUser = new User();
            expectedUser.setId("1001");
            expectedUser.setName("hello");
            UserDao mock = EasyMock.createMock(UserDao.class);//创建Mock对象
            EasyMock.expect(mock.getById("1001")).andReturn(expectedUser);//录制Mock对象预期行为
            EasyMock.replay(mock);//重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为
  
            UserServiceImpl service = new UserServiceImpl();
            service.setUserDao(mock);
            User user = service.query("1001");//调用测试方法
            assertEquals(expectedUser, user); //断言测试结果
            EasyMock.verify(mock);//验证Mock对象被调用
        }  
    }   