package com.haozileung.scau.server.common.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haozileung.scau.server.common.domain.IDomain;

/**
 * 
 * <b>类名称：</b>AbstractDoToDtoConvertor<br/>
 * <b>类描述：</b>抽象领域对象转DTO对象转换器<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午1:45:21<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public abstract class AbstractDoToDtoConvertor<O extends IDomain, D extends IDataTransferObject>
		implements IDoToDtoConvertor<O, D> {
	
	protected final Log logger = LogFactory.getLog(getClass().getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.common.dto.IDoToDtoConvertor#dos2Dtos(java
	 * .util.List)
	 */
	@Override
	public List<D> dos2Dtos(List<O> os) {
		List<D> dtos = new ArrayList<D>();
		if (os != null && os.size() > 0) {
			for (O o : os) {
				dtos.add(doToDto(o));
			}
			return dtos;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.haozileung.scau.server.common.dto.IDoToDtoConvertor#dos2DtosWithLazy
	 * (java.util.List)
	 */
	@Override
	public List<D> dos2DtosWithLazy(List<O> os) {
		List<D> dtos = new ArrayList<D>();
		if (os != null && os.size() > 0) {
			for (O o : os) {
				dtos.add(doToDtoWithLazy(o));
			}
			return dtos;
		}
		return null;
	}

}
