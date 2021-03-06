package com.woodystudio.api.service;

import com.woodystudio.api.entity.Butterfly;
import com.woodystudio.api.model.Butterflies;
import com.woodystudio.api.repository.ButterflyRepository;
import com.woodystudio.api.translator.ButterflyTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ButterflyService {

    @Autowired
    private ButterflyRepository repository;

    @Autowired
    private ButterflyTranslator translator;

    public Butterflies searchButterfly(Pageable page) {
        int DEFAULT_SET_NUMBER = 9;
        Pageable sizedPage = new PageRequest(page.getPageNumber(), page.getPageSize() * DEFAULT_SET_NUMBER, page.getSort());
        Page<Butterfly> pagedButterflies = repository.findAll(sizedPage);
        Page<Butterfly> revertedPagedButterflies =
                new PageImpl<>(pagedButterflies.getContent(), page, pagedButterflies.getTotalElements() / DEFAULT_SET_NUMBER);
        return translator.toButterflies(revertedPagedButterflies);
    }
}
