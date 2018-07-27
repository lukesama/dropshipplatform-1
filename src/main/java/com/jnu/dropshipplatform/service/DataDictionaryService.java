package com.jnu.dropshipplatform.service;

import com.jnu.dropshipplatform.entity.DataDictionary;

import java.util.List;

public interface DataDictionaryService {

    List<DataDictionary> getAllDic();

    DataDictionary getDataDictionaryById(Integer dataId);

    DataDictionary addDataDic(DataDictionary dataDictionary);

    void deleteByDataDicId(Integer dataId);

    DataDictionary updateDataDic(DataDictionary dataDictionary);

}
