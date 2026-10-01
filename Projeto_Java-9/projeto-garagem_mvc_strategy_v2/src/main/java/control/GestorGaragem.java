package control;
import model.Garagem;
import model.Veiculo;
import repository.GaragemRepository;
import java.util.List;

public class GestorGaragem {
    private final Garagem garagem; private final GaragemRepository repository;
    public GestorGaragem(Garagem garagem){if(garagem==null)throw new IllegalArgumentException("A garagem não pode ser nula.");this.garagem=garagem;this.repository=new GaragemRepository();}
    public Garagem getGaragem(){return garagem;}
    public boolean adicionarVeiculo(Veiculo v){return garagem.entrar(v);}
    public boolean removerVeiculo(Veiculo v){return garagem.sair(v);}
    public boolean podeAdicionar(Veiculo v){return garagem.podeEntrar(v);}
    public List<Veiculo> consultarVeiculos(){return repository.buscarTodos();}
    public void carregarGaragemDaBaseDeDados(){for(Veiculo v:repository.buscarTodos())garagem.entrar(v);}
}
