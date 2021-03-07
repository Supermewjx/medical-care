package cn.bdqn.controller;

import cn.bdqn.domain.Departments;
import cn.bdqn.service.DepartmentsService;
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
@Api(value = "DepartmentsController")
@RestController
@RequestMapping("/departments")
@CrossOrigin
public class DepartmentsController {

    @Autowired
    private DepartmentsService departmentsService;

    /***
     * Departments分页条件搜索实现
     * @param departments
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Departments条件分页查询",notes = "分页条件查询Departments方法详情",tags = {"DepartmentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )

    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Departments对象",value = "传入JSON数据",required = false) Departments departments, @PathVariable  int page, @PathVariable  int size){
        //调用DepartmentsService实现分页条件查询Departments
        PageInfo<Departments> pageInfo = departmentsService.findPage(departments, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Departments分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Departments分页查询",notes = "分页查询Departments方法详情",tags = {"DepartmentsController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DepartmentsService实现分页查询Departments
        PageInfo<Departments> pageInfo = departmentsService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param departments
     * @return
     */
    @ApiOperation(value = "Departments条件查询",notes = "条件查询Departments方法详情",tags = {"DepartmentsController"})
    @PostMapping(value = "/search" )
    public Result<List<Departments>> findList(@RequestBody(required = false) @ApiParam(name = "Departments对象",value = "传入JSON数据",required = false) Departments departments){
        //调用DepartmentsService实现条件查询Departments
        List<Departments> list = departmentsService.findList(departments);
        return new Result<List<Departments>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Departments根据ID删除",notes = "根据ID删除Departments方法详情",tags = {"DepartmentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DepartmentsService实现根据主键删除
        departmentsService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Departments数据
     * @param departments
     * @param id
     * @return
     */
    @ApiOperation(value = "Departments根据ID修改",notes = "根据ID修改Departments方法详情",tags = {"DepartmentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Departments对象",value = "传入JSON数据",required = false) Departments departments,@PathVariable Integer id){
        //设置主键值
        departments.setID(id);
        //调用DepartmentsService实现修改Departments
        departmentsService.update(departments);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Departments数据
     * @param departments
     * @return
     */
    @ApiOperation(value = "Departments添加",notes = "添加Departments方法详情",tags = {"DepartmentsController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Departments对象",value = "传入JSON数据",required = true) Departments departments){
        //调用DepartmentsService实现添加Departments
        departmentsService.add(departments);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Departments数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Departments根据ID查询",notes = "根据ID查询Departments方法详情",tags = {"DepartmentsController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Departments> findById(@PathVariable Integer id){
        //调用DepartmentsService实现根据主键查询Departments
        Departments departments = departmentsService.findById(id);
        return new Result<Departments>(true,StatusCode.OK,"查询成功",departments);
    }

    /***
     * 查询Departments全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Departments",notes = "查询所Departments有方法详情",tags = {"DepartmentsController"})
    @GetMapping
    public Result<List<Departments>> findAll(){
        //调用DepartmentsService实现查询所有Departments
        List<Departments> list = departmentsService.findAll();
        return new Result<List<Departments>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
