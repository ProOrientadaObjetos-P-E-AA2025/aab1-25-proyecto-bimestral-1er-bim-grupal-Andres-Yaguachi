package sistemacarcelario;

import java.util.Scanner;

public class SistemaCarcelario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Variables para menu;
        int opc, agr, opc1;
        //Variables para ppl
        String nomb, fecha;
        int edad;
        long cedula;
        //varuables para delito
        String tipodel, fe, descrip, gravedad;
        int condena, c;
        ControlPPL cont = new ControlPPL();

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    //Ingreso Reo
                    System.out.print("Ingresar Nombre:");
                    nomb = sc.nextLine();
                    System.out.print("Ingresar Cedula");
                    cedula = sc.nextLong();
                    System.out.print("Ingrese la edad: ");
                    edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese la fecha (dd/mm//aa) : ");
                    fecha = sc.nextLine();
                    //datos para objetos delito;
                    System.out.println("INGRESAR DELITO");
                    System.out.println("===============");
                    cont.nuevoPPL(nomb, edad, cedula, fecha);
                    c = 0;
                    do {
                        System.out.println("Igresar delito: ");
                        tipodel = sc.nextLine();
                        System.out.println("Ingresar fecha: ");
                        fe = sc.nextLine();
                        System.out.println("Ingresar descripcion del delito: ");
                        descrip = sc.nextLine();
                        System.out.println("Ingresar gravedad del caso: ");
                        gravedad = sc.nextLine();
                        System.out.println("Ingresar condena en dias: ");
                        condena = sc.nextInt();
                        c += condena;
                        sc.nextLine();
                        cont.delito(tipodel, fe, descrip, descrip, gravedad);

                        opc1 = masdelitos();

                    } while (opc1 != 2);
                    cont.registrarppl.setCondena(c);
                    cont.llenarArchivo();
                    break;
                case 2:
                    cont.mostrarPPL();
                    break;
                case 3:
                    System.out.println("Control de Agravantes");
                    System.out.println("---------------------");
                    System.out.println("Ingrese la cedula de la persona privada de la libertad: ");
                    cedula = sc.nextLong();
                    System.out.println("Ingrese el tipo de agravante: ");
                    agr = menu2();
                    cont.controlAgravantes(cedula, agr);
                    break;
                case 4:
                    break;
            }

        } while (opc != 0);

    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMenu Principal");
        System.out.println("[1] Ingresar Preso");
        System.out.println("[2] Mostrar Archivo con presos");
        System.out.println("[3] Control de Agravantes");
        System.out.println("[4] Mostrar Estadisticas");
        System.out.println("[0] Abandonar Programa");
        return sc.nextInt();
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Tipos de Agravantes");
        System.out.println("[1] Agravantes Leves");
        System.out.println("  - Reincidencia en Mal Comportamiento");
        System.out.println("  - Incumplimiento de las normas penitenciarias");
        System.out.println("  - Asociacion con otros internos para cometer faltas");
        System.out.println("[2] Agravantes Graves");
        System.out.println("  - Uso de Vioencia dentro del campo penitenciario");
        System.out.println("  - Posesion de objetos prohibidos");
        System.out.println("  - Intento de Fuga o Conspiracion");
        System.out.println("[3] Agravantes Muy Graves");
        System.out.println("  - Agresion Grave contra Personal o Internos");
        System.out.println("  - Organizacion de Activdades Delictivas desde la Carcel");
        System.out.println("  - Corrupcion o soborno");
        System.out.println("[0] Abandonar Programa");
        return sc.nextInt();
    }

    public static int masdelitos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Desea ingresar mas delitos?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        return sc.nextInt();
    }
}
