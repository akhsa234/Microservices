package com.bahar.toll.repo;

import com.bahar.model.MyTehranDateDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTehranDateDetailRepository extends
        MongoRepository<MyTehranDateDetail, String> {
}
