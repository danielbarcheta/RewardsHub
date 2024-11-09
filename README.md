[EM PROGRESSO]
Sistema de fidelização de clientes
-> Projeto fullstack para criação de uma aplicação que permite armazenar os registros das passagens e compras de clientes em uma empresa
e acumular pontos para serem trocados por brindes/descontos

A SER IMPLEMENTADO:
- Front end
- Construção das APIs
- API Gateway para direcionar as requisicoes entre os microssevicos, sendo estes: Envio de email/whatsapp, Acumulo de pontos, Notificacoes (RabbitMQ)
- Servicos no back para acumular pontos
- Melhorias de performance de acesso aos dados (indexacao, cache, etc)
- Alguns liquibases para melhorar o esquema que está incompleto
- Dockerização e deploy na AWS
