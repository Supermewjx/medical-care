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
@RequestMapping("/storage")
public interface StorageFeign {

    /***
     * Storage分页条件搜索实现
     * @param storage
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Storage storage, @PathVariable int page, @PathVariable int size);

    /***
     * Storage分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param storage
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Storage>> findList(@RequestBody(required = false) Storage storage);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Storage数据
     * @param storage
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Storage storage, @PathVariable Integer id);

    /***
     * 新增Storage数据
     * @param storage
     * @return
     */
    @PostMapping
    Result add(@RequestBody Storage storage);

    /***
     * 根据ID查询Storage数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Storage> findById(@PathVariable Integer id);

    /***
     * 查询Storage全部数据
     * @return
     */
    @GetMapping
    Result<List<Storage>> findAll();
}