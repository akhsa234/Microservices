package com.bahar.externalService.setplus.service.impl;

import com.bahar.dto.AirPollutionDetailsDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.externalService.setplus.ws.TehranTollsSummaryServiceClient;
import com.bahar.document.*;
import com.bahar.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SetplusAirPollutionRemainDaysImpl {
    @Autowired
    TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient;
    AirPollutionSeasonDataRepository airPollutionSeasonDataRepository;
    SetPlusResponseRepository setPlusResponseRepository;
    AirPollutionDetailsRepository airPollutionDetailsRepository;

    private AirPollutionSeasonData airPollutionSeasonData = new AirPollutionSeasonData();
    private AirPollutionDetails airPollutionDetails = new AirPollutionDetails();
    private SetPlusResponse setPlusResponseAirPollution = new SetPlusResponse();
    private AirPollutionDetailsDTO airPollutionDetailsDTO = new AirPollutionDetailsDTO();
    private SetPlusResponseDTO setPlusResponseAirPollutionDto = new SetPlusResponseDTO();


    public SetPlusResponseDTO<AirPollutionDetailsDTO> airPollutionRemainDays(@RequestHeader("Authorization") String jwt,
                                                                             @RequestHeader("traceNumber") String traceNumber,
                                                                             @RequestHeader("deviceId") String deviceId,
                                                                             @RequestParam("PlateNo") int plateNo){


        // populate SetPlusResponse
        setPlusResponseAirPollution.setActionCode(setPlusResponseAirPollutionDto.getActionCode());
        setPlusResponseAirPollution.setActionMessage(setPlusResponseAirPollutionDto.getActionMessage());
        setPlusResponseAirPollution.setErrorMessages(setPlusResponseAirPollutionDto.getErrorMessages());
        setPlusResponseAirPollution.setReferenceNumber(setPlusResponseAirPollutionDto.getReferenceNumber());
        setPlusResponseAirPollution.setTraceNumber(setPlusResponseAirPollutionDto.getTraceNumber());
        setPlusResponseAirPollution.setData(setPlusResponseAirPollutionDto.getData());


        //populate AirPollutionDetails
        airPollutionDetails.setPlateNo(airPollutionDetails.getPlateNo());
        airPollutionDetails.setSeasons(airPollutionDetails.getSeasons());


        //populate AirPollutionSeasonData




        // add to db
        airPollutionDetailsRepository.save(airPollutionDetails);
        setPlusResponseRepository.save(setPlusResponseAirPollution);
        airPollutionSeasonDataRepository.save(airPollutionSeasonData);

        return null;
    }



}
