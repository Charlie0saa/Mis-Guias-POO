//Integrantes:
//Cesar Daniel Trejo Rodriguez carnet: TR262213
//Edwin Fernando Amaya Navarro         “AN262051”
//Marcos Ezequiel Ayala Palacios       “AP260351”
//Carlos Josue Azucena Ayala           “AA260854”
//Jorge Alberto Orellana Henriquez     “OH240812”

package mediateca;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Gestion gestion = new Gestion();
        Scanner scanner = new Scanner(System.in);
        char opcion;

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
                        for (Material m : gestion.listarMateriales()) {
                            System.out.println(m.mostrarInfo());
                        }
                    }
                    break;

                case '2':
                    System.out.println("\n--- BUSCAR MATERIAL ---");
                    System.out.print("Ingrese el código del material a buscar: ");
                    String codigoBusqueda = scanner.nextLine().trim();

                    Material materialEncontrado = gestion.buscarMaterial(codigoBusqueda);

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

                    Material nuevoMaterial = null;

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

                    System.out.print("Ingrese el código del material a modificar: ");
                    String codigoMod = scanner.nextLine().trim();

                    Material materialAModificar = gestion.buscarMaterial(codigoMod);

                    if (materialAModificar == null) {
                        System.out.println("No se encontró ningún material con el código: " + codigoMod);
                    } else {
                        System.out.println("Material encontrado: " + materialAModificar.getTitulo());
                        System.out.println("Ingrese los nuevos datos:");

                        System.out.print("Nuevo Título: ");
                        materialAModificar.setTitulo(scanner.nextLine());

                        System.out.print("Nuevas Unidades Disponibles: ");
                        materialAModificar.setTotaldeunidades(Integer.parseInt(scanner.nextLine()));

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

                        gestion.modificarMaterial(codigoMod, materialAModificar);
                        System.out.println("¡Material modificado exitosamente!");
                    }
                    break;

                case '5':
                    System.out.println("\n--- BORRAR MATERIAL ---");

                    System.out.print("Ingrese el código del material a borrar: ");
                    String codigoBorrar = scanner.nextLine().trim();

                    if (gestion.borrarMaterial(codigoBorrar)) {
                        System.out.println("¡Material con código " + codigoBorrar + " borrado con éxito!");
                    } else {
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