# ORM e JPA no Spring Boot

### ORM (Object-Relational Mapping)

ORM (Mapeamento Objeto-Relacional) é uma técnica de programação que permite a conversão de dados entre sistemas incompatíveis usando a programação orientada a objetos. O ORM facilita a manipulação de dados em um banco de dados relacional utilizando classes e objetos, eliminando a necessidade de escrever SQL bruto.

### JPA (Java Persistence API)

JPA (Java Persistence API) é uma especificação Java que padroniza o mapeamento objeto-relacional. Ele define uma maneira de gerenciar dados relacionais em aplicações Java. O Spring Boot utiliza o JPA para simplificar o acesso a dados e o mapeamento de entidades.

### Injeção de Dependência e Inversão de Controle no Spring Boot

A Injeção de Dependência (DI) é um padrão de projeto que permite a criação de dependências fora de uma classe e a sua injeção na classe. A Inversão de Controle (IoC) é um princípio onde o controle do fluxo do programa é invertido e delegado a um contêiner ou framework. No Spring Boot, o contêiner IoC gerencia a injeção de dependências automaticamente, facilitando a construção de aplicações modulares e testáveis.

## ORM

### Exemplo de ORM utilizando o Spring Boot

No exemplo abaixo, temos a entidade `Usuario` mapeada para uma tabela no banco de dados usando JPA.

```java
package com.devleofulco.springJPA.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
```

## JPA no Spring Boot

### Exemplo de JPA utilizando o Spring Boot

No exemplo abaixo, utilizamos o JPA no Spring Boot para criar um repositório para a entidade `Usuario` e realizar operações de CRUD.

```java
package com.devleofulco.springJPA.repository;

import com.devleofulco.springJPA.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
```

### Inicialização da Aplicação

A classe `InicializarApp` demonstra como salvar um usuário no banco de dados e listar todos os usuários salvos.

```java
package com.devleofulco.springJPA;

import com.devleofulco.springJPA.model.Usuario;
import com.devleofulco.springJPA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InicializarApp implements CommandLineRunner {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Usuario pessoa1 = new Usuario();
        pessoa1.setNome("Leandresson");
        pessoa1.setUsername("DevLeoFulco");
        pessoa1.setPassword("testesJava");

        repository.save(pessoa1);

        for (Usuario u : repository.findAll()) {
            System.out.println(u);
        }
    }
}
```

## Importância de Entender essa Estrutura

Compreender ORM e JPA é essencial para desenvolver aplicações Java robustas e escaláveis. Eles facilitam a interação com o banco de dados, promovem a reutilização de código e reduzem a complexidade de manutenção.

## Facilidade em Fazer Mapeamentos de Dados Utilizando o Spring Boot JPA

O Spring Boot, em conjunto com o JPA, simplifica o processo de mapeamento objeto-relacional. Com anotações simples, é possível definir como os objetos Java são mapeados para tabelas no banco de dados, permitindo a criação de consultas e manipulações de dados de maneira intuitiva e eficiente.

## Facilidade em Conectar com Diversos Bancos de Dados usando Spring Boot

O Spring Boot oferece suporte integrado para vários bancos de dados, incluindo MySQL, PostgreSQL, H2, entre outros. Configurar a conexão é tão simples quanto adicionar as dependências necessárias e definir as propriedades de conexão no arquivo `application.properties`.
