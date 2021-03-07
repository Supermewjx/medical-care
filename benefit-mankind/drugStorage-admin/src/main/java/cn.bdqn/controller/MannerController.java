package cn.bdqn.controller;

import cn.bdqn.domain.Manner;
import cn.bdqn.service.MannerService;
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
@Api(value = "MannerController")
@RestController
@RequestMapping("/manner")
@CrossOrigin
public class MannerController {

    @Autowired
    private MannerService mannerService;

    /***
     * Manner分页条件搜索实现
     * @param manner
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Manner条件分页查询",notes = "分页条件查询Manner方法详情",tags = {"MannerController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Manner对象",value = "传入JSON数据",required = false) Manner manner, @PathVariable  int page, @PathVariable  int size){
        //调用MannerService实现分页条件查询Manner
        PageInfo<Manner> pageInfo = mannerService.findPage(manner, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Manner分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Manner分页查询",notes = "分页查询Manner方法详情",tags = {"MannerController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用MannerService实现分页查询Manner
        PageInfo<Manner> pageInfo = mannerService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param manner
     * @return
     */
    @ApiOperation(value = "Manner条件查询",notes = "条件查询Manner方法详情",tags = {"MannerController"})
    @PostMapping(value = "/search" )
    public Result<List<Manner>> findList(@RequestBody(required = false) @ApiParam(name = "Manner对象",value = "传入JSON数据",required = false) Manner manner){
        //调用MannerService实现条件查询Manner
        List<Manner> list = mannerService.findList(manner);
        return new Result<List<Manner>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Manner根据ID删除",notes = "根据ID删除Manner方法详情",tags = {"MannerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用MannerService实现根据主键删除
        mannerService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Manner数据
     * @param manner
     * @param id
     * @return
     */
    @ApiOperation(value = "Manner根据ID修改",notes = "根据ID修改Manner方法详情",tags = {"MannerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Manner对象",value = "传入JSON数据",required = false) Manner manner,@PathVariable Integer id){
        //设置主键值
        manner.setID(id);
        //调用MannerService实现修改Manner
        mannerService.update(manner);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Manner数据
     * @param manner
     * @return
     */
    @ApiOperation(value = "Manner添加",notes = "添加Manner方法详情",tags = {"MannerController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Manner对象",value = "传入JSON数据",required = true) Manner manner){
        //调用MannerService实现添加Manner
        mannerService.add(manner);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Manner数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Manner根据ID查询",notes = "根据ID查询Manner方法详情",tags = {"MannerController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Manner> findById(@PathVariable Integer id){
        //调用MannerService实现根据主键查询Manner
        Manner manner = mannerService.findById(id);
        return new Result<Manner>(true,StatusCode.OK,"查询成功",manner);
    }

    /***
     * 查询Manner全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Manner",notes = "查询所Manner有方法详情",tags = {"MannerController"})
    @GetMapping
    public Result<List<Manner>> findAll(){
        //调用MannerService实现查询所有Manner
        List<Manner> list = mannerService.findAll();
        return new Result<List<Manner>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
