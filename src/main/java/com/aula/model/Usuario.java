package com.aula.model;

import com.aula.model.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String senha;
    private String telefone;
    private String endereco;

    public static Usuario fromDto(UsuarioDto usuarioDto){
        return new Usuario(null, usuarioDto.nome(), usuarioDto.email(),
                usuarioDto.senha(), usuarioDto.telefone(), usuarioDto.endereco());    }
}
