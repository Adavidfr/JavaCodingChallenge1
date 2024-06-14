import java.util.List;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Usuario usuario1 = new Usuario(1L, "David");
        Usuario usuario2 = new Usuario(2L, "Katy");

        biblioteca.agregarUsuariio(usuario1);
        biblioteca.agregarUsuariio(usuario2);

        Libro libro1 = new Libro(1L, "El Quijote", "Miguel de Cervantes", "Novela");
        Libro libro2 = new Libro(2L, "Cien años de soledad", "Gabriel Garcia Marquez", "Novela");
        Libro libro3 = new Libro(3L, "El señor de los anillos", "J.R.R. Tolkien", "Fantasia");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);


        System.out.println("=========Mostrar libros=========");
        biblioteca.mostrarLibros();

        System.out.println();
        System.out.println("===========buscar libro por título=====");
        List<Libro> librosEncontrados = biblioteca.buscarLibroPorTitulo("El Quijote");
        for (Libro libro : librosEncontrados) {
            System.out.println(libro);
        }

        System.out.println();
        System.out.println("===========buscar libro por autor====");
        List<Libro> librosEncontradosAutor = biblioteca.buscarLibroPorAutor("J.R.R. Tolkien");
        for (Libro libro : librosEncontradosAutor) {
            System.out.println(libro);
        }


        System.out.println();
        System.out.println("===========prestar libro====");
        biblioteca.prestarLibro(3L, 2L);
        biblioteca.prestarLibro(1L, 1L);
        biblioteca.devolverLibro(3L);
        biblioteca.prestarLibro(3L, 1L);

        System.out.println();
        System.out.println("=======libros disponibles=======");
        biblioteca.mostrarLibrosDisponibles();

        System.out.println();
        System.out.println("========Historial de préstamos===========");
        biblioteca.mostrarHistorialDePrestamos(3L);

    }

}