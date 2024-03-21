<h1 align="center" style="font-weight: bold;">javendas-microservice-ebac</h1>

<p align="center">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white"  alt="Java badge"/>
    <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring badge">
    <img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white" alt="Docker badge">
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Maven badge">
    <img src="https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white" alt="MongoDB badge">
</p>

<p align="center">
 <a href="#started">Começando</a> • 
  <a href="#routes">API Endpoints</a>
</p>

<p align="center">
  <b>Microsserviço simplificado criado a partir das aulas do curso Especialista Back-end Java sobre um sistema
  de vendas online.</b>
</p>

<h2 id="started">🚀 Começando</h2>

Para rodar este projeto, é necessário que tenha Docker instalado em sua máquina e executar o comando `compose.yaml`,
acessar o devidos endpoints citados mais abaixo e testar.

<h3>Prerequisites</h3>

Aqui tem uma lista de dependências necessárias para rodar este projeto

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Docker](https://docs.docker.com/get-docker/)
- [Spring 3.2.3](https://spring.io)


As dependências do Spring poderão ser encontradas no arquivo `pom.xml` na raíz de cada serviço.

<h3>Clonando</h3>

Para clonar este repositório, será necessário executar este código bash abaixo no terminal:

```bash
git clone https://github.com/CrysLef/javendas-microservice-ebac.git
```

<h3>Rodando o projeto</h3>

Para começar, rode este comando:

```bash
docker compose up -d 
``````
A partir dessa execução, você terá acesso a alguns endpoints para monitorar se os serviços estão de pé com o Eureka da Netflix e também para testar as APIs com o OpenAPI 3. Para o acesso ao banco de dados não é necessário username e password.


<h2 id="routes">📍 API Endpoints</h2>

Aqui você encontrará os endpoints que serão postos de pé ao iniciar a aplicação, sendo eles:

<h3>Eureka</h3>

| route                         | description                                                               |
|-------------------------------|---------------------------------------------------------------------------|
| <kbd>localhost:8761</kbd>     | Nesta rota, será possível acessar o painel do Eureka e verificar métricas |




<h3>Serviços</h3>

| route                                             | description                                                                             |
|---------------------------------------------------|-----------------------------------------------------------------------------------------|
| <kbd> localhost:8080/swagger-ui/index.html </kbd> | Retorna uma página html com o painel do Swagger para realizar testes na API de Cliente. |
| <kbd> localhost:8081/swagger-ui/index.html </kbd> | Retorna uma página html com o painel do Swagger para realizar testes na API de Produtp. |
| <kbd> localhost:8082/swagger-ui/index.html </kbd> | Retorna uma página html com o painel do Swagger para realizar testes na API de Venda.   |

