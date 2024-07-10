package gestion.finanzas.personales.gfp.dto;

import gestion.finanzas.personales.gfp.model.Categoria;
import lombok.Builder;

import java.util.Base64;
@Builder
public record CategoriaResponseDto(Long id, String nombre, String imagen) {

    public static CategoriaResponseDto fromCategoria(Categoria categoria) {
        return CategoriaResponseDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .imagen(Base64.getEncoder().encodeToString(categoria.getImagen()))
                .build();
    }

    public Categoria toCategoria() {
        return Categoria.builder()
                .id(this.id)
                .nombre(this.nombre)
                .imagen(Base64.getDecoder().decode(this.imagen))
                .build();
    }
}
