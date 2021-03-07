package cn.bdqn.service;

import cn.bdqn.domain.Manner;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Manner业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface MannerService {

    /***
     * Manner多条件分页查询
     * @param manner
     * @param page
     * @param size
     * @return
     */
    PageInfo<Manner> findPage(Manner manner, int page, int size);

    /***
     * Manner分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Manner> findPage(int page, int size);

    /***
     * Manner多条件搜索方法
     * @param manner
     * @return
     */
    List<Manner> findList(Manner manner);

    /***
     * 删除Manner
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Manner数据
     * @param manner
     */
    void update(Manner manner);

    /***
     * 新增Manner
     * @param manner
     */
    void add(Manner manner);

    /**
     * 根据ID查询Manner
     * @param id
     * @return
     */
     Manner findById(Integer id);

    /***
     * 查询所有Manner
     * @return
     */
    List<Manner> findAll();
}
