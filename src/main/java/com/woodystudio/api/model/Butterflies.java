package com.woodystudio.api.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Butterflies {
    private List<ButterflyData> data = new ArrayList<>();

    private PagingMeta meta = new PagingMeta();
}
