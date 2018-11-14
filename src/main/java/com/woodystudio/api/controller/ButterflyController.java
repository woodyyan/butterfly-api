package com.woodystudio.api.controller;

import com.woodystudio.api.model.Butterflies;
import com.woodystudio.api.service.ButterflyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/butterfly", produces = "application/vnd.api+json")
@Api(tags = "Butterfly", description = "Operations on butterfly")
@Slf4j
public class ButterflyController {

    @Autowired
    private ButterflyService service;

    @RequestMapping(method = GET)
    @ApiOperation(value = "Search butterfly", notes = "Search butterfly by parameters")
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "The index of the page requested",
                    defaultValue = "0", dataType = "integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "The number of elements per page",
                    defaultValue = "10", dataType = "integer", paramType = "query")
    })
    public Butterflies searchButterfly(@PageableDefault(sort = "createdTime", direction = Sort.Direction.DESC)
                                               Pageable page) {
        //一行显示9张图片，所以一次拿10行的
        log.info("Start search butterfly for page = {}", page);
        Butterflies butterflies = service.searchButterfly(page);
        log.info("End search butterfly with butterflies: {}", butterflies);
        return butterflies;
    }
}
