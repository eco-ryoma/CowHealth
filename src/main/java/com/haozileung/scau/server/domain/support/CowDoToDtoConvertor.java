package com.haozileung.scau.server.domain.support;

import com.haozileung.scau.server.common.dto.AbstractDoToDtoConvertor;
import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.domain.Cow;
import com.haozileung.scau.server.dto.CowInfo;

/**
 * 
 * <b>类名称：</b>UserDoToDtoConvert<br/>
 * <b>类描述：</b>User的领域对象转DTO对象转换器<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午3:34:38<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class CowDoToDtoConvertor extends AbstractDoToDtoConvertor<Cow, CowInfo> {

	private static CowDoToDtoConvertor instance;

	private CowDoToDtoConvertor() {
	}

	static {
		if (null == instance) {
			instance = new CowDoToDtoConvertor();
			DoToDtoConvertorFactory.register(Cow.class, instance);
		}
	}

	public static CowDoToDtoConvertor getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDto(com.
	 * haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public CowInfo doToDto(Cow cow) {
		if (null == cow) {
			return null;
		}
		CowInfo cowInfo = new CowInfo();
		cowInfo.setAge(cow.getAge());
		cowInfo.setCowId(null == cow.getId() ? null : cow.getId().toString());
		cowInfo.setName(cow.getName());
		cowInfo.setSex(cow.getSex());
		return cowInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDtoWithLazy
	 * (com.haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public CowInfo doToDtoWithLazy(Cow cow) {
		return doToDto(cow);
	}

}
