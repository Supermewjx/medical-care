package cn.bdqn.controller;

import cn.bdqn.domain.Bunk;
import cn.bdqn.service.BunkService;
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
@Api(value = "BunkController")
@RestController
@RequestMapping("/bunk")
@CrossOrigin
public class BunkController {

    @Autowired
    private BunkService bunkService;

    /***
     * Bunk分页条件搜索实现
     * @param bunk
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Bunk条件分页查询",notes = "分页条件查询Bunk方法详情",tags = {"BunkController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Bunk对象",value = "传入JSON数据",required = false) Bunk bunk, @PathVariable  int page, @PathVariable  int size){
        //调用BunkService实现分页条件查询Bunk
        PageInfo<Bunk> pageInfo = bunkService.findPage(bunk, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Bunk分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Bunk分页查询",notes = "分页查询Bunk方法详情",tags = {"BunkController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用BunkService实现分页查询Bunk
        PageInfo<Bunk> pageInfo = bunkService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param bunk
     * @return
     */
    @ApiOperation(value = "Bunk条件查询",notes = "条件查询Bunk方法详情",tags = {"BunkController"})
    @PostMapping(value = "/search" )
    public Result<List<Bunk>> findList(@RequestBody(required = false) @ApiParam(name = "Bunk对象",value = "传入JSON数据",required = false) Bunk bunk){
        //调用BunkService实现条件查询Bunk
        List<Bunk> list = bunkService.findList(bunk);
        return new Result<List<Bunk>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Bunk根据ID删除",notes = "根据ID删除Bunk方法详情",tags = {"BunkController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用BunkService实现根据主键删除
        bunkService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Bunk数据
     * @param bunk
     * @param id
     * @return
     */
    @ApiOperation(value = "Bunk根据ID修改",notes = "根据ID修改Bunk方法详情",tags = {"BunkController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Bunk对象",value = "传入JSON数据",required = false) Bunk bunk,@PathVariable Integer id){
        //设置主键值
        bunk.setID(id);
        //调用BunkService实现修改Bunk
        bunkService.update(bunk);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Bunk数据
     * @param bunk
     * @return
     */
    @ApiOperation(value = "Bunk添加",notes = "添加Bunk方法详情",tags = {"BunkController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Bunk对象",value = "传入JSON数据",required = true) Bunk bunk){
        //调用BunkService实现添加Bunk
        bunkService.add(bunk);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Bunk数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Bunk根据ID查询",notes = "根据ID查询Bunk方法详情",tags = {"BunkController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Bunk> findById(@PathVariable Integer id){
        //调用BunkService实现根据主键查询Bunk
        Bunk bunk = bunkService.findById(id);
        return new Result<Bunk>(true,StatusCode.OK,"查询成功",bunk);
    }

    /***
     * 查询Bunk全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Bunk",notes = "查询所Bunk有方法详情",tags = {"BunkController"})
    @GetMapping
    public Result<List<Bunk>> findAll(){
        //调用BunkService实现查询所有Bunk
        List<Bunk> list = bunkService.findAll();
        return new Result<List<Bunk>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
