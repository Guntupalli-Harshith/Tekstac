package com.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Module;
import com.exception.InvalidModuleException;
import com.repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements IModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public Module addModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Module updateModuleFee(String moduleId, double moduleFee) throws InvalidModuleException {
        Optional<Module> moduleOpt = moduleRepository.findById(moduleId);
        if (moduleOpt.isPresent()) {
            Module module = moduleOpt.get();
            module.setModuleFee(moduleFee);
            return moduleRepository.save(module);
        } else {
            throw new InvalidModuleException("Module not found with ID: " + moduleId);
        }
    }

    @Override
    public Module viewModuleById(String moduleId) throws InvalidModuleException {
        if (moduleRepository.existsById(moduleId)) {
            return moduleRepository.findById(moduleId).get();
        } else {
            throw new InvalidModuleException("Module not found with ID: " + moduleId);
        }
    }

    @Override
    public List<Module> viewAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Module deleteModule(String moduleId) throws InvalidModuleException {
        Optional<Module> moduleOpt = moduleRepository.findById(moduleId);
        if (moduleOpt.isPresent()) {
            Module module = moduleOpt.get();
            moduleRepository.delete(module);
            return module;
        } else {
            throw new InvalidModuleException("Module not found with ID: " + moduleId);
        }
    }
}