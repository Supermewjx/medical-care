package cn.bdqn.controller;

import cn.bdqn.domain.Hospitalized;
import cn.bdqn.service.HospitalizedService;
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
@Api(value = "HospitalizedController")
@RestController
@RequestMapping("/hospitalized")
@CrossOrigin
public class HospitalizedController {

    @Autowired
    private HospitalizedService hospitalizedService;

    /***
     * Hospitalized分页条件搜索实现
     * @param hospitalized
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Hospitalized条件分页查询",notes = "分页条件查询Hospitalized方法详情",tags = {"HospitalizedController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Hospitalized对象",value = "传入JSON数据",required = false) Hospitalized hospitalized, @PathVariable  int page, @PathVariable  int size){
        //调用HospitalizedService实现分页条件查询Hospitalized
        PageInfo<Hospitalized> pageInfo = hospitalizedService.findPage(hospitalized, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Hospitalized分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Hospitalized分页查询",notes = "分页查询Hospitalized方法详情",tags = {"HospitalizedController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用HospitalizedService实现分页查询Hospitalized
        PageInfo<Hospitalized> pageInfo = hospitalizedService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param hospitalized
     * @return
     */
    @ApiOperation(value = "Hospitalized条件查询",notes = "条件查询Hospitalized方法详情",tags = {"HospitalizedController"})
    @PostMapping(value = "/search" )
    public Result<List<Hospitalized>> findList(@RequestBody(required = false) @ApiParam(name = "Hospitalized对象",value = "传入JSON数据",required = false) Hospitalized hospitalized){
        //调用HospitalizedService实现条件查询Hospitalized
        List<Hospitalized> list = hospitalizedService.findList(hospitalized);
        return new Result<List<Hospitalized>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Hospitalized根据ID删除",notes = "根据ID删除Hospitalized方法详情",tags = {"HospitalizedController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用HospitalizedService实现根据主键删除
        hospitalizedService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Hospitalized数据
     * @param hospitalized
     * @param id
     * @return
     */
    @ApiOperation(value = "Hospitalized根据ID修改",notes = "根据ID修改Hospitalized方法详情",tags = {"HospitalizedController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Hospitalized对象",value = "传入JSON数据",required = false) Hospitalized hospitalized,@PathVariable Integer id){
        //设置主键值
        hospitalized.setID(id);
        //调用HospitalizedService实现修改Hospitalized
        hospitalizedService.update(hospitalized);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Hospitalized数据
     * @param hospitalized
     * @return
     */
    @ApiOperation(value = "Hospitalized添加",notes = "添加Hospitalized方法详情",tags = {"HospitalizedController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Hospitalized对象",value = "传入JSON数据",required = true) Hospitalized hospitalized){
        //调用HospitalizedService实现添加Hospitalized
        hospitalizedService.add(hospitalized);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Hospitalized数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Hospitalized根据ID查询",notes = "根据ID查询Hospitalized方法详情",tags = {"HospitalizedController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Hospitalized> findById(@PathVariable Integer id){
        //调用HospitalizedService实现根据主键查询Hospitalized
        Hospitalized hospitalized = hospitalizedService.findById(id);
        return new Result<Hospitalized>(true,StatusCode.OK,"查询成功",hospitalized);
    }

    /***
     * 查询Hospitalized全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Hospitalized",notes = "查询所Hospitalized有方法详情",tags = {"HospitalizedController"})
    @GetMapping
    public Result<List<Hospitalized>> findAll(){
        //调用HospitalizedService实现查询所有Hospitalized
        List<Hospitalized> list = hospitalizedService.findAll();
        return new Result<List<Hospitalized>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
