/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfounding;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Juan Camilo
 */
public class Auction {
    private String id;
    private double substraction;
    private double Monto_Solicitado;
    private double Min_Final_Offer;
    private String Winner;
    private String Promoter;
    private double Final_static_demand;
    private double Final_winner_offer;

    public Auction(String id, double substraction, double Min_Final_Offer, String Promoter, double Monto_Solicitado, double Final_static_demand) {
        this.Min_Final_Offer=Min_Final_Offer;
        this.id = id;
        this.substraction = substraction;
        this.Promoter = Promoter;
        this.Monto_Solicitado= Monto_Solicitado;
        this.Final_static_demand=Final_static_demand;
    }

    public double getMonto_Solicitado() {
        return Monto_Solicitado;
    }

    public void setFinal_winner_offer(double Final_winner_offer) {
        this.Final_winner_offer = Final_winner_offer;
    }
    
    public String getId() {
        return id;
    }

    public double getSubstraction() {
        return substraction;
    }

    public String getWinner() {
        return Winner;
    }

    public double getFinal_winner_offer() {
        return Final_winner_offer;
    }
    

    public String getPromoter() {
        return Promoter;
    }

    public double getFinal_static_demand() {
        return Final_static_demand;
    }
    
    public void setSubstraction(int substraction) {
        this.substraction = substraction;
    }

    public void setMin_Final_Offer(int Min_Final_Offer) {
        this.Min_Final_Offer = Min_Final_Offer;
    }

    public void setWinner (String Winner) {
        this.Winner = Winner;
    }
    
    
    }

