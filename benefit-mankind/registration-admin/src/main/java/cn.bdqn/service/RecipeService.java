package cn.bdqn.service;

import cn.bdqn.domain.Recipe;
import com.github.pagehelper.PageInfo;

import java.util.List;
/****
 * @Author:shenkunlin
 * @Description:Recipe业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RecipeService {

    /***
     * Recipe多条件分页查询
     * @param recipe
     * @param page
     * @param size
     * @return
     */
    PageInfo<Recipe> findPage(Recipe recipe, int page, int size);

    /***
     * Recipe分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Recipe> findPage(int page, int size);

    /***
     * Recipe多条件搜索方法
     * @param recipe
     * @return
     */
    List<Recipe> findList(Recipe recipe);

    /***
     * 删除Recipe
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Recipe数据
     * @param recipe
     */
    void update(Recipe recipe);

    /***
     * 新增Recipe
     * @param recipe
     */
    void add(Recipe recipe);

    /**
     * 根据ID查询Recipe
     * @param id
     * @return
     */
     Recipe findById(Integer id);

    /***
     * 查询所有Recipe
     * @return
     */
    List<Recipe> findAll();
}
