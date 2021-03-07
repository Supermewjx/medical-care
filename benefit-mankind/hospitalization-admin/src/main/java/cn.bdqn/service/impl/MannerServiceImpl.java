package cn.bdqn.service.impl;

import cn.bdqn.domain.Manner;
import cn.bdqn.mapper.MannerMapper;
import cn.bdqn.service.MannerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Manner业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class MannerServiceImpl implements MannerService {

    @Autowired
    private MannerMapper mannerMapper;


    /**
     * Manner条件+分页查询
     * @param manner 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Manner> findPage(Manner manner, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(manner);
        //执行搜索
        return new PageInfo<Manner>(mannerMapper.selectByExample(example));
    }

    /**
     * Manner分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Manner> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Manner>(mannerMapper.selectAll());
    }

    /**
     * Manner条件查询
     * @param manner
     * @return
     */
    @Override
    public List<Manner> findList(Manner manner){
        //构建查询条件
        Example example = createExample(manner);
        //根据构建的条件查询数据
        return mannerMapper.selectByExample(example);
    }


    /**
     * Manner构建查询对象
     * @param manner
     * @return
     */
    public Example createExample(Manner manner){
        Example example=new Example(Manner.class);
        Example.Criteria criteria = example.createCriteria();
        if(manner!=null){
            // 
            if(!StringUtils.isEmpty(manner.getID())){
                    criteria.andEqualTo("ID",manner.getID());
            }
            // 方式名称(普通挂号，高级挂号)
            if(!StringUtils.isEmpty(manner.getMannerName())){
                    criteria.andEqualTo("MannerName",manner.getMannerName());
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
        mannerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Manner
     * @param manner
     */
    @Override
    public void update(Manner manner){
        mannerMapper.updateByPrimaryKey(manner);
    }

    /**
     * 增加Manner
     * @param manner
     */
    @Override
    public void add(Manner manner){
        mannerMapper.insert(manner);
    }

    /**
     * 根据ID查询Manner
     * @param id
     * @return
     */
    @Override
    public Manner findById(Integer id){
        return  mannerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Manner全部数据
     * @return
     */
    @Override
    public List<Manner> findAll() {
        return mannerMapper.selectAll();
    }
}
