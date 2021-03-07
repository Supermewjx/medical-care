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
@RequestMapping("/bunk")
public interface BunkFeign {

    /***
     * Bunk分页条件搜索实现
     * @param bunk
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Bunk bunk, @PathVariable int page, @PathVariable int size);

    /***
     * Bunk分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param bunk
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Bunk>> findList(@RequestBody(required = false) Bunk bunk);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Bunk数据
     * @param bunk
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Bunk bunk, @PathVariable Integer id);

    /***
     * 新增Bunk数据
     * @param bunk
     * @return
     */
    @PostMapping
    Result add(@RequestBody Bunk bunk);

    /***
     * 根据ID查询Bunk数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Bunk> findById(@PathVariable Integer id);

    /***
     * 查询Bunk全部数据
     * @return
     */
    @GetMapping
    Result<List<Bunk>> findAll();
}