package capgemini.entities;

import java.util.Date;

public class Anuncio {

    private String nome;
    private String cliente;
    private Date dataIncio;
    private Date dataFim;
    private double investimento;


    public Anuncio(String nome, String cliente, Date dataIncio, Date dataFim, double investimento) {
        this.nome = nome;
        this.cliente = cliente;
        this.dataIncio = dataIncio;
        this.dataFim = dataFim;
        this.investimento = investimento;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDataIncio() {
        return dataIncio;
    }

    public void setDataIncio(Date dataIncio) {
        this.dataIncio = dataIncio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }


    public int getPeriodo(){

        long diff = dataFim.getTime() - dataIncio.getTime();
        long diffHours = diff / (60 * 60 * 1000);
        int diffDays = (int) (diffHours/24);
        return diffDays;
    }

}
