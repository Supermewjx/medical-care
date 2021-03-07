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
@RequestMapping("/pharmacy")
public interface PharmacyFeign {

    /***
     * Pharmacy分页条件搜索实现
     * @param pharmacy
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Pharmacy pharmacy, @PathVariable int page, @PathVariable int size);

    /***
     * Pharmacy分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param pharmacy
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Pharmacy>> findList(@RequestBody(required = false) Pharmacy pharmacy);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Pharmacy数据
     * @param pharmacy
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Pharmacy pharmacy, @PathVariable Integer id);

    /***
     * 新增Pharmacy数据
     * @param pharmacy
     * @return
     */
    @PostMapping
    Result add(@RequestBody Pharmacy pharmacy);

    /***
     * 根据ID查询Pharmacy数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Pharmacy> findById(@PathVariable Integer id);

    /***
     * 查询Pharmacy全部数据
     * @return
     */
    @GetMapping
    Result<List<Pharmacy>> findAll();
}