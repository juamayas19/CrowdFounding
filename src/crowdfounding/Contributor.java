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
public class Contributor extends Person{
    private double Interest_Offer;
    private double Time_Offer;
    private double Final_Offer;

    public Contributor(double Interest_Offer, double Time_Offer, String Name, int Age, String id) {
        super(Name, Age, id);
        this.Interest_Offer = Interest_Offer;
        this.Time_Offer = Time_Offer;
        this.Final_Offer = 0;
    }

    public double getInterest_Offer() {
        return Interest_Offer;
    }
    public double getFinal_Offer(){
        return (this.Interest_Offer*0.7)+(this.Time_Offer*0.3);
    }
    public double getTime_Offer() {
        return Time_Offer;
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
