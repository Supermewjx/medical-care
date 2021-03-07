package cn.bdqn.service.impl;

import cn.bdqn.domain.Druginfo;
import cn.bdqn.mapper.DruginfoMapper;
import cn.bdqn.service.DruginfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Druginfo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class DruginfoServiceImpl implements DruginfoService {

    @Autowired
    private DruginfoMapper druginfoMapper;


    /**
     * Druginfo条件+分页查询
     * @param druginfo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Druginfo> findPage(Druginfo druginfo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(druginfo);
        //执行搜索
        return new PageInfo<Druginfo>(druginfoMapper.selectByExample(example));
    }

    /**
     * Druginfo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Druginfo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Druginfo>(druginfoMapper.selectAll());
    }

    /**
     * Druginfo条件查询
     * @param druginfo
     * @return
     */
    @Override
    public List<Druginfo> findList(Druginfo druginfo){
        //构建查询条件
        Example example = createExample(druginfo);
        //根据构建的条件查询数据
        return druginfoMapper.selectByExample(example);
    }


    /**
     * Druginfo构建查询对象
     * @param druginfo
     * @return
     */
    public Example createExample(Druginfo druginfo){
        Example example=new Example(Druginfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(druginfo!=null){
            // 
            if(!StringUtils.isEmpty(druginfo.getID())){
                    criteria.andEqualTo("ID",druginfo.getID());
            }
            // 药品名称
            if(!StringUtils.isEmpty(druginfo.getDrugName())){
                    criteria.andEqualTo("DrugName",druginfo.getDrugName());
            }
            // 药品单价
            if(!StringUtils.isEmpty(druginfo.getDrugPrice())){
                    criteria.andEqualTo("DrugPrice",druginfo.getDrugPrice());
            }
            // 药品说明
            if(!StringUtils.isEmpty(druginfo.getDrugExplain())){
                    criteria.andEqualTo("DrugExplain",druginfo.getDrugExplain());
            }
            // 药品类型
            if(!StringUtils.isEmpty(druginfo.getDrugType())){
                    criteria.andEqualTo("DrugType",druginfo.getDrugType());
            }
            // 药品剂量
            if(!StringUtils.isEmpty(druginfo.getDrugDosage())){
                    criteria.andEqualTo("DrugDosage",druginfo.getDrugDosage());
            }
            // 药品规格
            if(!StringUtils.isEmpty(druginfo.getDrugSpecifications())){
                    criteria.andEqualTo("DrugSpecifications",druginfo.getDrugSpecifications());
            }
            // 药品使用方式
            if(!StringUtils.isEmpty(druginfo.getDrugWay())){
                    criteria.andEqualTo("DrugWay",druginfo.getDrugWay());
            }
            // 保质期
            if(!StringUtils.isEmpty(druginfo.getDrugQuality())){
                    criteria.andEqualTo("DrugQuality",druginfo.getDrugQuality());
            }
            // 药品生产日期
            if(!StringUtils.isEmpty(druginfo.getDrugManufacture())){
                    criteria.andEqualTo("DrugManufacture",druginfo.getDrugManufacture());
            }
            // 单位(盒,片，瓶)
            if(!StringUtils.isEmpty(druginfo.getDrugCompany())){
                    criteria.andEqualTo("DrugCompany",druginfo.getDrugCompany());
            }
            // 厂家
            if(!StringUtils.isEmpty(druginfo.getDrugManufactor())){
                    criteria.andEqualTo("DrugManufactor",druginfo.getDrugManufactor());
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
        druginfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Druginfo
     * @param druginfo
     */
    @Override
    public void update(Druginfo druginfo){
        druginfoMapper.updateByPrimaryKey(druginfo);
    }

    /**
     * 增加Druginfo
     * @param druginfo
     */
    @Override
    public void add(Druginfo druginfo){
        druginfoMapper.insert(druginfo);
    }

    /**
     * 根据ID查询Druginfo
     * @param id
     * @return
     */
    @Override
    public Druginfo findById(Integer id){
        return  druginfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Druginfo全部数据
     * @return
     */
    @Override
    public List<Druginfo> findAll() {
        return druginfoMapper.selectAll();
    }
}
