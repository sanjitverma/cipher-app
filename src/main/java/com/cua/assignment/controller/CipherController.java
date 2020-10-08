package com.cua.assignment.controller;


import com.cua.assignment.CipherResponse;
import com.cua.assignment.service.CipherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(path = "/data",
        produces = {"application/json","text/plain"})
@CrossOrigin(origins="*")
@Validated
public class CipherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CipherController.class);

    final CipherService cipherService;

    public CipherController(CipherService cipherService) {
        this.cipherService = cipherService;
    }

    @GetMapping(value={"/encode"})
    public EntityModel<CipherResponse> encodeText(@RequestParam @NotEmpty String text){
        LOGGER.info("Request string received for encoding :: {}",text);

        EntityModel<CipherResponse> resource = EntityModel.of(new CipherResponse(cipherService.encode(text)));
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).decodeText(""));
        resource.add(linkTo.withRel("decode-text"));
        return resource;
    }

    @GetMapping("/decode")
    public EntityModel<CipherResponse> decodeText(@RequestParam @NotEmpty String text){
        LOGGER.info("Request string received for decoding :: {} ",text);
        EntityModel<CipherResponse> resource = EntityModel.of(new CipherResponse(cipherService.decode(text)));
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).encodeText(""));
        resource.add(linkTo.withRel("encode-text"));
        return resource;
    }

}
