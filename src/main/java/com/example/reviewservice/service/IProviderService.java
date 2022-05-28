package com.example.reviewservice.service;

import com.example.reviewservice.dto.ProviderDto;
import com.example.reviewservice.model.Provider;

public interface IProviderService {

    Provider save(Provider provider);
    String saveNewProvider(ProviderDto providerDto);
}
