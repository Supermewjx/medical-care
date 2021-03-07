package cn.bdqn.feign;

import cn.bdqn.domain.Registration;
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
@RequestMapping("/registration")
public interface RegistrationFeign {

    /***
     * Registration分页条件搜索实现
     * @param registration
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Registration registration, @PathVariable int page, @PathVariable int size);

    /***
     * Registration分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param registration
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Registration>> findList(@RequestBody(required = false) Registration registration);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Registration数据
     * @param registration
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Registration registration, @PathVariable Integer id);

    /***
     * 新增Registration数据
     * @param registration
     * @return
     */
    @PostMapping
    Result add(@RequestBody Registration registration);

    /***
     * 根据ID查询Registration数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Registration> findById(@PathVariable Integer id);

    /***
     * 查询Registration全部数据
     * @return
     */
    @GetMapping
    Result<List<Registration>> findAll();
}