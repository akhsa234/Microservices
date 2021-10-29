package com.bahar.toll.repo;

import com.bahar.model.SetPlusRequestResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SetPlusRequestResponseRepository extends
        MongoRepository<SetPlusRequestResponse, String> {

    @Query("SELECT u FROM SetPlusRequestResponse u WHERE u.reqDate = ? ,u.type=? , u.deviceId=?")
    SetPlusRequestResponse findByDataAndTypeAndDeviceId(String reqDate, String type, String deviceId);


}
