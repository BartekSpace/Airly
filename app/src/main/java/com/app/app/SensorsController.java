package com.app.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sensors")
public class SensorsController {

    private final Storage container;

    public SensorsController(Storage container) {
        this.container = container;
    }


    @PostMapping("")
    public ResponseEntity<?> addSensor( @RequestBody @Valid  Sensor sensor)
    {
        container.addSensor(sensor);
        return  ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping(value = "/{id}",  produces = "application/json")
    public ResponseEntity<?> showSensor(@PathVariable("id") String id)
    {
        if(isInvalidRequest(id))  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.ok(container.findSensor(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSensor(@PathVariable("id") String id)
    {
        if(isInvalidRequest(id))  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        container.deleteSensor(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSensor(@PathVariable("id") String id,@RequestBody @Valid Sensor sensor)
    {
        if(isInvalidRequest(id))  return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        container.updateSensor(id,sensor.getAddress(),sensor.getFullName());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping(value = "" , produces = "application/json")
    public ResponseEntity<?> showAllSensors()
    {
        return ResponseEntity.ok(container.showAllSensors());
    }

    private boolean isInvalidRequest(String id ){
        var sensor = container.findSensor(id);
        return sensor == null;
    }
}

