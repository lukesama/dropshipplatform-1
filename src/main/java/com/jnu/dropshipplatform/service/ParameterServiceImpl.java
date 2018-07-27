package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.Parameter;
import com.jnu.dropshipplatform.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ParameterServiceImpl implements ParameterService{

    @Autowired
    private ParameterRepository parameterRepository;

    @Override
    public List<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    @Override
    public void save(Parameter parameter) {
        parameterRepository.save(parameter);
    }

    @Override
    public void delete(Integer parameterId) {
        parameterRepository.deleteByParaId(parameterId);
    }

    @Override
    public Parameter findByParaId(Integer paraId) {
        return parameterRepository.findById(paraId).get();
    }
}
