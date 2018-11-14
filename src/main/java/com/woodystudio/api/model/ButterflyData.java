package com.woodystudio.api.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class ButterflyData {
    private int id;
    private int butterflyId;
    private String name;
    private int setId;
    private String url;
    private DateTime createdTime;
    private DateTime updatedTime;
}
