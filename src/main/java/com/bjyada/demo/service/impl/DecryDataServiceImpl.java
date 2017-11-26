package com.bjyada.demo.service.impl;

import com.bjyada.demo.dao.DectypeDataDao;
import com.bjyada.demo.entity.DecryData;
import com.bjyada.demo.service.DecryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */
@Service
public class DecryDataServiceImpl implements DecryDataService{
    @Autowired
    DectypeDataDao dectypeDataDao;

    public void save(DecryData decryData) {
        dectypeDataDao.saveAndFlush(decryData);
    }

    public void delete(Integer id) {
        dectypeDataDao.delete(id);
    }

    public Page<DecryData> findAll(int pageNo, int pageSize) {
        PageRequest pageable=new PageRequest(pageNo,pageSize);
        return  dectypeDataDao.findAll(pageable);
    }

    public DecryData findByID(Integer id) {
        return dectypeDataDao.findOne(id);
    }

    public List<DecryData> findAll() {
        return dectypeDataDao.findAll();
    }
}
