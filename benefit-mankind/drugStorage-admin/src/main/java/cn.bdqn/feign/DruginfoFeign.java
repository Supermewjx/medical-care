package cn.bdqn.feign;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="user")
@RequestMapping("/druginfo")
public interface DruginfoFeign {

    /***
     * Druginfo分页条件搜索实现
     * @param druginfo
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Druginfo druginfo, @PathVariable int page, @PathVariable int size);

    /***
     * Druginfo分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param druginfo
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Druginfo>> findList(@RequestBody(required = false) Druginfo druginfo);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Druginfo数据
     * @param druginfo
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Druginfo druginfo, @PathVariable Integer id);

    /***
     * 新增Druginfo数据
     * @param druginfo
     * @return
     */
    @PostMapping
    Result add(@RequestBody Druginfo druginfo);

    /***
     * 根据ID查询Druginfo数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Druginfo> findById(@PathVariable Integer id);

    /***
     * 查询Druginfo全部数据
     * @return
     */
    @GetMapping
    Result<List<Druginfo>> findAll();
}