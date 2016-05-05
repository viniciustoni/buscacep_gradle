# buscacep
Servico REST para busca de CEP.

# Developers
- Vinicius Antonio Gai - viniciustoni@gmail.com

# Tecnologias
As técnologias utilizadas para o desenvolvimento da aplicação foram:
- Maven 3
- Spring Framework
- Spring boot
- Hibernate
- HSQLDB
- Swagger - Frameworks para API
- Java 7

# Como executar a aplicação?
Para rodar a aplicação é necessário conter o Maven 3 instalado e configurado na maquina.
Após isso basta executar no prompt, dentro da pasta da aplicação os seguintes comandos maven:
- Compilando a aplicação: mvn clean package
- Executando a aplicação: mvn spring-boot:run -Dserver.port=8181

# Como utilizar a aplicação?
Como a aplicação está executando o framework do Swagger, ao acessar a URL (http://localhost:8181/index.html) será redirecionado para uma pagina onde irá conter todos os serviços Rest da aplicação:
- /buscacep/buscaCep/{numCep} : Busca pelos dados do CEP.
- /buscacep/cadastraCep : Cadastro de um novo CEP no banco.

## /buscacep/buscaCep/{numCep}
URL completa: http://localhost:8181/buscacep/buscaCep/{numCep}

Serviço no formato de GET, onde deve-se alterar o {numCep} pelo CEP desejado, exemplo: http://localhost:8181/buscacep/buscaCep/06213040

- JSON Request
O Request, basta informar o cep:

* Exemplo de chamada Request
![buscaCepRequest](https://github.com/viniciustoni/buscacep/blob/master/img_doc/ConsultaCepRequest.png)

Campo: numCep - Número do CEP que será pesquisado

- JSON Response
O Response caso de sucesso retorna os dados do CEP
{
  "numCep": "string",
  "nomLogradouro": "string",
  "nomCidade": "string",
  "sglUf": "string",
  "nomBairro": "string"
}

Campos:
- numCep : Número do CEP localizado
- nomLogradouro : Nome do logradouro cadastrado
- nomCidade : Nome da cidade do CEP
- sglUF : Uf do CEP
- nomBairro : Nome do bairro do CEP

Exemplo de chamada
![buscaCepResponse](https://github.com/viniciustoni/buscacep/blob/master/img_doc/Response_consultaCep.png)

## //buscacep/cadastraCep
URL completa: http://localhost:8181/buscacep/cadastraCep

Serviço no formato de POST, onde ele efetua o cadastro ou alteração do CEP(caso CEP já existente).

- JSON Request
O Request, é no formato REST com os seguintes campos:
{
  "numCep": "string",
  "nomLogradouro": "string",
  "nomCidade": "string",
  "sglUf": "string",
  "nomBairro": "string"
}

Campos:
- numCep : Número do CEP localizado
- nomLogradouro : Nome do logradouro cadastrado
- nomCidade : Nome da cidade do CEP
- sglUF : Uf do CEP
- nomBairro : Nome do bairro do CEP

* Exemplo de chamada Request
![cadastraCepRequest](https://github.com/viniciustoni/buscacep/blob/master/img_doc/CadastroCep_Request.png)

Campo: numCep - Número do CEP que será pesquisado

- JSON Response
O response, será somente o status code da aplicação:
200 em caso de sucesso, ou exception em caso de erro.

Exemplo de chamada
![cadastraCepResponse](https://github.com/viniciustoni/buscacep/blob/master/img_doc/CadastroCep_Response.png)

#Arquitetura
A aplicação está divida em 3 camadas:
- Controller: Camada que está esposta para acesso externo, com os serviços REST.
- Service: Camada contendo o processamento da aplicação, ou seja, as regras de negócio.
- Model: Contendo as entidades de mapeamento do banco e classes de Repository para acesso a base de dados(consulta, save, update)
- Auxiliares: Pacote de converter para conversão dos TOs do serviço para as entities e vice-versa.

# CEPs previamente cadastrados:
- 06213040
- 81490000
- 04143040
