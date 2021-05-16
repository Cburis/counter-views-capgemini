package capgemini.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GerenciadorAnuncio {

    List<Anuncio> list;

    public GerenciadorAnuncio() {
        this.list = new ArrayList<>();
    }

    public GerenciadorAnuncio(List<Anuncio> list) {
        this.list = list;
    }

    public void addAnuncio(Anuncio anuncio ) {
        list.add(anuncio);
    }

    public List<Anuncio> procuraAnuncio(String nome){
        return list.stream().filter(anuncio -> anuncio.getCliente() == nome).collect(Collectors.toList());
    }

    public List<Anuncio>listarAnuncio(){
        return list;
    }



}
