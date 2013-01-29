package com.haozileung.scau.server.common.dto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haozileung.scau.server.common.domain.IDomain;
import com.haozileung.scau.server.common.exception.BaseUncheckedException;

/**
 * 
 * <b>类名称：</b>DoToDtoConvertorFactory<br/>
 * <b>类描述：</b>领域对象转DTO对象转换器工厂<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午1:47:26<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class DoToDtoConvertorFactory {

	protected final static Log logger = LogFactory
			.getLog(DoToDtoConvertorFactory.class);

	@SuppressWarnings("rawtypes")
	private static Map map = new HashMap();
	private Set<String> convertorClassNames = new HashSet<String>();

	@SuppressWarnings("unchecked")
	public static void register(
			Class<? extends IDomain> domainObjectClass,
			IDoToDtoConvertor<? extends IDomain, ? extends IDataTransferObject> convertor) {
		if (logger.isInfoEnabled())
			logger.info("注册转换器：【name=" + domainObjectClass
					+ ";convertorClassName=" + convertor.getClass().getName()
					+ "】");
		map.put(domainObjectClass, convertor);
	}

	@SuppressWarnings("rawtypes")
	public static IDoToDtoConvertor getConvertor(
			Class<? extends IDomain> domainObjectClass) {
		if (map.get(domainObjectClass) == null) {
			throw new BaseUncheckedException(DoToDtoConvertorFactory.class
					.getName().concat("unregisterIDoToDtoConvertor"), "名称为\""
					+ domainObjectClass + "\"的转换器未注册，请先注册后再使用! ");
		}
		return (IDoToDtoConvertor) map.get(domainObjectClass);
	}

	public void setConvertorClassNames(Set<String> convertorClassNames) {
		this.convertorClassNames = convertorClassNames;
	}

	public void init() throws ClassNotFoundException {
		for (String convertorClassName : convertorClassNames) {
			Class.forName(convertorClassName.trim());
		}
		convertorClassNames.clear();
	}

}
