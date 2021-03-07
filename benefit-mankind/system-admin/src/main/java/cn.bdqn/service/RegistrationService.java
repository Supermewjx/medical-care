package cn.bdqn.service;

import cn.bdqn.domain.Registration;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Registration业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RegistrationService {

    /***
     * Registration多条件分页查询
     * @param registration
     * @param page
     * @param size
     * @return
     */
    PageInfo<Registration> findPage(Registration registration, int page, int size);

    /***
     * Registration分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Registration> findPage(int page, int size);

    /***
     * Registration多条件搜索方法
     * @param registration
     * @return
     */
    List<Registration> findList(Registration registration);

    /***
     * 删除Registration
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Registration数据
     * @param registration
     */
    void update(Registration registration);

    /***
     * 新增Registration
     * @param registration
     */
    void add(Registration registration);

    /**
     * 根据ID查询Registration
     * @param id
     * @return
     */
     Registration findById(Integer id);

    /***
     * 查询所有Registration
     * @return
     */
    List<Registration> findAll();
}
