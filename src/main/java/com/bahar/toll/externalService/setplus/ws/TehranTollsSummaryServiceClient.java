package com.bahar.externalService.setplus.ws;

import com.bahar.dto.*;
import com.bahar.externalService.setplus.dto.SetPlusResponseDTO;
import com.bahar.externalService.setplus.dto.SetPlusResponseListDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(name="tolls", url = "${server.simorgh_psp_server.url}")
public interface TehranTollsSummaryServiceClient {
    @GetMapping("vsms/api/Carbill/MyTehranTollsSummary")
    @ResponseBody
    SetPlusResponseDTO<MyTehranTollsSummaryDTO> tehranTollsSummary(@RequestHeader("Authorization") String jwt,
                                                                   @RequestHeader("traceNumber") String traceNumber,
                                                                   @RequestHeader("deviceId") String deviceId,
                                                                   @RequestParam("PlateNo") int plateNo);

//Collection<SetPlusResponseDto<MyTehranTollsSummaryDTO>

    @PostMapping("/token")
    List<String> setplusToken(@PathVariable("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("grant_type") String grant_type,
                              @RequestParam("client_id") String client_id,
                              @RequestParam("client_secret") String OrganSecret);

    @PostMapping("/token")
    List<String> setplusRefreshToken(@RequestParam("refresh_token") String refreshToken,
                                     @RequestParam("grant_type") String grant_type,
                                     @RequestParam("client_id") String client_id,
                                     @RequestParam("client_secret") String OrganSecret);


    @GetMapping("vsms/api/Carbill/AirPollution")
    @ResponseBody
    SetPlusResponseDTO<AirPollutionDetailsDTO> airPollutionRemainDays(@RequestHeader("Authorization") String jwt,
                                                                      @RequestHeader("traceNumber") String traceNumber,
                                                                      @RequestHeader("deviceId") String deviceId,
                                                                      @RequestParam("PlateNo") int plateNo);


    @GetMapping("vsms/api/Carbill/AnnualToll")
    @ResponseBody
    SetPlusResponseDTO<AnnualTollResponseDTO> annualToll(@RequestHeader("Authorization") String jwt,
                                                         @RequestHeader("traceNumber") String traceNumber,
                                                         @RequestHeader("deviceId") String deviceId,
                                                         @RequestParam("PlateNo") int plateNo,
                                                         @RequestParam("VIN") String vin,
                                                         @RequestParam("NationalCode") String nationalCode);


    @GetMapping("vsms/api/Carbill/FreewayTollsSummary")
    @ResponseBody
    SetPlusResponseDTO<FreewayTollsSummaryDTO> freewayTollsSummary(@RequestHeader("Authorization") String jwt,
                                                                   @RequestHeader("traceNumber") String traceNumber,
                                                                   @RequestHeader("deviceId") String deviceId,
                                                                   @RequestParam("PlateNo") int plateNo);


    @GetMapping("vsms/api/Toll/CityList")
    @ResponseBody
    SetPlusResponseListDTO<SetPlusCityDTO> cityList(@RequestHeader("Authorization") String jwt,
                                                    @RequestHeader("traceNumber") String traceNumber,
                                                    @RequestHeader("deviceId") String deviceId);

    @GetMapping("vsms/api/Toll/ListByTollCity")
    @ResponseBody
    SetPlusResponseListDTO<SetPlusTollDTO> listByTollCity(@RequestHeader("Authorization") String jwt,
                                                          @RequestHeader("traceNumber") String traceNumber,
                                                          @RequestHeader("deviceId") String deviceId,
                                                          @RequestParam("fromCityId") int fromCityId,
                                                          @RequestParam("toCityId") int toCityId,
                                                          @RequestParam("vehicleClassTypeId") int vehicleClassTypeId);

    @GetMapping("vsms/api/Toll/List")
    @ResponseBody
    SetPlusResponseListDTO<SetPlusTollDTO> tollList(@RequestHeader("Authorization") String jwt,
                                                    @RequestHeader("traceNumber") String traceNumber,
                                                    @RequestHeader("deviceId") String deviceId);

}