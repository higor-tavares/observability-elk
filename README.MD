# OBSERVABILITY ELK
Projeto de estudos da integração do Spring Boot e a stack ELK.

## Requisitos

* Docker
* Docker Compose
* Curl ou Postman
* Make (Opcional mas facilita)


## Como executar?

Rode o comando `make dependencies`, onde serão iniciados um container ElasticSearch, um container do Kibana e outro com o Logstash.
Em seguida rode um projeto na sua IDE (Caso tenha o Java e o Maven configurados) ou execute o comando `make build` (Isso demora uns 5 minutos) e em seguida um `make run`

## Como testar?

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

