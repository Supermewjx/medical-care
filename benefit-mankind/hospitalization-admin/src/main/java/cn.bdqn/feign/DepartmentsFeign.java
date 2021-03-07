package cn.bdqn.feign;

import cn.bdqn.domain.Departments;
import cn.bdqn.utils.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/departments")
public interface DepartmentsFeign {

    /***
     * Departments分页条件搜索实现
     * @param departments
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Departments departments, @PathVariable int page, @PathVariable int size);

    /***
     * Departments分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param departments
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Departments>> findList(@RequestBody(required = false) Departments departments);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Departments数据
     * @param departments
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Departments departments, @PathVariable Integer id);

    /***
     * 新增Departments数据
     * @param departments
     * @return
     */
    @PostMapping
    Result add(@RequestBody Departments departments);

    /***
     * 根据ID查询Departments数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Departments> findById(@PathVariable Integer id);

    /***
     * 查询Departments全部数据
     * @return
     */
    @GetMapping
    Result<List<Departments>> findAll();
}