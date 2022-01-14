package com.bahar.externalService.setplus.convertor;

import com.bahar.document.MyTehranDateDetail;
import com.bahar.document.SetPlusResponse;
import com.bahar.dto.MyTehranDateDetailDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class DTOTOSetPlusResponse implements Converter<SetPlusResponseDTO, SetPlusResponse> {

    private final SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public DTOTOSetPlusResponse(SequenceGeneratorService sequenceGeneratorService) {
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @Override
    public SetPlusResponse convert(SetPlusResponseDTO setPlusResponseDTO) {
        if (setPlusResponseDTO == null) {
            return null;
        }
        SetPlusResponse setPlusResponse = new SetPlusResponse();


        setPlusResponse.setId(sequenceGeneratorService.generateSequence(MyTehranDateDetail.SEQUENCE_NAME));
        setPlusResponse.setActionCode(setPlusResponseDTO.getActionCode());
        setPlusResponse.setActionMessage(setPlusResponseDTO.getActionMessage());
        setPlusResponse.setErrorMessages(setPlusResponseDTO.getErrorMessages());
        setPlusResponse.setReferenceNumber(setPlusResponseDTO.getReferenceNumber());
        setPlusResponse.setTraceNumber(setPlusResponseDTO.getTraceNumber());
        setPlusResponse.setData(setPlusResponseDTO.getData());

        return setPlusResponse;
    }


}
