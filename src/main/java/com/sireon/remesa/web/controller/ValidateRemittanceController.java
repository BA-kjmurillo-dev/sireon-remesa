package com.sireon.remesa.web.controller;

import com.sireon.remesa.client.SoapClient;
import com.sireon.remesa.service.dto.ValidateRemittanceDto;
import com.sireon.remesa.wsdl.ServicesResponse007;
import com.sireon.remesa.wsdl.ServicesResponse007ItemTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/validateRemittance")
public class ValidateRemittanceController {
    private SoapClient soapClient;

    @Autowired
    public ValidateRemittanceController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping
    public ResponseEntity<Object> getRemittanceSireon(
        @RequestBody ValidateRemittanceDto validateRemittanceDto
    ) {
        // return ResponseEntity.ok(validateRemittanceDto.getCanal());  // test
        try {
            String result = this.soapClient.getRemittanceByIdentifier();
            // return ResponseEntity.ok(validateRemittanceDto.getCanal()); // test
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado: " + e);
        }
    }
}