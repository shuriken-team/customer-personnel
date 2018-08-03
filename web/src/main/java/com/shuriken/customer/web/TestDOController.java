package com.shuriken.customer.web;
import com.shuriken.customer.core.Result;
import com.shuriken.customer.dal.model.TestDO;
import com.shuriken.customer.dal.service.TestDOService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/08/03.
*/
@RestController
@RequestMapping("/test/d/o")
@Slf4j
public class TestDOController {
    public TestDOController(){log.info("已加载[{}]", this.getClass().getSimpleName());}
    @Resource
    private TestDOService testDOService;

    @PostMapping("/add")
    public Result add(TestDO testDO) {
        testDOService.save(testDO);
        return Result.createSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        testDOService.deleteById(id);
        return Result.createSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TestDO testDO) {
        testDOService.update(testDO);
        return Result.createSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TestDO testDO = testDOService.findById(id);
        return Result.createSuccessResult(testDO);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TestDO> list = testDOService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return Result.createSuccessResult(pageInfo);
    }
}
