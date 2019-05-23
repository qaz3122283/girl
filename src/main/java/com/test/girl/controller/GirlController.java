package com.test.girl.controller;

import com.test.girl.bean.Girl;
import com.test.girl.repository.GirlRepository;
import com.test.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取所有信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList() {
        return girlService.getGirlList();
    }

    /**
     * 添加信息
     * @param girl
     * @return
     */

    @PostMapping(value = "/girls")
    public Girl getGirl(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    /**
     * 查找某个信息
     * @param id
     * @return
     */

    @GetMapping(value = "/girls/{id}")
    public Girl getGirls(@PathVariable(value = "id") Integer id) {
//        girlRepository.findById(id)
        System.out.println(girlRepository.findById(id).orElse(null));
        return girlRepository.findById(id).orElse(null);
    }
}
