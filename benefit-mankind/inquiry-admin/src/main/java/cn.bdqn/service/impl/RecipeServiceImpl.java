package cn.bdqn.service.impl;

import cn.bdqn.domain.Recipe;
import cn.bdqn.mapper.RecipeMapper;
import cn.bdqn.service.RecipeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Recipe业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;


    /**
     * Recipe条件+分页查询
     * @param recipe 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Recipe> findPage(Recipe recipe, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(recipe);
        //执行搜索
        return new PageInfo<Recipe>(recipeMapper.selectByExample(example));
    }

    /**
     * Recipe分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Recipe> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Recipe>(recipeMapper.selectAll());
    }

    /**
     * Recipe条件查询
     * @param recipe
     * @return
     */
    @Override
    public List<Recipe> findList(Recipe recipe){
        //构建查询条件
        Example example = createExample(recipe);
        //根据构建的条件查询数据
        return recipeMapper.selectByExample(example);
    }


    /**
     * Recipe构建查询对象
     * @param recipe
     * @return
     */
    public Example createExample(Recipe recipe){
        Example example=new Example(Recipe.class);
        Example.Criteria criteria = example.createCriteria();
        if(recipe!=null){
            // 
            if(!StringUtils.isEmpty(recipe.getID())){
                    criteria.andEqualTo("ID",recipe.getID());
            }
            // 挂号外键 病人信息
            if(!StringUtils.isEmpty(recipe.getRegisID())){
                    criteria.andEqualTo("RegisID",recipe.getRegisID());
            }
            // 药品信息ID外键
            if(!StringUtils.isEmpty(recipe.getDruginfoID())){
                    criteria.andEqualTo("DruginfoID",recipe.getDruginfoID());
            }
            // 药品数量
            if(!StringUtils.isEmpty(recipe.getDrugNumber())){
                    criteria.andEqualTo("DrugNumber",recipe.getDrugNumber());
            }
            // 总金额
            if(!StringUtils.isEmpty(recipe.getDrugTotalprice())){
                    criteria.andEqualTo("DrugTotalprice",recipe.getDrugTotalprice());
            }
            // 缴费状态
            if(!StringUtils.isEmpty(recipe.getRecipePayStatus())){
                    criteria.andEqualTo("RecipePayStatus",recipe.getRecipePayStatus());
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
        recipeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Recipe
     * @param recipe
     */
    @Override
    public void update(Recipe recipe){
        recipeMapper.updateByPrimaryKey(recipe);
    }

    /**
     * 增加Recipe
     * @param recipe
     */
    @Override
    public void add(Recipe recipe){
        recipeMapper.insert(recipe);
    }

    /**
     * 根据ID查询Recipe
     * @param id
     * @return
     */
    @Override
    public Recipe findById(Integer id){
        return  recipeMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Recipe全部数据
     * @return
     */
    @Override
    public List<Recipe> findAll() {
        return recipeMapper.selectAll();
    }
}
