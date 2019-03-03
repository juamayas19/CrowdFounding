/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdfounding;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author juamayas
 */
public class CrowdFounding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
    }
    public void DoAuction(Manager manager, String id) throws IOException{
        Promoter promoter= new Promoter(manager.getPromoter().get(0).getMonto(),manager.getPromoter().get(0).getInte_demand(), manager.getPromoter().get(0).getTime_demand(), manager.getPromoter().get(0).getName(),manager.getPromoter().get(0).getAge(), manager.getPromoter().get(0).getId());
        double Min_Final_Offer=promoter.getFinal_demand()*0.5;
        double substraction = promoter.getMonto()*0.05;
        Auction auction = new Auction(id, substraction, Min_Final_Offer, manager.getPromoter().get(0).getName(),promoter.getMonto(), promoter.getFinal_demand());
        for (int i = 0; i < manager.getContributors().size(); i++) {
            
            if(promoter.getFinal_demand()<manager.getContributors().get(i).getFinal_Offer()&& promoter.getFinal_demand()>=Min_Final_Offer){
                promoter.setFinal_demand(manager.getContributors().get(i).getFinal_Offer());
                auction.setWinner(manager.getContributors().get(i).getName());
                auction.setFinal_winner_offer(manager.getContributors().get(i).getFinal_Offer());
            }else if(promoter.getFinal_demand()-substraction>=Min_Final_Offer){
                promoter.setFinal_demand(promoter.getFinal_demand()-substraction);
            }else{
                auction.setWinner("Nobody accepts the demand");
            }
            manager.getAuction().add(auction);
        }
        
    }
    public static void writeAuction(Auction auction) throws FileNotFoundException {
        PrintStream in = new PrintStream("Auction.txt");
        try{
        
        in.println("Winner: "
                + auction.getWinner()
                + ";"
                + "Promoter: "
                + auction.getPromoter()
                + ";"
                + "id: "
                + auction.getId()
                + ";"
                + "Monto solicitado: "
                + auction.getMonto_Solicitado()
                + ";"
                + "Monto inicial: "
                + auction.getFinal_static_demand()
                + ";"
                + "Oferta Recibida: "
                + auction.getFinal_winner_offer()
                + ";"
                        + "Substraction"
                        + auction.getSubstraction()
                        + ";"
        );
        
        
        } catch (Exception e){
            System.out.println("Error");
        }
        finally {
                in.close();
            }
    }
    public static void writePromoter(Promoter promoter) throws FileNotFoundException {
        PrintStream in = new PrintStream("Promoters.txt");
        try{
        
        in.println("Nombre: "
                + promoter.getName()
                + ";"
                + "id: "
                + promoter.getId()
                + ";"
                + "Edad: "
                + promoter.getAge()
                + ";"
                + "Monto: "
                + promoter.getMonto()
                + ";"
                + "Demanda Intereses: "
                + promoter.getInte_demand()
                + ";"
                        + "Demanda Tiempo: "
                        + promoter.getTime_demand()
                        + ";"
                );
        
        
        } catch (Exception e){
            System.out.println("Error");
        }
        finally {
                in.close();
            }
    }
    public static void writeContributor(Contributor contributor) throws FileNotFoundException {
        PrintStream in = new PrintStream("Contributors.txt");
        try{
        
        in.println("Nombre: "
                + contributor.getName()
                + ";"
                + "id: "
                + contributor.getId()
                + ";"
                + "Edad: "
                + contributor.getAge()
                + ";"
                + "Oferta Intereses: "
                + contributor.getInterest_Offer()
                + ";"
                        + "Oferta Tiempo: "
                        + contributor.getTime_Offer()
                        + ";"
                );
        
        
        } catch (Exception e){
            System.out.println("Error");
        }
        finally {
                in.close();
            }
    }
    public static void readAuction(Manager manager) throws FileNotFoundException{
        Scanner in = new Scanner(new File("Auction.txt"));
        in.useDelimiter(";");
        double substraction=0, Min_Final_Offer=0, Monto_Solicitado=0,Final_static_demand=0; 
        String Promoter= null, Winner=null, id=null;
        if(in.hasNextLine()){
            in.nextLine();
            if (in.hasNext()){
                in.next();
                Winner = in.next();
                Promoter= in.next();
                id = in.next();
                Monto_Solicitado = Double.parseDouble(in.next());
                Final_static_demand= Double.parseDouble(in.next());
                Min_Final_Offer= Double.parseDouble(in.next());
                substraction = Double.parseDouble(in.next());
                manager.getAuction().add(new Auction(id,substraction,Min_Final_Offer,Promoter,Monto_Solicitado,Final_static_demand));
            }
            
    }
        in.close();
    }
    public static ArrayList<Contributor> readContributors() throws FileNotFoundException{
        ArrayList<Contributor> contributors = new ArrayList();
        Scanner in = new Scanner(new File("Contributors.txt"));
        in.useDelimiter(";");
        double Interest_Offer=0, Time_Offer=0;
        String Name=null, id=null;
        int Age=0;
        if(in.hasNextLine()){
            in.nextLine();
            if(in.hasNext()){
                in.next();
                Name=in.next();
                id=in.next();
                Age=Integer.parseInt(in.next());
                Interest_Offer= Double.parseDouble(in.next());
                Time_Offer= Double.parseDouble(in.next());
                contributors.add(new Contributor(Interest_Offer,Time_Offer, Name, Age,id));
            }
        }
        return contributors;
    }
    public static ArrayList<Promoter> readPromoters() throws FileNotFoundException{
        ArrayList<Promoter> promoters = new ArrayList();
        Scanner in = new Scanner(new File("Promoters.txt"));
        in.useDelimiter(";");
        double Interest_Offer=0, Time_Offer=0, Monto=0;
        String Name=null, id=null;
        int Age=0;
        if(in.hasNextLine()){
            in.nextLine();
            if(in.hasNext()){
                in.next();
                Name=in.next();
                id=in.next();
                Age=Integer.parseInt(in.next());
                Monto=Double.parseDouble(in.next());
                Interest_Offer= Double.parseDouble(in.next());
                Time_Offer= Double.parseDouble(in.next());
                promoters.add(new Promoter(Monto,Interest_Offer,Time_Offer, Name, Age,id));
            }
        }
        return promoters;
    }
}
