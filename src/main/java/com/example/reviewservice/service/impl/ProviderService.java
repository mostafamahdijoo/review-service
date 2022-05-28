package com.example.reviewservice.service.impl;

import com.example.reviewservice.dto.ProviderDto;
import com.example.reviewservice.model.Provider;
import com.example.reviewservice.repository.ProviderRepository;
import com.example.reviewservice.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProviderService implements IProviderService {

    private final ProviderRepository providerRepository;

    @Override
    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    @Transactional
    public String saveNewProvider(ProviderDto providerDto) {
        Provider provider;
        if(providerDto != null) {
            provider = Provider.builder()
                    .correlationId(UUID.randomUUID().toString())
                    .name(providerDto.getName())
                    .build();
            return save(provider).getCorrelationId();
        }
        else {
            return null;
        }
    }
}
