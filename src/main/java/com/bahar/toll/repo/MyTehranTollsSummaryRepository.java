package com.bahar.toll.repo;

import com.bahar.model.MyTehranTollsSummary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTehranTollsSummaryRepository extends
        MongoRepository<MyTehranTollsSummary, String> {
}
