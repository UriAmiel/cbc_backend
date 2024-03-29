package com.cbc.cbc.rides.model.save_ride;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveRideRequest {

    private String source;
    private String destination;
    private int driverId;
    private int communityId;
}
