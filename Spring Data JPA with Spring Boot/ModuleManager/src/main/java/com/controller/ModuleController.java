package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entity.Module;
import com.exception.InvalidModuleException;
import com.service.IModuleService;

@RestController
@RequestMapping("/")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @PostMapping("/addModule")
    public ResponseEntity<Module> addModule(@RequestBody Module module) {
        Module savedModule = moduleService.addModule(module);
        return new ResponseEntity<>(savedModule, HttpStatus.OK);
    }

    @PutMapping("/updateModuleFee/{moduleId}/{moduleFee}")
    public ResponseEntity<Module> updateModuleFee(@PathVariable String moduleId, 
                                                  @PathVariable double moduleFee) throws InvalidModuleException {
        Module updatedModule = moduleService.updateModuleFee(moduleId, moduleFee);
        return new ResponseEntity<>(updatedModule, HttpStatus.OK);
    }

    @GetMapping("/viewModuleById/{moduleId}")
    public ResponseEntity<Module> viewModuleById(@PathVariable String moduleId) throws InvalidModuleException {
        Module module = moduleService.viewModuleById(moduleId);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }

    @GetMapping("/viewAllModules")
    public ResponseEntity<List<Module>> viewAllModules() {
        List<Module> modules = moduleService.viewAllModules();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }

    @DeleteMapping("/deleteModule/{moduleId}")
    public ResponseEntity<Module> deleteModule(@PathVariable String moduleId) throws InvalidModuleException {
        Module deletedModule = moduleService.deleteModule(moduleId);
        return new ResponseEntity<>(deletedModule, HttpStatus.OK);
    }
}