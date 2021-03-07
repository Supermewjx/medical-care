package cn.bdqn.service;

import cn.bdqn.domain.Hospitalized;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Hospitalized业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface HospitalizedService {

    /***
     * Hospitalized多条件分页查询
     * @param hospitalized
     * @param page
     * @param size
     * @return
     */
    PageInfo<Hospitalized> findPage(Hospitalized hospitalized, int page, int size);

    /***
     * Hospitalized分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Hospitalized> findPage(int page, int size);

    /***
     * Hospitalized多条件搜索方法
     * @param hospitalized
     * @return
     */
    List<Hospitalized> findList(Hospitalized hospitalized);

    /***
     * 删除Hospitalized
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Hospitalized数据
     * @param hospitalized
     */
    void update(Hospitalized hospitalized);

    /***
     * 新增Hospitalized
     * @param hospitalized
     */
    void add(Hospitalized hospitalized);

    /**
     * 根据ID查询Hospitalized
     * @param id
     * @return
     */
     Hospitalized findById(Integer id);

    /***
     * 查询所有Hospitalized
     * @return
     */
    List<Hospitalized> findAll();
}
