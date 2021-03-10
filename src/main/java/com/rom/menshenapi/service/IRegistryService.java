package com.rom.menshenapi.service;

import java.util.List;

import com.rom.menshenapi.model.Registry;

public interface IRegistryService {

    Registry createRegistry(Registry registry);

    List<Registry> getRegistries();

    Registry getRegistry(long id);

    void updateRegsitry(long id, Registry registry);

    void deleteRegistry(long id);

}
