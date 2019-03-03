/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfounding;

import java.util.ArrayList;
/**
 *
 * @author juamayas
 */
public class Manager {
    private ArrayList<Auction> auction;
    private ArrayList<Contributor> contributors;
    private  ArrayList<Promoter> promoter;

    public Manager(ArrayList<Contributor> contributors, ArrayList<Promoter> promoter){
        this.auction = new ArrayList();
        this.contributors = contributors;
        this.promoter = promoter;
    }
    

    public ArrayList<Auction> getAuction() {
        return auction;
    }

    public ArrayList<Contributor> getContributors() {
        return contributors;
    }

    public ArrayList<Promoter> getPromoter() {
        return promoter;
    }
    
}
