package cn.bdqn.controller;

import cn.bdqn.domain.Doctor;
import cn.bdqn.service.DoctorService;
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
@Api(value = "DoctorController")
@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    /***
     * Doctor分页条件搜索实现
     * @param doctor
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Doctor条件分页查询",notes = "分页条件查询Doctor方法详情",tags = {"DoctorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Doctor对象",value = "传入JSON数据",required = false) Doctor doctor, @PathVariable  int page, @PathVariable  int size){
        //调用DoctorService实现分页条件查询Doctor
        PageInfo<Doctor> pageInfo = doctorService.findPage(doctor, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Doctor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Doctor分页查询",notes = "分页查询Doctor方法详情",tags = {"DoctorController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用DoctorService实现分页查询Doctor
        PageInfo<Doctor> pageInfo = doctorService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param doctor
     * @return
     */
    @ApiOperation(value = "Doctor条件查询",notes = "条件查询Doctor方法详情",tags = {"DoctorController"})
    @PostMapping(value = "/search" )
    public Result<List<Doctor>> findList(@RequestBody(required = false) @ApiParam(name = "Doctor对象",value = "传入JSON数据",required = false) Doctor doctor){
        //调用DoctorService实现条件查询Doctor
        List<Doctor> list = doctorService.findList(doctor);
        return new Result<List<Doctor>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctor根据ID删除",notes = "根据ID删除Doctor方法详情",tags = {"DoctorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用DoctorService实现根据主键删除
        doctorService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Doctor数据
     * @param doctor
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctor根据ID修改",notes = "根据ID修改Doctor方法详情",tags = {"DoctorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Doctor对象",value = "传入JSON数据",required = false) Doctor doctor,@PathVariable Integer id){
        //设置主键值
        doctor.setID(id);
        //调用DoctorService实现修改Doctor
        doctorService.update(doctor);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Doctor数据
     * @param doctor
     * @return
     */
    @ApiOperation(value = "Doctor添加",notes = "添加Doctor方法详情",tags = {"DoctorController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Doctor对象",value = "传入JSON数据",required = true) Doctor doctor){
        //调用DoctorService实现添加Doctor
        doctorService.add(doctor);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Doctor数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Doctor根据ID查询",notes = "根据ID查询Doctor方法详情",tags = {"DoctorController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Doctor> findById(@PathVariable Integer id){
        //调用DoctorService实现根据主键查询Doctor
        Doctor doctor = doctorService.findById(id);
        return new Result<Doctor>(true,StatusCode.OK,"查询成功",doctor);
    }

    /***
     * 查询Doctor全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Doctor",notes = "查询所Doctor有方法详情",tags = {"DoctorController"})
    @GetMapping
    public Result<List<Doctor>> findAll(){
        //调用DoctorService实现查询所有Doctor
        List<Doctor> list = doctorService.findAll();
        return new Result<List<Doctor>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
