package com.haozileung.scau.server.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.dto.CowInfo;

/**
 * 
 * 
 * <b>类名称：</b>Cow<br/>
 * <b>类描述：</b>领域对象<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-01-24 上午10:52:39<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
@Document(collection = "cowDoc")
public class Cow implements IDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6384207239416969734L;
	@Id
	@Indexed
	private ObjectId id;

	private String name;

	private int age;

	private String sex;

	public Cow() {
	}

	public Cow(CowInfo cowInfo) {
		if (null != cowInfo)
			update(cowInfo);
	}

	private void update(CowInfo cowInfo) {
		this.age = cowInfo.getAge();
		this.id = new ObjectId(cowInfo.getId());
		this.name = cowInfo.getName();
		this.sex = cowInfo.getSex();
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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
