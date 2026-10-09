package com.tienda.productos;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listar() {
        return repo.findAll();
    }

    public Page<Producto> listarPaginado(Pageable pageable) {
        return repo.findAll(pageable);
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ProductoNoEncontradoException(id);
        }
        repo.deleteById(id);
    }

    @Transactional
    public Producto actualizar(Long id, Producto p) {
        if (!repo.existsById(id)) {
            throw new ProductoNoEncontradoException(id);
        }
        p.setId(id);
        return repo.save(p);
    }
}
