package com.example.user.myassignment73;


public class Employee {
    private int id;
    private String name;
    private byte[] photo;
    private int age;


    public Employee(String name, int age, byte[] photo){
        this.name=name;
        this.age=age;
        this.photo=photo;
    }

    public Employee(int id, String name, int age, byte[] photo){
        this.id=id;
        this.name=name;
        this.age=age;
        this.photo=photo;

    }

    public  int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public int getAge(int age){
        return age;
    }

    public byte[] getPhoto(){
        return  photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}

