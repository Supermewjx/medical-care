package cn.bdqn.feign;

import cn.bdqn.domain.Hospitalized;
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
@RequestMapping("/hospitalized")
public interface HospitalizedFeign {

    /***
     * Hospitalized分页条件搜索实现
     * @param hospitalized
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Hospitalized hospitalized, @PathVariable int page, @PathVariable int size);

    /***
     * Hospitalized分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param hospitalized
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Hospitalized>> findList(@RequestBody(required = false) Hospitalized hospitalized);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Hospitalized数据
     * @param hospitalized
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Hospitalized hospitalized, @PathVariable Integer id);

    /***
     * 新增Hospitalized数据
     * @param hospitalized
     * @return
     */
    @PostMapping
    Result add(@RequestBody Hospitalized hospitalized);

    /***
     * 根据ID查询Hospitalized数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Hospitalized> findById(@PathVariable Integer id);

    /***
     * 查询Hospitalized全部数据
     * @return
     */
    @GetMapping
    Result<List<Hospitalized>> findAll();
}