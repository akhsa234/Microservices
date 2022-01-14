package com.bahar.externalService.setplus.service;

import com.bahar.dto.FreewayTollsSummaryDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public interface SetplusFreewayTollsSummaryService {
    SetPlusResponseDTO<FreewayTollsSummaryDTO> freewayTollsSummary(@RequestHeader("Authorization") String jwt,
                                                                   @RequestHeader("traceNumber") String traceNumber,
                                                                   @RequestHeader("deviceId") String deviceId,
                                                                   @RequestParam("PlateNo") int plateNo);



}
