# OBSERVABILITY ELK
Projeto de estudos da integração do Spring Boot e a stack ELK.

## Requisitos

* Java 11
* Make (É possivel fazer tudo sem o make, bastando rodar o docker-compose up e o mvn spring-boot:run manualmente ao invez de make dependencie e make run)
* Maven
* Docker
* Docker Compose
* Curl ou Postman


## Como executar?

Rode o comando `make dependencies`, onde serão iniciados um container ElasticSearch, um container do Kibana e outro com o Logstash.
Em seguida rode um projeto na sua IDE ou execute o comando `make run`

## Como testar
Uma vez que seu projeto está rodando acesse http://localhost:5601 espere o kibana carregar completamente e em seguida 
clique na aba discovery e crie um index pattern para `logstash*`
com a aplicação spring no ar utilize o curl ou postman para criar um usuário execute: 
`curl -X POST -H "Content-Type:application/json" -d '{
"name":"User Test",
"email":"user.test@gmail.com"
}' http://localhost:8080/user/`  
Para ver os usuários da base utilize o comando: `curl http://localhost:8080/user/`  
uma vez execultados os comandos a cima,acesse http://localhost:5601/app/discover#  
aonde é possivel criar filtros e ver os logs da aplicação

