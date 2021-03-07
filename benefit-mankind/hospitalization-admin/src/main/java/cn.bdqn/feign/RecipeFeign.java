package cn.bdqn.feign;

import cn.bdqn.domain.Recipe;
import cn.bdqn.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/recipe")
public interface RecipeFeign {

    /***
     * Recipe分页条件搜索实现
     * @param recipe
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Recipe recipe, @PathVariable int page, @PathVariable int size);

    /***
     * Recipe分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param recipe
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Recipe>> findList(@RequestBody(required = false) Recipe recipe);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Recipe数据
     * @param recipe
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Recipe recipe, @PathVariable Integer id);

    /***
     * 新增Recipe数据
     * @param recipe
     * @return
     */
    @PostMapping
    Result add(@RequestBody Recipe recipe);

    /***
     * 根据ID查询Recipe数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Recipe> findById(@PathVariable Integer id);

    /***
     * 查询Recipe全部数据
     * @return
     */
    @GetMapping
    Result<List<Recipe>> findAll();
}