package view;

import model.Garagem;
import model.Veiculo;

public class GaragemView {

    public void mostrarGaragem(Garagem garagem) {
        System.out.println("===== GARAGEM =====");
        System.out.println(
                "Ocupação: "
                        + garagem.getNumeroVeiculos()
                        + "/"
                        + garagem.getCapacidade()
        );

        if (garagem.estaVazia()) {
            System.out.println("A garagem está vazia.");
            return;
        }

        for (int i = 0; i < garagem.getVeiculos().size(); i++) {
            Veiculo veiculo = garagem.getVeiculos().get(i);
            System.out.println((i + 1) + ". " + veiculo);
        }
    }

    public void mostrarResultado(boolean sucesso, String operacao) {
        if (sucesso) {
            System.out.println(operacao + " realizada com sucesso.");
        } else {
            System.out.println("Não foi possível realizar: " + operacao + ".");
        }
    }
}
