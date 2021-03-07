package cn.bdqn.controller;

import cn.bdqn.domain.Dept;
import cn.bdqn.service.DeptService;
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
@Api(value = "DeptController")
@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DeptController {

    @Autowired
    private DeptService deptService;

    /***
     * Dept分页条件搜索实现
     * @param dept
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Dept条件分页查询",notes = "分页条件查询Dept方法详情",tags = {"DeptController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Dept对象",value = "传入JSON数据",required = false) Dept dept, @PathVariable  int page, @PathVariable  int size){
        //调用DeptService实现分页条件查询Dept
        PageInfo<Dept> pageInfo = deptService.findPage(dept, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Dept分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Dept分页查询",notes = "分页查询Dept方法详情",tags = {"DeptController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DeptService实现分页查询Dept
        PageInfo<Dept> pageInfo = deptService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param dept
     * @return
     */
    @ApiOperation(value = "Dept条件查询",notes = "条件查询Dept方法详情",tags = {"DeptController"})
    @PostMapping(value = "/search" )
    public Result<List<Dept>> findList(@RequestBody(required = false) @ApiParam(name = "Dept对象",value = "传入JSON数据",required = false) Dept dept){
        //调用DeptService实现条件查询Dept
        List<Dept> list = deptService.findList(dept);
        return new Result<List<Dept>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Dept根据ID删除",notes = "根据ID删除Dept方法详情",tags = {"DeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DeptService实现根据主键删除
        deptService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Dept数据
     * @param dept
     * @param id
     * @return
     */
    @ApiOperation(value = "Dept根据ID修改",notes = "根据ID修改Dept方法详情",tags = {"DeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Dept对象",value = "传入JSON数据",required = false) Dept dept,@PathVariable Integer id){
        //设置主键值
        dept.setID(id);
        //调用DeptService实现修改Dept
        deptService.update(dept);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Dept数据
     * @param dept
     * @return
     */
    @ApiOperation(value = "Dept添加",notes = "添加Dept方法详情",tags = {"DeptController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Dept对象",value = "传入JSON数据",required = true) Dept dept){
        //调用DeptService实现添加Dept
        deptService.add(dept);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Dept数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Dept根据ID查询",notes = "根据ID查询Dept方法详情",tags = {"DeptController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Dept> findById(@PathVariable Integer id){
        //调用DeptService实现根据主键查询Dept
        Dept dept = deptService.findById(id);
        return new Result<Dept>(true,StatusCode.OK,"查询成功",dept);
    }

    /***
     * 查询Dept全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Dept",notes = "查询所Dept有方法详情",tags = {"DeptController"})
    @GetMapping
    public Result<List<Dept>> findAll(){
        //调用DeptService实现查询所有Dept
        List<Dept> list = deptService.findAll();
        return new Result<List<Dept>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
