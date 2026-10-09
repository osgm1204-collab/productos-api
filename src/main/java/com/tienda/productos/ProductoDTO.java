package com.tienda.productos;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private double precio;
    private String categoriaNombre; // solo el nombre, no el objeto entero

    public ProductoDTO(Long id, String nombre, double precio, String categoriaNombre) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoriaNombre = categoriaNombre;
    }

    // Convierte una entidad en DTO (metodo estatico, se llama sin crear objeto)
    public static ProductoDTO de(Producto p) {
        String nombreCat = (p.getCategoria() != null) ? p.getCategoria().getNombre() : null;
        return new ProductoDTO(p.getId(), p.getNombre(), p.getPrecio(), nombreCat);
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoriaNombre() { return categoriaNombre; }
}