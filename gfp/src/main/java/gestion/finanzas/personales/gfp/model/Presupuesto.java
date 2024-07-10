package gestion.finanzas.personales.gfp.model;

import gestion.finanzas.personales.gfp.enums.Mes;
import jdk.jfr.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "presupuesto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float monto;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Mes mes;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}