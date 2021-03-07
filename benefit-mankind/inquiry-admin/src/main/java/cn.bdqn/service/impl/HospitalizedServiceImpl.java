package cn.bdqn.service.impl;

import cn.bdqn.domain.Hospitalized;
import cn.bdqn.mapper.HospitalizedMapper;
import cn.bdqn.service.HospitalizedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Hospitalized业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class HospitalizedServiceImpl implements HospitalizedService {

    @Autowired
    private HospitalizedMapper hospitalizedMapper;


    /**
     * Hospitalized条件+分页查询
     * @param hospitalized 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Hospitalized> findPage(Hospitalized hospitalized, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(hospitalized);
        //执行搜索
        return new PageInfo<Hospitalized>(hospitalizedMapper.selectByExample(example));
    }

    /**
     * Hospitalized分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Hospitalized> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Hospitalized>(hospitalizedMapper.selectAll());
    }

    /**
     * Hospitalized条件查询
     * @param hospitalized
     * @return
     */
    @Override
    public List<Hospitalized> findList(Hospitalized hospitalized){
        //构建查询条件
        Example example = createExample(hospitalized);
        //根据构建的条件查询数据
        return hospitalizedMapper.selectByExample(example);
    }


    /**
     * Hospitalized构建查询对象
     * @param hospitalized
     * @return
     */
    public Example createExample(Hospitalized hospitalized){
        Example example=new Example(Hospitalized.class);
        Example.Criteria criteria = example.createCriteria();
        if(hospitalized!=null){
            // 
            if(!StringUtils.isEmpty(hospitalized.getID())){
                    criteria.andEqualTo("ID",hospitalized.getID());
            }
            // 处方表ID
            if(!StringUtils.isEmpty(hospitalized.getRecipeId())){
                    criteria.andEqualTo("recipeId",hospitalized.getRecipeId());
            }
            // 床位号外键
            if(!StringUtils.isEmpty(hospitalized.getBunkId())){
                    criteria.andEqualTo("bunkId",hospitalized.getBunkId());
            }
            // 是否出院（0，住院，1出院）
            if(!StringUtils.isEmpty(hospitalized.getStatus())){
                    criteria.andEqualTo("status",hospitalized.getStatus());
            }
            // 住院天数
            if(!StringUtils.isEmpty(hospitalized.getHospDay())){
                    criteria.andEqualTo("hospDay",hospitalized.getHospDay());
            }
            // 住院日期
            if(!StringUtils.isEmpty(hospitalized.getHospStart())){
                    criteria.andEqualTo("hospStart",hospitalized.getHospStart());
            }
            // 出院日期
            if(!StringUtils.isEmpty(hospitalized.getHostEnd())){
                    criteria.andEqualTo("hostEnd",hospitalized.getHostEnd());
            }
            // 住院金额
            if(!StringUtils.isEmpty(hospitalized.getHostMoney())){
                    criteria.andEqualTo("hostMoney",hospitalized.getHostMoney());
            }
            // 挂号表外键
            if(!StringUtils.isEmpty(hospitalized.getRegistrationId())){
                    criteria.andEqualTo("registrationId",hospitalized.getRegistrationId());
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
        hospitalizedMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Hospitalized
     * @param hospitalized
     */
    @Override
    public void update(Hospitalized hospitalized){
        hospitalizedMapper.updateByPrimaryKey(hospitalized);
    }

    /**
     * 增加Hospitalized
     * @param hospitalized
     */
    @Override
    public void add(Hospitalized hospitalized){
        hospitalizedMapper.insert(hospitalized);
    }

    /**
     * 根据ID查询Hospitalized
     * @param id
     * @return
     */
    @Override
    public Hospitalized findById(Integer id){
        return  hospitalizedMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Hospitalized全部数据
     * @return
     */
    @Override
    public List<Hospitalized> findAll() {
        return hospitalizedMapper.selectAll();
    }
}
