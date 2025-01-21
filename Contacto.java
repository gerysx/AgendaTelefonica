public class Contacto {
    
    private String nombre; // Atributo para almacenar el nombre del contacto
    private int telefono;  // Atributo para almacenar el teléfono del contacto

    // Constructor con nombre y teléfono
    public Contacto(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Constructor con solo nombre, el teléfono se inicializa a 0
    public Contacto(String nombre) {
        this.nombre = nombre;
        this.telefono = 0;
    }

    // Métodos getter y setter para obtener y modificar los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    // Método equals que compara dos contactos por el nombre
    public boolean equals(Contacto c) {
        // Compara los nombres de los contactos ignorando mayúsculas/minúsculas
        if(this.nombre.trim().equalsIgnoreCase(c.getNombre().trim())){
            return true;
        }
        return false;
    }

    // Método toString para mostrar la información del contacto
    @Override
    public String toString() {
        return "nombre=" + nombre + ", telefono=" + telefono;
    }
}
