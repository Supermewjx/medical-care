package cn.bdqn.service;

import cn.bdqn.domain.Storage;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Storage业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface StorageService {

    /***
     * Storage多条件分页查询
     * @param storage
     * @param page
     * @param size
     * @return
     */
    PageInfo<Storage> findPage(Storage storage, int page, int size);

    /***
     * Storage分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Storage> findPage(int page, int size);

    /***
     * Storage多条件搜索方法
     * @param storage
     * @return
     */
    List<Storage> findList(Storage storage);

    /***
     * 删除Storage
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Storage数据
     * @param storage
     */
    void update(Storage storage);

    /***
     * 新增Storage
     * @param storage
     */
    void add(Storage storage);

    /**
     * 根据ID查询Storage
     * @param id
     * @return
     */
     Storage findById(Integer id);

    /***
     * 查询所有Storage
     * @return
     */
    List<Storage> findAll();
}
