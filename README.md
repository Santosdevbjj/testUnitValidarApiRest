# 🍺 Beerstock API — Testes Unitários com Spring Boot

![bradescoQA001](https://github.com/user-attachments/assets/29575c32-58cd-4469-bc0e-10da93f623b5)

**Bootcamp PcD Tech Bradesco — Java & QA Developer**

---

## 1. Problema de Negócio

APIs REST em produção sem cobertura de testes representam um risco real para qualquer organização. Uma falha silenciosa na lógica de estoque — como permitir que a quantidade de cerveja ultrapasse o limite máximo configurado, ou registrar uma cerveja já existente — pode gerar inconsistências operacionais difíceis de rastrear.

O desafio técnico aqui é claro: **como garantir que cada endpoint e cada regra de negócio da API se comportem exatamente como esperado, antes que qualquer mudança chegue ao ambiente de produção?**

A resposta está na construção de uma suíte robusta de testes unitários, desenvolvida com a prática de TDD (Test-Driven Development).

---

## 2. Contexto

Este projeto foi desenvolvido durante o **Bootcamp PcD Tech Bradesco — Java & QA Developer**, com foco em qualidade de software e boas práticas de engenharia.

A aplicação gerencia um estoque de cervejas por meio de uma API REST construída com **Spring Boot**. Ela permite criar, listar, buscar e excluir registros, validando regras de negócio como limites de quantidade e unicidade de nome.

O objetivo central não é apenas fazer a API funcionar — é **provar que ela funciona corretamente**, mesmo quando o código muda. Para isso, foi construída uma cobertura de testes unitários que valida tanto a camada de controller (HTTP) quanto a camada de serviço (regras de negócio).

---

## 3. Premissas da Análise

Para o desenvolvimento dos testes, as seguintes premissas foram adotadas:

- Os testes unitários são **isolados**: cada teste valida uma única responsabilidade, sem depender de banco de dados real ou de outros serviços.
- O banco de dados **H2 em memória** é utilizado para simular o ambiente de persistência durante a execução da aplicação.
- **Mockito** é usado para isolar dependências externas nos testes de serviço, garantindo que apenas a lógica testada seja avaliada.
- A cobertura foca nos fluxos **feliz (happy path)** e nos principais **cenários de erro** (recurso não encontrado, limite excedido, duplicidade).
- Os testes foram escritos seguindo a prática de **TDD**, onde o teste é criado antes da implementação.

---

## 4. Estratégia da Solução

A abordagem seguiu uma estrutura em camadas, alinhada à arquitetura da aplicação:

**Passo 1 — Entendimento das regras de negócio**
Antes de escrever qualquer teste, foram mapeadas as operações da API e seus comportamentos esperados: o que deve acontecer ao criar uma cerveja que já existe? O que retornar quando um ID não é encontrado?

**Passo 2 — Construção do BeerDTOBuilder**
Criação de uma classe auxiliar de testes responsável por construir objetos `BeerDTO` de forma padronizada, evitando repetição de código e garantindo consistência nos cenários de teste.

**Passo 3 — Testes de Serviço (BeerServiceTest)**
Validação da lógica de negócio em isolamento, usando mocks para simular o repositório. Cenários cobertos: criação com sucesso, criação de cerveja duplicada, busca por nome, exclusão e incremento de estoque.

**Passo 4 — Testes de Controller (BeerControllerTest)**
Validação dos endpoints HTTP com MockMvc, verificando status codes, corpo das respostas e comportamento correto diante de entradas inválidas.

**Passo 5 — Execução e análise dos resultados**
Execução da suíte com `mvn clean test`, análise dos relatórios e ajuste dos casos de teste para garantir cobertura dos fluxos críticos.

---

## 5. Decisões Técnicas

**Por que JUnit 5 e Mockito?**
JUnit 5 oferece uma API moderna e expressiva para escrita de testes em Java. Mockito é o padrão de mercado para criação de mocks e verificação de interações em testes unitários Java — a combinação é amplamente adotada em projetos Spring Boot.

**Por que H2 e não um banco real?**
O H2 em memória elimina a necessidade de infraestrutura externa para rodar os testes, tornando a suíte rápida, portátil e reproduzível em qualquer ambiente.

**Por que TDD?**
Escrever o teste antes da implementação força o desenvolvedor a pensar no comportamento esperado antes de pensar em como implementá-lo. Isso reduz bugs, melhora o design do código e documenta a intenção de cada funcionalidade.

**O que eu faria diferente hoje?**
Adicionaria testes de integração com `@SpringBootTest` para validar o fluxo completo da aplicação, e configuraria uma pipeline de CI/CD no GitHub Actions para executar os testes automaticamente a cada push.

---

## 6. Insights do Desenvolvimento

Durante o desenvolvimento, ficou claro que:

- **Testar não é opcional** — sem testes, qualquer refatoração vira um risco calculado no escuro.
- O **BeerDTOBuilder** foi um dos maiores ganhos de produtividade: centralizar a criação de objetos de teste evitou dezenas de linhas duplicadas e tornou os testes muito mais legíveis.
- O uso de **Hamcrest** como biblioteca de assertivas deixa os testes significativamente mais expressivos do que comparações com `assertEquals` simples.
- Escrever testes revela **fragilidades no design** que passariam despercebidas na implementação direta — o TDD funcionou como um feedback loop contínuo.

---

## 7. Resultados

Com a suíte de testes implementada, o projeto entrega:

- ✅ Cobertura dos endpoints: `POST`, `GET` (lista e por nome), `DELETE`
- ✅ Validação de regras de negócio: limite de estoque, unicidade de nome, recurso não encontrado
- ✅ Testes isolados por camada (controller e serviço)
- ✅ Base sólida para evolução segura da API — qualquer nova feature pode ser adicionada sem risco de quebrar o que já funciona

---

## 8. Próximos Passos

- [ ] Adicionar testes de integração com `@SpringBootTest` e banco H2
- [ ] Configurar pipeline de CI no **GitHub Actions** para rodar testes automaticamente a cada pull request
- [ ] Aumentar cobertura de código com relatórios do **JaCoCo**
- [ ] Implementar testes de contrato com **Spring Cloud Contract**
- [ ] Dockerizar a aplicação para facilitar o onboarding de novos colaboradores

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 17 | Linguagem principal |
| Spring Boot 3.x | Framework da aplicação |
| Spring Data JPA | Persistência de dados |
| H2 Database | Banco em memória para testes |
| JUnit 5 | Framework de testes unitários |
| Mockito | Criação de mocks e verificação de comportamento |
| Hamcrest | Assertivas expressivas nos testes |
| Maven | Gerenciamento de dependências e build |
| Git / GitHub | Versionamento e hospedagem do código |

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/santosdevbjj/beerstock/
│   │   ├── BeerController.java       # Endpoints REST (/api/v1/beers)
│   │   ├── BeerService.java          # Lógica de negócio
│   │   ├── BeerDTO.java              # Objeto de transferência de dados
│   │   ├── Beer.java                 # Entidade JPA (tabela beer)
│   │   └── BeerstockApplication.java # Inicialização do Spring Boot
│   └── resources/
│       ├── application.properties    # Configurações (H2, JPA)
│       └── data.sql                  # Dados iniciais (Heineken, Budweiser)
└── test/
    └── java/
        ├── BeerDTOBuilder.java       # Builder auxiliar para cenários de teste
        ├── BeerControllerTest.java   # Testes dos endpoints HTTP
        └── BeerServiceTest.java      # Testes da lógica de negócio
```

---

## ▶️ Como Executar o Projeto

**Pré-requisitos:** Java 17+, Maven 3.6.3+, Git

```bash
# Clone o repositório
git clone https://github.com/Santosdevbjj/testUnitValidarApiRest.git

# Acesse a pasta
cd testUnitValidarApiRest

# Execute a aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080/api/v1/beers`

Para visualizar o banco H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:beerstockdb`
- Usuário: `sa` | Senha: *(vazio)*

---

## 🧪 Como Executar os Testes

```bash
mvn clean test
```

---

## 📡 Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/api/v1/beers` | Criar uma nova cerveja |
| `GET` | `/api/v1/beers` | Listar todas as cervejas |
| `GET` | `/api/v1/beers/{name}` | Buscar cerveja por nome |
| `DELETE` | `/api/v1/beers/{id}` | Excluir cerveja por ID |

**Exemplo — Criar cerveja:**
```bash
curl -X POST http://localhost:8080/api/v1/beers \
  -H "Content-Type: application/json" \
  -d '{"name": "Corona", "brand": "Grupo Modelo", "max": 80, "quantity": 15}'
```

**Resposta esperada (`201 Created`):**
```json
{ "id": 3, "name": "Corona", "brand": "Grupo Modelo", "max": 80, "quantity": 15 }
```

**Exemplo — Recurso não encontrado (`404 Not Found`):**
```json
{ "error": "Beer not found" }
```

---

## 💻 Requisitos de Hardware e Software

**Software:** Java 17+, Maven 3.6.3+, Git, IDE de sua preferência (IntelliJ IDEA, Eclipse ou VS Code)  
**Hardware:** Processador Dual-Core, 4 GB RAM (mínimo), 500 MB de espaço em disco

---

## 📚 Referências

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://site.mockito.org/)
- [Pirâmide de Testes — Martin Fowler](https://martinfowler.com/articles/practical-test-pyramid.html)

---

## Autor

**Sergio Santos**

[![Portfólio](https://img.shields.io/badge/Portfólio-Sérgio_Santos-111827?style=for-the-badge&logo=githubpages&logoColor=00eaff)](https://portfoliosantossergio.vercel.app)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Sérgio_Santos-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/santossergioluiz)
