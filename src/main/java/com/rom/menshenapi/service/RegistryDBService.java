package com.rom.menshenapi.service;

import java.util.ArrayList;
import java.util.List;

import com.rom.menshenapi.model.Registry;
import com.rom.menshenapi.repository.RegistryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistryDBService implements IRegistryService {

    @Autowired
    RegistryRepository repository;

    @Override
    public Registry createRegistry(Registry registry) {
        return repository.save(registry);
    }

    @Override
    public List<Registry> getRegistries() {
        List<Registry> registries = new ArrayList<>();
        repository.findAll().forEach(registries::add);
        return registries;
    }

    @Override
    public Registry getRegistry(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void updateRegsitry(long id, Registry registry) {
        registry.setId(id);
        repository.save(registry);
    }

    @Override
    public void deleteRegistry(long id) {
        repository.deleteById(id);
    }

}
