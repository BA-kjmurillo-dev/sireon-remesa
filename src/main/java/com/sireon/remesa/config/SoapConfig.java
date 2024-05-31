package com.sireon.remesa.config;

import com.sireon.remesa.client.Service07SoapClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller07() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.soap.wsdl.service07");
        return marshaller;
    }

    @Bean
    public Service07SoapClient Service07SoapClient(Jaxb2Marshaller marshaller07) {
        Service07SoapClient client = new Service07SoapClient();
        client.setDefaultUri("http://10.128.248.118/SIREONGFA/awssireon007.aspx?wsdl");
        client.setMarshaller(marshaller07);
        client.setUnmarshaller(marshaller07);
        return client;
    }
}
