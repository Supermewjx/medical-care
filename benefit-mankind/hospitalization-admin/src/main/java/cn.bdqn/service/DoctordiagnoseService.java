package cn.bdqn.service;

import cn.bdqn.domain.Doctordiagnose;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Doctordiagnose业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface DoctordiagnoseService {

    /***
     * Doctordiagnose多条件分页查询
     * @param doctordiagnose
     * @param page
     * @param size
     * @return
     */
    PageInfo<Doctordiagnose> findPage(Doctordiagnose doctordiagnose, int page, int size);

    /***
     * Doctordiagnose分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Doctordiagnose> findPage(int page, int size);

    /***
     * Doctordiagnose多条件搜索方法
     * @param doctordiagnose
     * @return
     */
    List<Doctordiagnose> findList(Doctordiagnose doctordiagnose);

    /***
     * 删除Doctordiagnose
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Doctordiagnose数据
     * @param doctordiagnose
     */
    void update(Doctordiagnose doctordiagnose);

    /***
     * 新增Doctordiagnose
     * @param doctordiagnose
     */
    void add(Doctordiagnose doctordiagnose);

    /**
     * 根据ID查询Doctordiagnose
     * @param id
     * @return
     */
     Doctordiagnose findById(Integer id);

    /***
     * 查询所有Doctordiagnose
     * @return
     */
    List<Doctordiagnose> findAll();
}
