package com.sireon.remesa.client;

import com.sireon.remesa.config.SoapConfig;
import com.sireon.remesa.wsdl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class SoapClient extends WebServiceGatewaySupport {

    // public List<ServicesResponse007ItemTransfer> getRemittanceByIdentifier() {
    public String getRemittanceByIdentifier() {
        //Credentials
        ServicesCredentials credentials  = new ServicesCredentials();
        credentials.setServicesUser("SIREON_TELLER");
        credentials.setServicesPassword("JTEgi4sCvTg1H67");
        // credentials.setServicesToken("");

        //Item Solicitud
        ServicesRequest007ItemSolicitud itemSolicitud = new ServicesRequest007ItemSolicitud();
        itemSolicitud.setCanal("0002");
        itemSolicitud.setCodigoBanco("2000");
        itemSolicitud.setIdentificadorRemesa("202405230001");

        //Request
        ServicesRequest007 request007 = new ServicesRequest007();
        request007.setServicesCredentials(credentials);
        request007.setItemSolicitud(itemSolicitud);

        WSSIREON007CONSULTAPORIDENTIFICADOR remittanceByIdentifier = new WSSIREON007CONSULTAPORIDENTIFICADOR();
        remittanceByIdentifier.setServicesrequest007(request007);

        SoapActionCallback callback = new SoapActionCallback("SIREONGFA");
        WSSIREON007CONSULTAPORIDENTIFICADORResponse response = (WSSIREON007CONSULTAPORIDENTIFICADORResponse) getWebServiceTemplate().marshalSendAndReceive("http://10.128.248.118/SIREONGFA/awssireon007.aspx?wsdl", remittanceByIdentifier, callback);
        String code = response.getServicesresponse007().getServicesResponse().getMessageCode();
        String message = response.getServicesresponse007().getServicesResponse().getMessage();
        return code + " " + message;
    }
}