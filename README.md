# Sistema de Registro de Libros de Biblioteca 📚

Este es un proyecto desarrollado en **Java (JFrame & NIO)** para cumplir con los requerimientos del Caso de Estudio 3 ("Sistema de Registro de Libros de Biblioteca"). Se trata de una aplicación de escritorio que permite gestionar un catálogo bibliotecario mediante operaciones CRUD completas, persistiendo los datos de manera local y garantizando una arquitectura limpia.

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Swing-007396?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white" />
</p>

## Características Principales ⚙️

- **Interfaz Gráfica Intuitiva:** Desarrollada 100% en código Java puro (sin dependencias `.form` de IDEs) usando `JFrame`, `JPanel` y `JTable` para una visualización ordenada.
- **Gestión de Archivos con java.nio:** Utiliza de forma nativa la librería `java.nio.file.Files` para la lectura y escritura de un archivo serializado `.txt`, asegurando operaciones de I/O eficientes.
- **Operaciones CRUD Funcionales:**
  - **Nuevo:** Limpia el formulario para capturar un libro desde cero.
  - **Guardar (Alta):** Valida la información del formulario, añade a la memoria y persiste en el archivo en disco.
  - **Modificar:** Actualiza registros interactuando desde la tabla o campo específico y los almacena dinámicamente.
  - **Eliminar:** Quita permanentemente libros del archivo tras una confirmación de seguridad.
- **Validaciones Seguras:** Evita el grabado de campos en blanco y evalúa la entrada de año en formato numérico (int), retroalimentando a través de modales visuales (`JOptionPane`).

## Estructura del Código 📦

El código fuente implementa una separación lógica clara (MVC aproximado):
1. **`Libro.java`:** La clase del modelo. Abstrae la entidad libro estableciendo una **Validación Temprana del Dominio** durante su construcción, evitando instanciar libros en estados inconsistentes.
2. **`GestorArchivosNIO.java`:** El intermediario encargado de manipular el archivo `libros_biblioteca.txt`. Exclusivamente utiliza librerías `nio`.
3. **`FormularioBiblioteca.java`:** El núcleo visual y controlador temporal. Reúne todos los componentes Swing, delega los clics, gestiona la tabla interna y despacha el CRUD.
4. **`BibloitecaEquipo2.java`:** El punto de entrada seguro (`SwingUtilities.invokeLater()`).

## Requisitos 💻

*   **Java Development Kit (JDK 17+)**
*   **Apache Maven** (para compilación limpia del POM asociado)
*   Integración probada con **Apache NetBeans**.

## Cómo Ejecutar ▶️

1. Clona este repositorio:
   ```bash
   git clone https://github.com/AlejandroMontijo/BibloitecaEquipo2.git
   ```
2. Compila y ejecuta la clase principal desde tu IDE favorito (ej. Apache NetBeans) seleccionando el archivo `BibloitecaEquipo2.java`.
3. Alternativamente usando la terminal mediante Maven:
   ```bash
   mvn clean compile exec:java -Dexec.mainClass="com.mycompany.bibloitecaequipo2.BibloitecaEquipo2"
   ```

*Nota:* Al arrancar el sistema, cargará de forma automática los registros de prueba previamente declarados en el archivo adjunto `libros_biblioteca.txt`.
