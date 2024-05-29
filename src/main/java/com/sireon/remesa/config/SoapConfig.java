package com.sireon.remesa.config;

import com.sireon.remesa.client.SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.sireon.remesa.wsdl");
        return marshaller;
    }

    @Bean
    public SoapClient soapClient(Jaxb2Marshaller jaxb2Marshaller){
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://10.128.248.118/SIREONGFA/awssireon007.aspx?wsdl");
        soapClient.setMarshaller(jaxb2Marshaller);
        soapClient.setUnmarshaller(jaxb2Marshaller);
        return soapClient;
    }
}