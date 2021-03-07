package cn.bdqn.controller;

import cn.bdqn.domain.Doctordiagnose;
import cn.bdqn.service.DoctordiagnoseService;
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
@Api(value = "DoctordiagnoseController")
@RestController
@RequestMapping("/doctordiagnose")
@CrossOrigin
public class DoctordiagnoseController {

    @Autowired
    private DoctordiagnoseService doctordiagnoseService;

    /***
     * Doctordiagnose分页条件搜索实现
     * @param doctordiagnose
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Doctordiagnose条件分页查询",notes = "分页条件查询Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Doctordiagnose对象",value = "传入JSON数据",required = false) Doctordiagnose doctordiagnose, @PathVariable  int page, @PathVariable  int size){
        //调用DoctordiagnoseService实现分页条件查询Doctordiagnose
        PageInfo<Doctordiagnose> pageInfo = doctordiagnoseService.findPage(doctordiagnose, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Doctordiagnose分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Doctordiagnose分页查询",notes = "分页查询Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DoctordiagnoseService实现分页查询Doctordiagnose
        PageInfo<Doctordiagnose> pageInfo = doctordiagnoseService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param doctordiagnose
     * @return
     */
    @ApiOperation(value = "Doctordiagnose条件查询",notes = "条件查询Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @PostMapping(value = "/search" )
    public Result<List<Doctordiagnose>> findList(@RequestBody(required = false) @ApiParam(name = "Doctordiagnose对象",value = "传入JSON数据",required = false) Doctordiagnose doctordiagnose){
        //调用DoctordiagnoseService实现条件查询Doctordiagnose
        List<Doctordiagnose> list = doctordiagnoseService.findList(doctordiagnose);
        return new Result<List<Doctordiagnose>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctordiagnose根据ID删除",notes = "根据ID删除Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DoctordiagnoseService实现根据主键删除
        doctordiagnoseService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Doctordiagnose数据
     * @param doctordiagnose
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctordiagnose根据ID修改",notes = "根据ID修改Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Doctordiagnose对象",value = "传入JSON数据",required = false) Doctordiagnose doctordiagnose,@PathVariable Integer id){
        //设置主键值
        doctordiagnose.setID(id);
        //调用DoctordiagnoseService实现修改Doctordiagnose
        doctordiagnoseService.update(doctordiagnose);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Doctordiagnose数据
     * @param doctordiagnose
     * @return
     */
    @ApiOperation(value = "Doctordiagnose添加",notes = "添加Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Doctordiagnose对象",value = "传入JSON数据",required = true) Doctordiagnose doctordiagnose){
        //调用DoctordiagnoseService实现添加Doctordiagnose
        doctordiagnoseService.add(doctordiagnose);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Doctordiagnose数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctordiagnose根据ID查询",notes = "根据ID查询Doctordiagnose方法详情",tags = {"DoctordiagnoseController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Doctordiagnose> findById(@PathVariable Integer id){
        //调用DoctordiagnoseService实现根据主键查询Doctordiagnose
        Doctordiagnose doctordiagnose = doctordiagnoseService.findById(id);
        return new Result<Doctordiagnose>(true,StatusCode.OK,"查询成功",doctordiagnose);
    }

    /***
     * 查询Doctordiagnose全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Doctordiagnose",notes = "查询所Doctordiagnose有方法详情",tags = {"DoctordiagnoseController"})
    @GetMapping
    public Result<List<Doctordiagnose>> findAll(){
        //调用DoctordiagnoseService实现查询所有Doctordiagnose
        List<Doctordiagnose> list = doctordiagnoseService.findAll();
        return new Result<List<Doctordiagnose>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
