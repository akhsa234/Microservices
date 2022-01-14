package com.bahar.externalService.setplus.service.impl;

import com.bahar.document.*;
import com.bahar.dto.DateDetailDTO;
import com.bahar.dto.FreewayTollsSummaryDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.externalService.setplus.service.SetplusFreewayTollsSummaryService;
import com.bahar.externalService.setplus.ws.TehranTollsSummaryServiceClient;
import com.bahar.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetplusFreewayTollsSummaryServiceImpl implements SetplusFreewayTollsSummaryService {



    TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient;
    DateDetailRepository myTehranTollsSummaryRepository;
    SetPlusResponseRepository setPlusResponseFreewayTollsRepository;
    FreewayTollsSummaryRepository myTehranDateDetailRepository;

    public SetplusFreewayTollsSummaryServiceImpl(TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient,
                                                 DateDetailRepository myTehranTollsSummaryRepository,
                                                 SetPlusResponseRepository setPlusResponseFreewayTollsRepository,
                                                 FreewayTollsSummaryRepository myTehranDateDetailRepository) {
        this.tehranTollsSummaryServiceClient = tehranTollsSummaryServiceClient;
        this.myTehranTollsSummaryRepository = myTehranTollsSummaryRepository;
        this.setPlusResponseFreewayTollsRepository = setPlusResponseFreewayTollsRepository;
        this.myTehranDateDetailRepository = myTehranDateDetailRepository;
    }


    private final DateDetail dateDetail = new DateDetail(); //TODO ??
    private final DateDetailDTO dateDetailDTO = new DateDetailDTO();

    private final SetPlusResponse setPlusResponseFreewayTolls = new SetPlusResponse();
    private final SetPlusResponseDTO setPlusResponseFreewayTollsDTO = new SetPlusResponseDTO();

    private final FreewayTollsSummary freewayTollsSummary = new FreewayTollsSummary();
    private final FreewayTollsSummaryDTO freewayTollsSummaryDTO = new FreewayTollsSummaryDTO();

    @Override
    public SetPlusResponseDTO<FreewayTollsSummaryDTO> freewayTollsSummary(
            String jwt,
            String traceNumber,
            String deviceId,
            int plateNo) {

        // populate SetPlusResponse
        setPlusResponseFreewayTolls.setActionCode(setPlusResponseFreewayTollsDTO.getActionCode());
        setPlusResponseFreewayTolls.setActionMessage(setPlusResponseFreewayTollsDTO.getActionMessage());
        setPlusResponseFreewayTolls.setErrorMessages(setPlusResponseFreewayTollsDTO.getErrorMessages());
        setPlusResponseFreewayTolls.setReferenceNumber(setPlusResponseFreewayTollsDTO.getReferenceNumber());
        setPlusResponseFreewayTolls.setTraceNumber(setPlusResponseFreewayTollsDTO.getTraceNumber());
        setPlusResponseFreewayTolls.setData(setPlusResponseFreewayTollsDTO.getData());


        //populate FreewayTollsSummary
        freewayTollsSummary.setPlateNo(freewayTollsSummaryDTO.getPlateNo());
        freewayTollsSummary.setEnquiryId(freewayTollsSummaryDTO.getEnquiryId());
        freewayTollsSummary.setTotalAmount(freewayTollsSummaryDTO.getTotalAmount());


        //populate List<DateDetail> details



        //populate DateDetail


        //save to db
        setPlusResponseFreewayTollsRepository.save(setPlusResponseFreewayTolls);

        return null;
    }
}
