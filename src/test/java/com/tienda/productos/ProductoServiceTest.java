package com.tienda.productos;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {

    @Mock
    private ProductoRepository repo;      // bodega falsa

    @InjectMocks
    private ProductoService service;      // cocinero real con la bodega falsa

    @Test
    void listar_devuelveTodosLosProductos() {
        // 1. Preparar
        Producto p1 = new Producto();
        p1.setId(1L);
        p1.setNombre("Camisa");
        p1.setPrecio(199);

        Producto p2 = new Producto();
        p2.setId(2L);
        p2.setNombre("Pantalon");
        p2.setPrecio(350);

        when(repo.findAll()).thenReturn(List.of(p1, p2));

        // 2. Ejecutar
        List<Producto> resultado = service.listar();

        // 3. Verificar
        assertEquals(2, resultado.size());
        assertEquals("Camisa", resultado.get(0).getNombre());
        verify(repo, times(1)).findAll();
    }

    @Test
    void eliminar_productoNoExiste_lanzaExcepcion() {
        when(repo.existsById(99L)).thenReturn(false);

        assertThrows(ProductoNoEncontradoException.class, () -> service.eliminar(99L));

        verify(repo, never()).deleteById(any());
    }

    @Test
    void eliminar_productoExiste_llamaDeleteById() {
        when(repo.existsById(1L)).thenReturn(true);

        service.eliminar(1L);

        verify(repo, times(1)).deleteById(1L);
    }
}