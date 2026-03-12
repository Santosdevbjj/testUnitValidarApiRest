### Desenvolvimento de Testes Unitários para Validar uma API REST de Gerenciamento Estoques de Cerveja

![bradescoQA001](https://github.com/user-attachments/assets/29575c32-58cd-4469-bc0e-10da93f623b5)


**Bootcamp PcD Tech Bradesco - Java & QA Developer**


---


**DESCRIÇÃO:**

Neste Labs você irá aprender a testar, unitariamente, uma API REST para o gerenciamento de estoques de cerveja.

Vamos construir testes unitários para validar o nosso sistema de gerenciamento de estoques de cerveja desenvolvido em Spring Boot, e também apresentar os principais conceitos e vantagens de criar testes unitários com JUnit e Mockito.

Além disso, vamos também mostrar como desenvolver funcionalidades da nossa API através da prática do TDD.

---


**Beerstock API – Testes Unitários com Spring Boot**

Este projeto implementa uma API REST para gerenciamento de estoques de cerveja, desenvolvida em Spring Boot e validada com testes unitários utilizando JUnit 5, Mockito e Hamcrest.  
O objetivo é demonstrar boas práticas de TDD (Test-Driven Development) e reforçar a importância dos testes unitários no ciclo de desenvolvimento.

---

📂 **Estrutura de Pastas e Arquivos**

<img width="880" height="1486" alt="Screenshot_20251112-172345" src="https://github.com/user-attachments/assets/9ff0ab05-ead8-4d4a-8243-4679fd7f4d65" />


---


**Explicação dos Arquivos**

🔹 Testes (src/test/java)
- BeerDTOBuilder.java  
  Classe auxiliar para construir objetos BeerDTO em cenários de teste, evitando repetição de código.

- BeerControllerTest.java  
  Testa os endpoints expostos pelo BeerController, garantindo que as requisições HTTP retornem os status e dados esperados.

- BeerServiceTest.java  
  Testa a lógica de negócio implementada em BeerService, validando operações como criação, busca e exclusão de cervejas.

---

🔹 Configuração (src/main/resources)
- application.properties  
  Configurações da aplicação, incluindo banco de dados H2 em memória e parâmetros do JPA/Hibernate.

- data.sql  
  Script para popular o banco de dados com registros iniciais de cervejas (ex.: Heineken, Budweiser).

---

🔹 **Código Principal**(src/main/java/com/santosdevbjj/beerstock)
- BeerController.java  
  Controlador REST que expõe os endpoints da API (/api/v1/beers).  
  Responsável por operações de criação, listagem, consulta por nome e exclusão.

- BeerService.java  
  Camada de serviço que contém a lógica de negócio da aplicação.  
  Faz a ponte entre o controlador e o repositório.

- BeerDTO.java  
  Objeto de transferência de dados (Data Transfer Object).  
  Usado para trafegar informações entre camadas sem expor diretamente a entidade.

- Beer.java  
  Entidade JPA que representa a tabela beer no banco de dados.  
  Contém atributos como id, name, brand, max e quantity.

- BeerstockApplication.java  
  Classe principal que inicializa a aplicação Spring Boot.

---

🔹 **Arquivos de Configuração do Projeto**
- pom.xml  
  Arquivo de configuração do Maven. Define dependências (Spring Boot, JUnit, Mockito, Hamcrest, H2) e plugins de build.

- .gitignore  
  Lista de arquivos e pastas ignorados pelo Git (ex.: target/, .idea/, .DS_Store, logs).

---

🛠️ **Tecnologias Utilizadas**

- Java 17  
- Spring Boot 3.x  
- Spring Data JPA  
- H2 Database (in-memory)  
- JUnit 5  
- Mockito  
- Hamcrest  
- Maven  
- Git/GitHub

---

💻 **Requisitos de Hardware e Software**

**Hardware**
- Processador Dual-Core ou superior  
- 4 GB de RAM (mínimo)  
- 500 MB de espaço em disco  

**Software**
- Java 17 ou superior  
- Maven 3.6.3 ou superior  
- IDE: IntelliJ IDEA, Eclipse ou VS Code  
- Git instalado  
- Sistema Operacional: Windows, macOS ou Linux  

---

▶️ **Como Executar o Projeto**

1. Clone o repositório:
   `bash
   git clone https://github.com/Santosdevbjj/testUnitValidarApiRest.git
   `

2. Acesse a pasta do projeto:
   `bash
   cd testUnitValidarApiRest
   `

3. Execute a aplicação:
   `bash
   mvn spring-boot:run
   `

4. Acesse no navegador:
   `
   http://localhost:8080/api/v1/beers
   `

---

🧪 **Como Executar os Testes**

Para rodar a suíte de testes unitários:

`bash
mvn clean test
`

---

📚 **Referências**

- Spring Boot  
- JUnit 5  
- Mockito  
- Hamcrest  
- Pirâmide de Testes - Martin Fowler  
- RESTful API  

---



**Exemplos de Requisições HTTP**

**A API expõe os seguintes endpoints principais:**

- POST /api/v1/beers → Criar uma nova cerveja  
- GET /api/v1/beers → Listar todas as cervejas  
- GET /api/v1/beers/{name} → Buscar cerveja por nome  
- DELETE /api/v1/beers/{id} → Excluir cerveja por ID  

---

🔹 **Criar uma nova cerveja**

cURL
`bash
curl -X POST http://localhost:8080/api/v1/beers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Corona",
    "brand": "Grupo Modelo",
    "max": 80,
    "quantity": 15
  }'
`

Postman
- Método: POST  
- URL: http://localhost:8080/api/v1/beers  
- Body → Raw → JSON:
`json
{
  "name": "Corona",
  "brand": "Grupo Modelo",
  "max": 80,
  "quantity": 15
}
`

---

🔹 **Listar todas as cervejas**

cURL
`bash
curl -X GET http://localhost:8080/api/v1/beers
`

Postman
- Método: GET  
- URL: http://localhost:8080/api/v1/beers

---

🔹 **Buscar cerveja por nome**

cURL
`bash
curl -X GET http://localhost:8080/api/v1/beers/Heineken
`

Postman
- Método: GET  
- URL: http://localhost:8080/api/v1/beers/Heineken

---

🔹 **Excluir cerveja por ID**

cURL
`bash
curl -X DELETE http://localhost:8080/api/v1/beers/1
`

Postman
- Método: DELETE  
- URL: http://localhost:8080/api/v1/beers/1

---

**Dicas para Testes**

- O banco de dados H2 em memória é inicializado a cada execução, populado com os dados do arquivo data.sql.  
- Para visualizar o banco, acesse:
  `
  http://localhost:8080/h2-console
  `
  - JDBC URL: jdbc:h2:mem:beerstockdb  
  - Usuário: sa  
  - Senha: (vazio)  

---


**Exemplos de Requisições HTTP + Respostas Esperadas**

**A API expõe os seguintes endpoints principais:**

- POST /api/v1/beers → Criar uma nova cerveja  
- GET /api/v1/beers → Listar todas as cervejas  
- GET /api/v1/beers/{name} → Buscar cerveja por nome  
- DELETE /api/v1/beers/{id} → Excluir cerveja por ID  

---

🔹 **Criar uma nova cerveja**

Requisição (cURL)
`bash
curl -X POST http://localhost:8080/api/v1/beers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Corona",
    "brand": "Grupo Modelo",
    "max": 80,
    "quantity": 15
  }'
`

**Resposta esperada (JSON)**
`json
{
  "id": 3,
  "name": "Corona",
  "brand": "Grupo Modelo",
  "max": 80,
  "quantity": 15
}
`

---

🔹 **Listar todas as cervejas**

Requisição (cURL)
`bash
curl -X GET http://localhost:8080/api/v1/beers
`

**Resposta esperada (JSON)**
`json
[
  {
    "id": 1,
    "name": "Heineken",
    "brand": "Heineken",
    "max": 50,
    "quantity": 10
  },
  {
    "id": 2,
    "name": "Budweiser",
    "brand": "ABInBev",
    "max": 100,
    "quantity": 20
  },
  {
    "id": 3,
    "name": "Corona",
    "brand": "Grupo Modelo",
    "max": 80,
    "quantity": 15
  }
]
`

---

🔹 **Buscar cerveja por nome**

Requisição (cURL)
`bash
curl -X GET http://localhost:8080/api/v1/beers/Heineken
`

**Resposta esperada (JSON)**
`json
{
  "id": 1,
  "name": "Heineken",
  "brand": "Heineken",
  "max": 50,
  "quantity": 10
}
`

---

🔹 **Excluir cerveja por ID**

Requisição (cURL)
`bash
curl -X DELETE http://localhost:8080/api/v1/beers/1
`

Resposta esperada (JSON)  
A exclusão não retorna corpo, apenas HTTP Status 204 (No Content):
`http
HTTP/1.1 204 No Content
`

---

 **Observações Importantes**

- O banco de dados H2 em memória é reiniciado a cada execução, populado com os dados do arquivo data.sql.  
- IDs são gerados automaticamente ao criar novas cervejas.  
- Caso o nome ou ID não seja encontrado, a API retorna HTTP Status 404 (Not Found) com uma mensagem de erro:
`json
{
  "error": "Beer not found"
}
`

---

**Postman Collection (JSON Exportável)**


**Como Importar no Postman**

1. Abra o Postman.  
2. Clique em Import (canto superior esquerdo).  
3. Selecione o arquivo Beerstock.postman_collection.json.  
4. A coleção aparecerá na sua sidebar com o nome Beerstock API.  
5. Agora você pode executar cada requisição diretamente e validar os endpoints.

---

 Com isso, você tem uma coleção pronta para rodar todos os testes da API sem precisar configurar manualmente cada requisição.  

---

**Postman Environment (JSON Exportável)**


**Como Importar no Postman**

1. Abra o Postman.  
2. Clique em Import (canto superior esquerdo).  
3. Selecione o arquivo Beerstock.postman_environment.json.  
4. Ative o ambiente Beerstock Environment no canto superior direito.  
5. Agora todas as requisições da coleção podem usar variáveis como:  
   - {{baseUrl}}/beers  
   - {{baseUrl}}/beers/{{beerName}}  
   - {{baseUrl}}/beers/{{beerId}}

---

🔹 **Exemplos com Variáveis**

- Criar cerveja:
  `
  POST {{baseUrl}}/beers
  `

- Listar cervejas:
  `
  GET {{baseUrl}}/beers
  `

- Buscar por nome:
  `
  GET {{baseUrl}}/beers/{{beerName}}
  `

- Excluir por ID:
  `
  DELETE {{baseUrl}}/beers/{{beerId}}
  `

---

   Com esse ambiente configurado, você pode trocar o baseUrl (por exemplo, para um servidor remoto ou porta diferente) sem precisar alterar cada requisição manualmente.  



---

**Postman Collection + Environment Integrado**


**Como Usar**

1. Salve o arquivo como Beerstock.postman_collection.json.  
2. Abra o Postman.  
3. Clique em Import e selecione o arquivo.  
4. A coleção aparecerá com o nome Beerstock API.  
5. As variáveis já estão embutidas, então você pode rodar os endpoints diretamente usando:  
   - {{baseUrl}}/beers  
   - {{baseUrl}}/beers/{{beerName}}  
   - {{baseUrl}}/beers/{{beerId}}

---

 

**Autor:**
Sergio Santos 

---

**Contato:**


[![Portfólio Sérgio Santos](https://img.shields.io/badge/Portfólio-Sérgio_Santos-111827?style=for-the-badge&logo=githubpages&logoColor=00eaff)](https://portfoliosantossergio.vercel.app)

[![LinkedIn Sérgio Santos](https://img.shields.io/badge/LinkedIn-Sérgio_Santos-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/santossergioluiz)


---

