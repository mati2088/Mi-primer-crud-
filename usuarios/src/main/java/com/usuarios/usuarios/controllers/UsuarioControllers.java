package com.usuarios.usuarios.controllers;

import com.usuarios.usuarios.entity.Usuarios;
import com.usuarios.usuarios.services.UsuariosServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class UsuarioControllers {
    @Autowired
    private UsuariosServiceIMPL usuariosServiceIMPL;





    @GetMapping("/listarUsuarios")
    public List<Usuarios>listarUsuarios(){
        return usuariosServiceIMPL.listarUsuarios();
    }
    @DeleteMapping("/eliminarUsuarios/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        if(!usuariosServiceIMPL.obtenerPorId(id).isPresent())
        {

            return ResponseEntity.notFound().build();
        }

        usuariosServiceIMPL.eliminarPorId(id);
        return ResponseEntity.ok().build();
    }



    @PostMapping("/crearUsuario")
    public ResponseEntity<?> create(@RequestBody Usuarios usuarios){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosServiceIMPL.guardarUsuario(usuarios));
    }
    @PutMapping("/ediarUsuarios/{id}")
    public ResponseEntity<?> update(@RequestBody Usuarios userDetails, @PathVariable long id){
        Optional<Usuarios> user= usuariosServiceIMPL.obtenerPorId(id);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setNombre(userDetails.getNombre());
        user.get().setApellido(userDetails.getApellido());
        user.get().setEmail(userDetails.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosServiceIMPL.guardarUsuario(user.get()));

    }





}
