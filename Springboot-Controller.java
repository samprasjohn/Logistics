package com.example.loadmanagement.controller; 

import com.example.loadmanagement.model.Load;
import com.example.loadmanagement.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.util.List;
import java.util.Optional; 

@RestController
@RequestMapping("/api/load")
public class LoadController { 

    private final LoadService loadService; 

    @Autowired
    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    } 

    @PostMapping
    public ResponseEntity<Load> addLoad(@RequestBody Load load) {
        Load addedLoad = loadService.addLoad(load);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedLoad);
    } 

    @GetMapping
    public ResponseEntity<List<Load>> getLoadsByShipperId(@RequestParam String shipperId) {
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return ResponseEntity.ok(loads);
    } 

    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Optional<Load> load = loadService.getLoadById(loadId);
        return load.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    } 

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load updatedLoad) {
        Load load = loadService.updateLoad(loadId, updatedLoad);
        return ResponseEntity.ok(load);
    } 

    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }
}
