package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.Parameter;
import com.jnu.dropshipplatform.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/jnu/parameter")
public class ParameterController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping
    public String jumpToParameter(Model model){
        List<Parameter> parameters=parameterService.findAll();
        model.addAttribute("parameter",parameters);
        return "Parameter";
    }

    @PostMapping("add")
    public String save(Parameter parameter){
        parameterService.save(parameter);
        return "redirect:/jnu/parameter";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        parameterService.delete(id);
        return "redirect:/jnu/parameter";
    }
    @GetMapping("update/{id}")
    public String jumpToUpdate(@PathVariable Integer id,Model model){
        Parameter parameter=parameterService.findByParaId(id);
        model.addAttribute("para",parameter);
        return "ParameterUpdate";
    }

    @PostMapping("update")
    public String update( Parameter parameter){
        parameterService.save(parameter);
        return "redirect:/jnu/parameter";
    }
}
