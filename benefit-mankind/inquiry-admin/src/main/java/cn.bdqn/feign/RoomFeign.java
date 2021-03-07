package cn.bdqn.feign;

import cn.bdqn.domain.Room;
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
@RequestMapping("/room")
public interface RoomFeign {

    /***
     * Room分页条件搜索实现
     * @param room
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) Room room, @PathVariable int page, @PathVariable int size);

    /***
     * Room分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size);

    /***
     * 多条件搜索品牌数据
     * @param room
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<Room>> findList(@RequestBody(required = false) Room room);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改Room数据
     * @param room
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody Room room, @PathVariable Integer id);

    /***
     * 新增Room数据
     * @param room
     * @return
     */
    @PostMapping
    Result add(@RequestBody Room room);

    /***
     * 根据ID查询Room数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Room> findById(@PathVariable Integer id);

    /***
     * 查询Room全部数据
     * @return
     */
    @GetMapping
    Result<List<Room>> findAll();
}