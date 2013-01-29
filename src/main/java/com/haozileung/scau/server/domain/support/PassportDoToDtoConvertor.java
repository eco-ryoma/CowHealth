/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.domain.support<br />
 * <b>文件名：</b>PassportDoToDtoConvertor.java<br />
 * <b>文件描述：</b>通行证领域对象转换器<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-24 下午5:01:34<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.domain.support;

import com.haozileung.scau.server.common.dto.AbstractDoToDtoConvertor;
import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.domain.Passport;
import com.haozileung.scau.server.dto.PassportInfo;

/**
 * 
 * <b>类名称：</b>PassportDoToDtoConvertor<br/>
 * <b>类描述：</b>通行证领域对象转换器<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午5:01:34<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public class PassportDoToDtoConvertor extends
		AbstractDoToDtoConvertor<Passport, PassportInfo> {

	private static PassportDoToDtoConvertor instance;

	private PassportDoToDtoConvertor() {
	}

	static {
		if (null == instance) {
			instance = new PassportDoToDtoConvertor();
			DoToDtoConvertorFactory.register(Passport.class, instance);
		}
	}

	public static PassportDoToDtoConvertor getInstance() {
		return instance;
	}

	@Override
	public PassportInfo doToDto(Passport passport) {
		PassportInfo passportInfo = new PassportInfo();
		passportInfo.setEmail(passport.getEmail());
		passportInfo.setId(null == passport.getId() ? null : passport.getId()
				.toString());
		passportInfo.setIsEnabled(passport.getIsEnabled());
		return passportInfo;
	}

	@Override
	public PassportInfo doToDtoWithLazy(Passport passport) {
		return doToDto(passport);
	}

}
