package com.bahar.toll.repo;

import com.bahar.model.SetPlusResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetPlusResponseRepository extends
        MongoRepository<SetPlusResponse, String> {
}
