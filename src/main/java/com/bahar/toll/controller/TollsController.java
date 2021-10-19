package com.bahar.controller;

import com.bahar.dto.client.CityDTO;
import com.bahar.dto.*;
import com.bahar.dto.client.FreewayDTO;
import com.bahar.externalService.setplus.ws.TehranTollsSummaryServiceClient;
import com.bahar.service.impl.GeneralServiceImpl;
import com.bahar.service.impl.PlaqueServiceImpl;
import com.bahar.service.impl.TehranTollsSummaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tolls")
public class TollsController {

    private PlaqueServiceImpl plaqueService;
    private TehranTollsSummaryServiceImpl tehranTollsSummaryService;
    private GeneralServiceImpl generalService;
    private TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient;

    private TehranTollsSummaryHeaderDTO tehranTollsSummaryHeaderDto;
    private GeneralServiceDTO generalServiceDTO;

    @Autowired
    public TollsController(PlaqueServiceImpl plaqueService,
                           TehranTollsSummaryServiceImpl tehranTollsSummaryService,
                           GeneralServiceImpl generalService,
                           TehranTollsSummaryServiceClient tehranTollsSummaryServiceClient) {

        this.plaqueService = plaqueService;
        this.tehranTollsSummaryService = tehranTollsSummaryService;
        this.generalService = generalService;
        this.tehranTollsSummaryServiceClient = tehranTollsSummaryServiceClient;
    }

    @PostMapping(value = "tehranTollsSummary")
    public void getTehranTollsSummary(
            @RequestBody TehranTollsSummaryInputDTO tehranTollsSummaryInputDTO) throws Exception {

        generalServiceDTO.setDeviceId(tehranTollsSummaryInputDTO.getDeviceId());
        generalServiceDTO.setNumberPlatesObj(tehranTollsSummaryInputDTO.getNumberPlatesObj());

        int numberPlate = plaqueService.getPlaqueFormatter(generalServiceDTO.getNumberPlatesObj());
        String deviceId = generalServiceDTO.getDeviceId();

        String type = "tehranTollsSummary";

        generalService.saveSetPlusRequestResponse(deviceId, type, numberPlate);
        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();

        String jwt= "";
        //send these variables{traceNumber,deviceId  ,numberPlate} to external service ??? //TODO
        tehranTollsSummaryServiceClient.tehranTollsSummary(jwt,traceNumber,deviceId,numberPlate); //TODO ask from najafi????

        //what do you should return to the front ???
        //  return tehranTollsSummaryService.getTehranTollsSummaryHeaderDto(); //TODO ask from pderam????
    }

    @PostMapping(value = "payMyTehranToll")
    public void payMyTehranToll(@RequestBody SetPlusPaymentInputDTO paymentInputDTO) throws Exception {

        generalServiceDTO.setDeviceId(paymentInputDTO.getDeviceId());
        generalServiceDTO.setNumberPlatesObj(paymentInputDTO.getNumberPlatesObj());
        String type = "payMyTehranToll";
        int numberPlate = plaqueService.getPlaqueFormatter(generalServiceDTO.getNumberPlatesObj());
        String deviceId = generalServiceDTO.getDeviceId();

        generalService.saveSetPlusRequestResponse(deviceId, type, numberPlate);
        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();
        String jwt = "";
        //send these variables{traceNumber,deviceId  ,numberPlate} to external service ??? //TODO
      //  tehranTollsSummaryServiceClient.(jwt, traceNumber, deviceId, numberPlate);

        //what do you should return to the front ???


    }

    @PostMapping(value = "airPollutionRemainDays")
    public AirPollutionDTO airPollutionRemainDays(@RequestBody AirPollutionDTO airPollutionDTO) throws Exception {

        generalServiceDTO.setDeviceId(airPollutionDTO.getDeviceId());
        generalServiceDTO.setNumberPlatesObj(airPollutionDTO.getNumberPlatesObj());
        String type = "airPollutionRemainDays";
        int numberPlate = plaqueService.getPlaqueFormatter(generalServiceDTO.getNumberPlatesObj());
        String deviceId = generalServiceDTO.getDeviceId();

        generalService.saveSetPlusRequestResponse(deviceId, type, numberPlate);
        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();
        String jwt = "";
        //send these variables{traceNumber,deviceId  ,numberPlate} to external service ??? //TODO
        tehranTollsSummaryServiceClient.airPollutionRemainDays(jwt, traceNumber, deviceId, numberPlate);

//what do you should return to the front ???
        //return to client- front ---
        return airPollutionDTO;
    }

    //{"amount":0,"deviceId":"354650070938737",
// "nationalCode":"0040822877",
// "numberPlatesObj":{"ir":"68","p2":"98","p3":"911","pc":"ج"},
// "vin":"IRFC141V06V559280"}
    @PostMapping(value = "annualToll")
    public AnnualTollDTO annualToll(@RequestBody AnnualTollDTO annualTollDTO) throws Exception {

        generalServiceDTO.setDeviceId(annualTollDTO.getDeviceId());
        generalServiceDTO.setNumberPlatesObj(annualTollDTO.getNumberPlatesObj());
        String type = "annualToll";
        int numberPlate = plaqueService.getPlaqueFormatter(generalServiceDTO.getNumberPlatesObj());
        String deviceId = generalServiceDTO.getDeviceId();

        generalService.saveSetPlusRequestResponse(deviceId, type, numberPlate);

        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();
        String vin = annualTollDTO.getVin();
        String nationalCode = annualTollDTO.getNationalCode();
        String jwt = "";

        //send these variables{traceNumber,deviceId  ,numberPlate,vin,nationalCode } to external service ??? //TODO
        tehranTollsSummaryServiceClient.annualToll(jwt, traceNumber, deviceId, numberPlate, vin, nationalCode);
//what do you should return to the front ???
        //return to client- front ---
        return annualTollDTO;
    }


    @PostMapping(value = "freewayTollsSummary")
    public void freewayTollsSummary(@RequestBody FreewayDTO freewayDTO) throws Exception {
        generalServiceDTO.setDeviceId(freewayDTO.getDeviceId());
        generalServiceDTO.setNumberPlatesObj(freewayDTO.getNumberPlatesObj());
        String type = "annualToll";
        int numberPlate = plaqueService.getPlaqueFormatter(generalServiceDTO.getNumberPlatesObj());
        String deviceId = generalServiceDTO.getDeviceId();

        generalService.saveSetPlusRequestResponse(deviceId, type, numberPlate);

        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();
        String jwt= "";

        //send these variables{traceNumber,deviceId  ,numberPlate,vin,nationalCode } to external service ??? //TODO
        tehranTollsSummaryServiceClient.freewayTollsSummary(jwt,traceNumber,deviceId,numberPlate);

//what do you should return to the front ???

    }

    @PostMapping(value = "cityList")
    public void cityList(@RequestBody CityDTO cityDTO) throws Exception {
        generalServiceDTO.setDeviceId(cityDTO.getDeviceId());
        String type = "cityList";
        String deviceId = generalServiceDTO.getDeviceId();

        generalService.saveSetPlusRequestResponse(deviceId, type, 0);

        // call save method from serviceimpl
        String traceNumber = generalService.getTraceNumber();
        String jwt= "";

        //send these variables{traceNumber,deviceId  ,numberPlate,vin,nationalCode } to external service ??? //TODO
        tehranTollsSummaryServiceClient.cityList(jwt,traceNumber,deviceId);

    }


}
