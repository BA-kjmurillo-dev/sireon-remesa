package com.sireon.remesa.service;

import com.sireon.remesa.persistence.entity.LogEntity;
import com.sireon.remesa.persistence.entity.LogId;
import com.sireon.remesa.persistence.repository.LogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private LogRespository logRespository;

    @Autowired
    public LogService(LogRespository logRespository) {
        this.logRespository = logRespository;
    }

    public List<LogEntity> getAll(){
        return this.logRespository.findAll();
    }

    public LogEntity get(LogId logId){
        return this.logRespository.findLog(logId.getCanal(), logId.getFechaLog().toString(), logId.getHoraLog().toString(), logId.getRemesa());
    }
}
