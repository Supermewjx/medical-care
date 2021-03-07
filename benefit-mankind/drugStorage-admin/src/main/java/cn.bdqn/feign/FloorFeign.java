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
@RequestMapping("/floor")
public interface FloorFeign {

    /***
     * Floor分页条件搜索实现
     * @param floor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Floor floor, @PathVariable int page, @PathVariable int size);

    /***
     * Floor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param floor
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Floor>> findList(@RequestBody(required = false) Floor floor);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Floor数据
     * @param floor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Floor floor, @PathVariable Integer id);

    /***
     * 新增Floor数据
     * @param floor
     * @return
     */
    @PostMapping
    Result add(@RequestBody Floor floor);

    /***
     * 根据ID查询Floor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Floor> findById(@PathVariable Integer id);

    /***
     * 查询Floor全部数据
     * @return
     */
    @GetMapping
    Result<List<Floor>> findAll();
}