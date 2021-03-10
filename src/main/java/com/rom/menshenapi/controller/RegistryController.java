package com.rom.menshenapi.controller;

import java.net.URI;
import java.util.List;

import com.rom.menshenapi.model.Registry;
import com.rom.menshenapi.service.IRegistryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RegistryController {

    @Autowired
    private IRegistryService service;

    @GetMapping("/registries")
    public ResponseEntity<List<Registry>> getRegistries() {
        return ResponseEntity.ok().body(service.getRegistries());
    }

    @GetMapping("/registries/{id}")
    public ResponseEntity<Registry> getRegistry(@PathVariable long id) {
        return ResponseEntity.ok().body(service.getRegistry(id));
    }

    @PostMapping("/registries")
    public ResponseEntity<Void> createRegistry(@RequestBody Registry registry) {
        Registry savedRegistry = service.createRegistry(registry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedRegistry.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("registries/{id}")
    public ResponseEntity<Void> updateRegistry(@PathVariable long id, @RequestBody Registry registry) {
        service.updateRegsitry(id, registry);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/registries/{id}")
    public ResponseEntity<Void> deleteRegistry(@PathVariable long id) {
        service.deleteRegistry(id);
        return ResponseEntity.noContent().build();
    }

}
