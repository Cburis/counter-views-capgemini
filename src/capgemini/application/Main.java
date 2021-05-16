package capgemini.application;

import capgemini.entities.Anuncio;
import capgemini.entities.GerenciadorAnuncio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Services services = new Services();
        Scanner scan = new Scanner(System.in);

        int numDigitado = -1;
        while (numDigitado != 0) {
            System.out.println("Para cadastrar anuncio tecle '1' caso queira consultar relatorio tecle: '2' ");
            System.out.println("Para sair do programa digite '0' ");
            numDigitado = scan.nextInt();

            if (numDigitado == 1) {
                services.criarAnuncio();
            } else if (numDigitado == 2) {
                services.controleRelatorio();
            }else if(numDigitado  != 1 && numDigitado  != 2 && numDigitado  != 0){
                System.out.println("A opçao digitada é invalida");
            }else if(numDigitado == 0){
                System.out.println("Muito Obrigado, até um proximo dia!");
            }


        }






        scan.close();




    }

}
