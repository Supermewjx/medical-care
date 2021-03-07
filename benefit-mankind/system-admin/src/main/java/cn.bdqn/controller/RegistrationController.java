package cn.bdqn.controller;

import cn.bdqn.domain.Registration;
import cn.bdqn.service.RegistrationService;
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
@Api(value = "RegistrationController")
@RestController
@RequestMapping("/registration")
@CrossOrigin
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    /***
     * Registration分页条件搜索实现
     * @param registration
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Registration条件分页查询",notes = "分页条件查询Registration方法详情",tags = {"RegistrationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Registration对象",value = "传入JSON数据",required = false) Registration registration, @PathVariable  int page, @PathVariable  int size){
        //调用RegistrationService实现分页条件查询Registration
        PageInfo<Registration> pageInfo = registrationService.findPage(registration, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Registration分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Registration分页查询",notes = "分页查询Registration方法详情",tags = {"RegistrationController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RegistrationService实现分页查询Registration
        PageInfo<Registration> pageInfo = registrationService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param registration
     * @return
     */
    @ApiOperation(value = "Registration条件查询",notes = "条件查询Registration方法详情",tags = {"RegistrationController"})
    @PostMapping(value = "/search" )
    public Result<List<Registration>> findList(@RequestBody(required = false) @ApiParam(name = "Registration对象",value = "传入JSON数据",required = false) Registration registration){
        //调用RegistrationService实现条件查询Registration
        List<Registration> list = registrationService.findList(registration);
        return new Result<List<Registration>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Registration根据ID删除",notes = "根据ID删除Registration方法详情",tags = {"RegistrationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RegistrationService实现根据主键删除
        registrationService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Registration数据
     * @param registration
     * @param id
     * @return
     */
    @ApiOperation(value = "Registration根据ID修改",notes = "根据ID修改Registration方法详情",tags = {"RegistrationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Registration对象",value = "传入JSON数据",required = false) Registration registration,@PathVariable Integer id){
        //设置主键值
        registration.setID(id);
        //调用RegistrationService实现修改Registration
        registrationService.update(registration);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Registration数据
     * @param registration
     * @return
     */
    @ApiOperation(value = "Registration添加",notes = "添加Registration方法详情",tags = {"RegistrationController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Registration对象",value = "传入JSON数据",required = true) Registration registration){
        //调用RegistrationService实现添加Registration
        registrationService.add(registration);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Registration数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Registration根据ID查询",notes = "根据ID查询Registration方法详情",tags = {"RegistrationController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Registration> findById(@PathVariable Integer id){
        //调用RegistrationService实现根据主键查询Registration
        Registration registration = registrationService.findById(id);
        return new Result<Registration>(true,StatusCode.OK,"查询成功",registration);
    }

    /***
     * 查询Registration全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Registration",notes = "查询所Registration有方法详情",tags = {"RegistrationController"})
    @GetMapping
    public Result<List<Registration>> findAll(){
        //调用RegistrationService实现查询所有Registration
        List<Registration> list = registrationService.findAll();
        return new Result<List<Registration>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
