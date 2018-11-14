package com.woodystudio.api.service;

import com.woodystudio.api.entity.Butterfly;
import com.woodystudio.api.model.Butterflies;
import com.woodystudio.api.repository.ButterflyRepository;
import com.woodystudio.api.translator.ButterflyTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ButterflyService {
    @Autowired
    private ButterflyRepository repository;

    @Autowired
    private ButterflyTranslator translator;

    public Butterflies searchButterfly(Pageable page) {
        Page<Butterfly> pagedButterflies = repository.findAll(page);
        return translator.toButterflies(pagedButterflies);
    }
}
