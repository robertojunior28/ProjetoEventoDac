# ProjetoEventoDac
Projeto solicitado pelo professor da Disciplina de Desenvolvimento de Aplicações Corporativas com o intuito de aprendermos a usar Spring Boot com JPA.

Requisitos:
1. Edite o projeto anterior no STS
2. Crie duas entidades de sua preferência e relacione elas da maneira como preferir (OneToMany, ManyToOne ou ManyToMany). 
Cada entidade precisa ter pelo menos 3 atributos.
3. Crie uma classe Repository para cada uma das suas entidades estendendo o JpaRepository
4. Crie um servico para cada uma das entidades com as quatro operações básicas de um CRUD. Crie serviços alternativos caso seja necessário.
5. Crie um controller para cada uma de suas entidades com as quatro operações básicas de um CRUD
6. Na classe do SpringBootApplication, estenda a CommandLineRunner
7. Crie um menu a ser impresso no méodo run: uma opção para criar os objetos da sua entidade e salvar no banco (faça uso dos controllers)
8. Crie um menu a ser impresso no méodo run: uma opção para mostrar todos os objetos do banco das suas entidades (faça uso dos controllers)
9. Você não pode utilizar as entidades: Pessoa, Produto, Carro, Veículo.
10. As entidades não podem ser repetidas entre os projetos, logo, você precisa colocar nos comentários abaixo quais serão as suas duas.

**Para o código rodar você precisa atualizar o user e a senha do seu banco de dados Prostgre no arquivo application.properties, além de criar um banco com o nome "evento"**
