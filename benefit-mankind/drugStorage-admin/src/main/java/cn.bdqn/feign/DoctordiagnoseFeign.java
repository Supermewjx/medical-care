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
@RequestMapping("/doctordiagnose")
public interface DoctordiagnoseFeign {

    /***
     * Doctordiagnose分页条件搜索实现
     * @param doctordiagnose
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Doctordiagnose doctordiagnose, @PathVariable int page, @PathVariable int size);

    /***
     * Doctordiagnose分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param doctordiagnose
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Doctordiagnose>> findList(@RequestBody(required = false) Doctordiagnose doctordiagnose);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Doctordiagnose数据
     * @param doctordiagnose
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Doctordiagnose doctordiagnose, @PathVariable Integer id);

    /***
     * 新增Doctordiagnose数据
     * @param doctordiagnose
     * @return
     */
    @PostMapping
    Result add(@RequestBody Doctordiagnose doctordiagnose);

    /***
     * 根据ID查询Doctordiagnose数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Doctordiagnose> findById(@PathVariable Integer id);

    /***
     * 查询Doctordiagnose全部数据
     * @return
     */
    @GetMapping
    Result<List<Doctordiagnose>> findAll();
}