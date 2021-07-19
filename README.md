# Instruções

Crie um banco de dados PostgreSQL e atualize as informações do arquivo
`application.properties` dentro da pasta `src/main/resources` com 
as informações do seu banco de dados.

## Dependências
As dependências do projeto estão listas no arquivo `pom.xml`. Para instalar
caso tenha o maven instalado execute o comando:

```sh
mvn clean install
```
Caso não tenha o maven instalado execute o comando:

```sh
./mvnw clean install
```

## Executando
Esse é um projeto spring boot, então basta executar o comando:

```sh
mvn spring-boot:run
```
Ou caso não tenha o Maven instalado:

```sh
./mvnw spring-boot:run
```

# API endpoints

Alguns endpoints importantes da API (onde {rootUrl} é a url do servidor ex:
locahost:8080):

- POST {rootUrl}/api/gerarUrl
	- Expera um objeto json na forma:

```json
{ 
	"longUrl" : "https://www.example.com/url-muito-longa", 
	"expiresDate" : "22/07/2025" 
}
```
- GET {rootUrl}/api/urls
	- Retorna todas as urls cadastradas (é necessário que o usuários esteja 
	logado)

