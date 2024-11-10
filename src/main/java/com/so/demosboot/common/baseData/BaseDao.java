package com.so.demosboot.common.baseData;

import java.util.List;

public interface BaseDao<T> {

	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T getById(String id);
	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity);
	
	
	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);
	
	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);
	
	/**
	 * 删除数据
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	public int delete(String id);
}
