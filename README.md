# Criar um sistema para o estacionamento “smart-park” 


<!-- ABOUT THE PROJECT -->

## Sobre o Projeto

Resumo: Criar um cadastro de veículos para um estacionamento. Este estacionamento contém veículos que pertencem a pessoas físicas e pessoas jurídicas. Cada veículo possui um responsável, um proprietário (pode ser pessoa jurídica ou física). Um motorista pode ou não ser o responsável. Um motorista possui permissão para dirigir um ou mais veículos, e esta permissão pode ser desabilitada e habilitada novamente. Podem haver vários veículos de uma única empresa ou pessoa  neste estacionamento ou nenhum. Os veículos devem ser classificados com a categoria sendo carro, caminhão, ônibus ou moto. Um veículo pode ter seu acesso bloqueado no estacionamento e deve ser possível desbloquear.


Tutorial: Quarkus - criando uma aplicação simples utilizando Quarkus Java + REST + CDI + Panache + lombok + flyway

### Feito Com

Tecnologias utilizadas no projeto

- [JAVA](https://www.java.com/pt_BR/download/) - Java é uma linguagem de programação e plataforma computacional lançada pela primeira vez pela Sun Microsystems em 1995. Existem muitas aplicações e sites que não funcionarão, a menos que você tenha o Java instalado, e mais desses são criados todos os dias;
- [Quarkus](https://quarkus.io/) - A Red Hat lançou o Quarkus, um framework Java nativo do Kubernetes feito sob medida para o GraalVM e OpenJDK HotSpot. O Quarkus visa tornar o java uma plataforma líder em ambientes serverless e Kubernetes, oferecendo aos desenvolvedores um modelo unificado de programação reativa e imperativa;
- [Panache](https://quarkus.io/guides/hibernate-orm-panache) - Simplificando a camada de persistência de dados.

<!-- GETTING STARTED -->

## Começando

Para reproduzir o exemplo, é necessário seguir os requisitos mínimos.

### Pré-requisitos

 - Você vai precisar de uma IDE como por exemplo: IntelliJ IDEA, Eclipse, VSCode.
 - Instale PostgreSQL 14+
 - Instale a JDK 11+
 - Instale o Apache Maven 3.5.3+ 
 - Panache Entity
 - lombok
 - flyway



## Modelo de dados

### Veículo:
* Categoria (CARRO, caminhão, ônibus ou moto);
* Chassi (No padrão que está no documento);
* Placa (No padrão brasileiro);
* Modelo (descritivo);
* Marca (deve ser selecionado no front-end);
* Cor (descritivo);
* Ano de fabricação (data);
* Ano do modelo (data);
* Responsável (Possui um);
* Proprietário (Possui um);
* Motoristas permitidos (Possui vários);

### Responsável:
* Nome;
* Sobrenome;
* RG;
* CPF;
* Endereço completo;
* Data de nascimento;
* Telefone celular;
* E-mail;
* Sexo;

### Motorista:
* Nome;
* Sobrenome;
* Telefone celular;
* E-mail;
* CNH;

### Proprietário:
* Nome Completo ou Razão Social;
* CPF ou CNPJ;
* Nome Fantasia se pessoa jurídica ou Sobrenome se pessoa física;
* Endereço completo;
* E-mail;
* Telefone de contato;


## Executando o projeto em Quarkus

Para executar um projeto em Quarkus, basta executar o comando: 
```sh
mvn compile quarkus:dev
```
	
