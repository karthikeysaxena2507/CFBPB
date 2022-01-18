package ConsumerFinancing.equifax.config;

import ConsumerFinancing.equifax.models.model.ObjectFactory;
import ConsumerFinancing.equifax.models.model.RequestType;
import ConsumerFinancing.equifax.models.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.bind.JAXBElement;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import java.util.Iterator;

@Slf4j
public class EquifaxClient extends WebServiceGatewaySupport {

    private final Jaxb2Marshaller jaxb2Marshaller;
    private final EquifaxConfig equifaxConfig;

    public EquifaxClient(Jaxb2Marshaller marshaller, EquifaxConfig equifaxConfig) {
        this.equifaxConfig = equifaxConfig;
        this.jaxb2Marshaller = marshaller;
    }

    public Response getResponse(RequestType request) {

        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<RequestType> requestType = objectFactory.createRequest(request);
        WebServiceTemplate template = new WebServiceTemplate(jaxb2Marshaller);

        log.info("Request Started .....");
        String username = equifaxConfig.getUsername();
        String password = equifaxConfig.getPassword();
        String toHeader = equifaxConfig.getToHeader();
        String actionHeader = equifaxConfig.getActionHeader();
        String enquiryUri = equifaxConfig.getEnquiryUri();
        String headerNamespace = equifaxConfig.getHeaderNamespace();
        String securityNamespace = equifaxConfig.getSecurityNamespace();

        Response response = (Response) template.marshalSendAndReceive(
            enquiryUri, requestType, message -> {

                SoapMessage soapMessage = (SoapMessage) message;
                SoapHeader header = soapMessage.getSoapHeader();

                StringSource headerSource = new StringSource(
             "<wsse:Security xmlns:wsse=\"" + securityNamespace + "\">\n" +
                    "   <wsse:UsernameToken>\n" +
                    "       <wsse:Username>" + username + "</wsse:Username>\n" +
                    "       <wsse:Password>" + password + "</wsse:Password>\n" +
                    "   </wsse:UsernameToken>\n" +
                    "</wsse:Security>\n");
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(headerSource, header.getResult());

                headerSource = new StringSource("<wsa:To xmlns:wsa=\"" + headerNamespace + "\">" + toHeader + "</wsa:To>");
                transformer.transform(headerSource, header.getResult());

                headerSource = new StringSource("<wsa:Action xmlns:wsa=\"" + headerNamespace + "\">" + actionHeader + "</wsa:Action>");
                transformer.transform(headerSource, header.getResult());

                Iterator<SoapHeaderElement> it = header.examineAllHeaderElements();
                while (it.hasNext()) {
                    log.info("header is {}", it.next().getName().getPrefix());
                }

            });

        log.info("Response Object is {}", response.getProductData().getSummaryData().getDataBlock().size());
        log.info("Request Completed ...");
        return response;
    }

}
