package com.jnu.dropshipplatform.controller;

import com.jnu.dropshipplatform.entity.DataDictionary;
import com.jnu.dropshipplatform.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("jnu")
public class DataDictionaryController {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @GetMapping("/adminDataDictPage")
    public String getDataDictPage(HttpSession session,Model model){
        List<DataDictionary> dict=dataDictionaryService.getAllDic();
       model.addAttribute("dict",dict);
        return "adminManageDataDictionary";
    }

    @GetMapping("addDataDic")
    public String addDataDictionary(HttpSession session){
        return "addDataDictionary";
    }

    @PostMapping("addDataDic")
    public String addDataDictionary(DataDictionary dataDictionary,HttpSession session){
        dataDictionaryService.updateDataDic(dataDictionary);
        return "redirect:/jnu/adminDataDictPage";
    }
    @GetMapping("deleteDic/{id}")
    public String  deleteDataDic(@PathVariable("id") Integer dataId,HttpSession session){
        dataDictionaryService.deleteByDataDicId(dataId);
        return "redirect:/jnu/adminDataDictPage";
    }
    @GetMapping("updateDic/{id}")
    public String updateDataDic(@PathVariable("id") Integer dataId,Model model,HttpSession session){
        DataDictionary dic=dataDictionaryService.getDataDictionaryById(dataId);
        model.addAttribute("dic",dic);
        return "updateDataDictionary";
    }
    @PostMapping("updateDic")
    public String updateDataDic(DataDictionary dataDictionary,HttpSession session){
        dataDictionaryService.updateDataDic(dataDictionary);
        return "redirect:/jnu/adminDataDictPage";
    }




}
