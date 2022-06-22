# OBSERVABILITY ELK
Projeto de estudos da integração do Spring Boot e a stack ELK.

## Requisitos

* Docker
* Docker Compose
* Make (Opcional mas facilita)


## Como executar?

Rode o comando `make dependencies`, onde serão iniciados um container ElasticSearch, um container do Kibana e outro com o Logstash.
Em seguida rode um projeto na sua IDE (Caso tenha o Java e o Maven configurados) ou execute o comando `make build` (Isso demora uns 5 minutos) e em seguida um `make run`

## Como testar?

Uma vez que seu projeto está rodando acesse http://localhost:5601 espere o kibana carregar completamente e em seguida 
clique na aba discovery e crie um index pattern para `logstash*`
com a aplicação spring no ar utilize o swagger em http://localhost:8080 para criar um usuário.
Uma vez execultados os passos acima,acesse http://localhost:5601/app/discover#  
Aonde é possivel criar filtros e ver os logs da aplicação.

