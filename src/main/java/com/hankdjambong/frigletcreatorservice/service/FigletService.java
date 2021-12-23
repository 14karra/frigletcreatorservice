package com.hankdjambong.frigletcreatorservice.service;

import com.github.lalyos.jfiglet.FigletFont;
import com.hankdjambong.frigletcreatorservice.entity.Figlet;
import com.hankdjambong.frigletcreatorservice.repository.FigletRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class FigletService {

    private final FigletRepository figletRepository;

    public String createFiglet(String text) throws IOException {
        String figletText = FigletFont.convertOneLine(text);
        figletRepository
                .save(Figlet.builder()
                        .figletValue(figletText)
                        .build());
        return figletText;
    }

    public List<Figlet> getAllFiglets() {
        //return figletRepository.findAll();
    }
}
