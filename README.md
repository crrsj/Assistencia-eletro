🚀 Assistência Técnica API - BackendEste projeto é o serviço de backend construído em Java com Spring Boot, responsável pela gestão de clientes, eletrodomésticos e ordens de serviço para uma assistência técnica.🛠️
Tecnologias UtilizadasLinguagem: 
Java 21+Framework: Spring Boot 3 Banco de Dados: H2 Database (em ambiente de desenvolvimento/Docker)Mapeamento: Spring Data JPASegurança e Acesso: CORS configurado para permitir acesso frontend.
⚙️ Configuração do AmbienteO projeto utiliza um arquivo docker-compose.yml que facilita o levantamento do ambiente, embora o banco de dados principal de desenvolvimento esteja configurado para o H2 Database (em memória ou modo arquivo, conforme definido no application.properties).
Nota: A configuração do Docker Compose atual é fornecida para padronização e possível expansão futura, mas o serviço Spring Boot é iniciado com o H2 ativo.
📖 Documentação da API (Swagger/OpenAPI)A documentação interativa dos endpoints da API está disponível via Swagger UI.Após iniciar a aplicação, você pode acessar a documentação completa no seu navegador:URL de Acesso: http://localhost:8080/swagger-ui.html 
A documentação detalha os métodos HTTP, parâmetros de requisição, modelos de DTOs (Data Transfer Objects) e códigos de resposta para os recursos:/clientes/eletrodomesticos (serviços)
📦 Estrutura do ProjetoO código segue a arquitetura de camadas tradicional de uma aplicação Spring Boot:controller: Gerencia o roteamento das requisições HTTP e DTOs.service: Contém a lógica de negócio principal.repository: 
Interface de acesso ao banco de dados via JPA.model/entity: Entidades mapeadas para o banco de dados.dto: Objetos de Transferência de Dados para entrada e saída.
🌐 Endpoints PrincipaisA API é acessada no caminho base /clientes e /eletrodomesticos.MétodoEndpointDescriçãoPOST/clientesCadastra um novo cliente.GET/clientesLista todos os clientes (com paginação).
GET/clientes/buscarCpf?cpf={cpf}Busca um cliente específico pelo CPF.POST/eletrodomesticos/{clienteId}Cadastra um novo serviço e o vincula a um cliente.GET/eletrodomesticosLista todos os serviços (ordens de serviço).PATCH/eletrodomesticos/{id}Atualiza o status de um serviço (e.g., Cancelar).
![ass1](https://github.com/user-attachments/assets/796310b8-4815-4cac-8a67-945d764b4885)
![ass2](https://github.com/user-attachments/assets/15ddd075-1be8-4bcb-8819-b94d359df7d1)
![ass3](https://github.com/user-attachments/assets/20bd3b94-d41e-4ecf-bbb1-e34c91e0ff0e)
![ass4](https://github.com/user-attachments/assets/9ec12b17-9136-4aec-b8e0-c7a48d048b0e)
![ass5](https://github.com/user-attachments/assets/a46aa3f0-497b-438a-b8ba-dff83eb57a76)
![ass6](https://github.com/user-attachments/assets/b79bfedf-cedc-4856-bcc0-e0a115b0a8b4)
![ass7](https://github.com/user-attachments/assets/867500ed-607c-47cf-ac6c-92df32b80aea)
