package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepsSalesService;
import com.promineotech.jeep.entity.JeepModel;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultJeepSalesController implements JeepSalesController {
  
  
  @Autowired
  private JeepsSalesService jeepSaleService; 
  
  @Override
  public List<Jeep> fetchJeeps(JeepModel model, String trim) {
    log.debug("model = {}, trim = {}", model, trim );
    return JeepsSalesService.fetchJeeps(model, trim);
  }


}
