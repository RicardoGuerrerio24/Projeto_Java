public class Carro {

    // CARACTERÍSTICAS

    private String marca;
    private String modelo;
    private int ano;

    private double peso;
    private double comprimento;
    private double largura;
    private double altura;

    private double velocidadeMaxima;

    private Motor motor;
    private SistemaArrefecimento arrefecimento;
    private SistemaCombustivel combustivel;
    private SistemaEletrico sistemaEletrico;
    private SistemaTravagem travagem;
    private Pneus pneus;


    // CONSTRUTOR

    public Carro(String marca, String modelo, int ano,
                 double peso, double comprimento,
                 double largura, double altura,
                 double velocidadeMaxima) {

        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;

        this.peso = peso;
        this.comprimento = comprimento;
        this.largura = largura;
        this.altura = altura;

        this.velocidadeMaxima = velocidadeMaxima;

        this.motor = new Motor();
        this.arrefecimento = new SistemaArrefecimento();
        this.combustivel = new SistemaCombustivel();
        this.sistemaEletrico = new SistemaEletrico();
        this.travagem = new SistemaTravagem();
        this.pneus = new Pneus();
    }

    // COMPORTAMENTO AUTOMÁTICO

    /*
     * Atualiza os sistemas automáticos do carro.
     */
    public void atualizar() {

        motor.controlarTemperatura();
        arrefecimento.controlar(motor);

        sistemaEletrico.controlarBateria();

        travagem.controlarTemperatura();
        pneus.controlarPressao();
    }


    // INFORMAÇÃO DO CARRO

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


    // MOTOR

    public class Motor {

        private double temperatura;
        private double temperaturaNormal;
        private double temperaturaMaxima;

        private double oleo;
        private double desgaste;


        private Motor() {
            temperatura = 20;
            temperaturaNormal = 90;
            temperaturaMaxima = 120;

            oleo = 100;
            desgaste = 0;
        }


        /*
         * O motor perde calor naturalmente.
         */
        private void controlarTemperatura() {

            if (temperatura > 20) {
                temperatura -= 0.2;
            }
        }


        /*
         * O desgaste aumenta naturalmente com o funcionamento.
         */
        private void aumentarDesgaste() {

            desgaste += 0.001;

            if (desgaste > 100) {
                desgaste = 100;
            }
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

        public boolean estaSobreaquecido() {
            return temperatura >= temperaturaMaxima;
        }
    }


    // SISTEMA DE ARREFECIMENTO

    public class SistemaArrefecimento {

        private boolean ventoinhaLigada;
        private double nivelLiquido;


        private SistemaArrefecimento() {
            ventoinhaLigada = false;
            nivelLiquido = 100;
        }


        /*
         * O sistema decide sozinho quando deve funcionar.
         */
        private void controlar(Motor motor) {

            if (motor.getTemperatura() >= 95) {
                ventoinhaLigada = true;
            }

            if (motor.getTemperatura() <= 85) {
                ventoinhaLigada = false;
            }
        }


        public boolean isVentoinhaLigada() {
            return ventoinhaLigada;
        }

        public double getNivelLiquido() {
            return nivelLiquido;
        }
    }


    // SISTEMA DE COMBUSTÍVEL

    public class SistemaCombustivel {

        private double capacidade;
        private double quantidade;


        private SistemaCombustivel() {
            capacidade = 50;
            quantidade = 50;
        }


        /*
         * Apenas representa o estado do combustível.
         * Não existe "abastecer()" porque isso requer uma pessoa.
         */
        public double getQuantidade() {
            return quantidade;
        }

        public double getCapacidade() {
            return capacidade;
        }

        public boolean estaNaReserva() {
            return quantidade <= capacidade * 0.15;
        }

        public boolean estaVazio() {
            return quantidade <= 0;
        }
    }


    // SISTEMA ELÉTRICO

    public class SistemaEletrico {

        private double bateria;
        private double voltagem;


        private SistemaEletrico() {
            bateria = 100;
            voltagem = 12;
        }


        /*
         * O sistema elétrico gere automaticamente
         * determinados aspetos da bateria.
         */
        private void controlarBateria() {

            if (bateria < 100) {
                bateria += 0.01;
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


    // SISTEMA DE TRAVAGEM

    public class SistemaTravagem {

        private double temperatura;
        private double desgaste;


        private SistemaTravagem() {
            temperatura = 20;
            desgaste = 0;
        }


        /*
         * Os travões arrefecem naturalmente.
         */
        private void controlarTemperatura() {

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


    // PNEUS

    public class Pneus {

        private double pressaoDianteira;
        private double pressaoTraseira;

        private double desgaste;


        private Pneus() {
            pressaoDianteira = 2.2;
            pressaoTraseira = 2.2;
            desgaste = 0;
        }


        /*
         * A pressão dos pneus diminui lentamente
         * devido à perda natural de ar.
         */
        private void controlarPressao() {

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