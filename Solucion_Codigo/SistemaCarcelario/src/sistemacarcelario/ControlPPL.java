package sistemacarcelario;

import clases.PPL;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class ControlPPL {

    File datos;
    PPL registrarppl;
    ArrayList<PPL> ppl;

    public ControlPPL() {
        datos = new File("ppl.data");
        ppl = new ArrayList<>();
    }

    public void nuevoPPL(String nombre, int edad, long cedula, String fechaIn, String sexo) {
        registrarppl = new PPL(nombre, edad, cedula, fechaIn, sexo);

    }

    public void delito(String tipoDeDelito, String fecha, String descripcion, int condena, String gravedad) {
        registrarppl.nuevoDelito(tipoDeDelito, fecha, descripcion, condena, gravedad);

    }

    public void llenarArchivo() {
        cargarArchivo();
        ppl.add(registrarppl);
        registrarppl = null;

        try (ObjectOutputStream nuevoppl = new ObjectOutputStream(new FileOutputStream(datos))) {
            nuevoppl.writeObject(ppl);
            System.out.println("Persona Privada de la Libertad agregada correctamente.....");

        } catch (IOException e) {
            System.err.println("Error de escritura " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cargarArchivo() {
        try {
            if (!datos.exists()) {
                datos.createNewFile();
            }

            ObjectInputStream leerppl = new ObjectInputStream(new FileInputStream(datos));
            ppl = (ArrayList<PPL>) leerppl.readObject();
            if (ppl.isEmpty()) {
                ppl = new ArrayList<>();
            }

        } catch (EOFException e) {
            System.out.println("Su archivo esta vacio");
        } catch (IOException e) {
            System.err.println("Error leyendo Archivo" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Archivo recorrido");
        }

    }

    public void mostrarPPL() {
        try {
            cargarArchivo();
            if (ppl.isEmpty()) {
                System.out.println("\nPor favor seleccione la opcion [1] e ingrese un ppl");
            } else {
                System.out.println("Personas Privadas de la libertad");
                System.out.println("--------------------------------");
                for (int i = 0; i < ppl.size(); i++) {
                    System.out.println(ppl.get(i));
                    System.out.println("-------------------------------");
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void estadisticas() {
        int edad = 0, diasV = 0, cond = 0, delitos = 0, masD = 0, masC = 0;
        cargarArchivo();
        if (ppl.isEmpty()) {
            System.out.println("\nPor favor seleccione la opcion [1] e ingrese un ppl");
        } else {
            String masDelitos = "", masCondena = "";
            for (int i = 0; i < ppl.size(); i++) {
                //calculo promedios
                edad += ppl.get(i).getEdad();
                diasV += ppl.get(i).getDiasVisita();
                cond += ppl.get(i).getCondena();
                delitos += ppl.get(i).getDelitos().size();

                if ((i == (ppl.size() - 1)) && (i != 0)) {
                    edad = edad / (i + 1);
                    diasV = diasV / (i + 1);
                    cond = cond / (i + 1);
                    delitos = delitos / (i + 1);
                }
                //calculo Mayor
                if (ppl.get(i).getCondena() > masC) {
                    masCondena = ppl.get(i).getNombre();
                    masC = ppl.get(i).getCondena();
                }
                if (ppl.get(i).getDelitos().size() > masD) {
                    masDelitos = ppl.get(i).getNombre();
                    masD = ppl.get(i).getDelitos().size();
                }
            }
            System.out.println("\nPromedios entre los PPL");
            System.out.println("El promedio de edad de los reos es: " + edad);
            System.out.println("El promedio de dias de visita de los reos es: " + diasV);
            System.out.println("El promedio de condena de los reos es: " + cond);
            System.out.println("El promedio de delitos por reos es: " + delitos);
            System.out.println("\nMayor Condena-Delitos");
            System.out.println("La mayor condena la posee: " + masCondena + " de: " + masC + " dias");
            System.out.println("La mayor cantidad de delitos la posee: " + masDelitos + " de: " + masD + " delitos");
        }

    }

    public void controlAgravantes(long ci, int agra) {
        cargarArchivo();
        if (ppl.isEmpty()) {
            System.out.println("\nPor favor seleccione la opcion [1] e ingrese un ppl");
        } else {
            for (int i = 0; i < ppl.size(); i++) {
                if (ppl.get(i).getCedula() == ci) {
                    switch (agra) {
                        case 1:

                            if (ppl.get(i).getDiasVisita() == 0 || ppl.get(i).getDiasVisita() == 1) {
                                System.out.println("El Reo ya no tenia dias de visitas por agravantes pasados..., se le aumentara tiempo de condena");
                                ppl.get(i).setDiasVisita(0);
                                ppl.get(i).setCondena((int) (ppl.get(i).getCondena() * 1.1));
                            } else {
                                System.out.println("Agravante leve se le restara 2 dia ala semana para visitas..");
                                ppl.get(i).setDiasVisita(ppl.get(i).getDiasVisita() - 2);
                            }
                            break;
                        case 2:
                            System.out.println("Agravante grave, el reo ya no tiene derecho a visitas");
                            ppl.get(i).setDiasVisita(0);
                            break;
                        case 3:
                            System.out.println("Agravante muy grave, el reo sufrira un aumento de condena  ");
                            System.out.println("de 1/3 de su condena actual.");
                            System.out.println("y ya no tiene derecho a visitas.");
                            ppl.get(i).setDiasVisita(0);
                            ppl.get(i).setCondena((int) (ppl.get(i).getCondena() * 1.3));
                            break;
                    }
                    break;
                } else {
                    System.out.println("Persona Privada de la Libertad no encontrada....");
                }
            }
            try (ObjectOutputStream nuevoppl = new ObjectOutputStream(new FileOutputStream(datos))) {
                nuevoppl.writeObject(ppl);
                System.out.println("Actualizado Correctamente");
            } catch (IOException e) {
                System.err.println("Error....." + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
