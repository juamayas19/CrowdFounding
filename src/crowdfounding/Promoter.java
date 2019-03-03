/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfounding;

/**
 *
 * @author juamayas
 */
public class Promoter extends Person {
   private double Monto;
   private double inte_demand;
   private double time_demand;
   private double Final_demand;
    public Promoter(double Monto, double inte_demand, double time_demand, String Name, int Age, String id) {
        super(Name, Age, id);
        this.Monto = Monto;
        this.inte_demand = inte_demand;
        this.time_demand = time_demand;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public void setInte_demand(int inte_demand) {
        this.inte_demand = inte_demand;
    }

    public void setTime_demand(int time_demand) {
        this.time_demand = time_demand;
    }
    public double getFinal_demand(){
        return (this.inte_demand*0.7)+(this.time_demand*0.3);
    }
    public void setFinal_demand(double Final_demand){
        this.Final_demand=Final_demand;
    }
    public double getInte_demand() {
        return inte_demand;
    }

    public double getTime_demand() {
        return time_demand;
    }
   
    
    public double getMonto() {
        return Monto;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getId() {
        return id;
    }
   
}

