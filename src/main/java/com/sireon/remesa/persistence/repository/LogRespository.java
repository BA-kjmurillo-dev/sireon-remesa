package com.sireon.remesa.persistence.repository;

import com.sireon.remesa.persistence.entity.LogEntity;
import com.sireon.remesa.persistence.entity.LogId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LogRespository extends ListCrudRepository<LogEntity, LogId> {

    @Query(value = "SELECT * FROM LOG WHERE CANAL=:ca AND TO_CHAR(FECHA_LOG, 'yyyy-MM-dd')=:fecha AND TO_CHAR(HORA_LOG,'HH:MI:SS')=:hora AND REMESA=:rem", nativeQuery = true)
    LogEntity findLog(@Param("ca") String canal, @Param("fecha") String fecha, @Param("hora") String hora, @Param("rem") String remesa);
}
