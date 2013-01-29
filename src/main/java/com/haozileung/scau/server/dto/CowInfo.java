package com.haozileung.scau.server.dto;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

/**
 * 
 * 
 * <b>类名称：</b>CowInfo<br/>
 * <b>类描述：</b>奶牛对象传输类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午3:10:46<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class CowInfo implements IDataTransferObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6480708859151450051L;

	private String id;

	private String name;

	private int age;

	private String sex;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
