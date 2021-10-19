package com.bahar.toll.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "PLAQUE_MAPPER")
public class PlaqueMapper {

    @Transient
    public static final String SEQUENCE_NAME = "PlaqueMapper_sequence";
    @Id
    private long id;
    private String key;
    private String value;


}
