package com.vallegrande.bigml;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.sql.SQLOutput;

public class httpClient {

    public static void main(String[] args) throws IOException {
        postUser();
    }

    public static void postUser() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://bigml.io/andromeda/prediction?username=carlostorres;api_key=7b3ceb203b49b389fcb9ab8de134d7bedcad5b63");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            String json = "{\n" +
                    "    \"model\": \"logisticregression/5f235a90ace11f5cf10035ce\",\n" +
                    "    \"input_data\" : {\n" +
                    "        \"age\": 120,\n" +
                    "        \"anaemia\": 1,\n" +
                    "        \"creatinine_phosphokinase\": 610,\n" +
                    "        \"diabetes\": 0,\n" +
                    "        \"ejection_fraction\": 38,\n" +
                    "        \"high_blood_pressure\": 0,\n" +
                    "        \"platelets\": 10000,\n" +
                    "        \"serum_creatinine\": 20,\n" +
                    "        \"serum_sodium\": 136,\n" +
                    "        \"sex\": 0,\n" +
                    "        \"smoking\": 0\n" +
                    "    }\n" +
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            System.out.println("Lo que envio "+ stringEntity);
            httpPost.setEntity(stringEntity);

            System.out.println("Request Ejecuta:D " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                HttpEntity entity = response.getEntity();
                System.out.println(":D "+entity);
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        }
    }
}
