package com.sireon.remesa.service.dto;

import lombok.Data;

@Data
public class ValidateRemittanceDto {
    private String Canal;
    private String CodigoBanco;
    private String IdentificadorRemesa;
}
