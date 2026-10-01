# Projeto Garagem

Projeto Java com Maven, SQLite, MVC e Strategy Pattern.

## MVC
- Model: classes de domínio.
- View: `GaragemView`.
- Control: `GestorGaragem`.
- Repository: acesso à base de dados SQLite.

## Strategy
Cada veículo usa uma estratégia de movimento: `MovimentoCarro`, `MovimentoBarco` ou `MovimentoMota`.

## Base de dados
O `Main` não cria manualmente os veículos. Eles são lidos de `garagem.db` pelo `GaragemRepository`.

Fluxo:
`Main -> GestorGaragem -> GaragemRepository -> garagem.db -> objetos -> Garagem -> View`

A garagem aceita capacidade entre 0 e 5. A ordem inicial é Carro, Barco e Mota.

## Executar
```bash
mvn clean compile
mvn exec:java
```
