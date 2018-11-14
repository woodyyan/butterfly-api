package com.woodystudio.api.translator;

import com.woodystudio.api.entity.Butterfly;
import com.woodystudio.api.model.Butterflies;
import org.joda.time.LocalDateTime;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ButterflyTranslatorTest {

    private LocalDateTime updatedTime = LocalDateTime.now();
    private LocalDateTime createdTime = LocalDateTime.now();

    @Test
    public void shouldTranslateButterfly() {
        ButterflyTranslator translator = new ButterflyTranslator();
        Pageable page = new PageRequest(0, 20);
        List<Butterfly> content = new ArrayList<>();
        content.add(createButterfly(1, "name1"));
        content.add(createButterfly(1, "name1"));
        content.add(createButterfly(1, "name1"));
        content.add(createButterfly(2, "name2"));
        content.add(createButterfly(2, "name2"));
        content.add(createButterfly(2, "name2"));
        content.add(createButterfly(3, "name3"));
        content.add(createButterfly(3, "name3"));
        content.add(createButterfly(3, "name3"));
        Page<Butterfly> pagedButterflies = new PageImpl<>(content, page, 3);

        Butterflies butterflies = translator.toButterflies(pagedButterflies);

        Assert.assertEquals(0, butterflies.getMeta().getPageNumber());
        Assert.assertEquals(20, butterflies.getMeta().getPageSize());
        Assert.assertEquals(1, butterflies.getMeta().getTotalPages());
        Assert.assertEquals(9, butterflies.getMeta().getTotalElements());
        Assert.assertEquals(3, butterflies.getData().size());

        Assert.assertEquals(3, butterflies.getData().get(0).getId());
        Assert.assertEquals(3, butterflies.getData().get(0).getButterflyId());
        Assert.assertEquals(3, butterflies.getData().get(0).getSetId());
        Assert.assertEquals("name3", butterflies.getData().get(0).getName());
        Assert.assertEquals(createdTime.toDateTime(), butterflies.getData().get(0).getCreatedTime());
        Assert.assertEquals(updatedTime.toDateTime(), butterflies.getData().get(0).getUpdatedTime());
        Assert.assertEquals(3, butterflies.getData().get(0).getUrls().size());
        Assert.assertEquals("url", butterflies.getData().get(0).getUrls().get(0));
    }

    private Butterfly createButterfly(int id, String name) {
        Butterfly butterfly = new Butterfly();
        butterfly.setButterflyId(id);
        butterfly.setId(id);
        butterfly.setSetId(id);
        butterfly.setName(name);
        butterfly.setUrl("url");
        butterfly.setCreatedTime(createdTime);
        butterfly.setUpdatedTime(updatedTime);
        return butterfly;
    }
}