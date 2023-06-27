import java.util.*;

public class VentaLibro {
    public static void main(String[] args) {

        System.out.println("Bienvenido a la librería");

        Scanner scanner = new Scanner(System.in);

        // Crea una lista de libros
        List<Libro> lista = new ArrayList<>();

        // Agrega libros a la lista
        lista.add(new Libro(1, "Ficcion", "El Aleph", "Jorge Luis Borges", "Sur", Estado.Original, 10.0));
        lista.add(new Libro(2, "Ficcion", "La biblioteca de Babel", "Jorge Luis Borges", "Alianza", Estado.Original, 10.0));
        lista.add(new Libro(3, "Terror", "La llamada de Cthulhu", "Howard Phillips Lovecraft", "NoBooks", Estado.Usado, 8.0));
        lista.add(new Libro(4, "Terror", "En las motañas de la locura", "Howard Phillips Lovecraft", "NoBooks", Estado.Original, 10.0));
        lista.add(new Libro(5, "Tragedia", "Antigona Edipo Rey", "Howard Phillips Lovecraft", "Cantaro", Estado.Original, 10.0));
        lista.add(new Libro(6, "Novela", "Mi planta de naranja lima", "Jose Mauro de Vasconcelos", "El Ateneo", Estado.Usado, 8.0));




        //Conjunto para que no se repita los generos
        HashSet<String> generos = new HashSet<>();
        for (Libro genLibro : lista) {
            generos.add(genLibro.getGenero());
        }

        // Muestra los generos disponibles de la libreria
        System.out.println("Tenemos en la librería los siguientes géneros:");

        for (String genero : generos) {
            System.out.println("Genero: " + genero);
        }

        // Pide al usuario que ingrese el género que quiere buscar
        System.out.print("Ingrese el género que desea buscar: ");

        String genero = scanner.nextLine();

        boolean librosEncontrados = false;

        // Buscar el genero del libro ingresado

        do {
            System.out.println("Libros disponibles del genero " + genero + ":");
            for (Libro libro2 : lista) {
                if (libro2.getGenero().equals(genero)) {
                    System.out.println("Id: " + libro2.getId());
                    System.out.println("Genero: " + libro2.getGenero());
                    System.out.println("Titulo: " + libro2.getTitulo());
                    System.out.println("Autor: " + libro2.getAutor());
                    System.out.println("Editorial: " + libro2.getEditorial());
                    System.out.println("Estado: " + libro2.getEstado());
                    System.out.println("Precio: " + libro2.getPrecio());
                    System.out.println("-------------------------------");
                    librosEncontrados = true;

                }
            }
            if(!librosEncontrados){
                //en caso que no se encuentren libros, solicita un nuevo genero
                System.out.println("No se encontraron libros del genero especificado.");
                System.out.println("Ingrese un nuevo genero: ");
                genero = scanner.nextLine();
            }

        } while (!librosEncontrados);

        // Pregunta al usuario si desea comprar algun libro
        System.out.println("¿Desea comprar algun libro? (s/n): ");
        String respuesta = scanner.nextLine();

        double totalAPagar = 0.0;
        List<String> librosComprados = new ArrayList<>(); // Lista para almacenar los títulos de los libros comprados


        //Proceso de comprar
        while(respuesta.equals("s")){
            //Pedir que id quiere comprar
            System.out.println("Ingrese el ID del libro que desea comprar: ");
            int idLibro = scanner.nextInt();
            scanner.nextLine();

            Libro libroSeleccionado = null;

            // Buscar el libro con el id ingresado
            for(Libro libro2 : lista){
                if (libro2.getId() == idLibro){
                    libroSeleccionado = libro2;

                }
            }

            if (libroSeleccionado != null){
                //mostrar los detalles del libro comprado
                System.out.println("Ha comprado el siguiente libro");
                System.out.println("Id: " + libroSeleccionado.getId());
                System.out.println("Genero: " + libroSeleccionado.getGenero());
                System.out.println("Titulo: " + libroSeleccionado.getTitulo());
                System.out.println("Autor: " + libroSeleccionado.getAutor());
                System.out.println("Editorial: " + libroSeleccionado.getEditorial());
                System.out.println("Estado: " + libroSeleccionado.getEstado());
                System.out.println("Precio: " + libroSeleccionado.getPrecio());
                System.out.println("-------------------------------");
                totalAPagar += libroSeleccionado.getPrecio();
                librosComprados.add(libroSeleccionado.getTitulo());
            } else {
                System.out.println("No se encontro el Id.");
            }


            System.out.println("¿Desea seguir comprando? (s/n): ");
            respuesta = scanner.nextLine();


            if (respuesta.equals("s")) {
                // Si desea seguir comprando, pedir el nuevo género a buscar
                System.out.println("Tenemos en la librería los siguientes géneros:");
                for (String gen : generos) {
                    System.out.println("Género: " + gen);
                }

                boolean nuevoGeneroValido = false;

                do {
                    System.out.print("Ingrese el género que desea buscar: ");
                    genero = scanner.nextLine();

                    librosEncontrados = false;

                    // Buscar libros disponibles en el nuevo género ingresado
                    System.out.println("Libros disponibles del género " + genero + ":");
                    for (Libro libro : lista) {
                        if (libro.getGenero().equals(genero)) {
                            System.out.println("Id: " + libro.getId());
                            System.out.println("Género: " + libro.getGenero());
                            System.out.println("Título: " + libro.getTitulo());
                            System.out.println("Autor: " + libro.getAutor());
                            System.out.println("Editorial: " + libro.getEditorial());
                            System.out.println("Estado: " + libro.getEstado());
                            System.out.println("Precio: " + libro.getPrecio());
                            System.out.println("-------------------------------");
                            librosEncontrados = true;
                        }
                    }

                    if (!librosEncontrados) {
                        System.out.println("No se encontraron libros del género especificado.");
                        System.out.println("Por favor, ingrese un nuevo género.");
                    } else {
                        nuevoGeneroValido = true;
                    }
                } while (!nuevoGeneroValido);

                // Pregunta al usuario si desea comprar algún libro del nuevo género
                System.out.print("¿Desea comprar algún libro de este género? (s/n): ");
                respuesta = scanner.nextLine();
            }


        }

        // mostrar el total a pagar y finalizar la compra

        if (!librosComprados.isEmpty()) {
            System.out.println("Libros comprados:");
            for (String titulo : librosComprados) {
                System.out.println("-Titulo: " + titulo);
            }
        }
        System.out.println("Total a pagar: $" + totalAPagar);

        System.out.println("Gracias por su compra");

        scanner.close();



    }
}