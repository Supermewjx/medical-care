package cn.bdqn.controller;

import cn.bdqn.domain.Druginfo;
import cn.bdqn.service.DruginfoService;
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
@Api(value = "DruginfoController")
@RestController
@RequestMapping("/druginfo")
@CrossOrigin
public class DruginfoController {

    @Autowired
    private DruginfoService druginfoService;

    /***
     * Druginfo分页条件搜索实现
     * @param druginfo
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Druginfo条件分页查询",notes = "分页条件查询Druginfo方法详情",tags = {"DruginfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Druginfo对象",value = "传入JSON数据",required = false) Druginfo druginfo, @PathVariable  int page, @PathVariable  int size){
        //调用DruginfoService实现分页条件查询Druginfo
        PageInfo<Druginfo> pageInfo = druginfoService.findPage(druginfo, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Druginfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Druginfo分页查询",notes = "分页查询Druginfo方法详情",tags = {"DruginfoController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DruginfoService实现分页查询Druginfo
        PageInfo<Druginfo> pageInfo = druginfoService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param druginfo
     * @return
     */
    @ApiOperation(value = "Druginfo条件查询",notes = "条件查询Druginfo方法详情",tags = {"DruginfoController"})
    @PostMapping(value = "/search" )
    public Result<List<Druginfo>> findList(@RequestBody(required = false) @ApiParam(name = "Druginfo对象",value = "传入JSON数据",required = false) Druginfo druginfo){
        //调用DruginfoService实现条件查询Druginfo
        List<Druginfo> list = druginfoService.findList(druginfo);
        return new Result<List<Druginfo>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Druginfo根据ID删除",notes = "根据ID删除Druginfo方法详情",tags = {"DruginfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DruginfoService实现根据主键删除
        druginfoService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Druginfo数据
     * @param druginfo
     * @param id
     * @return
     */
    @ApiOperation(value = "Druginfo根据ID修改",notes = "根据ID修改Druginfo方法详情",tags = {"DruginfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Druginfo对象",value = "传入JSON数据",required = false) Druginfo druginfo,@PathVariable Integer id){
        //设置主键值
        druginfo.setID(id);
        //调用DruginfoService实现修改Druginfo
        druginfoService.update(druginfo);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Druginfo数据
     * @param druginfo
     * @return
     */
    @ApiOperation(value = "Druginfo添加",notes = "添加Druginfo方法详情",tags = {"DruginfoController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Druginfo对象",value = "传入JSON数据",required = true) Druginfo druginfo){
        //调用DruginfoService实现添加Druginfo
        druginfoService.add(druginfo);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Druginfo数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Druginfo根据ID查询",notes = "根据ID查询Druginfo方法详情",tags = {"DruginfoController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Druginfo> findById(@PathVariable Integer id){
        //调用DruginfoService实现根据主键查询Druginfo
        Druginfo druginfo = druginfoService.findById(id);
        return new Result<Druginfo>(true,StatusCode.OK,"查询成功",druginfo);
    }

    /***
     * 查询Druginfo全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Druginfo",notes = "查询所Druginfo有方法详情",tags = {"DruginfoController"})
    @GetMapping
    public Result<List<Druginfo>> findAll(){
        //调用DruginfoService实现查询所有Druginfo
        List<Druginfo> list = druginfoService.findAll();
        return new Result<List<Druginfo>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
