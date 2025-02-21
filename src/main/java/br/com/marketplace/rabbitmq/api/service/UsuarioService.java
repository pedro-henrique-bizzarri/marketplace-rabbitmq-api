package br.com.marketplace.rabbitmq.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marketplace.rabbitmq.api.domain.entity.Usuario;
import br.com.marketplace.rabbitmq.api.exception.UserNotFoundException;
import br.com.marketplace.rabbitmq.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario pesquisarPorCodigo(Long codigo){
        return usuarioRepository.findByCodigo(codigo)
            .orElseThrow(UserNotFoundException::new);
    }

    public List<Usuario> listar(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        if(usuarios.isEmpty())
            throw new UserNotFoundException();
       
        return usuarios;
    }
}
