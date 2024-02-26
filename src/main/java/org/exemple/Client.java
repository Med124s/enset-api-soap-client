package org.exemple;

import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        System.out.println("Conversion: "+proxy.convertionEuroToDh(11)+"dh");
        System.out.println("\n------Get Account By Code --------\n");
        Compte cp = proxy.getCompte(101);
        System.out.println("Code: "+cp.getCode());
        System.out.println("Solde: "+cp.getSolde());
        System.out.println("DateCreation: "+cp.getDateCreation());

        List<Compte>comptes = proxy.listComptes();
        System.out.println("\n-------List Accounts-----\n");

        for (Compte compte:comptes){
            System.out.println("code:"+compte.getCode());
            System.out.println("solde:"+compte.getSolde());
            System.out.println("dateCreation:"+compte.getDateCreation());
            System.out.println("------------");

        }


    }
}
