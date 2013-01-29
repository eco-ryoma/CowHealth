/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.domain.support<br />
 * <b>文件名：</b>EquipmentDoToDtoConvertor.java<br />
 * <b>文件描述：</b>DoToDtoConvertor<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-24 下午4:48:00<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.domain.support;

import com.haozileung.scau.server.common.dto.AbstractDoToDtoConvertor;
import com.haozileung.scau.server.common.dto.DoToDtoConvertorFactory;
import com.haozileung.scau.server.common.utility.DateUtil;
import com.haozileung.scau.server.domain.Equipment;
import com.haozileung.scau.server.dto.EquipmentInfo;

/**
 * 
 * <b>类名称：</b>EquipmentDoToDtoConvertor<br/>
 * <b>类描述：</b>DoToDtoConvertor<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-24 下午4:48:00<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public class EquipmentDoToDtoConvertor extends
		AbstractDoToDtoConvertor<Equipment, EquipmentInfo> {

	/**
	 * 单例对象引用
	 */
	private static EquipmentDoToDtoConvertor instance;

	/**
	 * 私有构造函数
	 */
	private EquipmentDoToDtoConvertor() {
	}

	/**
	 * 静态代码区
	 */
	static {
		if (null == instance) {
			instance = new EquipmentDoToDtoConvertor();
			// 注册转换器到转换工厂
			DoToDtoConvertorFactory.register(Equipment.class, instance);
		}
	}

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static EquipmentDoToDtoConvertor getInstance() {
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDto(com.
	 * haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public EquipmentInfo doToDto(Equipment equipment) {
		if (null == equipment) {
			return null;
		}
		EquipmentInfo equipmentInfo = new EquipmentInfo();
		equipmentInfo.setExpireDate(DateUtil.convertDate2Str(equipment
				.getExpireDate()));
		equipmentInfo.setId(null == equipment.getId() ? null : equipment
				.getId().toString());
		equipmentInfo.setName(equipment.getName());
		equipmentInfo.setProducter(equipment.getProducter());
		equipmentInfo.setType(equipment.getType());
		return equipmentInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.common.dto.IDoToDtoConvertor#doToDtoWithLazy
	 * (com.haozileung.scau.server.common.domain.IDomain)
	 */
	@Override
	public EquipmentInfo doToDtoWithLazy(Equipment equipment) {
		return doToDto(equipment);
	}

}
