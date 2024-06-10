
# Webservice em Java com Spring

Este projeto é um webservice desenvolvido em Java com Spring que realiza as operações básicas de CRUD (GET, PUT, POST e DELETE) para as entidades `Contrato` e `Veiculo`.

## Entidades

### Contrato

- **Id**: Identificador único do contrato.
- **Nome Devedor**: Nome do devedor associado ao contrato.
- **Data de Nascimento Devedor**: Data de nascimento do devedor.
- **Número do Registro Eletrônico**: Número randômico prefixado no ano corrente.
- **Veiculos**: Uma lista de veículos associados ao contrato.

### Veiculo

- **Id**: Identificador único do veículo.
- **Número do Gravame**: Número do gravame do veículo.
- **Número do RENAVAM**: Número do RENAVAM do veículo.
- **Placa**: Placa do veículo.
- **Número do Chassi**: Número do chassi do veículo.
- **Contrato**: Relacionamento com contrato.
## Como Executar

### Requisitos

1. **Java Development Kit (JDK):** Versão 17 ou superior.
   
2. **Spring Boot:** Utilize a versão 3.3.0 ou superior.

3. **Maven:** Utilize uma versão compatível e estável do Maven.

4. **Postman ou Insomnia:** Utilize a versão mais recente disponível dessas ferramentas para testar as requisições HTTP aos endpoints da aplicação.

Sempre verifique a documentação oficial das ferramentas e tecnologias utilizadas para garantir a compatibilidade e obter informações sobre as versões mais recentes disponíveis.

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/moonshinerd/case-estagio-placeti.git
   ```

2. **Navegue até o Diretório:**

   ```bash
   cd case-estagio-placeti
   ```

3. **Execute o Maven:**

   Para compilar e executar a aplicação utilizando o Maven, execute o seguinte comando:

   ```
   mvn install
   mvn spring-boot:run
   ```
   Isso iniciará a aplicação Spring Boot. Certifique-se de ter o JDK instalado e configurado corretamente em seu sistema.
   Caso você não consiga executar o projeto maven através do teminal, utilize a IDE de sua prefêrencia para executar o projeto maven.


5. **Acesse o Postman ou Insomnia e Faça as Requisições:**

   Você pode usar o seguinte conjunto de endpoints para testar as operações CRUD:

   - **GET /contrato**: Retorna todos os contratos.
   - **GET /contrato/{id}**: Retorna um contrato específico pelo ID.
   - **POST /contrato**: Cria um novo contrato.

     Para fazer um POST para criar um novo contrato, siga estas etapas:
     
     - Abra o Postman ou Insomnia.
     - Selecione o método `POST`.
     - Insira a URL `http://localhost:8080/contrato`.
     - Selecione o tipo de corpo (`Body`).
     - Escolha o formato `JSON (application/json)`.
     - No corpo da requisição, insira os detalhes do contrato em formato JSON, por exemplo:
     
       ```json
       {
           "nome_devedor": "Nome do Devedor",
           "data_nascimento_devedor": "1990-01-01",
           "num_reg_eletronico": "123456"
       }
       ```

     - Você também pode criar contratos junto de veículos:
     
       ```json
       {
           "nome_devedor": "Nome do Devedor",
           "data_nascimento_devedor": "1990-01-01",
           "num_reg_eletronico": "123456",
           "veiculos":[
               {
                   "gravame": "334",
                   "renavam": "667",
                   "placa": "OPQ3344",
                   "chassi": "445"
               }
           ]
       }
       ```

   - **PUT /contrato/{id}**: Atualiza um contrato existente pelo ID.
   - **DELETE /contrato/{id}**: Deleta um contrato existente pelo ID.

   - **GET /veiculo**: Retorna todos os veículos.
   - **GET /veiculo/{id}**: Retorna um veículo específico pelo ID.
   - **POST /veiculo**: Cria um novo veículo.

     Para fazer um POST para criar um novo veículo, siga estas etapas:

     - Abra o Postman ou Insomnia.
     - Selecione o método `POST`.
     - Insira a URL `http://localhost:8080/veiculo`.
     - Selecione o tipo de corpo (`Body`).
     - Escolha o formato `JSON (application/json)`.
     - No corpo da requisição, insira os detalhes do veículo em formato JSON, por exemplo:
     
       ```json
       {
           "gravame": "12345",
           "renavam": "67890",
           "placa": "ABC1234",
           "chassi": "XYZ789"
       }
       ```

     - Você também pode criar veiculos vinculados a um contrato:

     ```json
     {
           "gravame": "12345",
           "renavam": "67890",
           "placa": "ABC1234",
           "chassi": "XYZ789",
           "contrato": {
                  "nome_devedor": "João",
                  "data_nascimento_devedor": "1980-01-01",
                  "num_reg_eletronico": "123456"
           }
       }
     ```

   - **PUT /veiculo/{id}**: Atualiza um veículo existente pelo ID.
   - **DELETE /veiculo/{id}**: Deleta um veículo existente pelo ID.

6. **Teste as Associações entre Contrato e Veículo:**

   Para associar um veículo a um contrato existente ou associar um contrato a um veículo existente, use os seguintes endpoints:

   - **POST /contrato/{id}/adicionar-veiculo/{veiculoId}**: Adiciona um veículo ao contrato com o ID especificado. Certifique-se de substituir `{id}` pelo ID do contrato e `{veiculoId}` pelo ID do veículo que deseja associar.

   - **POST /veiculo/{id}/associar-contrato/{contratoId}**: Associa um contrato ao veículo com o ID especificado. Substitua `{id}` pelo ID do veículo e `{contratoId}` pelo ID do contrato que deseja associar.

   Certifique-se de passar os IDs corretos no corpo da requisição ou como parâmetros na URL.

## Ferramentas e Conceitos

### Maven

Maven é uma ferramenta de automação de compilação utilizada primariamente para projetos em Java. Ele ajuda na gestão de dependências do projeto, compilação, empacotamento e distribuição de artefatos.

### Docker

Docker é uma plataforma que permite que você desenvolva, envie e execute aplicativos em contêineres. Contêineres permitem empacotar um aplicativo com todas as partes necessárias, como bibliotecas e outras dependências, e enviá-lo como uma única imagem.

### Spring

Spring é um framework Java que simplifica o desenvolvimento de aplicativos corporativos. Ele fornece uma infraestrutura abrangente para desenvolver aplicativos Java de forma rápida e fácil, especialmente aplicativos baseados em microservices. Alguns conceitos importantes do Spring incluem:

- **Inversão de Controle (IoC)**: O controle do fluxo de execução é invertido pelo framework, que gerencia a criação e injeção de dependências.
- **Injeção de Dependência (DI)**: É um padrão de design no qual as dependências de um objeto são injetadas em vez de serem criadas dentro do objeto.
- **Spring Boot**: Uma extensão do Spring que facilita a configuração e o desenvolvimento de aplicativos Spring, fornecendo configurações padrão e eliminando a necessidade de configuração manual.
- **Spring Data**: Uma subprojetos do Spring que facilita o acesso a dados de bancos de dados relacionais e NoSQL por meio de abstrações simplificadas.
- **Spring MVC**: Um framework de model-view-controller para criar aplicativos web baseados em padrões.
