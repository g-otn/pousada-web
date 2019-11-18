# Arquivos de banco de dados

Esta pasta contém scripts SQL para configurar o banco de dados que o projeto utilizará. 
Atualmente apenas scripts para o PostgreSQL estão disponíveis.

Para configurar o banco, siga esses passos:
1. Instale o PostgreSQL e o pgAdmin4 (recomendado).
2. Crie o usuário e o banco que a aplicação utilizará:
   - Usuário: `es3_usuario`
   - Senha: `es3`
   - Banco de Dados: `es3_db`

Caso queria alterar esses nomes você também deverá alterar o arquivo de conexão com o banco de dados (`Conexao[...].java`), 
localizado em `src\java\br\com\gotn\pousada\util`:
```java
    private static final String DATABASE_NAME = "es3_db";
    private static final String USER = "es3_usuario";
    private static final String USER_PASSWORD = "es3";
```

3. No banco de dados criado, crie o esquema `pousada`.
4. No pgAdmin, abra a ferramenta de query (Query Tool) para colar e executar os scripts, nessa ordem:
   - `create_tables.sql`
