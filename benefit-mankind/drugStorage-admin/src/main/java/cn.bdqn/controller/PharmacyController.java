package cn.bdqn.controller;

import cn.bdqn.domain.Pharmacy;
import cn.bdqn.service.PharmacyService;
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
@Api(value = "PharmacyController")
@RestController
@RequestMapping("/pharmacy")
@CrossOrigin
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    /***
     * Pharmacy分页条件搜索实现
     * @param pharmacy
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Pharmacy条件分页查询",notes = "分页条件查询Pharmacy方法详情",tags = {"PharmacyController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Pharmacy对象",value = "传入JSON数据",required = false) Pharmacy pharmacy, @PathVariable  int page, @PathVariable  int size){
        //调用PharmacyService实现分页条件查询Pharmacy
        PageInfo<Pharmacy> pageInfo = pharmacyService.findPage(pharmacy, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Pharmacy分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Pharmacy分页查询",notes = "分页查询Pharmacy方法详情",tags = {"PharmacyController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用PharmacyService实现分页查询Pharmacy
        PageInfo<Pharmacy> pageInfo = pharmacyService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param pharmacy
     * @return
     */
    @ApiOperation(value = "Pharmacy条件查询",notes = "条件查询Pharmacy方法详情",tags = {"PharmacyController"})
    @PostMapping(value = "/search" )
    public Result<List<Pharmacy>> findList(@RequestBody(required = false) @ApiParam(name = "Pharmacy对象",value = "传入JSON数据",required = false) Pharmacy pharmacy){
        //调用PharmacyService实现条件查询Pharmacy
        List<Pharmacy> list = pharmacyService.findList(pharmacy);
        return new Result<List<Pharmacy>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Pharmacy根据ID删除",notes = "根据ID删除Pharmacy方法详情",tags = {"PharmacyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用PharmacyService实现根据主键删除
        pharmacyService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Pharmacy数据
     * @param pharmacy
     * @param id
     * @return
     */
    @ApiOperation(value = "Pharmacy根据ID修改",notes = "根据ID修改Pharmacy方法详情",tags = {"PharmacyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Pharmacy对象",value = "传入JSON数据",required = false) Pharmacy pharmacy,@PathVariable Integer id){
        //设置主键值
        pharmacy.setID(id);
        //调用PharmacyService实现修改Pharmacy
        pharmacyService.update(pharmacy);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Pharmacy数据
     * @param pharmacy
     * @return
     */
    @ApiOperation(value = "Pharmacy添加",notes = "添加Pharmacy方法详情",tags = {"PharmacyController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Pharmacy对象",value = "传入JSON数据",required = true) Pharmacy pharmacy){
        //调用PharmacyService实现添加Pharmacy
        pharmacyService.add(pharmacy);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Pharmacy数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Pharmacy根据ID查询",notes = "根据ID查询Pharmacy方法详情",tags = {"PharmacyController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Pharmacy> findById(@PathVariable Integer id){
        //调用PharmacyService实现根据主键查询Pharmacy
        Pharmacy pharmacy = pharmacyService.findById(id);
        return new Result<Pharmacy>(true,StatusCode.OK,"查询成功",pharmacy);
    }

    /***
     * 查询Pharmacy全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Pharmacy",notes = "查询所Pharmacy有方法详情",tags = {"PharmacyController"})
    @GetMapping
    public Result<List<Pharmacy>> findAll(){
        //调用PharmacyService实现查询所有Pharmacy
        List<Pharmacy> list = pharmacyService.findAll();
        return new Result<List<Pharmacy>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
