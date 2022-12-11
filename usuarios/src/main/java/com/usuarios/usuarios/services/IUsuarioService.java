package com.usuarios.usuarios.services;

import com.usuarios.usuarios.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuarios> listarUsuarios();

    public Usuarios guardarUsuario(Usuarios usuarios);

    public Optional<Usuarios> obtenerPorId(Long id);

    public void eliminarPorId(Long id);


}
