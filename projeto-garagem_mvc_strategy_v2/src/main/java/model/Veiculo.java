package model;
import strategy.MovimentoStrategy;

public abstract class Veiculo {
    private final String marca, modelo;
    private final int ano;
    private final double peso, velocidadeMaxima;
    private double velocidadeAtual;
    private final Matricula matricula;
    private MovimentoStrategy movimentoStrategy;

    protected Veiculo(String marca,String modelo,int ano,double peso,double velocidadeMaxima,Matricula matricula){
        this.marca=marca; this.modelo=modelo; this.ano=ano; this.peso=peso; this.velocidadeMaxima=velocidadeMaxima; this.matricula=matricula;
    }
    public String getMarca(){return marca;} public String getModelo(){return modelo;} public int getAno(){return ano;}
    public double getPeso(){return peso;} public double getVelocidadeMaxima(){return velocidadeMaxima;}
    public double getVelocidadeAtual(){return velocidadeAtual;} public Matricula getMatricula(){return matricula;}
    public void acelerar(double q){velocidadeAtual=Math.min(velocidadeAtual+q,velocidadeMaxima);}
    public void travar(double q){velocidadeAtual=Math.max(velocidadeAtual-q,0);}
    public void setMovimentoStrategy(MovimentoStrategy s){if(s==null) throw new IllegalArgumentException("A estratégia não pode ser nula."); movimentoStrategy=s;}
    protected MovimentoStrategy getMovimentoStrategy(){return movimentoStrategy;}
    public abstract void mover();
    @Override public String toString(){return getClass().getSimpleName()+" - "+marca+" "+modelo+" | Matrícula: "+matricula;}
}
