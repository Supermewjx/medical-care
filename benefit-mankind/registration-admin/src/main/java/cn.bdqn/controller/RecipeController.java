package cn.bdqn.controller;

import cn.bdqn.domain.Recipe;
import cn.bdqn.service.RecipeService;
import cn.bdqn.utils.Result;
import cn.bdqn.utils.StatusCode;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "RecipeController")
@RestController
@RequestMapping("/recipe")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    /***
     * Recipe分页条件搜索实现
     * @param recipe
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Recipe条件分页查询",notes = "分页条件查询Recipe方法详情",tags = {"RecipeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Recipe对象",value = "传入JSON数据",required = false) Recipe recipe, @PathVariable  int page, @PathVariable  int size){
        //调用RecipeService实现分页条件查询Recipe
        PageInfo<Recipe> pageInfo = recipeService.findPage(recipe, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Recipe分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Recipe分页查询",notes = "分页查询Recipe方法详情",tags = {"RecipeController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RecipeService实现分页查询Recipe
        PageInfo<Recipe> pageInfo = recipeService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param recipe
     * @return
     */
    @ApiOperation(value = "Recipe条件查询",notes = "条件查询Recipe方法详情",tags = {"RecipeController"})
    @PostMapping(value = "/search" )
    public Result<List<Recipe>> findList(@RequestBody(required = false) @ApiParam(name = "Recipe对象",value = "传入JSON数据",required = false) Recipe recipe){
        //调用RecipeService实现条件查询Recipe
        List<Recipe> list = recipeService.findList(recipe);
        return new Result<List<Recipe>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Recipe根据ID删除",notes = "根据ID删除Recipe方法详情",tags = {"RecipeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RecipeService实现根据主键删除
        recipeService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Recipe数据
     * @param recipe
     * @param id
     * @return
     */
    @ApiOperation(value = "Recipe根据ID修改",notes = "根据ID修改Recipe方法详情",tags = {"RecipeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Recipe对象",value = "传入JSON数据",required = false) Recipe recipe,@PathVariable Integer id){
        //设置主键值
        recipe.setID(id);
        //调用RecipeService实现修改Recipe
        recipeService.update(recipe);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Recipe数据
     * @param recipe
     * @return
     */
    @ApiOperation(value = "Recipe添加",notes = "添加Recipe方法详情",tags = {"RecipeController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Recipe对象",value = "传入JSON数据",required = true) Recipe recipe){
        //调用RecipeService实现添加Recipe
        recipeService.add(recipe);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Recipe数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Recipe根据ID查询",notes = "根据ID查询Recipe方法详情",tags = {"RecipeController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Recipe> findById(@PathVariable Integer id){
        //调用RecipeService实现根据主键查询Recipe
        Recipe recipe = recipeService.findById(id);
        return new Result<Recipe>(true,StatusCode.OK,"查询成功",recipe);
    }

    /***
     * 查询Recipe全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Recipe",notes = "查询所Recipe有方法详情",tags = {"RecipeController"})
    @GetMapping
    public Result<List<Recipe>> findAll(){
        //调用RecipeService实现查询所有Recipe
        List<Recipe> list = recipeService.findAll();
        return new Result<List<Recipe>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
