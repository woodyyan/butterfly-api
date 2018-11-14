package com.woodystudio.api.translator;

import com.woodystudio.api.entity.Butterfly;
import com.woodystudio.api.model.Butterflies;
import com.woodystudio.api.model.ButterflyData;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ButterflyTranslator {
    public Butterflies toButterflies(Page<Butterfly> pagedButterflies) {
        Butterflies butterflies = new Butterflies();

        for (Butterfly butterfly : pagedButterflies.getContent()) {
            ButterflyData data = toButterflyData(butterfly);
            butterflies.getData().add(data);
        }

        butterflies.getMeta().setPageSize(pagedButterflies.getSize());
        butterflies.getMeta().setPageNumber(pagedButterflies.getNumber());
        butterflies.getMeta().setTotalPages(pagedButterflies.getTotalPages());
        butterflies.getMeta().setTotalElements(pagedButterflies.getTotalElements());
        return butterflies;
    }

    private ButterflyData toButterflyData(Butterfly butterfly) {
        ButterflyData data = new ButterflyData();
        data.setId(butterfly.getId());
        data.setButterflyId(butterfly.getButterflyId());
        data.setName(butterfly.getName());
        data.setSetId(butterfly.getSetId());
        data.setUrl(butterfly.getUrl());
        data.setCreatedTime(butterfly.getCreatedTime().toDateTime());
        data.setUpdatedTime(butterfly.getUpdatedTime().toDateTime());
        return data;
    }
}
