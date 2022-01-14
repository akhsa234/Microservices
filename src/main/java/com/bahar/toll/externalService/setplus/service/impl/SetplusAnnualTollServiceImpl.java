package com.bahar.externalService.setplus.service.impl;

import com.bahar.dto.AnnualTollResponseDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.externalService.setplus.ws.TehranTollsSummaryServiceClient;
import com.bahar.document.AnnualTollDetail;
import com.bahar.document.AnnualTollResponse;
import com.bahar.document.SetPlusResponse;
import com.bahar.repo.AnnualTollDetailRepository;
import com.bahar.repo.AnnualTollResponseRepository;
import com.bahar.repo.SetPlusResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SetplusAnnualTollServiceImpl {

    @Autowired
    TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient;
    AnnualTollResponseRepository annualTollResponseRepository;
    SetPlusResponseRepository setPlusResponseAnnualTollRepository;
    AnnualTollDetailRepository annualTollDetailRepository;


    private final AnnualTollResponse annualTollResponse = new AnnualTollResponse();
    private final SetPlusResponse setPlusResponseAnnualToll = new SetPlusResponse();
    private final AnnualTollDetail annualTollDetail = new AnnualTollDetail();
    private final SetPlusResponseDTO setPlusResponseAnnualTollDTO = new SetPlusResponseDTO();
    private final AnnualTollResponseDTO annualTollResponseDTO=new AnnualTollResponseDTO();


    public SetPlusResponseDTO<AnnualTollResponseDTO> annualToll(@RequestHeader("Authorization") String jwt,
                                                                @RequestHeader("traceNumber") String traceNumber,
                                                                @RequestHeader("deviceId") String deviceId,
                                                                @RequestParam("PlateNo") int plateNo,
                                                                @RequestParam("VIN") String vin,
                                                                @RequestParam("NationalCode") String nationalCode) {


        // populate SetPlusResponse
        setPlusResponseAnnualToll.setActionCode(setPlusResponseAnnualTollDTO.getActionCode());
        setPlusResponseAnnualToll.setActionMessage(setPlusResponseAnnualTollDTO.getActionMessage());
        setPlusResponseAnnualToll.setErrorMessages(setPlusResponseAnnualTollDTO.getErrorMessages());
        setPlusResponseAnnualToll.setReferenceNumber(setPlusResponseAnnualTollDTO.getReferenceNumber());
        setPlusResponseAnnualToll.setTraceNumber(setPlusResponseAnnualTollDTO.getTraceNumber());
        setPlusResponseAnnualToll.setData(setPlusResponseAnnualTollDTO.getData());


        //populate AnnualTollResponse
        annualTollResponse.setPlateNo(annualTollResponseDTO.getPlateNo());
        annualTollResponse.setEnquiryId(annualTollResponseDTO.getEnquiryId());
        annualTollResponse.setTotalAmount(annualTollResponseDTO.getTotalAmount());
        annualTollResponse.setItems(annualTollResponseDTO.getItems());

        //populate AnnualTollDetail


        // add to db
        annualTollResponseRepository.save(annualTollResponse);
        setPlusResponseAnnualTollRepository.save(setPlusResponseAnnualToll);
        annualTollDetailRepository.save(annualTollDetail);

        return null;
    }


}
