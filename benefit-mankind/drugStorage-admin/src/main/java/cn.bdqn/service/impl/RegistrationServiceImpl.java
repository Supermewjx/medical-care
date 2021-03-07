package cn.bdqn.service.impl;

import cn.bdqn.domain.Registration;
import cn.bdqn.mapper.RegistrationMapper;
import cn.bdqn.service.RegistrationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Registration业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationMapper registrationMapper;


    /**
     * Registration条件+分页查询
     * @param registration 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Registration> findPage(Registration registration, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(registration);
        //执行搜索
        return new PageInfo<Registration>(registrationMapper.selectByExample(example));
    }

    /**
     * Registration分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Registration> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Registration>(registrationMapper.selectAll());
    }

    /**
     * Registration条件查询
     * @param registration
     * @return
     */
    @Override
    public List<Registration> findList(Registration registration){
        //构建查询条件
        Example example = createExample(registration);
        //根据构建的条件查询数据
        return registrationMapper.selectByExample(example);
    }


    /**
     * Registration构建查询对象
     * @param registration
     * @return
     */
    public Example createExample(Registration registration){
        Example example=new Example(Registration.class);
        Example.Criteria criteria = example.createCriteria();
        if(registration!=null){
            // 
            if(!StringUtils.isEmpty(registration.getID())){
                    criteria.andEqualTo("ID",registration.getID());
            }
            // 号码
            if(!StringUtils.isEmpty(registration.getRegisNumber())){
                    criteria.andEqualTo("RegisNumber",registration.getRegisNumber());
            }
            // 挂号信息姓名
            if(!StringUtils.isEmpty(registration.getRegisName())){
                    criteria.andEqualTo("RegisName",registration.getRegisName());
            }
            // 性别（0:女 1:男）
            if(!StringUtils.isEmpty(registration.getRegisSex())){
                    criteria.andEqualTo("RegisSex",registration.getRegisSex());
            }
            // 电话
            if(!StringUtils.isEmpty(registration.getRegisPhone())){
                    criteria.andEqualTo("RegisPhone",registration.getRegisPhone());
            }
            // 年龄
            if(!StringUtils.isEmpty(registration.getRegisAge())){
                    criteria.andEqualTo("RegisAge",registration.getRegisAge());
            }
            // 出生日期
            if(!StringUtils.isEmpty(registration.getRegisBirthday())){
                    criteria.andEqualTo("RegisBirthday",registration.getRegisBirthday());
            }
            // 科室ID(外键)
            if(!StringUtils.isEmpty(registration.getRegisDepartments())){
                    criteria.andEqualTo("RegisDepartments",registration.getRegisDepartments());
            }
            // 医生ID(外键) 
            if(!StringUtils.isEmpty(registration.getRegisDoctor())){
                    criteria.andEqualTo("RegisDoctor",registration.getRegisDoctor());
            }
            // 挂号方式ID(外键)
            if(!StringUtils.isEmpty(registration.getRegisManner())){
                    criteria.andEqualTo("RegisManner",registration.getRegisManner());
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
        registrationMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Registration
     * @param registration
     */
    @Override
    public void update(Registration registration){
        registrationMapper.updateByPrimaryKey(registration);
    }

    /**
     * 增加Registration
     * @param registration
     */
    @Override
    public void add(Registration registration){
        registrationMapper.insert(registration);
    }

    /**
     * 根据ID查询Registration
     * @param id
     * @return
     */
    @Override
    public Registration findById(Integer id){
        return  registrationMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Registration全部数据
     * @return
     */
    @Override
    public List<Registration> findAll() {
        return registrationMapper.selectAll();
    }
}
