package com.example.nadeemchaudhary.savadata;

public class Computer {

    private int ID;
    private String ComputerName,ComputerType;

    public Computer(){
        super();
    }
    public Computer(int ID,String ComputerName,String ComputerType){
        this.ID=ID;
        this.ComputerName=ComputerName;
        this.ComputerType=ComputerType;
    }
    public Computer(String ComputerName,String ComputerType){
        this.ComputerName=ComputerName;
        this.ComputerType=ComputerType;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getComputerName() {
        return ComputerName;
    }

    public void setComputerName(String computerName) {
        ComputerName = computerName;
    }

    public String getComputerType() {
        return ComputerType;
    }

    public void setComputerType(String computerType) {
        ComputerType = computerType;
    }
}
