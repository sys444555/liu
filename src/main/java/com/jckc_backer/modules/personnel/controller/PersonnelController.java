package com.jckc_backer.modules.personnel.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.personnel.entity.PersonnelEntity;
import com.jckc_backer.modules.personnel.service.PersonnelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Resource
    private PersonnelService personnelService;

    /**
     * 添加员工信息
     * @param shoopEntity
     * @return
     */
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    public ResponseUtil insertShoopEntity(PersonnelEntity shoopEntity){
        personnelService.insertShoop(shoopEntity);
        return ResponseUtil.success();
    }

    /**
     * 根据员工姓名查询
     * @param name
     * @return
     */
    @RequestMapping(value="/select",method= RequestMethod.POST)
    public ResponseUtil selectShoopEntity(String name){
        PersonnelEntity shoopEntity= personnelService.selectByName(name);
        return ResponseUtil.success(shoopEntity);
    }

    /**
     * 修改员工信息
     * @param shoopEntity
     * @return
     */
    @RequestMapping(value="/update",method=RequestMethod.POST)
    public ResponseUtil updateShoopEntity(PersonnelEntity shoopEntity){
        personnelService.updateShoop(shoopEntity);
        return ResponseUtil.success();
    }

    /**
     * 根据id删除员工信息
     * @param id
     * @return
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
    public ResponseUtil deleteById(@PathVariable Integer id){
        personnelService.deleteById(id);
        return ResponseUtil.success();
    }

    /**
     *分页查询
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseUtil shoopEntityList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        EntityWrapper<PersonnelEntity> wrapper = new EntityWrapper<PersonnelEntity>();
        List<PersonnelEntity> pageList =personnelService.getList(wrapper);
        PageInfo<PersonnelEntity> pageInfo=new PageInfo<>(pageList);
        return ResponseUtil.success(pageInfo);
    }
}
