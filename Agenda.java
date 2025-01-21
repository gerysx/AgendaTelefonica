public class Agenda {

    // Atributo para almacenar los contactos
    private Contacto[] contactos;

    // Constructor por defecto que crea una agenda con 10 espacios
    public Agenda() {
        this.contactos = new Contacto[10];
    }

    // Constructor que permite especificar el tamaño de la agenda
    public Agenda(int tamanio) {
        this.contactos = new Contacto[tamanio];
    }

    // Método que añade un contacto a la agenda
    public boolean aniadirContacto(Contacto c) {
        // Comprobamos si el contacto ya existe
        if (existeContacto(c)) {
            System.out.println("El contacto con ese nombre ya existe");
            return false;
        } 
        // Comprobamos si la agenda está llena
        else if (agendaLlena()) {
            System.out.println("La agenda está llena, no se pueden meter más contactos");
            return false;
        } else {
            // Buscamos un lugar vacío para añadir el contacto
            for (int i = 0; i < contactos.length; i++) {
                if (contactos[i] == null) {
                    contactos[i] = c; // Insertamos el contacto
                    System.out.println("Se ha añadido");
                    return true; // Retornamos true si el contacto se ha añadido
                }
            }
        }
        System.out.println("No se ha podido añadir el contacto");
        return false;
    }

    // Método que verifica si existe un contacto en la agenda
    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto != null && c.equals(contacto)) {
                return true; // Si el contacto ya está en la agenda, retornamos true
            }
        }
        return false;
    }

    // Método para listar todos los contactos de la agenda
    public void listarContactos() {
        if (huecosLibre() == contactos.length) {
            System.out.println("No hay contactos que mostrar");
        } else {
            for (Contacto contacto : contactos) {
                if (contacto != null) {
                    System.out.println(contacto); // Mostramos cada contacto no nulo
                }
            }
        }
    }

    // Método que busca un contacto por su nombre
    public void buscarPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto != null && contacto.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                System.out.println("Su teléfono es " + contacto.getTelefono());
                return;
            }
        }
        System.out.println("No se ha encontrado el contacto");
    }

    // Método que verifica si la agenda está llena
    public boolean agendaLlena() {
        for (Contacto contacto : contactos) {
            if (contacto == null) {
                return false; // Si hay espacios vacíos, retornamos false
            }
        }
        return true; // Si no hay espacios vacíos, la agenda está llena
    }

    // Método que elimina un contacto de la agenda
    public boolean eliminarContacto(Contacto c) {
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].equals(c)) {
                contactos[i] = null; // Eliminar el contacto
                System.out.println("Se ha eliminado el contacto");
                return true; // Retornamos true si el contacto fue eliminado
            }
        }
        System.out.println("No se ha eliminado el contacto");
        return false;
    }

    // Método que devuelve la cantidad de huecos libres en la agenda
    public int huecosLibre() {
        int contadorLibres = 0;
        for (Contacto contacto : contactos) {
            if (contacto == null) {
                contadorLibres++; // Contamos los huecos vacíos
            }
        }
        return contadorLibres;
    }

    // ** Método que falta, añadido para solucionar el error **
    // Devuelve el array de contactos
    public Contacto[] getContactos() {
        return contactos;
    }
}
