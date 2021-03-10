package com.rom.menshenapi.service;

import java.util.ArrayList;
import java.util.List;

import com.rom.menshenapi.model.Location;
import com.rom.menshenapi.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationDBService implements ILocationService {

    @Autowired
    LocationRepository repository;

    @Override
    public Location createLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        repository.findAll().forEach(locations::add);
        return locations;
    }

    @Override
    public Location getLocation(long id) {
        return repository.findById(id).get();
    }

    @Override
    public void updateLocation(long id, Location location) {
        location.setId(id);
        repository.save(location);
    }

    @Override
    public void deleteLocation(long id) {
        repository.deleteById(id);
    }

}
