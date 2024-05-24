package com.sireon.remesa.web.controller;

import com.sireon.remesa.persistence.entity.LogEntity;
import com.sireon.remesa.persistence.entity.LogId;
import com.sireon.remesa.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {
    private LogService logService;


    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping
    public ResponseEntity<List<LogEntity>> getAll(){
        return ResponseEntity.ok(this.logService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<LogEntity> get(@RequestBody LogId logId){
        LogId log = new LogId(logId.getRemesa(), logId.getFechaLog(), logId.getHoraLog(), logId.getCanal());
        return ResponseEntity.ok(this.logService.get(log));
    }
}
