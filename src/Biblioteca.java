import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {

    private Map<Long, Libro> libros;
    private Map<Long, Usuario> usuarios;
    private Map<Long, List<Long>> historialPrestamos;

    public Biblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.historialPrestamos = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.put(libro.getId(), libro);
    }

    public void eliminarLibro(Long id) {
        libros.remove(id);
    }

    public List<Libro> buscarLibroPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public List<Libro> buscarLibroPorGenero(String genero) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros.values()) {
            if (libro.getGenero().equalsIgnoreCase(genero)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public void mostrarLibros() {
        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
    }

    public void mostrarLibrosDisponibles() {
        for (Libro libro : libros.values()) {
            if (libro.isDisponible()) {
                System.out.println(libro);
            }
        }
    }

    public void prestarLibro(Long libroId, Long usuarioId) {
        if (libros.containsKey(libroId) && usuarios.containsKey(usuarioId)) {
            Libro libro = libros.get(libroId);
            if (libro.isDisponible()) {
                libro.setDisponible(false);
                if (!historialPrestamos.containsKey(libroId)) {
                    historialPrestamos.put(libroId, new ArrayList<>());
                }
                historialPrestamos.get(libroId).add(usuarioId);
                Libro libro1 = libros.get(libroId);
                Usuario usuario = usuarios.get(usuarioId);
                System.out.println("El libro: " + libro1.getTitulo() + " ha sido prestado con éxito a " + usuario.getNombre());
            } else {
                System.out.println("El libro no está disponible");
            }
        }
    }

    public void devolverLibro(Long libroId) {
        if (libros.containsKey(libroId)) {
            Libro libro = libros.get(libroId);
            libro.setDisponible(true);
            System.out.println("Libro devuelto con éxito");
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public void mostrarHistorialDePrestamos(Long libroId) {
        if (historialPrestamos.containsKey(libroId)) {
            List<Long> historial = historialPrestamos.get(libroId);
            Libro libro = libros.get(libroId);
            System.out.println("Historial de préstamos para el libro " + libro.getTitulo() + ": ");
            for (Long usuarioId : historial) {
                Usuario usuario = usuarios.get(usuarioId);
                System.out.println("- Prestado a: " + usuario.getNombre());
            }
        } else {
            System.out.println("No hay historial de préstamos para este libro");
        }
    }

    public void agregarUsuariio(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }
}
