package com.rom.menshenapi.controller;

import java.net.URI;
import java.util.List;

import com.rom.menshenapi.model.Location;
import com.rom.menshenapi.service.ILocationService;

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
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LocationController {

    @Autowired
    private ILocationService service;

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getLocations() {
        return ResponseEntity.ok().body(service.getLocations());
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Location> getLocation(@RequestParam Long id) {
        return ResponseEntity.ok().body(service.getLocation(id));
    }

    @PostMapping("/locations")
    public ResponseEntity<Void> createLocation(@RequestBody Location location) {
        Location savedLocation = service.createLocation(location);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedLocation.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/locations/{id}")
    public ResponseEntity<Void> updateLocation(@PathVariable long id, @RequestBody Location location) {
        service.updateLocation(id, location);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable long id) {
        service.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

}
