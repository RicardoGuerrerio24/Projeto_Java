# Projeto Garagem — MVC + Strategy Pattern

## Estrutura

- `model/` — entidades e regras do domínio.
- `strategy/` — diferentes estratégias de movimento.
- `control/` — gestor que coordena as operações da garagem.
- `view/` — apresentação da informação.
- `Main.java` — ponto de entrada e demonstração.

## MVC

- **Model:** `Veiculo`, `Carro`, `Barco`, `Mota`, `Matricula` e `Garagem`.
- **Control:** `GestorGaragem`.
- **View:** `GaragemView`.

## Strategy Pattern

A interface `MovimentoStrategy` define o comportamento de movimento.
Cada tipo de veículo tem uma estratégia própria: `MovimentoCarro`, `MovimentoMota` e `MovimentoBarco`.

As classes `Carro`, `Mota` e `Barco` mantêm o método público `mover()`, mas delegam o comportamento para a sua Strategy. Desta forma, a API principal dos veículos mantém-se simples.

## Regras

- Capacidade da garagem entre 0 e 5.
- Ordem inicial obrigatória: Carro -> Barco -> Mota.
- `Carro` e `Mota` usam `Matricula.terrestre(...)`.
- `Barco` usa `Matricula.maritima(...)`.

## OOP

O projeto usa encapsulamento, herança, abstração, polimorfismo e associação entre `Veiculo` e `Matricula`.

## Compilação

A partir da pasta `src`:

```bash
javac Main.java model/*.java control/*.java view/*.java strategy/*.java
java Main
```
