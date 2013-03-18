/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.service<br />
 * <b>文件名：</b>UserServiceTest.java<br />
 * <b>文件描述：</b>用户领域业务测试<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-29 下午5:12:24<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haozileung.scau.server.common.BaseJUnitTest;

/**
 * 
 * <b>类名称：</b>UserServiceTest<br/>
 * <b>类描述：</b>用户领域业务测试<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-29 下午5:12:25<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public class UserServiceTest extends BaseJUnitTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int a = 1;
		boolean flag = a + 1 == 2;
		Assert.assertTrue("失败：a + 1 != 2", flag);
	}

}
