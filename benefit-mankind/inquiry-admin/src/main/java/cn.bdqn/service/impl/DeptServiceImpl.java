package cn.bdqn.service.impl;

import cn.bdqn.domain.Dept;
import cn.bdqn.mapper.DeptMapper;
import cn.bdqn.service.DeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Dept业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    /**
     * Dept条件+分页查询
     * @param dept 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Dept> findPage(Dept dept, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(dept);
        //执行搜索
        return new PageInfo<Dept>(deptMapper.selectByExample(example));
    }

    /**
     * Dept分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Dept> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Dept>(deptMapper.selectAll());
    }

    /**
     * Dept条件查询
     * @param dept
     * @return
     */
    @Override
    public List<Dept> findList(Dept dept){
        //构建查询条件
        Example example = createExample(dept);
        //根据构建的条件查询数据
        return deptMapper.selectByExample(example);
    }


    /**
     * Dept构建查询对象
     * @param dept
     * @return
     */
    public Example createExample(Dept dept){
        Example example=new Example(Dept.class);
        Example.Criteria criteria = example.createCriteria();
        if(dept!=null){
            // 
            if(!StringUtils.isEmpty(dept.getID())){
                    criteria.andEqualTo("ID",dept.getID());
            }
            // 部门名称
            if(!StringUtils.isEmpty(dept.getEptName())){
                    criteria.andEqualTo("eptName",dept.getEptName());
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
        deptMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Dept
     * @param dept
     */
    @Override
    public void update(Dept dept){
        deptMapper.updateByPrimaryKey(dept);
    }

    /**
     * 增加Dept
     * @param dept
     */
    @Override
    public void add(Dept dept){
        deptMapper.insert(dept);
    }

    /**
     * 根据ID查询Dept
     * @param id
     * @return
     */
    @Override
    public Dept findById(Integer id){
        return  deptMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Dept全部数据
     * @return
     */
    @Override
    public List<Dept> findAll() {
        return deptMapper.selectAll();
    }
}
