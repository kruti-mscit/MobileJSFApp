/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestMobileResource
 * [mobile]<br>
 * USAGE:
 * <pre>
 *        MobileClient client = new MobileClient();
 *        Object re sponse = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author kruti
 */
public class MobileClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/MobileApp/webresources";

    public MobileClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("mobile");
    }

    public <T> T getAllMobilesByFilter(Object requestEntity,Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllMobilesByFilter");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON),responseType);
    }

    public void addMobile(String company, String model, String year, String memory, String catid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addMobile/{0}/{1}/{2}/{3}/{4}", new Object[]{company, model, year, memory, catid})).request().post(null);
    }

    public <T> T getAllMobiles(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllMobiles");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteCat(String catid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteCat/{0}", new Object[]{catid})).request().delete();
    }

    public void deleteMobile(String mobileid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteMobile/{0}", new Object[]{mobileid})).request().delete();
    }

    public <T> T getAllCats(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCats");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
