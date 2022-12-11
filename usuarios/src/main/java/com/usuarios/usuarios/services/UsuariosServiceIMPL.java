package com.usuarios.usuarios.services;

import com.usuarios.usuarios.entity.Usuarios;
import com.usuarios.usuarios.repository.Irepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceIMPL  implements IUsuarioService{
    @Autowired
    private Irepository repository;

    @Override
    public List<Usuarios> listarUsuarios() {
        return repository.findAll();
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuarios) {
        return repository.save(usuarios);
    }

    @Override
    public Optional<Usuarios> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarPorId(Long id) {
            repository.deleteById(id);

    }
}
