package com.devleofulco.springJPA.repository;

import com.devleofulco.springJPA.model.Usuario;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
