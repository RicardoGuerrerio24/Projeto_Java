package model;
import strategy.MovimentoMota;
public class Mota extends Veiculo {
    private final int cilindrada;
    public Mota(String marca,String modelo,int ano,double peso,double velocidadeMaxima,Matricula matricula,int cilindrada){
        super(marca,modelo,ano,peso,velocidadeMaxima,matricula); this.cilindrada=cilindrada; setMovimentoStrategy(new MovimentoMota());
    }
    public int getCilindrada(){return cilindrada;}
    @Override public void mover(){getMovimentoStrategy().mover(this);}
}
