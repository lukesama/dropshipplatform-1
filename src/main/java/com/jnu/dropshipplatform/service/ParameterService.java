package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.Parameter;

import java.util.List;

public interface ParameterService {
    List<Parameter> findAll();
    void save(Parameter parameter);
    void delete(Integer parameterId);
    Parameter findByParaId(Integer paraId);
}
