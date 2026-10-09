package com.tienda.productos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.productos")
    List<Categoria> findAllConProductos();
}