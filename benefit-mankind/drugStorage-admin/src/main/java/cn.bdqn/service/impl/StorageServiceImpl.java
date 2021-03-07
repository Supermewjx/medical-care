package cn.bdqn.service.impl;

import cn.bdqn.domain.Storage;
import cn.bdqn.mapper.StorageMapper;
import cn.bdqn.service.StorageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Storage业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;


    /**
     * Storage条件+分页查询
     * @param storage 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Storage> findPage(Storage storage, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(storage);
        //执行搜索
        return new PageInfo<Storage>(storageMapper.selectByExample(example));
    }

    /**
     * Storage分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Storage> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Storage>(storageMapper.selectAll());
    }

    /**
     * Storage条件查询
     * @param storage
     * @return
     */
    @Override
    public List<Storage> findList(Storage storage){
        //构建查询条件
        Example example = createExample(storage);
        //根据构建的条件查询数据
        return storageMapper.selectByExample(example);
    }


    /**
     * Storage构建查询对象
     * @param storage
     * @return
     */
    public Example createExample(Storage storage){
        Example example=new Example(Storage.class);
        Example.Criteria criteria = example.createCriteria();
        if(storage!=null){
            // 
            if(!StringUtils.isEmpty(storage.getID())){
                    criteria.andEqualTo("ID",storage.getID());
            }
            //  外键
            if(!StringUtils.isEmpty(storage.getDruID())){
                    criteria.andEqualTo("DruID",storage.getDruID());
            }
            // 药库药品剩余总数量
            if(!StringUtils.isEmpty(storage.getDrogYktotalNumber())){
                    criteria.andEqualTo("DrogYktotalNumber",storage.getDrogYktotalNumber());
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
        storageMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Storage
     * @param storage
     */
    @Override
    public void update(Storage storage){
        storageMapper.updateByPrimaryKey(storage);
    }

    /**
     * 增加Storage
     * @param storage
     */
    @Override
    public void add(Storage storage){
        storageMapper.insert(storage);
    }

    /**
     * 根据ID查询Storage
     * @param id
     * @return
     */
    @Override
    public Storage findById(Integer id){
        return  storageMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Storage全部数据
     * @return
     */
    @Override
    public List<Storage> findAll() {
        return storageMapper.selectAll();
    }
}
