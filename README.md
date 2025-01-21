
# Descripción del Programa: Agenda Telefónica

Este programa simula una agenda telefónica donde se pueden agregar, listar, buscar, eliminar contactos, y verificar si la agenda está llena o no. Los contactos se guardan en un archivo de texto, "agenda.txt", para su persistencia.

## Clases y Métodos

### 1. Clase `Contacto`
Representa un contacto en la agenda, con dos atributos principales:
- `nombre`: Nombre del contacto (String).
- `telefono`: Teléfono del contacto (int).

#### Métodos:
- `getNombre()`: Devuelve el nombre del contacto.
- `setNombre()`: Establece el nombre del contacto.
- `getTelefono()`: Devuelve el teléfono del contacto.
- `setTelefono()`: Establece el teléfono del contacto.
- `equals(Contacto c)`: Compara si el nombre del contacto actual es igual al nombre de otro contacto, ignorando mayúsculas/minúsculas y espacios.
- `toString()`: Devuelve una representación en formato String del contacto.

### 2. Clase `Agenda`
Representa la agenda telefónica donde se almacenan los contactos.

#### Atributos:
- `contactos`: Un arreglo de objetos `Contacto`.

#### Métodos:
- `aniadirContacto(Contacto c)`: Añade un contacto a la agenda. Si el contacto ya existe o la agenda está llena, no lo añade.
- `existeContacto(Contacto c)`: Verifica si un contacto ya existe en la agenda.
- `listarContactos()`: Lista todos los contactos almacenados en la agenda.
- `buscarPorNombre(String nombre)`: Busca un contacto por nombre y muestra su teléfono.
- `agendaLlena()`: Verifica si la agenda está llena.
- `eliminarContacto(Contacto c)`: Elimina un contacto de la agenda.
- `huecosLibre()`: Devuelve el número de huecos libres en la agenda.

### 3. Clase `AgendaT`
Es la clase principal que permite al usuario interactuar con la agenda telefónica.

#### Funcionalidad:
El programa ofrece un menú interactivo con las siguientes opciones:
1. **Añadir contacto**: Permite agregar un nuevo contacto a la agenda, escribiendo su nombre y teléfono.
2. **Listar contactos**: Muestra todos los contactos almacenados en la agenda.
3. **Buscar contacto**: Busca un contacto por nombre y muestra su teléfono.
4. **Verificar existencia de contacto**: Verifica si un contacto existe en la agenda.
5. **Eliminar contacto**: Permite eliminar un contacto de la agenda.
6. **Ver contactos disponibles**: Muestra cuántos huecos libres hay en la agenda.
7. **Verificar si la agenda está llena**: Muestra si la agenda está llena o si hay espacio para más contactos.
8. **Salir**: Termina el programa.

### Flujo del Programa:
1. El programa inicia y permite al usuario seleccionar una opción del menú.
2. Si se selecciona añadir un contacto, el programa pide el nombre y teléfono del contacto, y lo guarda en la agenda.
3. Si se selecciona listar los contactos, el programa muestra todos los contactos almacenados.
4. El programa puede buscar contactos por nombre, verificar si un contacto existe, y eliminar contactos existentes.
5. Todos los cambios realizados en la agenda se reflejan en un archivo "agenda.txt", donde se almacenan los contactos.

## Uso:
Para usar el programa, se debe ejecutar la clase `AgendaT`, y el menú de opciones aparecerá en la consola. El usuario puede elegir las opciones según lo necesite.

