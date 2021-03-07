package cn.bdqn.service.impl;

import cn.bdqn.domain.Pharmacy;
import cn.bdqn.mapper.PharmacyMapper;
import cn.bdqn.service.PharmacyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Pharmacy业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class PharmacyServiceImpl implements PharmacyService {

    @Autowired
    private PharmacyMapper pharmacyMapper;


    /**
     * Pharmacy条件+分页查询
     * @param pharmacy 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Pharmacy> findPage(Pharmacy pharmacy, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(pharmacy);
        //执行搜索
        return new PageInfo<Pharmacy>(pharmacyMapper.selectByExample(example));
    }

    /**
     * Pharmacy分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Pharmacy> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Pharmacy>(pharmacyMapper.selectAll());
    }

    /**
     * Pharmacy条件查询
     * @param pharmacy
     * @return
     */
    @Override
    public List<Pharmacy> findList(Pharmacy pharmacy){
        //构建查询条件
        Example example = createExample(pharmacy);
        //根据构建的条件查询数据
        return pharmacyMapper.selectByExample(example);
    }


    /**
     * Pharmacy构建查询对象
     * @param pharmacy
     * @return
     */
    public Example createExample(Pharmacy pharmacy){
        Example example=new Example(Pharmacy.class);
        Example.Criteria criteria = example.createCriteria();
        if(pharmacy!=null){
            // 
            if(!StringUtils.isEmpty(pharmacy.getID())){
                    criteria.andEqualTo("ID",pharmacy.getID());
            }
            // 外键
            if(!StringUtils.isEmpty(pharmacy.getDruID())){
                    criteria.andEqualTo("DruID",pharmacy.getDruID());
            }
            // 药房药品剩余总数量
            if(!StringUtils.isEmpty(pharmacy.getDrogTotalNumber())){
                    criteria.andEqualTo("DrogTotalNumber",pharmacy.getDrogTotalNumber());
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
        pharmacyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Pharmacy
     * @param pharmacy
     */
    @Override
    public void update(Pharmacy pharmacy){
        pharmacyMapper.updateByPrimaryKey(pharmacy);
    }

    /**
     * 增加Pharmacy
     * @param pharmacy
     */
    @Override
    public void add(Pharmacy pharmacy){
        pharmacyMapper.insert(pharmacy);
    }

    /**
     * 根据ID查询Pharmacy
     * @param id
     * @return
     */
    @Override
    public Pharmacy findById(Integer id){
        return  pharmacyMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Pharmacy全部数据
     * @return
     */
    @Override
    public List<Pharmacy> findAll() {
        return pharmacyMapper.selectAll();
    }
}
