package com.service;

import java.util.List;

import com.entity.Module;
import com.exception.InvalidModuleException;

public interface IModuleService {

    public Module addModule(Module module);

    public Module updateModuleFee(String moduleId, double moduleFee) throws InvalidModuleException;

    public Module viewModuleById(String moduleId) throws InvalidModuleException;

    public List<Module> viewAllModules();

    public Module deleteModule(String moduleId) throws InvalidModuleException;
}