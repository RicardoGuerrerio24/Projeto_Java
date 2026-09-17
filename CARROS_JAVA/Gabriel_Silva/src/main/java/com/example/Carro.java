public class Carro {

    // ==========================================
    // CARACTERÍSTICAS DO CARRO
    // ==========================================

    private String marca;
    private String modelo;
    private int ano;

    private double peso;
    private double comprimento;
    private double largura;
    private double altura;

    private double velocidadeMaxima;
    private double velocidadeAtual;

    // Sistemas do carro
    private Motor motor;
    private SistemaArrefecimento arrefecimento;
    private SistemaCombustivel combustivel;
    private SistemaEletrico sistemaEletrico;
    private SistemaTravagem travagem;
    private Pneus pneus;


    // ==========================================
    // CONSTRUTOR
    // ==========================================

    public Carro(
            String marca,
            String modelo,
            int ano,
            double peso,
            double comprimento,
            double largura,
            double altura,
            double velocidadeMaxima) {

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;

        this.peso = peso;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;

        this.velocidadeMaxima = velocidadeMaxima;
        this.velocidadeAtual = 0;

        this.motor = new Motor();
        this.arrefecimento = new SistemaArrefecimento();
        this.combustivel = new SistemaCombustivel();
        this.sistemaEletrico = new SistemaEletrico();
        this.travagem = new SistemaTravagem();
        this.pneus = new Pneus();
    }


    // ==========================================
    // FUNCIONAMENTO AUTOMÁTICO
    // ==========================================

    public void atualizar() {

        motor.atualizar();
        arrefecimento.controlar(motor);
        sistemaEletrico.atualizar();
        travagem.atualizar();
        pneus.atualizar();

        // Se o carro estiver parado, a velocidade mantém-se a zero.
        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }
    }


    // ==========================================
    // MÉTODOS DE ACESSO
    // ==========================================

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPeso() {
        return peso;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }


    // ==========================================
    // MÉTODOS PARA O CONDUTOR
    // ==========================================
    //
    // Estes métodos não são public.
    // Só podem ser utilizados dentro do mesmo package.
    //
    // A ideia é que o Condutor seja responsável
    // por chamar estas ações.
    // ==========================================

    void ligar() {

        if (motor.estaLigado()) {
            System.out.println("O carro já está ligado.");
            return;
        }

        if (!combustivel.temCombustivel()) {
            System.out.println("Não é possível ligar: combustível insuficiente.");
            return;
        }

        if (!sistemaEletrico.temEnergia()) {
            System.out.println("Não é possível ligar: bateria sem energia.");
            return;
        }

        motor.ligar();

        System.out.println("O carro foi ligado.");
    }


    void desligar() {

        if (!motor.estaLigado()) {
            System.out.println("O carro já está desligado.");
            return;
        }

        if (velocidadeAtual > 0) {
            System.out.println(
                    "Não é possível desligar o carro enquanto está em movimento."
            );
            return;
        }

        motor.desligar();

        System.out.println("O carro foi desligado.");
    }


    void acelerar(double quantidade) {

        if (!motor.estaLigado()) {
            System.out.println("Não é possível acelerar: o carro está desligado.");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("A aceleração tem de ser superior a zero.");
            return;
        }

        velocidadeAtual += quantidade;

        if (velocidadeAtual > velocidadeMaxima) {
            velocidadeAtual = velocidadeMaxima;
        }

        combustivel.consumir(quantidade);
        motor.aumentarDesgaste();

        System.out.println(
                "O carro acelerou. Velocidade atual: "
                        + velocidadeAtual + " km/h"
        );
    }


    void travar(double quantidade) {

        if (quantidade <= 0) {
            System.out.println("A travagem tem de ser superior a zero.");
            return;
        }

        velocidadeAtual -= quantidade;

        if (velocidadeAtual < 0) {
            velocidadeAtual = 0;
        }

        travagem.usar(quantidade);

        System.out.println(
                "O carro travou. Velocidade atual: "
                        + velocidadeAtual + " km/h"
        );
    }


    void buzinar() {

        System.out.println("BEEP BEEP!");
    }


    // ==========================================
    // MOTOR
    // ==========================================

    public class Motor {

        private boolean ligado;

        private double temperatura;
        private final double TEMPERATURA_NORMAL = 90;
        private final double TEMPERATURA_MAXIMA = 120;

        private double oleo;
        private double desgaste;


        private Motor() {

            ligado = false;

            temperatura = 20;
            oleo = 100;
            desgaste = 0;
        }


        private void ligar() {

            ligado = true;
            temperatura = 70;
        }


        private void desligar() {

            ligado = false;
        }


        private void atualizar() {

            if (ligado) {

                // O motor aquece enquanto funciona.
                temperatura += 0.5;

                aumentarDesgaste();
            }
            else {

                // Um motor desligado arrefece naturalmente.
                if (temperatura > 20) {
                    temperatura -= 0.3;
                }
            }
        }


        private void aumentarDesgaste() {

            desgaste += 0.001;

            if (desgaste > 100) {
                desgaste = 100;
            }
        }


        private boolean estaLigado() {
            return ligado;
        }


        private boolean estaSobreaquecido() {
            return temperatura >= TEMPERATURA_MAXIMA;
        }


        public double getTemperatura() {
            return temperatura;
        }


        public double getOleo() {
            return oleo;
        }


        public double getDesgaste() {
            return desgaste;
        }
    }


    // ==========================================
    // SISTEMA DE ARREFECIMENTO
    // ==========================================

    public class SistemaArrefecimento {

        private boolean ventoinhaLigada;
        private double nivelLiquido;


        private SistemaArrefecimento() {

            ventoinhaLigada = false;
            nivelLiquido = 100;
        }


        private void controlar(Motor motor) {

            if (motor.getTemperatura() >= 95) {
                ventoinhaLigada = true;
            }

            if (motor.getTemperatura() <= 85) {
                ventoinhaLigada = false;
            }

            if (ventoinhaLigada) {
                motor.temperatura -= 1.0;
            }
        }


        public boolean isVentoinhaLigada() {
            return ventoinhaLigada;
        }


        public double getNivelLiquido() {
            return nivelLiquido;
        }
    }


    // ==========================================
    // SISTEMA DE COMBUSTÍVEL
    // ==========================================

    public class SistemaCombustivel {

        private final double CAPACIDADE = 50;

        private double quantidade;


        private SistemaCombustivel() {

            quantidade = CAPACIDADE;
        }


        private boolean temCombustivel() {

            return quantidade > 0;
        }


        private void consumir(double quantidade) {

            this.quantidade -= quantidade * 0.01;

            if (this.quantidade < 0) {
                this.quantidade = 0;
            }
        }


        public double getQuantidade() {

            return quantidade;
        }


        public double getCapacidade() {

            return CAPACIDADE;
        }


        public boolean estaNaReserva() {

            return quantidade <= CAPACIDADE * 0.15;
        }


        public boolean estaVazio() {

            return quantidade <= 0;
        }
    }


    // ==========================================
    // SISTEMA ELÉTRICO
    // ==========================================

    public class SistemaEletrico {

        private double bateria;
        private double voltagem;


        private SistemaEletrico() {

            bateria = 100;
            voltagem = 12;
        }


        private boolean temEnergia() {

            return bateria > 0;
        }


        private void atualizar() {

            if (motor.estaLigado() && bateria < 100) {
                bateria += 0.1;
            }

            if (bateria > 100) {
                bateria = 100;
            }
        }


        public double getBateria() {

            return bateria;
        }


        public double getVoltagem() {

            return voltagem;
        }
    }


    // ==========================================
    // SISTEMA DE TRAVAGEM
    // ==========================================

    public class SistemaTravagem {

        private double temperatura;
        private double desgaste;


        private SistemaTravagem() {

            temperatura = 20;
            desgaste = 0;
        }


        private void usar(double intensidade) {

            temperatura += intensidade * 0.5;
            desgaste += intensidade * 0.001;

            if (desgaste > 100) {
                desgaste = 100;
            }
        }


        private void atualizar() {

            if (temperatura > 20) {
                temperatura -= 0.5;
            }

            if (temperatura < 20) {
                temperatura = 20;
            }
        }


        public double getTemperatura() {

            return temperatura;
        }


        public double getDesgaste() {

            return desgaste;
        }
    }


    // ==========================================
    // PNEUS
    // ==========================================

    public class Pneus {

        private double pressaoDianteira;
        private double pressaoTraseira;

        private double desgaste;


        private Pneus() {

            pressaoDianteira = 2.2;
            pressaoTraseira = 2.2;

            desgaste = 0;
        }


        private void atualizar() {

            // Pequena perda natural de pressão.
            pressaoDianteira -= 0.0001;
            pressaoTraseira -= 0.0001;

            if (pressaoDianteira < 0) {
                pressaoDianteira = 0;
            }

            if (pressaoTraseira < 0) {
                pressaoTraseira = 0;
            }
        }


        public double getPressaoDianteira() {

            return pressaoDianteira;
        }


        public double getPressaoTraseira() {

            return pressaoTraseira;
        }


        public double getDesgaste() {

            return desgaste;
        }
    }
}