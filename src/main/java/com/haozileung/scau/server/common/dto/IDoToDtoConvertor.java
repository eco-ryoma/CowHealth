package com.haozileung.scau.server.common.dto;

import java.util.List;

import com.haozileung.scau.server.common.domain.IDomain;

/**
 * 
 * <b>类名称：</b>IDoToDtoConvertor<br/>
 * <b>类描述：</b>Domain到DTO的转换器接口<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午1:32:52<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public interface IDoToDtoConvertor<O extends IDomain, D extends IDataTransferObject> {

	/**
	 * 
	 * doToDto领域对象转换DTO对象
	 * @param obj
	 * @return
	 *D
	 * @exception
	 * @since  1.0.0
	 */
	public D doToDto(O obj);

	/**
	 * 
	 * dos2Dtos领域对象转换DTO对象
	 * (这里描述这个方法适用条件 – 可选)
	 * @param os
	 * @return
	 *List<D>
	 * @exception
	 * @since  1.0.0
	 */
	public List<D> dos2Dtos(List<O> os);

	/**
	 * 
	 * doToDtoWithLazy领域对象转换DTO对象
	 * 带延迟操作
	 * @param obj
	 * @return
	 *D
	 * @exception
	 * @since  1.0.0
	 */
	public D doToDtoWithLazy(O obj);

	/**
	 * 
	 * doToDtoWithLazy领域对象转换DTO对象
	 * 带延迟操作
	 * @param os
	 * @return
	 *List<D>
	 * @exception
	 * @since  1.0.0
	 */
	public List<D> dos2DtosWithLazy(List<O> os);

}
