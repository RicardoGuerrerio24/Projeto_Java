package view;
import model.*;
public class GaragemView {
    public void mostrarGaragem(Garagem g){
        System.out.println("===== GARAGEM =====");
        System.out.println("Ocupação: "+g.getNumeroVeiculos()+"/"+g.getCapacidade());
        if(g.estaVazia()){System.out.println("A garagem está vazia.");return;}
        for(int i=0;i<g.getVeiculos().size();i++)System.out.println((i+1)+". "+g.getVeiculos().get(i));
    }
}
