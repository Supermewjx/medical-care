package cn.bdqn.controller;

import cn.bdqn.domain.Storage;
import cn.bdqn.service.StorageService;
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
@Api(value = "StorageController")
@RestController
@RequestMapping("/storage")
@CrossOrigin
public class StorageController {

    @Autowired
    private StorageService storageService;

    /***
     * Storage分页条件搜索实现
     * @param storage
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Storage条件分页查询",notes = "分页条件查询Storage方法详情",tags = {"StorageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Storage对象",value = "传入JSON数据",required = false) Storage storage, @PathVariable  int page, @PathVariable  int size){
        //调用StorageService实现分页条件查询Storage
        PageInfo<Storage> pageInfo = storageService.findPage(storage, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Storage分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Storage分页查询",notes = "分页查询Storage方法详情",tags = {"StorageController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用StorageService实现分页查询Storage
        PageInfo<Storage> pageInfo = storageService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param storage
     * @return
     */
    @ApiOperation(value = "Storage条件查询",notes = "条件查询Storage方法详情",tags = {"StorageController"})
    @PostMapping(value = "/search" )
    public Result<List<Storage>> findList(@RequestBody(required = false) @ApiParam(name = "Storage对象",value = "传入JSON数据",required = false) Storage storage){
        //调用StorageService实现条件查询Storage
        List<Storage> list = storageService.findList(storage);
        return new Result<List<Storage>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Storage根据ID删除",notes = "根据ID删除Storage方法详情",tags = {"StorageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用StorageService实现根据主键删除
        storageService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Storage数据
     * @param storage
     * @param id
     * @return
     */
    @ApiOperation(value = "Storage根据ID修改",notes = "根据ID修改Storage方法详情",tags = {"StorageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Storage对象",value = "传入JSON数据",required = false) Storage storage,@PathVariable Integer id){
        //设置主键值
        storage.setID(id);
        //调用StorageService实现修改Storage
        storageService.update(storage);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Storage数据
     * @param storage
     * @return
     */
    @ApiOperation(value = "Storage添加",notes = "添加Storage方法详情",tags = {"StorageController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Storage对象",value = "传入JSON数据",required = true) Storage storage){
        //调用StorageService实现添加Storage
        storageService.add(storage);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Storage数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Storage根据ID查询",notes = "根据ID查询Storage方法详情",tags = {"StorageController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Storage> findById(@PathVariable Integer id){
        //调用StorageService实现根据主键查询Storage
        Storage storage = storageService.findById(id);
        return new Result<Storage>(true,StatusCode.OK,"查询成功",storage);
    }

    /***
     * 查询Storage全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Storage",notes = "查询所Storage有方法详情",tags = {"StorageController"})
    @GetMapping
    public Result<List<Storage>> findAll(){
        //调用StorageService实现查询所有Storage
        List<Storage> list = storageService.findAll();
        return new Result<List<Storage>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
