package com.vallegrande.bigml.controller;

import com.vallegrande.bigml.model.Model;
import com.vallegrande.bigml.services.Conexion;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin({"*"})
@RestController
public class Demo {

    private final Conexion conexion = new Conexion();

    @PostMapping("/add")
    public String save(@RequestBody Model model) throws IOException {

        /*Estructura de Json*/
        String json = "{\n" +
                "    \"model\": \"logisticregression/5f24ad002fb31c2967005efa\",\n" +
                "    \"input_data\" : {\n" +
                "        \"age\":  "+ model.getAge() +" ,\n" +
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

        /*Retonarmos la respuesta de la conexion*/
        return conexion.conectar(json);
    }
}
