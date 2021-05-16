package capgemini.application;

import capgemini.entities.Anuncio;
import capgemini.entities.GerenciadorAnuncio;
import capgemini.entities.Relatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Services {
    private GerenciadorAnuncio gerenciadorAnuncio;

    public Services() {
        this.gerenciadorAnuncio = new GerenciadorAnuncio();
    }

    public void criarAnuncio() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();

        System.out.println("Digite o nome do anuncio: ");
        String nomeAnuncio = sc.nextLine();

        System.out.println("Digite a data de inicio, neste formato 'dd/MM/yyyy': ");
        String dataIncio = sc.nextLine();

        System.out.println("Digite a data do final, neste formato 'dd/MM/yyyy': ");
        String dataFim = sc.nextLine();

        System.out.println("Digite o valor que será investido por dia no anuncio: ");
        double valorInvestido = sc.nextDouble();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Date inicio = null;
        Date fim = null;
        try {
            inicio = format.parse(dataIncio);
            fim = format.parse(dataFim);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Anuncio novoAnuncio = new Anuncio(nomeAnuncio, nomeCliente, inicio, fim, valorInvestido);

        gerenciadorAnuncio.addAnuncio(novoAnuncio);
    }

    public void getRelatorios(List<Anuncio> anuncios){
        ArrayList<Relatorio> relatorios = new ArrayList<>();
        anuncios.stream().forEach(anuncio -> relatorios.add(new Relatorio(anuncio)) );
        for (Relatorio relatorio:
             relatorios) {
            System.out.println(relatorio);
        }



    }

    public void controleRelatorio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o período do relatorio, caso queira um periodo especifico, caso contrario aperte enter: ");
        System.out.println();

        System.out.println("Digite a data inicio, neste formato 'dd/MM/yyyy':");
        String dateIni = sc.nextLine();
        System.out.println("Digite a data final, neste formato 'dd/MM/yyyy':");
        String dateFin = sc.nextLine();

        ArrayList<Anuncio> anunciosPorPeriodo = new ArrayList<>();
        if (!dateIni.isEmpty() || !dateIni.isEmpty()){

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Date inicio = null;
            Date fim = null;
            try {
                inicio = format.parse(dateIni);
                fim = format.parse(dateFin);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            for (Anuncio anuncio:
                    gerenciadorAnuncio.listarAnuncio()) {
                if (anuncio.getDataIncio().getTime()>=inicio.getTime() && anuncio.getDataFim().getTime()<=fim.getTime()){
                    anunciosPorPeriodo.add(anuncio);

                }
            }

        }else{
            anunciosPorPeriodo.addAll(gerenciadorAnuncio.listarAnuncio());
        }


        System.out.println("Digite o nome do Cliente");
        String nomeCliente = sc.nextLine();
        ArrayList<Anuncio> anunciosPorCliente = new ArrayList<>();
        if(!nomeCliente.isEmpty()){
            for (Anuncio anuncio:
                    anunciosPorPeriodo ) {
                if (anuncio.getCliente().equalsIgnoreCase(nomeCliente)) {
                    anunciosPorCliente.add(anuncio);
                }
            }
        }else{
            anunciosPorCliente.addAll(anunciosPorPeriodo);
        }

        if (anunciosPorCliente.size()>0){
            if ((!dateIni.isEmpty() || !dateIni.isEmpty()) && !nomeCliente.isEmpty() ){
                System.out.println("\n Todos relarios com a data "+dateIni + " até a data " + dateFin+ " pertencente a,  " + nomeCliente);
            }
            else if(!dateIni.isEmpty() || !dateIni.isEmpty()){
                System.out.println("\n Todos relarios com a data "+dateIni + " até a data " + dateFin);
            }
            else if(!nomeCliente.isEmpty()){
                System.out.println("\n Todos relarios pertencente a,  " + nomeCliente);
            }
        }else{
            System.out.println("Anuncio não encontrado!");
        }
        getRelatorios(anunciosPorCliente);

    }
}