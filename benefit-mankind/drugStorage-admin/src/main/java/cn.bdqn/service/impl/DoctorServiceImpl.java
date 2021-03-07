package cn.bdqn.service.impl;

import cn.bdqn.domain.Doctor;
import cn.bdqn.mapper.DoctorMapper;
import cn.bdqn.service.DoctorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Doctor业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;


    /**
     * Doctor条件+分页查询
     * @param doctor 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Doctor> findPage(Doctor doctor, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(doctor);
        //执行搜索
        return new PageInfo<Doctor>(doctorMapper.selectByExample(example));
    }

    /**
     * Doctor分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Doctor> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Doctor>(doctorMapper.selectAll());
    }

    /**
     * Doctor条件查询
     * @param doctor
     * @return
     */
    @Override
    public List<Doctor> findList(Doctor doctor){
        //构建查询条件
        Example example = createExample(doctor);
        //根据构建的条件查询数据
        return doctorMapper.selectByExample(example);
    }


    /**
     * Doctor构建查询对象
     * @param doctor
     * @return
     */
    public Example createExample(Doctor doctor){
        Example example=new Example(Doctor.class);
        Example.Criteria criteria = example.createCriteria();
        if(doctor!=null){
            // 
            if(!StringUtils.isEmpty(doctor.getID())){
                    criteria.andEqualTo("ID",doctor.getID());
            }
            // 医生工号
            if(!StringUtils.isEmpty(doctor.getDoctorNumber())){
                    criteria.andEqualTo("DoctorNumber",doctor.getDoctorNumber());
            }
            // 医生姓名
            if(!StringUtils.isEmpty(doctor.getDoctorName())){
                    criteria.andEqualTo("DoctorName",doctor.getDoctorName());
            }
            // 所属科室 外键
            if(!StringUtils.isEmpty(doctor.getDepartmentsId())){
                    criteria.andEqualTo("DepartmentsId",doctor.getDepartmentsId());
            }
            // 部门ID（外键）
            if(!StringUtils.isEmpty(doctor.getDeptID())){
                    criteria.andEqualTo("DeptID",doctor.getDeptID());
            }
            // 密码
            if(!StringUtils.isEmpty(doctor.getDoctorPassword())){
                    criteria.andEqualTo("DoctorPassword",doctor.getDoctorPassword());
            }
            // 邮箱
            if(!StringUtils.isEmpty(doctor.getDoctorEmail())){
                    criteria.andEqualTo("DoctorEmail",doctor.getDoctorEmail());
            }
            // 电话
            if(!StringUtils.isEmpty(doctor.getDoctorPhone())){
                    criteria.andEqualTo("DoctorPhone",doctor.getDoctorPhone());
            }
            // 性别
            if(!StringUtils.isEmpty(doctor.getDoctorSex())){
                    criteria.andEqualTo("DoctorSex",doctor.getDoctorSex());
            }
            // 家庭住址
            if(!StringUtils.isEmpty(doctor.getDoctorAddress())){
                    criteria.andEqualTo("DoctorAddress",doctor.getDoctorAddress());
            }
            // 身份证号
            if(!StringUtils.isEmpty(doctor.getDoctorCarID())){
                    criteria.andEqualTo("DoctorCarID",doctor.getDoctorCarID());
            }
            // 状态（0：正常登录1：异常不可登
            if(!StringUtils.isEmpty(doctor.getDocStatsu())){
                    criteria.andEqualTo("DocStatsu",doctor.getDocStatsu());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        doctorMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Doctor
     * @param doctor
     */
    @Override
    public void update(Doctor doctor){
        doctorMapper.updateByPrimaryKey(doctor);
    }

    /**
     * 增加Doctor
     * @param doctor
     */
    @Override
    public void add(Doctor doctor){
        doctorMapper.insert(doctor);
    }

    /**
     * 根据ID查询Doctor
     * @param id
     * @return
     */
    @Override
    public Doctor findById(Integer id){
        return  doctorMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Doctor全部数据
     * @return
     */
    @Override
    public List<Doctor> findAll() {
        return doctorMapper.selectAll();
    }
}
