package com.bahar.externalService.setplus.service;

import com.bahar.dto.MyTehranTollsSummaryDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public interface SetplusTehranTollsSummaryService  {
    SetPlusResponseDTO<MyTehranTollsSummaryDTO> tehranTollsSummary(@RequestHeader("Authorization") String jwt,
                                                                   @RequestHeader("traceNumber") String traceNumber,
                                                                   @RequestHeader("deviceId") String deviceId,
                                                                   @RequestParam("PlateNo") int plateNo);


}
