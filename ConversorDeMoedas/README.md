# Conversor de Moedas Desafio One

## Sobre
Conversor de moedas que utiliza taxas de câmbio em tempo real através da API exchangerate-api. Desenvolvido em Java com interface via terminal.

## Funcionalidades
- Conversão entre 6 pares de moedas
- Interface de terminal intuitiva
- Precisão de 7 casas decimais
- Atualização automática de cotações

## Tecnologias
- Java 8+
- Gson para JSON
- HTTP Client

## Como Usar

### Pré-requisitos
- Java JDK 8+
- Internet
- API key do exchangerate-api

### Execução
```bash
javac -encoding UTF-8 *.java
java -Dfile.encoding=UTF-8 ConversorDeMoedasApp
```
### Menu Interativo
```
************************************************ 
Bem vindo ao conversor de Moedas!

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileiro
4) Real brasileiro =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Sair
************************************************
```
### Exemplo de Uso
```
2
Digite o valor que deseja converter:
10
Valor 10.0 [ARS] corresponde ao valor final de =>>> 0.0080656 [USD]
```

### Pares de Moedas
- USD ↔ ARS
- USD ↔ BRL
- USD ↔ COP

### Estrutura
```
src/
├── ConverserDeMoedasService.java
├── ConversorDeMoedasApp.java
├── ConversorJsonHandler.java
├── ExternalApiRequestor.java
└── Requestor.java
```