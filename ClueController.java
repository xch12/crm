package com.ctgu.crm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ctgu.crm.entity.ClueEntity;
import com.ctgu.crm.service.clueService;
import com.ctgu.crm.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/clue")
class clueController {

    @Resource
    clueService clueService;

    @PostMapping("/append")
    public R AddOneclue(@RequestBody ClueEntity clueEntity)
    {
        System.out.println((clueEntity));
        clueService.save(clueEntity);
        return R.ok().put("clueEntity",clueEntity);
    }

    @DeleteMapping("/delete/{id}")
    public R DeleteOneclueById(@PathVariable int id)
    {
        System.out.println(id);
        clueService.removeById(id);
        return R.ok();
    }

    @PutMapping("/update")
    public R UpdateOneclueById(@RequestBody ClueEntity clueEntity)
    {
        System.out.println(clueEntity);
        clueService.update(clueEntity,new QueryWrapper<ClueEntity>().eq("id",clueEntity.getId()));
        return R.ok();
    }


    @GetMapping("/list")
    public  R GetclueList(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String  search)
    {
        Page<ClueEntity> cluePage =  clueService.page(new Page<>(pageNum,pageSize), Wrappers.<ClueEntity>lambdaQuery().like(ClueEntity::getChance_src,search));
        return R.ok().put("cluePage",cluePage);
    }


}
