package cn.bdqn.service;

import cn.bdqn.domain.Dept;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Dept业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DeptService {

    /***
     * Dept多条件分页查询
     * @param dept
     * @param page
     * @param size
     * @return
     */
    PageInfo<Dept> findPage(Dept dept, int page, int size);

    /***
     * Dept分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Dept> findPage(int page, int size);

    /***
     * Dept多条件搜索方法
     * @param dept
     * @return
     */
    List<Dept> findList(Dept dept);

    /***
     * 删除Dept
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Dept数据
     * @param dept
     */
    void update(Dept dept);

    /***
     * 新增Dept
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据ID查询Dept
     * @param id
     * @return
     */
     Dept findById(Integer id);

    /***
     * 查询所有Dept
     * @return
     */
    List<Dept> findAll();
}
