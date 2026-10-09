package com.tienda.productos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping("/dto")
    public List<ProductoDTO> listarDTO() {
        return service.listar().stream()
                .map(ProductoDTO::de)
                .collect(Collectors.toList());
    }

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/pagina")
    public Page<Producto> listarPaginado(Pageable pageable) {
        return service.listarPaginado(pageable);
    }

    @PostMapping
    public Producto crear(@Valid @RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        return service.actualizar(id, producto);
    }
}
