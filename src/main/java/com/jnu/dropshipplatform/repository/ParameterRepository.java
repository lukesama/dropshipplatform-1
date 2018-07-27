package com.jnu.dropshipplatform.repository;

import com.jnu.dropshipplatform.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ParameterRepository extends JpaRepository<Parameter,Integer> {
    @Modifying
    @Query(value="delete from Parameter p where paraId=?1")
    void deleteByParaId(Integer paraId);

}
