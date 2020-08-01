package com.vallegrande.bigml.model;

public class Model {
    private String model;
    private int age;
    private int anaemia;
    private int creatinine_phosphokinase;
    private int diabetes;
    private int ejection_fraction;
    private int high_blood_pressure;
    private int platelets;
    private int serum_creatinine;
    private int serum_sodium;
    private int sex;
    private int smoking;

    public Model(String model, int age, int anaemia, int creatinine_phosphokinase, int diabetes, int ejection_fraction, int high_blood_pressure, int platelets, int serum_creatinine, int serum_sodium, int sex, int smoking) {
        this.model = model;
        this.age = age;
        this.anaemia = anaemia;
        this.creatinine_phosphokinase = creatinine_phosphokinase;
        this.diabetes = diabetes;
        this.ejection_fraction = ejection_fraction;
        this.high_blood_pressure = high_blood_pressure;
        this.platelets = platelets;
        this.serum_creatinine = serum_creatinine;
        this.serum_sodium = serum_sodium;
        this.sex = sex;
        this.smoking = smoking;
    }

    public Model() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnaemia() {
        return anaemia;
    }

    public void setAnaemia(int anaemia) {
        this.anaemia = anaemia;
    }

    public int getCreatinine_phosphokinase() {
        return creatinine_phosphokinase;
    }

    public void setCreatinine_phosphokinase(int creatinine_phosphokinase) {
        this.creatinine_phosphokinase = creatinine_phosphokinase;
    }

    public int getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(int diabetes) {
        this.diabetes = diabetes;
    }

    public int getEjection_fraction() {
        return ejection_fraction;
    }

    public void setEjection_fraction(int ejection_fraction) {
        this.ejection_fraction = ejection_fraction;
    }

    public int getHigh_blood_pressure() {
        return high_blood_pressure;
    }

    public void setHigh_blood_pressure(int high_blood_pressure) {
        this.high_blood_pressure = high_blood_pressure;
    }

    public int getPlatelets() {
        return platelets;
    }

    public void setPlatelets(int platelets) {
        this.platelets = platelets;
    }

    public int getSerum_creatinine() {
        return serum_creatinine;
    }

    public void setSerum_creatinine(int serum_creatinine) {
        this.serum_creatinine = serum_creatinine;
    }

    public int getSerum_sodium() {
        return serum_sodium;
    }

    public void setSerum_sodium(int serum_sodium) {
        this.serum_sodium = serum_sodium;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSmoking() {
        return smoking;
    }

    public void setSmoking(int smoking) {
        this.smoking = smoking;
    }

    @Override
    public String toString() {
        return "Model{" +
                "model='" + model + '\'' +
                ", age=" + age +
                ", anaemia=" + anaemia +
                ", creatinine_phosphokinase=" + creatinine_phosphokinase +
                ", diabetes=" + diabetes +
                ", ejection_fraction=" + ejection_fraction +
                ", high_blood_pressure=" + high_blood_pressure +
                ", platelets=" + platelets +
                ", serum_creatinine=" + serum_creatinine +
                ", serum_sodium=" + serum_sodium +
                ", sex=" + sex +
                ", smoking=" + smoking +
                '}';
    }
}
