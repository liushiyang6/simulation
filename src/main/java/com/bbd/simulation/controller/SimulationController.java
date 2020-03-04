package com.bbd.simulation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lsy
 * @date 2020/1/21 11:35
 */
@RestController
public class SimulationController {
    @Value("${simulationFile.path}")
    private String simulationFile;

    @GetMapping("/{fileName}")
    public String getString(@PathVariable String fileName) throws IOException {
        String substring = fileName.substring(3);
        System.out.println(substring);
        return FileCopyUtils.copyToString(new BufferedReader(new FileReader(simulationFile + substring + ".json")));
    }
}
