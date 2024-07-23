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

        for (Usuario u: repository.findAll()){
            System.out.println(u);
        }
    }
}
