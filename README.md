<h1 name="portuguese">Food API</h1>

[You can also read it in English! :)](#english)
> API RESTful projetada para gerenciamento de cardápio de restaurante.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

Food API é uma API RESTful desenvolvida e projetada especificamente para gerenciar de cardápios de restaurantes. Criada para ser implementada em um projeto front-end desenvolvido em React, esta API oferece os principais métodos para realizar operações CRUD (Create, Read, Update, Delete).

## Tecnologias utilizadas

- Java
- Spring Boot
- JUnit
- Flyway Migrations
- MySQL

IDE: IntelliJ IDEA

## Instalação

1. Clone o repositório para a sua IDE
   
```bash
git clone https://github.com/eurenaneu/food-api.git
```

2. Utilize o Maven para instalar as dependências utilizadas no projeto
3. Baixe e instale o [MySQL](https://dev.mysql.com/downloads/workbench/) e o [XAMPP](https://www.apachefriends.org/pt_br/index.html)

**OBS:** Caso você prefira outro SGBD, basta modificar o arquivo applications.properties e os arquivos SQL do Migrations.

## Endpoints
```markdown
GET /food - Retorna todas as comidas armazenadas.

GET /food/active - Retorna todas as comidas ativas armazenadas.

GET /food/{id} - Retorna a comida associada ao ID.

POST /food - Cadastra uma comida nova.

PUT /food/{id} - Atualiza as informações da comida.

PATCH /food/{id} - Atualiza parcialmente as informações da comida.

DELETE /food/{id} - Atualiza o status da comida para INATIVA (Exclusão lógica).
```

<br>
<hr>

<h1 name="english">Food API</h1>

[Você também pode ler isto em Português! :)](#portuguese)
> RESTful API designed for restaurant menu management.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

Food API is a RESTful API developed and designed for managing restaurant menus. Created to be implemented in a front-end project developed with React, this API offers all the main HTTP methods that you need to perform CRUD (Create, Read, Update, Delete) operations.

## Used Technologies:

- Java
- Spring Boot
- JUnit
- Flyway Migrations
- MySQL

IDE: IntelliJ IDEA

## Installation

1. Clone the repository to the IDE:
   
```bash
git clone https://github.com/eurenaneu/food-api.git
```

2. Use Maven Importing option to install all the dependencies of the project:
3. Download and install [MySQL](https://dev.mysql.com/downloads/workbench/) and [XAMPP](https://www.apachefriends.org/pt_br/index.html)

**Note:** In case you prefer other DBMS, such as PostgreSQL or Oracle Database, just modify the applications.properties file and all Migrations SQL files.

## Endpoints
```markdown
GET /food - Returns all stored foods.

GET /food/active - Returns all stored and active foods.

GET /food/{id} - Returns a specific food.

POST /food - Registers a new food.

PUT /food/{id} - Updates all food info.

PATCH /food/{id} - Partially updates food info.

DELETE /food/{id} - Updates food status to INACTIVE (Logic Exclusion).
```
