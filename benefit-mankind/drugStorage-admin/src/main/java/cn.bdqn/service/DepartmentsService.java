package cn.bdqn.service;

import cn.bdqn.domain.Departments;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Departments业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DepartmentsService {

    /***
     * Departments多条件分页查询
     * @param departments
     * @param page
     * @param size
     * @return
     */
    PageInfo<Departments> findPage(Departments departments, int page, int size);

    /***
     * Departments分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Departments> findPage(int page, int size);

    /***
     * Departments多条件搜索方法
     * @param departments
     * @return
     */
    List<Departments> findList(Departments departments);

    /***
     * 删除Departments
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Departments数据
     * @param departments
     */
    void update(Departments departments);

    /***
     * 新增Departments
     * @param departments
     */
    void add(Departments departments);

    /**
     * 根据ID查询Departments
     * @param id
     * @return
     */
     Departments findById(Integer id);

    /***
     * 查询所有Departments
     * @return
     */
    List<Departments> findAll();
}
