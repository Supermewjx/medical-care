package cn.bdqn.service;

import cn.bdqn.domain.Pharmacy;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Pharmacy业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface PharmacyService {

    /***
     * Pharmacy多条件分页查询
     * @param pharmacy
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pharmacy> findPage(Pharmacy pharmacy, int page, int size);

    /***
     * Pharmacy分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Pharmacy> findPage(int page, int size);

    /***
     * Pharmacy多条件搜索方法
     * @param pharmacy
     * @return
     */
    List<Pharmacy> findList(Pharmacy pharmacy);

    /***
     * 删除Pharmacy
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Pharmacy数据
     * @param pharmacy
     */
    void update(Pharmacy pharmacy);

    /***
     * 新增Pharmacy
     * @param pharmacy
     */
    void add(Pharmacy pharmacy);

    /**
     * 根据ID查询Pharmacy
     * @param id
     * @return
     */
     Pharmacy findById(Integer id);

    /***
     * 查询所有Pharmacy
     * @return
     */
    List<Pharmacy> findAll();
}
