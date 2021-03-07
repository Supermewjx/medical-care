package cn.bdqn.service.impl;

import cn.bdqn.domain.Bunk;
import cn.bdqn.mapper.BunkMapper;
import cn.bdqn.service.BunkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Bunk业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class BunkServiceImpl implements BunkService {

    @Autowired
    private BunkMapper bunkMapper;


    /**
     * Bunk条件+分页查询
     * @param bunk 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Bunk> findPage(Bunk bunk, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(bunk);
        //执行搜索
        return new PageInfo<Bunk>(bunkMapper.selectByExample(example));
    }

    /**
     * Bunk分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Bunk> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Bunk>(bunkMapper.selectAll());
    }

    /**
     * Bunk条件查询
     * @param bunk
     * @return
     */
    @Override
    public List<Bunk> findList(Bunk bunk){
        //构建查询条件
        Example example = createExample(bunk);
        //根据构建的条件查询数据
        return bunkMapper.selectByExample(example);
    }


    /**
     * Bunk构建查询对象
     * @param bunk
     * @return
     */
    public Example createExample(Bunk bunk){
        Example example=new Example(Bunk.class);
        Example.Criteria criteria = example.createCriteria();
        if(bunk!=null){
            // 
            if(!StringUtils.isEmpty(bunk.getID())){
                    criteria.andEqualTo("ID",bunk.getID());
            }
            // 床位号
            if(!StringUtils.isEmpty(bunk.getBunkID())){
                    criteria.andEqualTo("BunkID",bunk.getBunkID());
            }
            // 房间表外键ID
            if(!StringUtils.isEmpty(bunk.getRoomID())){
                    criteria.andEqualTo("RoomID",bunk.getRoomID());
            }
            // 是否住人（0，未住1，住）
            if(!StringUtils.isEmpty(bunk.getBunkStatus())){
                    criteria.andEqualTo("BunkStatus",bunk.getBunkStatus());
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
        bunkMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Bunk
     * @param bunk
     */
    @Override
    public void update(Bunk bunk){
        bunkMapper.updateByPrimaryKey(bunk);
    }

    /**
     * 增加Bunk
     * @param bunk
     */
    @Override
    public void add(Bunk bunk){
        bunkMapper.insert(bunk);
    }

    /**
     * 根据ID查询Bunk
     * @param id
     * @return
     */
    @Override
    public Bunk findById(Integer id){
        return  bunkMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Bunk全部数据
     * @return
     */
    @Override
    public List<Bunk> findAll() {
        return bunkMapper.selectAll();
    }
}
