package com.vallegrande.bigml.controller;

import com.vallegrande.bigml.model.Model;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Demo {
    private Model model = new Model();

    @PostMapping("/add")
    public String save() throws IOException {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://bigml.io/andromeda/prediction?username=bryanbenavente;api_key=6bdd6d1dbf8ac8a270e56896062c3083555bfcc8");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            String json = "{\n" +
                    "    \"model\": \"logisticregression/5f24ad002fb31c2967005efa\",\n" +
                    "    \"input_data\" : {\n" +
                    "        \"age\": " + model.getAge() + ",\n" +
                    "        \"anaemia\": " + model.getAnaemia() + ",\n" +
                    "        \"creatinine_phosphokinase\": " + model.getCreatinine_phosphokinase() + ",\n" +
                    "        \"diabetes\": " + model.getDiabetes() + ",\n" +
                    "        \"ejection_fraction\": " + model.getEjection_fraction() + ",\n" +
                    "        \"high_blood_pressure\": " + model.getHigh_blood_pressure() + ",\n" +
                    "        \"platelets\": " + model.getPlatelets() + ",\n" +
                    "        \"serum_creatinine\": " + model.getSerum_creatinine() + ",\n" +
                    "        \"serum_sodium\": " + model.getSerum_sodium() + ",\n" +
                    "        \"sex\": " + model.getSex() + ",\n" +
                    "        \"smoking\": " + model.getSmoking() + "\n" +
                    "    }\n" +
                    "}";
            StringEntity stringEntity = new StringEntity(json);
            httpPost.setEntity(stringEntity);

            System.out.println("Request Ejecuta:D " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    System.out.println(":D " + entity);
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            return responseBody;
        }

    }
}
