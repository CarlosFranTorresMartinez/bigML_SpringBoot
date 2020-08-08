package controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import model.Model;
import services.Services;

@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable{
    
    private final Services services;
    private Model model;
    
    public Controller() {
        model = new Model();
        services = new Services();
    }
    
    public void obtenerDatos() throws IOException, InterruptedException {
        String a = services.datosAPI(model);   
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject) jsonParser.parse(a);
        model = new Model();
        model.setCategory(jsonObject.get("output").getAsInt());
        model.setProbability(jsonObject.get("probability").getAsDouble());
        if(model.getCategory() == 1) {
            model.setResult("Lo sentimos, de acuerdo a tus antecedentes nuestro algoritmo nos dice que existe una probabilidad de que mueras :(");
        } else {
            model.setResult("Que bien, sigue disfrutando de la vida");
        }
    }
    
    public Model getModel() {
        return model;
    }
    
    public void setModel(Model model) {
        this.model = model;
    }
    
}
