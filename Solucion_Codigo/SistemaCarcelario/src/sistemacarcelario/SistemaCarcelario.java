package sistemacarcelario;

import java.util.Scanner;

public class SistemaCarcelario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Variables para menu;
        int opc, agr, opc1;
        //Variables para ppl
        String nomb, fecha, sexo;
        int edad = 0;
        long cedula = 0;
        //varuables para delito
        String tipodel, fe, descrip, gravedad;
        int condena = 0, c;
        //variable control de errores 
        boolean datocor;
        ControlPPL cont = new ControlPPL();

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    //Ingreso Reo
                    System.out.print("Ingresar Nombre:");
                    nomb = sc.nextLine();
                    do {
                        datocor = false;
                        System.out.print("Ingresar Cedula: ");
                        try {
                            cedula = Long.parseLong(sc.nextLine());
                            if (cedula < 0) {
                                throw new Exception("La cedula no puede ser negativa");
                            }
                            datocor = true;
                        } catch (NumberFormatException e) {
                            System.err.println(" Error: solo se permite el ingreso de numeros...");
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }

                    } while (!datocor);
                    do {
                        datocor = false;
                        System.out.print("Ingrese la edad: ");
                        try {
                            edad = Integer.parseInt(sc.nextLine());
                            if (edad < 0) {
                                throw new Exception("La edad no puede ser negativa");
                            }
                            if (edad > 150) {
                                throw new Exception("No hay personas mayores a 150 anios");
                            }
                            datocor = true;
                        } catch (NumberFormatException e) {
                            System.err.println(" Error: solo se permite el ingreso de numeros...");
                        } catch (Exception e) {
                            System.err.println("Error: " + e.getMessage());
                        }

                    } while (!datocor);
                    System.out.print("Ingrese el sexo: ");
                    sexo = sc.nextLine();
                    System.out.print("Ingrese la fecha (dd/mm//aa) : ");
                    fecha = sc.nextLine();
                    //datos para objetos delito;
                    System.out.println("\nDELITOS");
                    System.out.println("===============");
                    cont.nuevoPPL(nomb, edad, cedula, fecha, sexo);
                    c = 0;
                    do {
                        System.out.print("Ingresar delito: ");
                        tipodel = sc.nextLine();
                        System.out.print("Ingresar fecha del delito: ");
                        fe = sc.nextLine();
                        System.out.print("Ingresar descripcion del delito: ");
                        descrip = sc.nextLine();
                        System.out.print("Ingresar gravedad del caso: ");
                        gravedad = sc.nextLine();
                        do {
                            System.out.print("Ingrese la condena: ");
                            datocor = false;
                            try {
                                condena = Integer.parseInt(sc.nextLine());
                                if (condena <= 0) {
                                    throw new Exception("La condena no puede ser negativa o igual a 0");
                                }
                                datocor = true;
                            } catch (NumberFormatException e) {
                                System.err.println(" Error: solo se permite el ingreso de numeros...");
                            } catch (Exception e) {
                                System.err.println("Error: " + e.getMessage());
                            }

                        } while (!datocor);
                        c += condena;
                        cont.delito(tipodel, fe, descrip, condena, gravedad);

                        opc1 = masdelitos();

                    } while (opc1 != 2);
                    cont.registrarppl.setCondena(c);
                    cont.llenarArchivo();
                    break;
                case 2:
                    cont.mostrarPPL();
                    break;
                case 3:
                    cont.cargarArchivo();
                    if (cont.ppl.isEmpty()) {
                        System.out.println("\nPor favor seleccione la opcion [1] e ingrese un ppl");
                    } else {
                        System.out.println("\nControl de Agravantes");
                        System.out.println("---------------------");
                        System.out.print("Ingrese la cedula de la persona privada de la libertad: ");
                        cedula = sc.nextLong();
                        System.out.print("Ingrese el tipo de agravante: ");
                        agr = menu2();
                        cont.controlAgravantes(cedula, agr);
                    }
                    break;
                case 4:
                    cont.estadisticas();
                    break;
            }

        } while (opc != 0);

    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean datocor;
        System.out.println("\nMenu Principal");
        System.out.println("[1] Ingresar Preso");
        System.out.println("[2] Mostrar Archivo con presos");
        System.out.println("[3] Control de Agravantes");
        System.out.println("[4] Mostrar Estadisticas");
        System.out.println("[0] Abandonar Programa");
        do {
            datocor = false;
            try {
                System.out.print("Opcion escogida: ");
                opc = Integer.parseInt(sc.nextLine());
                datocor = true;
            } catch (NumberFormatException e) {
                System.err.println(" Error: solo se permite el ingreso de numeros...");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        } while (!datocor);
        return opc;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean datocor;
        System.out.println("\nTipos de Agravantes");
        System.out.println("===================");
        System.out.println("[1] Agravantes Leves:");
        System.out.println("  - Reincidencia en Mal Comportamiento");
        System.out.println("  - Incumplimiento de las normas penitenciarias");
        System.out.println("  - Asociacion con otros internos para cometer faltas");
        System.out.println("[2] Agravantes Graves: ");
        System.out.println("  - Uso de Vioencia dentro del campo penitenciario");
        System.out.println("  - Posesion de objetos prohibidos");
        System.out.println("  - Intento de Fuga o Conspiracion");
        System.out.println("[3] Agravantes Muy Graves:");
        System.out.println("  - Agresion Grave contra Personal o Internos");
        System.out.println("  - Organizacion de Activdades Delictivas desde la Carcel");
        System.out.println("  - Corrupcion o soborno");
        System.out.println("[0] Abandonar Programa");
        do {
            datocor = false;
            try {
                System.out.print("Opcion escogida: ");
                opc = Integer.parseInt(sc.nextLine());
                datocor = true;
            } catch (NumberFormatException e) {
                System.err.println(" Error: solo se permite el ingreso de numeros...");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        } while (!datocor);
        return opc;
    }

    public static int masdelitos() {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        boolean datocor;
        System.out.println("\n¿Desea ingresar mas delitos?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        do {
            datocor = false;
            try {
                System.out.print("Opcion escogida: ");
                opc = Integer.parseInt(sc.nextLine());
                datocor = true;
            } catch (NumberFormatException e) {
                System.err.println(" Error: solo se permite el ingreso de numeros...");
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        } while (!datocor);
        return opc;
    }

}
