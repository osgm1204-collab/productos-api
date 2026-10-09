package com.tienda.productos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Categoria> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria c) {
        return repo.save(c);
    }

    @GetMapping("/{id}/productos")
    public ResponseEntity<List<Producto>> productosDe(@PathVariable Long id) {
        return repo.findById(id)
                .map(c -> ResponseEntity.ok(c.getProductos()))
                .orElse(ResponseEntity.notFound().build());
    }
}