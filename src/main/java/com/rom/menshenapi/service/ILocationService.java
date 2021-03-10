package com.rom.menshenapi.service;

import java.util.List;

import com.rom.menshenapi.model.Location;

public interface ILocationService {

    Location createLocation(Location location);

    List<Location> getLocations();

    Location getLocation(long id);

    void updateLocation(long id, Location location);

    void deleteLocation(long id);

}
