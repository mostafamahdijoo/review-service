package com.example.reviewservice.controller;

import com.example.reviewservice.dto.ProviderDto;
import com.example.reviewservice.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/provider")
public class ProviderController {

    private final IProviderService iProviderService;

    @PostMapping(value = "/saveNewProvider")
    @ResponseBody
    public ResponseEntity<String> saveNewProvider(@RequestBody ProviderDto providerDto) {
        String savedProviderCorrelationId = iProviderService.saveNewProvider(providerDto);
        return new ResponseEntity<>(savedProviderCorrelationId, HttpStatus.OK);
    }
}
