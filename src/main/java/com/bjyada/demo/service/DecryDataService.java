package com.bjyada.demo.service;

import com.bjyada.demo.dao.DectypeDataDao;
import com.bjyada.demo.entity.DecryData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18.
 */

public interface DecryDataService {
    public void save(DecryData decryData);
    public void delete(Integer id);
    public DecryData findByID(Integer id);
    public List<DecryData>  findAll();
    public Page<DecryData> findAll(int pageNo, int pageSize);
}
