Criar um sistema para o estacionamento “smart-park” 

Cadastro de Veículos

Resumo: Criar um cadastro de veículos para um estacionamento. Este estacionamento contém veículos que pertencem a pessoas físicas e pessoas jurídicas. Cada veículo possui um responsável, um proprietário (pode ser pessoa jurídica ou física). Um motorista pode ou não ser o responsável. Um motorista possui permissão para dirigir um ou mais veículos, e esta permissão pode ser desabilitada e habilitada novamente. Podem haver vários veículos de uma única empresa ou pessoa  neste estacionamento ou nenhum. Os veículos devem ser classificados com a categoria sendo carro, caminhão, ônibus ou moto. Um veículo pode ter seu acesso bloqueado no estacionamento e deve ser possível desbloquear.

Veículo:
Categoria (CARRO, caminhão, ônibus ou moto);
Chassi (No padrão que está no documento);
Placa (No padrão brasileiro);
Modelo (descritivo);
Marca (deve ser selecionado no front-end);
Cor (descritivo);
Ano de fabricação (data);
Ano do modelo (data);
Responsável (Possui um);
Proprietário (Possui um);
Motoristas permitidos (Possui vários);

Responsável:
Nome;
Sobrenome;
RG;
CPF;
Endereço completo;
Data de nascimento;
Telefone celular;
E-mail;
Sexo;

Motorista:
Nome;
Sobrenome;
Telefone celular;
E-mail;
CNH;

Proprietário:
Nome Completo ou Razão Social;
CPF ou CNPJ;
Nome Fantasia se pessoa jurídica ou Sobrenome se pessoa física;
Endereço completo;
E-mail;
Telefone de contato;


1º passo - modelar uma estrutura de banco de dados no PostgreSQL, criando um schema novo chamado cadastro, e todas as tabelas e campos necessários dado a informação acima; utilizar os nomes das tabelas e elementos do banco de dados em português, porém sem os acentos da linguagem.

2º passo - codificar uma APi utilizando linguagem JAVA e o framework Quarkus.
	
