package com.bahar.externalService.setplus.service.impl;

import com.bahar.dto.MyTehranDateDetailDTO;
import com.bahar.dto.MyTehranTollsSummaryDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.externalService.setplus.service.SetplusTehranTollsSummaryService;
import com.bahar.externalService.setplus.ws.TehranTollsSummaryServiceClient;
import com.bahar.document.MyTehranDateDetail;
import com.bahar.document.MyTehranTollsSummary;
import com.bahar.document.SetPlusResponse;
import com.bahar.repo.MyTehranDateDetailRepository;
import com.bahar.repo.MyTehranTollsSummaryRepository;
import com.bahar.repo.SetPlusResponseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SetplusTehranTollsSummaryServiceImpl  implements SetplusTehranTollsSummaryService {

    TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient;
    MyTehranTollsSummaryRepository myTehranTollsSummaryRepository;
    SetPlusResponseRepository setPlusResponseTehranTollsSummaryRepository;
    MyTehranDateDetailRepository myTehranDateDetailRepository;
    SetPlusResponseRepository setPlusResponseRepository;


    public SetplusTehranTollsSummaryServiceImpl(TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient,
                                                MyTehranTollsSummaryRepository myTehranTollsSummaryRepository,
                                                SetPlusResponseRepository setPlusResponseRepository,
                                                MyTehranDateDetailRepository myTehranDateDetailRepository) {

        this.tehranTollsSummaryServiceClient = tehranTollsSummaryServiceClient;
        this.myTehranTollsSummaryRepository = myTehranTollsSummaryRepository;
        this.setPlusResponseRepository = setPlusResponseRepository;
        this.myTehranDateDetailRepository = myTehranDateDetailRepository;
    }


    private final SetPlusResponse setPlusResponse = new SetPlusResponse();
    private final SetPlusResponseDTO setPlusResponseDTO = new SetPlusResponseDTO();

    private final MyTehranTollsSummary myTehranTollsSummary = new MyTehranTollsSummary();
    private final MyTehranTollsSummaryDTO myTehranTollsSummaryDTO = new MyTehranTollsSummaryDTO();

    private final MyTehranDateDetail myTehranDateDetail = new MyTehranDateDetail();
    private final MyTehranDateDetailDTO myTehranDateDetailDTO = new MyTehranDateDetailDTO();
    private final ModelMapper modelMapper= new ModelMapper();

    @Override
    public SetPlusResponseDTO<MyTehranTollsSummaryDTO> tehranTollsSummary(String jwt,
                                                                          String traceNumber,
                                                                          String deviceId,
                                                                          int plateNo) {

        // populate SetPlusResponse
        //version 2 use convertor dto -> model
        setPlusResponse.setActionCode(setPlusResponseDTO.getActionCode());
        setPlusResponse.setActionMessage(setPlusResponseDTO.getActionMessage());
        setPlusResponse.setErrorMessages(setPlusResponseDTO.getErrorMessages());
        setPlusResponse.setReferenceNumber(setPlusResponseDTO.getReferenceNumber());
        setPlusResponse.setTraceNumber(setPlusResponseDTO.getTraceNumber());
        setPlusResponse.setData(setPlusResponseDTO.getData());

        //modelMapper
        SetPlusResponse setPlusResponseTehranTollsSummary = modelMapper.map(SetPlusResponseDTO.class,
                                                                            SetPlusResponse.class);
        
        //populate MyTehranTollsSummary
        //version 2 use convertor dto -> model
        myTehranTollsSummary.setPlateNo(myTehranTollsSummaryDTO.getPlateNo());
        myTehranTollsSummary.setType(myTehranTollsSummaryDTO.getType());
        myTehranTollsSummary.setTotalAmount(myTehranTollsSummaryDTO.getTotalAmount());
        myTehranTollsSummary.setEnquiryId(myTehranTollsSummaryDTO.getEnquiryId());

        MyTehranTollsSummary myTehranTollsSummary= modelMapper.map(MyTehranTollsSummaryDTO.class,
                                                                    MyTehranTollsSummary.class);
        System.out.println(myTehranTollsSummary);
        // how to populate the list of  List<MyTehranDateDetail> ???

        List<MyTehranDateDetail> myTehranDateDetail = setPlusResponse.getData()
                .stream().map(item -> modelMapper.map(MyTehranTollsSummaryDTO.class, ItemDto.class)).collect(Collectors.toList());


        modelMapper.typeMap(MyTehranTollsSummaryDTO.class, MyTehranTollsSummary.class).addMappings(mapper -> {
            mapper.map(src -> src.getDetails(),
                    Destination::set);
            mapper.map(src -> src.getDetails(),
                    Destination::setBillingCity);
        });
        // how to set and get myTehranDateDetail ?????
        List<MyTehranDateDetailDTO> tempMyTehranDateDetailDTO = new ArrayList();
        tempMyTehranDateDetailDTO= myTehranTollsSummaryDTO.getDetails();
        // populate List<MyTehranDateDetailDTO> details
        tempMyTehranDateDetailDTO.stream().map(x-> {

            myTehranDateDetailDTO.setDate(x.getDate());
            myTehranDateDetailDTO.setAmount(x.getAmount());
            myTehranDateDetailDTO.setPaymentStatus(x.getPaymentStatus());
            myTehranTollsSummaryDTO.addMyTehranDateDetailDTO(myTehranDateDetailDTO);
            return x.getDate();

        });

        myTehranTollsSummaryRepository.save(myTehranTollsSummary);
        setPlusResponseTehranTollsSummaryRepository.save(setPlusResponseTehranTollsSummary);
        myTehranDateDetailRepository.save(myTehranDateDetail);

        return null; //TODO I do not know yet??

    }


}

