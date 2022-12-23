"# wkt-test-backend" 

1 -> Criar banco wkttestdb com colação utf8mb4_general_ci para evitar errinhos gravinhos

2 -> Rodar aplicação Spring

3 -> Rodar esse SQL no banco para criar usuário padrão e permitir autenticação:
REPLACE  INTO users (id, email, name, password)
VALUES (1, "naruto@ninja.com","Naruto","$2a$12$XiTbWwJi0RqgAvIN220EU.LDMXOWfRoBJ0yAUi/sZ.Uj6lVG6qHnq");

4 -> HTTP POST no endpoint /api/candidates para cadastrar os candidatos pelo JSON

5 -> Testar pelo Front em Angular desse repositório: https://github.com/JeanTesla/wkt-test-frontend
