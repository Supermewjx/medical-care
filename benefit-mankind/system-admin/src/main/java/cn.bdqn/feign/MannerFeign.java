package cn.bdqn.feign;

import cn.bdqn.domain.Manner;
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
@RequestMapping("/manner")
public interface MannerFeign {

    /***
     * Manner分页条件搜索实现
     * @param manner
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Manner manner, @PathVariable int page, @PathVariable int size);

    /***
     * Manner分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param manner
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Manner>> findList(@RequestBody(required = false) Manner manner);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Manner数据
     * @param manner
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Manner manner, @PathVariable Integer id);

    /***
     * 新增Manner数据
     * @param manner
     * @return
     */
    @PostMapping
    Result add(@RequestBody Manner manner);

    /***
     * 根据ID查询Manner数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Manner> findById(@PathVariable Integer id);

    /***
     * 查询Manner全部数据
     * @return
     */
    @GetMapping
    Result<List<Manner>> findAll();
}