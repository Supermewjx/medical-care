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
@RequestMapping("/dept")
public interface DeptFeign {

    /***
     * Dept分页条件搜索实现
     * @param dept
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Dept dept, @PathVariable int page, @PathVariable int size);

    /***
     * Dept分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param dept
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Dept>> findList(@RequestBody(required = false) Dept dept);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Dept数据
     * @param dept
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Dept dept, @PathVariable Integer id);

    /***
     * 新增Dept数据
     * @param dept
     * @return
     */
    @PostMapping
    Result add(@RequestBody Dept dept);

    /***
     * 根据ID查询Dept数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Dept> findById(@PathVariable Integer id);

    /***
     * 查询Dept全部数据
     * @return
     */
    @GetMapping
    Result<List<Dept>> findAll();
}