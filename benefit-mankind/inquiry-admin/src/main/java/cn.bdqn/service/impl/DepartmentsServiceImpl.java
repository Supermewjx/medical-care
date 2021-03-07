package cn.bdqn.service.impl;

import cn.bdqn.domain.Departments;
import cn.bdqn.mapper.DepartmentsMapper;
import cn.bdqn.service.DepartmentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Departments业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DepartmentsServiceImpl implements DepartmentsService {

    @Autowired
    private DepartmentsMapper departmentsMapper;


    /**
     * Departments条件+分页查询
     * @param departments 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Departments> findPage(Departments departments, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(departments);
        //执行搜索
        return new PageInfo<Departments>(departmentsMapper.selectByExample(example));
    }

    /**
     * Departments分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Departments> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Departments>(departmentsMapper.selectAll());
    }

    /**
     * Departments条件查询
     * @param departments
     * @return
     */
    @Override
    public List<Departments> findList(Departments departments){
        //构建查询条件
        Example example = createExample(departments);
        //根据构建的条件查询数据
        return departmentsMapper.selectByExample(example);
    }


    /**
     * Departments构建查询对象
     * @param departments
     * @return
     */
    public Example createExample(Departments departments){
        Example example=new Example(Departments.class);
        Example.Criteria criteria = example.createCriteria();
        if(departments!=null){
            // 
            if(!StringUtils.isEmpty(departments.getID())){
                    criteria.andEqualTo("ID",departments.getID());
            }
            // 科室名称
            if(!StringUtils.isEmpty(departments.getDeparName())){
                    criteria.andEqualTo("DeparName",departments.getDeparName());
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
        departmentsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Departments
     * @param departments
     */
    @Override
    public void update(Departments departments){
        departmentsMapper.updateByPrimaryKey(departments);
    }

    /**
     * 增加Departments
     * @param departments
     */
    @Override
    public void add(Departments departments){
        departmentsMapper.insert(departments);
    }

    /**
     * 根据ID查询Departments
     * @param id
     * @return
     */
    @Override
    public Departments findById(Integer id){
        return  departmentsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Departments全部数据
     * @return
     */
    @Override
    public List<Departments> findAll() {
        return departmentsMapper.selectAll();
    }
}
