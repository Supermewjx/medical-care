package cn.bdqn.service;

import cn.bdqn.domain.Doctor;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Doctor业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DoctorService {

    /***
     * Doctor多条件分页查询
     * @param doctor
     * @param page
     * @param size
     * @return
     */
    PageInfo<Doctor> findPage(Doctor doctor, int page, int size);

    /***
     * Doctor分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Doctor> findPage(int page, int size);

    /***
     * Doctor多条件搜索方法
     * @param doctor
     * @return
     */
    List<Doctor> findList(Doctor doctor);

    /***
     * 删除Doctor
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Doctor数据
     * @param doctor
     */
    void update(Doctor doctor);

    /***
     * 新增Doctor
     * @param doctor
     */
    void add(Doctor doctor);

    /**
     * 根据ID查询Doctor
     * @param id
     * @return
     */
     Doctor findById(Integer id);

    /***
     * 查询所有Doctor
     * @return
     */
    List<Doctor> findAll();
}
