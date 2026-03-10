# Evidencia de Cumplimiento de Rúbrica - Sistema de Biblioteca
**Proyecto:** Registro de Libros (Java Swing + NIO)
**Autor:** [Nombre del Estudiante / Equipo 2]
**Fecha:** [Fecha actual]

A continuación se detalla cómo el proyecto implementado cumple con cada uno de los criterios estipulados en la rúbrica de evaluación:

## 1. Diseño de la interfaz gráfica (20 Puntos)
- **Implementación:** Se construyó una ventana principal (`FormularioBiblioteca.java`) que extiende de `JFrame`. Se utilizó `BorderLayout` para dividir la ventana en tres paneles: Izquierdo (Botones de acción), Central (Formulario de campos) y Sur (Listado o Tabla).
- **Formularios Claros:** La interfaz aloja campos de texto `JTextField` con sus respectivas etiquetas `JLabel` para: ISBN, Título, Autor, Editorial y Año de publicación.
- **Menú Funcional:** En la parte superior de la ventana se ha implementado una barra de menú desplegable `JMenuBar` con la opción `Archivo` y el submenú `Salir`, el cual cierra la aplicación limpiamente cerrando todos los procesos (`System.exit(0)`).
- **Evidencia requerida:** [**Insertar captura de pantalla de la ventana principal**].

## 2. Implementación CRUD (25 Puntos)
- **Nuevo:** El botón limpia todos los campos de texto (`limpiarCampos()`) para facilitar el ingreso de nueva información, y deselecciona la tabla de registros.
- **Guardar:** Convierte los datos de la interfaz a un objeto `Libro`, revisa validaciones como que no haya datos vacíos o exista ya un libro con dicho ISBN, y una vez persistido en código se manda guardar y actualizar la tabla.
- **Modificar:** Permite seleccionar un registro en la tabla cargando su información en el formulario para editar; valida que el nuevo ISBN (si se cambia) no choque con un tercero y posteriormente actualiza la misma fila y archivo de texto.
- **Eliminar:** Requiere seleccionar un libro del listado (`JTable`), pide una confirmación por seguridad al usuario a través de un `JOptionPane` antes de remover el objeto y sobreescribir la persistencia en el texto.
- **Evidencia requerida:** [**Insertar capturas de uso de cada botón (Nuevo, Guardar, Modificar, Eliminar) y mensajes de diálogo**].

## 3. Uso de archivos con NIO (25 Puntos)
- **Implementación:** Se creó la clase enfocada en la lógica I/O `GestorArchivosNIO.java` en lugar del uso viejo de `java.io`.
- **Lectura/Escritura con java.nio.file:** El proyecto hace uso del API NIO utilizando `Path`, `Paths.get()`, `Files.readAllLines()` y `Files.write()` con directivas modernas de apertura de archivo (`StandardOpenOption.CREATE`, `StandardOpenOption.TRUNCATE_EXISTING`) respetando las características de la librería y la codificación en UTF-8.
- **Archivo persistido:** Se lee y manipula el archivo `libros_biblioteca.txt` por cada cambio en el estado en memoria para salvaguardar siempre la información de los libros.

## 4. Validación de datos (15 Puntos)
- **Validación Lógica:** La clase Entidad del modelo (`Libro.java`) contiene en su constructor y métodos _Setters_ las validaciones base para lanzar `IllegalArgumentException` si un campo es nulo o vacío, así como forzar un año mayor a cero.
- **Validación Visual/Formulario:** El formulario `FormularioBiblioteca.java` atrapa todas las excepciones e impide registros incorrectos:
    - Revisa que el ISBN no se repita con ningún otro registro al Guardar y/o Modificar.
    - Captura con bloque `catch(NumberFormatException)` la conversión del texto a número de año en caso de que un usuario coloque letras, y muestra una alerta (`JOptionPane.ERROR_MESSAGE`).
    - Exige que ningún campo del formulario se encuentre vacío antes de iniciar el guardado.

## 5. Documentación y evidencias (15 Puntos)
- **Cumplimiento:** Este documento detalla minuciosamente qué hace cada parte y por qué pertenece a su criterio. Se preparó además el archivo de texto `libros_biblioteca.txt` con ejemplos de prueba pre-cargados para exhibir la funcionalidad instantáneamente sin partir de cero cada vez.

---
### Pasos para probar (Archivo de prueba)
El proyecto incluye un archivo *libros_biblioteca.txt* generado en el entorno mediante Java NIO. Compile y corra el programa para observar los registros desplegados. Compruebe modificar uno de los códigos de título o año seleccionándolo con su *mouse* desde la propia tabla del programa.
