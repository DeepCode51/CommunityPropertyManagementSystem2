package com.so.demosboot.common.baseData;

import java.util.List;

import com.so.demosboot.common.utils.IdGenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BaseService<D extends BaseDao<T>, T extends BaseEntity<T> > {
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T getById(String id) {
		return dao.getById(id);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	/*public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}*/

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public void save(T entity) {
		if (StringUtils.isEmpty(entity.getId())){
			entity.setId(IdGenUtil.getUUID());
			dao.insert(entity);
		}else{
			dao.update(entity);
		}
	}
	
	/**
	 * 删除数据
	 * @param id
	 */
	@Transactional(readOnly = false)
	public int delete(String id) {
		return dao.delete(id);
	}


}
