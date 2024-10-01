package com.aula.model;

import com.aula.enums.LivroStatus;
import com.aula.model.dto.LivroDto;
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
@Table(name = "tb_livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity pois estamos usando MySQL
    private Long id;
    @Column(length = 80, nullable = false) //VARCHAR(80) e nao pode ser NULO
    private String titulo;
    @Column(length = 150, nullable = false)
    private String descricao;
    @Column(length = 2, nullable = false)
    private Float nota;
    private Integer qtedPaginas;
    @Enumerated(EnumType.STRING)
    private LivroStatus livroStatus;

    //conversor para o DTO
    public static Livro fromDto(LivroDto livroDto) {
        return new Livro(null, livroDto.titulo(), livroDto.descricao(),
                livroDto.nota(), livroDto.qtdePaginas(), livroDto.livroStatus());
    }
}
