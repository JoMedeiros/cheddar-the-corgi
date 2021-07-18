<style>
@import url('https://fonts.googleapis.com/css2?family=Merriweather:wght@300&display=swap');

h1 {
	font-family: 'Merriweather', serif;
	font-style: italic;
	color: green;
}
</style>

# Instruções

Crie um banco de dados PostgreSQL e atualize as informações do arquivo
`application.properties` dentro da pasta `src/main/resources` com 
as informações do seu banco de dados.

## Executando
Esse é um projeto spring boot, então basta executar o comando:

```sh
mvn spring-boot:run
```
Ou caso não tenha o Maven instalado:

```sh
./mvnw spring-boot:run
```
