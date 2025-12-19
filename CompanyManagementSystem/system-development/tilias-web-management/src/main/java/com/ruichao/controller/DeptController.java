package com.ruichao.controller;

import com.ruichao.pojo.Dept;
import com.ruichao.pojo.Result;
import com.ruichao.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门数据
     * @return
     */
    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/depts")
    public Result delete(Integer id){
        System.out.println("删除部门" + id);
        deptService.deleteById(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门" + dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门信息
     * @param id
     * @return
     */
    @GetMapping("/depts/{id}")
    public Result getinfo(@PathVariable Integer id){
        System.out.println("根据ID查询部门" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门信息
     * @param dept
     * @return
     */
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        System.out.println("修改部门" + dept);
        deptService.update(dept);
        return Result.success();
    }
}
