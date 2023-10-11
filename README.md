# Food API

> Em breve, descrição detalhada.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)

Criada para ser utilizada com um projeto front-end feito em React.

## Tecnologias utilizadas

- Java
- Spring Boot
- Flyway Migrations
- MySQL

IDE: IntelliJ IDEA

## Instalação

1. Clone o repositório para a sua IDE
   
```bash
git clone https://github.com/eurenaneu/food-api
```

2. Utilize o Maven para instalar as dependências utilizadas no projeto
3. Baixe e instale o [MySQL](https://dev.mysql.com/downloads/workbench/) e o [XAMPP](https://www.apachefriends.org/pt_br/index.html)

**OBS:** Caso você prefira outro banco de dados, basta modificar o arquivo applications.properties e os arquivos SQL do Migrations.

## Endpoints
```markdown
GET /food - Retorna todas as comidas armazenadas.

GET /food/{id} - Retorna a comida associada ao ID.

POST /food - Cadastra uma comida nova.

PUT /food - Atualiza as informações da comida.

DEL /food/{id} - Atualiza o status da comida para INATIVA.
```
