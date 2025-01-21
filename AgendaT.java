import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaT {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion;

        Agenda agendaTelefonica = new Agenda(50);
        String nombre;
        int telefono;

        Contacto c;

        FileWriter archivo = null;
        PrintWriter escribir = null;

        try {
            archivo = new FileWriter("agenda.txt", true); // Abre el archivo para añadir información
            escribir = new PrintWriter(archivo);

            while (!salir) {

                System.out.println("1. Añadir contacto");
                System.out.println("2. Listar contactos");
                System.out.println("3. Buscar contacto");
                System.out.println("4. Existe contacto");
                System.out.println("5. Eliminar contacto");
                System.out.println("6. Contactos disponibles");
                System.out.println("7. Agenda llena");
                System.out.println("8. Salir");

                try {
                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Escribe un nombre");
                            nombre = sn.next();
                            System.out.println("Escribe un telefono");
                            telefono = sn.nextInt();

                            c = new Contacto(nombre, telefono);
                            if (agendaTelefonica.aniadirContacto(c)) {
                                escribir.println("Nombre: " + nombre + ", Teléfono: " + telefono);
                                escribir.flush(); // Asegura que el contacto se escriba en el archivo
                                System.out.println("Contacto añadido y guardado en el archivo.");
                            } else {
                                System.out.println("No se pudo añadir el contacto. Puede que la agenda esté llena.");
                            }
                            break;
                        case 2:
                            agendaTelefonica.listarContactos();
                            break;
                        case 3:
                            System.out.println("Escribe un nombre");
                            nombre = sn.next();
                            agendaTelefonica.buscarPorNombre(nombre);
                            break;
                        case 4:
                            System.out.println("Escribe un nombre");
                            nombre = sn.next();
                            c = new Contacto(nombre, 0);
                            if (agendaTelefonica.existeContacto(c)) {
                                System.out.println("Existe contacto");
                            } else {
                                System.out.println("No existe contacto");
                            }
                            break;
                        case 5:
                            System.out.println("Escribe un nombre para eliminar:");
                            nombre = sn.next();
                            c = new Contacto(nombre, 0);
                            if (agendaTelefonica.eliminarContacto(c)) {
                                try (FileWriter archivoNuevo = new FileWriter("agenda.txt"); PrintWriter escribirNuevo = new PrintWriter(archivoNuevo)) {
                                    for (Contacto contacto : agendaTelefonica.getContactos()) {
                                        if (contacto != null) {
                                            escribirNuevo.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono());
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error al actualizar el archivo: " + e.getMessage());
                                }
                                System.out.println("Contacto eliminado y archivo actualizado.");
                            } else {
                                System.out.println("No se encontró el contacto para eliminar.");
                            }
                            break;
                        case 6:
                            System.out.println("Hay " + agendaTelefonica.huecosLibre() + " contactos libres.");
                            break;
                        case 7:
                            if (agendaTelefonica.agendaLlena()) {
                                System.out.println("La agenda está llena.");
                            } else {
                                System.out.println("Aún puedes meter contactos.");
                            }
                            break;
                        case 8:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 8.");
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número.");
                    sn.next();
                }
            }
        } catch (IOException e) {
            System.out.println("Error al abrir o escribir en el archivo: " + e.getMessage());
        } finally {
            if (escribir != null) {
                escribir.close();
            }
            if (archivo != null) {
                try {
                    archivo.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
}
