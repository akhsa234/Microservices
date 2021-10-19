package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "DB_SEQUENCES")
public class DatabaseSequence {

    @Id
    private String id;
    private long seq;

}
