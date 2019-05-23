package com.test.girl.service.impl;

import com.test.girl.bean.Girl;
import com.test.girl.repository.GirlRepository;
import com.test.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Override
    @Transactional
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }
}
