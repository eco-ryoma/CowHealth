/**
 * @Title: BaseJUnitTest.java
 * @Package com.haozileung.scau.server.common
 * @Description: 测试基类
 * @author lianghaopeng
 * @date 2012-12-18 上午10:42:33
 * @version V1.0
 */
package com.haozileung.scau.server.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName: BaseJUnitTest
 * @Description: 测试基类
 * @author lianghaopeng
 * @date 2012-12-18 上午10:42:33
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({ "classpath:application-context.xml" }) 
public abstract class BaseJUnitTest {

}
