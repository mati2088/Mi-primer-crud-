package com.usuarios.usuarios.repository;

import com.usuarios.usuarios.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Irepository extends JpaRepository<Usuarios,Long> {
}
