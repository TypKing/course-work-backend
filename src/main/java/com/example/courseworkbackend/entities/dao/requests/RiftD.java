package com.example.courseworkbackend.entities.dao.requests;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class RiftD {

    private Long coordinateId;
    private Long countryId;
    private Integer rank;
    private Integer accessLevel;
    private Integer reward;

}
