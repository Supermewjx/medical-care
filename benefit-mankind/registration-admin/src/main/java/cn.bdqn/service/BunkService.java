package cn.bdqn.service;

import cn.bdqn.domain.Bunk;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Bunk业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface BunkService {

    /***
     * Bunk多条件分页查询
     * @param bunk
     * @param page
     * @param size
     * @return
     */
    PageInfo<Bunk> findPage(Bunk bunk, int page, int size);

    /***
     * Bunk分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Bunk> findPage(int page, int size);

    /***
     * Bunk多条件搜索方法
     * @param bunk
     * @return
     */
    List<Bunk> findList(Bunk bunk);

    /***
     * 删除Bunk
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Bunk数据
     * @param bunk
     */
    void update(Bunk bunk);

    /***
     * 新增Bunk
     * @param bunk
     */
    void add(Bunk bunk);

    /**
     * 根据ID查询Bunk
     * @param id
     * @return
     */
     Bunk findById(Integer id);

    /***
     * 查询所有Bunk
     * @return
     */
    List<Bunk> findAll();
}
