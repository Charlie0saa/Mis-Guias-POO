package mediateca;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Gestion gestion = new Gestion();
        Scanner scanner = new Scanner(System.in);
        char opcion;

        // Variables para llevar el control del correlativo auto-incrementable (5 dígitos)
        int correlativoLibro = 1;
        int correlativoRevista = 1;
        int correlativoDVD = 1;
        int correlativoCD = 1;

        do {
            System.out.println("\n--- MENÚ MEDIATECA ---");
            System.out.println("1. Listar materiales");
            System.out.println("2. Buscar material");
            System.out.println("3. Agregar material");
            System.out.println("4. Modificar material");
            System.out.println("5. Borrar material");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = (char) System.in.read();
            System.in.skip(System.in.available());

            switch (opcion) {
                case '1':
                    System.out.println("\n--- LISTA DE MATERIALES ---");
                    if (gestion.listarMateriales().isEmpty()) {
                        System.out.println("No hay materiales registrados.");
                    } else {
                        for (Formato f : gestion.listarMateriales()) {
                            System.out.println(f.mostrarInfo());
                        }
                    }
                    break;

                case '2':
                    System.out.println("\n--- BUSCAR MATERIAL ---");
                    System.out.print("Ingrese el código del material a buscar: ");
                    String codigoBusqueda = scanner.nextLine().trim();

                    Formato materialEncontrado = gestion.buscarMaterial(codigoBusqueda);

                    if (materialEncontrado != null) {
                        System.out.println("Material encontrado:");
                        System.out.println(materialEncontrado.mostrarInfo());
                    } else {
                        System.out.println("No se encontró ningún material con el código: " + codigoBusqueda);
                    }
                    break;

                case '3':
                    System.out.println("\n--- AGREGAR MATERIAL ---");
                    System.out.println("1. Libro");
                    System.out.println("2. Revista");
                    System.out.println("3. DVD");
                    System.out.println("4. CD Audio");
                    System.out.print("Seleccione el tipo de material: ");
                    String tipo = scanner.nextLine().trim();

                    Formato nuevoMaterial = null;

                    switch (tipo) {
                        case "1": // LIBRO
                            String codigoLib = String.format("LIB%05d", correlativoLibro++);
                            System.out.print("Título: ");
                            String tituloLib = scanner.nextLine();
                            System.out.print("Autor: ");
                            String autor = scanner.nextLine();
                            System.out.print("Número de páginas: ");
                            int paginas = Integer.parseInt(scanner.nextLine());
                            System.out.print("Editorial: ");
                            String editLib = scanner.nextLine();
                            System.out.print("ISBN: ");
                            String isbn = scanner.nextLine();
                            System.out.print("Año de publicación: ");
                            int anio = Integer.parseInt(scanner.nextLine());
                            System.out.print("Unidades disponibles: ");
                            int unidadesLib = Integer.parseInt(scanner.nextLine());

                            nuevoMaterial = new Libro(codigoLib, tituloLib, autor, paginas, editLib, isbn, anio, unidadesLib);
                            break;

                        case "2": // REVISTA
                            String codigoRev = String.format("REV%05d", correlativoRevista++);
                            System.out.print("Título: ");
                            String tituloRev = scanner.nextLine();
                            System.out.print("Editorial: ");
                            String editRev = scanner.nextLine();
                            System.out.print("Periodicidad: ");
                            String periodicidad = scanner.nextLine();
                            System.out.print("Fecha de publicación: ");
                            String fechaPub = scanner.nextLine();
                            System.out.print("Unidades disponibles: ");
                            int unidadesRev = Integer.parseInt(scanner.nextLine());

                            nuevoMaterial = new Revista(codigoRev, tituloRev, editRev, periodicidad, fechaPub, unidadesRev);
                            break;

                        case "3": // DVD
                            String codigoDVD = String.format("DVD%05d", correlativoDVD++);
                            System.out.print("Título: ");
                            String tituloDVD = scanner.nextLine();
                            System.out.print("Director: ");
                            String director = scanner.nextLine();
                            System.out.print("Duración: ");
                            String duracionDVD = scanner.nextLine();
                            System.out.print("Género: ");
                            String generoDVD = scanner.nextLine();
                            System.out.print("Unidades disponibles: ");
                            int unidadesDVD = Integer.parseInt(scanner.nextLine());

                            nuevoMaterial = new DVD(codigoDVD, tituloDVD, director, duracionDVD, generoDVD, unidadesDVD);
                            break;

                        case "4": // CD AUDIO
                            String codigoCD = String.format("CDA%05d", correlativoCD++);
                            System.out.print("Título: ");
                            String tituloCD = scanner.nextLine();
                            System.out.print("Artista: ");
                            String artista = scanner.nextLine();
                            System.out.print("Género: ");
                            String generoCD = scanner.nextLine();
                            System.out.print("Duración: ");
                            String duracionCD = scanner.nextLine();
                            System.out.print("Número de canciones: ");
                            int canciones = Integer.parseInt(scanner.nextLine());
                            System.out.print("Unidades disponibles: ");
                            int unidadesCD = Integer.parseInt(scanner.nextLine());

                            nuevoMaterial = new CDAudio(codigoCD, tituloCD, artista, generoCD, duracionCD, canciones, unidadesCD);
                            break;

                        default:
                            System.out.println("Tipo de material no válido.");
                    }

                    if (nuevoMaterial != null) {
                        gestion.agregarMaterial(nuevoMaterial);
                        System.out.println("Material registrado con éxito. Código asignado: " + nuevoMaterial.getCodigo());
                    }
                    break;

                case '4':
                    System.out.println("\n--- MODIFICAR MATERIAL ---");

                    // segun lo que me dijeron aqui lo que hace es Pedir el código del material
                    System.out.print("Ingrese el código del material a modificar: ");
                    String codigoMod = scanner.nextLine().trim();

                    //  segun lo que me dijeron aqui lo que hace es  Buscar el material y guardarlo
                    Formato materialAModificar = gestion.buscarMaterial(codigoMod);

                    //  segun lo que me dijeron aqui lo que hace es  Validar si es null
                    if (materialAModificar == null) {
                        System.out.println("No se encontró ningún material con el código: " + codigoMod);
                    } else {
                        //  segun lo que me dijeron aqui lo que hace es  Si existe, verificar el tipo con instanceof y pedir nuevos datos
                        System.out.println("Material encontrado: " + materialAModificar.getTitulo());
                        System.out.println("Ingrese los nuevos datos:");


                        System.out.print("Nuevo Título: ");
                        materialAModificar.setTitulo(scanner.nextLine());


                        System.out.print("Nuevas Unidades Disponibles: ");
                        materialAModificar.setTotaldeunidades(Integer.parseInt(scanner.nextLine()));

                        //  segun lo que me dijeron aqui lo que hace es Verificamos el tipo específico para los atributos propios
                        if (materialAModificar instanceof Libro) {
                            Libro lib = (Libro) materialAModificar;

                            System.out.print("Nuevo Autor: ");
                            lib.setAutor(scanner.nextLine());

                            System.out.print("Nueva Editorial: ");
                            lib.setEditorial(scanner.nextLine());

                            System.out.print("Nuevo Número de páginas: ");
                            lib.setNumerodepags(Integer.parseInt(scanner.nextLine()));

                        } else if (materialAModificar instanceof Revista) {
                            Revista rev = (Revista) materialAModificar;

                            System.out.print("Nueva Editorial: ");
                            rev.setEditorial(scanner.nextLine());

                            System.out.print("Nueva Periodicidad: ");
                            rev.setPeriodicidad(scanner.nextLine());

                        } else if (materialAModificar instanceof DVD) {
                            DVD dvd = (DVD) materialAModificar;
                            System.out.print("Nuevo Director: ");
                            dvd.setDirector(scanner.nextLine());

                            System.out.print("Nuevo Género: ");
                            dvd.setGenero(scanner.nextLine());

                        } else if (materialAModificar instanceof CDAudio) {
                            CDAudio cd = (CDAudio) materialAModificar;

                            System.out.print("Nuevo Artista: ");
                            cd.setArtista(scanner.nextLine());

                            System.out.print("Nuevas Canciones: ");
                            cd.setNumerodecanciones(Integer.parseInt(scanner.nextLine()));
                        }

                        //  segun lo que me dijeron aqui lo que hace es Guardamos los cambios usando el método de la clase Gestion
                        gestion.modificarMaterial(codigoMod, materialAModificar);
                        System.out.println("¡Material modificado exitosamente!");
                    }
                    break;

                case '5':
                    System.out.println("\n--- BORRAR MATERIAL ---");

                    //  Pedir el código del material
                    System.out.print("Ingrese el código del material a borrar: ");
                    String codigoBorrar = scanner.nextLine().trim();

                    // Llamar a gestion.borrarMaterial() y evaluar el resultado
                    if (gestion.borrarMaterial(codigoBorrar)) {
                        // Si devolvió true, fue exitoso
                        System.out.println("¡Material con código " + codigoBorrar + " borrado con éxito!");
                    } else {
                        // Si devolvió false, no existía
                        System.out.println("No se encontró ningún material con el código: " + codigoBorrar);
                    }
                    break;

                case '6':
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != '6');
    }
}