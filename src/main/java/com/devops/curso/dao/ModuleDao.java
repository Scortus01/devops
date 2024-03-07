package com.devops.curso.dao;

import com.devops.curso.domain.Module;
import org.springframework.data.repository.CrudRepository;

public interface ModuleDao extends CrudRepository<Module, Long> { }
