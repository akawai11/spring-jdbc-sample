package com.example.demo.Controller;


import com.example.demo.entiy.Sample;
import com.example.demo.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sample")
public class SampleController {

    @Autowired
    SampleRepository sampleRepository;

    @GetMapping("1")
    public String sample1() {
        return "sample1";
    }

    @GetMapping("getName")
    public String getName() {
        // sampleなので固定値
        return sampleRepository.getSampleName(1);
    }

    @GetMapping("findIdByName")
    public String findIdByName() {
        String result = "";
        // sampleなので固定値
        for(Integer id : sampleRepository.findSampleIdByName("Sam")) {
            result += id;
        }
        return result;
    }

    @GetMapping("getSample")
    public String getSample() {
        // sampleなので固定値
        Sample sample = sampleRepository.getSample(1);
        return sample.id + sample.name;
    }

    @GetMapping("findSampleByName")
    public String findSampleByName() {
        String result = "";
        // sampleなので固定値
        for(Sample sample : sampleRepository.findSampleByName("Sam")) {
            result += sample.id;
            result += sample.name;
        }
        return result;
    }

}
