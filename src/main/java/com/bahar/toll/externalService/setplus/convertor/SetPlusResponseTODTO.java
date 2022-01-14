package com.bahar.externalService.setplus.convertor;

import com.bahar.document.MyTehranDateDetail;
import com.bahar.document.SetPlusResponse;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class SetPlusResponseTODTO implements Converter<SetPlusResponse, SetPlusResponseDTO> {
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public SetPlusResponseDTO convert(SetPlusResponse setPlusResponse) {
        if (setPlusResponse == null) {
            return null;
        }
        SetPlusResponseDTO setPlusResponseDTO = new SetPlusResponseDTO();

        setPlusResponseDTO.setId(sequenceGeneratorService.generateSequence(MyTehranDateDetail.SEQUENCE_NAME));
        setPlusResponseDTO.setActionCode(setPlusResponse.getActionCode());
        setPlusResponseDTO.setActionMessage(setPlusResponse.getActionMessage());
        setPlusResponseDTO.setErrorMessages(setPlusResponse.getErrorMessages());
        setPlusResponseDTO.setReferenceNumber(setPlusResponse.getReferenceNumber());
        setPlusResponseDTO.setTraceNumber(setPlusResponse.getTraceNumber());
//setPlusResponseDTO.getData(setPlusResponse.getData());


        return setPlusResponseDTO;
    }

}
