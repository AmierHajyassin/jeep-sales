package com.promineotech.jeep.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.jeep.dao.JeepSlaesDao;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultJeepSaleService implements JeepsSalesService {

 @Autowired
 private JeepSlaesDao jeepSalesDao;
 @Transactional(readOnly = true)
  @Override
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
    log.info("These fetchJeeps method was called with model = {} and trim = {}",
        model, trim);

   List<Jeep> jeeps = jeepSalesDao.fetchJeeps(model, trim);
   
   if(jeeps.isEmpty()) {
     String msg = String.format("No jeeps found with model=%s and trim=%s",
         model, trim);
     
     throw new NoSuchElementException(msg);
   }
   
  
   return jeeps;
  }



}