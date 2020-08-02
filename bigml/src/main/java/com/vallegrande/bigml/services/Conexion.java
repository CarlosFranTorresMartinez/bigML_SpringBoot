package com.vallegrande.bigml.services;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Conexion {

    public String conectar(String json) throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            /*Agregamos la api que nos otorga bigML,con nuestro usuario y key*/
            HttpPost httpPost = new HttpPost("https://bigml.io/andromeda/prediction?username=bryanbenavente;api_key=6bdd6d1dbf8ac8a270e56896062c3083555bfcc8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            /*Ingresamos nuestros datos con formato Json*/
            StringEntity stringEntity = new StringEntity(json);
            System.out.println(json);

            /*Enviamos nuestro Json*/
            httpPost.setEntity(stringEntity);

            /*Personalisamos los tipos de respuesta*/
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Estado de la respuesta " + status);
                }
            };

            /*Agregamos  nuestra respuesta*/
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("responseBody" + responseBody);

            /*Obtenes la respuesta del Json*/
            return responseBody;
        }

    }
}
