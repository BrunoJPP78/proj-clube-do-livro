package com.aula.service;

import com.aula.model.Usuario;
import com.aula.model.dto.UsuarioDto;
import com.aula.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Page<UsuarioDto> findAll(Pageable pagination){
        return usuarioRepository.findAll(pagination).map(l -> new UsuarioDto(l));
    }

    public UsuarioDto findById(Long id) {
        return new UsuarioDto(usuarioRepository.getReferenceById(id));
    }

    @Transactional
    public UsuarioDto save(UsuarioDto usuarioDto) {
        Usuario usuario = Usuario.fromDto(usuarioDto);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }

    @Transactional
    public UsuarioDto update(Long id, UsuarioDto usuarioDto) {
        Usuario usuario = Usuario.fromDto(usuarioDto);
        usuario.setId(id);
        return new UsuarioDto(usuarioRepository.save(usuario));
    }

    @Transactional
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

}
