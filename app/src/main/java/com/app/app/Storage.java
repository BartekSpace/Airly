package com.app.app;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Storage  {

    private final List<Sensor> sensorList;

    public Storage() {
        this.sensorList = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {

        sensorList.add(sensor);
    }
    public Sensor findSensor(String id){
        return sensorList.stream()
                .filter(sensor -> id.equals(sensor.getId()))
                .findFirst()
                .orElse(null);
    }
    public void deleteSensor(String id){
        sensorList.remove(findSensor(id));
    }

    public void updateSensor(String id, String address, String ownerName){
        var sensor = findSensor(id);
        sensorList.remove(sensor);
        sensor.setFullName(ownerName);
        sensor.setAddress(address);
        sensorList.add(sensor);
    }

    public List<Sensor> showAllSensors(){
        return sensorList;
    }


}
