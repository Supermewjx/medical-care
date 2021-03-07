package cn.bdqn.service.impl;

import cn.bdqn.domain.Doctordiagnose;
import cn.bdqn.mapper.DoctordiagnoseMapper;
import cn.bdqn.service.DoctordiagnoseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Doctordiagnose业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DoctordiagnoseServiceImpl implements DoctordiagnoseService {

    @Autowired
    private DoctordiagnoseMapper doctordiagnoseMapper;


    /**
     * Doctordiagnose条件+分页查询
     * @param doctordiagnose 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Doctordiagnose> findPage(Doctordiagnose doctordiagnose, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(doctordiagnose);
        //执行搜索
        return new PageInfo<Doctordiagnose>(doctordiagnoseMapper.selectByExample(example));
    }

    /**
     * Doctordiagnose分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Doctordiagnose> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Doctordiagnose>(doctordiagnoseMapper.selectAll());
    }

    /**
     * Doctordiagnose条件查询
     * @param doctordiagnose
     * @return
     */
    @Override
    public List<Doctordiagnose> findList(Doctordiagnose doctordiagnose){
        //构建查询条件
        Example example = createExample(doctordiagnose);
        //根据构建的条件查询数据
        return doctordiagnoseMapper.selectByExample(example);
    }


    /**
     * Doctordiagnose构建查询对象
     * @param doctordiagnose
     * @return
     */
    public Example createExample(Doctordiagnose doctordiagnose){
        Example example=new Example(Doctordiagnose.class);
        Example.Criteria criteria = example.createCriteria();
        if(doctordiagnose!=null){
            // 
            if(!StringUtils.isEmpty(doctordiagnose.getID())){
                    criteria.andEqualTo("ID",doctordiagnose.getID());
            }
            // 挂号外键 病人信息
            if(!StringUtils.isEmpty(doctordiagnose.getRegisID())){
                    criteria.andEqualTo("RegisID",doctordiagnose.getRegisID());
            }
            // 病情
            if(!StringUtils.isEmpty(doctordiagnose.getDiagCondition())){
                    criteria.andEqualTo("DiagCondition",doctordiagnose.getDiagCondition());
            }
            // 是否需要住院（默认不需要）
            if(!StringUtils.isEmpty(doctordiagnose.getIsHospital())){
                    criteria.andEqualTo("IsHospital",doctordiagnose.getIsHospital());
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
        doctordiagnoseMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Doctordiagnose
     * @param doctordiagnose
     */
    @Override
    public void update(Doctordiagnose doctordiagnose){
        doctordiagnoseMapper.updateByPrimaryKey(doctordiagnose);
    }

    /**
     * 增加Doctordiagnose
     * @param doctordiagnose
     */
    @Override
    public void add(Doctordiagnose doctordiagnose){
        doctordiagnoseMapper.insert(doctordiagnose);
    }

    /**
     * 根据ID查询Doctordiagnose
     * @param id
     * @return
     */
    @Override
    public Doctordiagnose findById(Integer id){
        return  doctordiagnoseMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Doctordiagnose全部数据
     * @return
     */
    @Override
    public List<Doctordiagnose> findAll() {
        return doctordiagnoseMapper.selectAll();
    }
}
