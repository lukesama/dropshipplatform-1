package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.DataDictionary;
import com.jnu.dropshipplatform.repository.DataDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

    @Autowired
    private DataDictionaryRepository dataDictionaryRepository;

    @Override
    public List<DataDictionary> getAllDic(){
        return dataDictionaryRepository.findAll();
    }
    @Override
    public DataDictionary getDataDictionaryById(Integer dataId){
        return dataDictionaryRepository.findById(dataId).get();
    }
    @Override
    public DataDictionary addDataDic(DataDictionary dataDictionary){
        return dataDictionaryRepository.save(dataDictionary);
    }

    @Override
    public void deleteByDataDicId(Integer dataId){
        dataDictionaryRepository.deleteById(dataId);
    }

    @Override
    public DataDictionary updateDataDic(DataDictionary dataDictionary){
        return dataDictionaryRepository.save(dataDictionary);
    }

}
