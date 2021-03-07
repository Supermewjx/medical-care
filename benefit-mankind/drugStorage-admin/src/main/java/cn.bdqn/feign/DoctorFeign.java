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
@RequestMapping("/doctor")
public interface DoctorFeign {

    /***
     * Doctor分页条件搜索实现
     * @param doctor
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Doctor doctor, @PathVariable int page, @PathVariable int size);

    /***
     * Doctor分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param doctor
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Doctor>> findList(@RequestBody(required = false) Doctor doctor);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Doctor数据
     * @param doctor
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Doctor doctor, @PathVariable Integer id);

    /***
     * 新增Doctor数据
     * @param doctor
     * @return
     */
    @PostMapping
    Result add(@RequestBody Doctor doctor);

    /***
     * 根据ID查询Doctor数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Doctor> findById(@PathVariable Integer id);

    /***
     * 查询Doctor全部数据
     * @return
     */
    @GetMapping
    Result<List<Doctor>> findAll();
}