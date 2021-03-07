package cn.bdqn.controller;

import cn.bdqn.domain.Floor;
import cn.bdqn.service.FloorService;
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
@Api(value = "FloorController")
@RestController
@RequestMapping("/floor")
@CrossOrigin
public class FloorController {

    @Autowired
    private FloorService floorService;

    /***
     * Floor分页条件搜索实现
     * @param floor
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Floor条件分页查询",notes = "分页条件查询Floor方法详情",tags = {"FloorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Floor对象",value = "传入JSON数据",required = false) Floor floor, @PathVariable  int page, @PathVariable  int size){
        //调用FloorService实现分页条件查询Floor
        PageInfo<Floor> pageInfo = floorService.findPage(floor, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Floor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Floor分页查询",notes = "分页查询Floor方法详情",tags = {"FloorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FloorService实现分页查询Floor
        PageInfo<Floor> pageInfo = floorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param floor
     * @return
     */
    @ApiOperation(value = "Floor条件查询",notes = "条件查询Floor方法详情",tags = {"FloorController"})
    @PostMapping(value = "/search" )
    public Result<List<Floor>> findList(@RequestBody(required = false) @ApiParam(name = "Floor对象",value = "传入JSON数据",required = false) Floor floor){
        //调用FloorService实现条件查询Floor
        List<Floor> list = floorService.findList(floor);
        return new Result<List<Floor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Floor根据ID删除",notes = "根据ID删除Floor方法详情",tags = {"FloorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FloorService实现根据主键删除
        floorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Floor数据
     * @param floor
     * @param id
     * @return
     */
    @ApiOperation(value = "Floor根据ID修改",notes = "根据ID修改Floor方法详情",tags = {"FloorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Floor对象",value = "传入JSON数据",required = false) Floor floor,@PathVariable Integer id){
        //设置主键值
        floor.setID(id);
        //调用FloorService实现修改Floor
        floorService.update(floor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Floor数据
     * @param floor
     * @return
     */
    @ApiOperation(value = "Floor添加",notes = "添加Floor方法详情",tags = {"FloorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Floor对象",value = "传入JSON数据",required = true) Floor floor){
        //调用FloorService实现添加Floor
        floorService.add(floor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Floor数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Floor根据ID查询",notes = "根据ID查询Floor方法详情",tags = {"FloorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Floor> findById(@PathVariable Integer id){
        //调用FloorService实现根据主键查询Floor
        Floor floor = floorService.findById(id);
        return new Result<Floor>(true,StatusCode.OK,"查询成功",floor);
    }

    /***
     * 查询Floor全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Floor",notes = "查询所Floor有方法详情",tags = {"FloorController"})
    @GetMapping
    public Result<List<Floor>> findAll(){
        //调用FloorService实现查询所有Floor
        List<Floor> list = floorService.findAll();
        return new Result<List<Floor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
