package com.hankdjambong.frigletcreatorservice.controller;

import com.hankdjambong.frigletcreatorservice.entity.Figlet;
import com.hankdjambong.frigletcreatorservice.service.FigletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/${api.version}")
public class FigletController {

    private final FigletService figletService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<Figlet> getAllFiglets() {
        log.info("Request to get all figlets.");
        return figletService.getAllFiglets();
    }

    @PostMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
    public String createFiglet(@RequestBody String text) throws IOException {
        log.info("Request to save a new figlet.");
        return figletService.createFiglet(text);
    }
}
