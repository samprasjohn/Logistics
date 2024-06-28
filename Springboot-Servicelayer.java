package com.example.loadmanagement.service; 

import com.example.loadmanagement.model.Load;
import com.example.loadmanagement.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import java.util.List;
import java.util.Optional; 

@Service
public class LoadService { 

    private final LoadRepository loadRepository; 

    @Autowired
    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    } 

    public Load addLoad(Load load) {
        return loadRepository.save(load);
    } 

    public List<Load> getLoadsByShipperId(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    } 

    public Optional<Load> getLoadById(Long loadId) {
        return loadRepository.findById(loadId);
    } 

    public Load updateLoad(Long loadId, Load updatedLoad) {
        updatedLoad.setId(loadId);
        return loadRepository.save(updatedLoad);
    } 

    public void deleteLoad(Long loadId) {
        loadRepository.deleteById(loadId);
    }
}
