package cn.bdqn.service;

import cn.bdqn.domain.Druginfo;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Druginfo业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DruginfoService {

    /***
     * Druginfo多条件分页查询
     * @param druginfo
     * @param page
     * @param size
     * @return
     */
    PageInfo<Druginfo> findPage(Druginfo druginfo, int page, int size);

    /***
     * Druginfo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Druginfo> findPage(int page, int size);

    /***
     * Druginfo多条件搜索方法
     * @param druginfo
     * @return
     */
    List<Druginfo> findList(Druginfo druginfo);

    /***
     * 删除Druginfo
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Druginfo数据
     * @param druginfo
     */
    void update(Druginfo druginfo);

    /***
     * 新增Druginfo
     * @param druginfo
     */
    void add(Druginfo druginfo);

    /**
     * 根据ID查询Druginfo
     * @param id
     * @return
     */
     Druginfo findById(Integer id);

    /***
     * 查询所有Druginfo
     * @return
     */
    List<Druginfo> findAll();
}
