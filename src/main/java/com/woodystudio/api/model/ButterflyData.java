package com.woodystudio.api.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

@Data
public class ButterflyData {
    private int id;
    private int butterflyId;
    private String name;
    private int setId;
    private List<String> urls = new ArrayList<>();
    private DateTime createdTime;
    private DateTime updatedTime;
}
