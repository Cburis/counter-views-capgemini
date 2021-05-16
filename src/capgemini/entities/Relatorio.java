package capgemini.entities;

public class Relatorio {

    private Anuncio anuncio;
    private int views = 0;
    private int click = 0;
    private int shares = 0;
    private int periodo = 0;
    private double valorTotalInvestido;



    public Relatorio(Anuncio anuncio) {
        this.anuncio = anuncio;

        valorTotalInvestido = anuncio.getInvestimento() * anuncio.getPeriodo();
        views = (int)valorTotalInvestido * 30;
        int viewsTotal = 0;
        for (int i = 0; i < 3; i++) {
            double quantidadeDeClick = views * 12 / 100;
            click += quantidadeDeClick;
            int quantidadeCompartilhamento = (int) quantidadeDeClick * 15 / 100;
            shares += quantidadeCompartilhamento;
            int viewsCompartilhamento = quantidadeCompartilhamento * 40;
            views += viewsCompartilhamento;
        }

    }

    public int getViews() {
        return views;
    }

    public int getClick() {
        return click;
    }

    public int getShares() {
        return shares;
    }

    public int getPeriodo() {
        return periodo;
    }

    @Override
    public String toString() {
        return

                "******************************************* " +anuncio.getNome()+  " *******************************************\n" +
                "Total aproximado de views : " + views +
                "\n Total aproximado de click : " + click +
                "\n Total aproximado de compartilhamentos : " + shares +
                "\n Valor total investido : " + valorTotalInvestido +
                "\n*******************************************************************************************************************";

    }
}
