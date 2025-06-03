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

    public void nuevoPPL(String nombre, int edad, long cedula, String fechaIn) {
        registrarppl = new PPL(nombre, edad, cedula, fechaIn);
    }

    public void delito(String tipoDeDelito, String fecha, String descripcion, String estado, String gravedad) {
        registrarppl.nuevoDelito(tipoDeDelito, fecha, descripcion, estado, gravedad);

    }

    public void llenarArchivo() {
        ppl.add(registrarppl);

        try {
            if (!datos.exists()) {
                datos.createNewFile();
            }

            ObjectOutputStream nuevoppl = new ObjectOutputStream(new FileOutputStream(datos));
            nuevoppl.writeObject(ppl);
            System.out.println("Persona Privada de la Libertad agregada correctamente.....");

        } catch (IOException e) {
            System.err.println("Error.....");
        } catch (Exception e) {

        }
    }

    public void mostrarPPL() {
        try {
            ObjectInputStream leerppl = new ObjectInputStream(new FileInputStream(datos));
            while (true) {
                try {
                    registrarppl = (PPL) leerppl.readObject();
                    ppl.add(registrarppl);
                    System.out.println(ppl);
                } catch (EOFException e) {
                    System.err.println("Su archivo esta vacio...");
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("");
        }
    }

    public void controlAgravantes(long ci, int agra) {
        try {
            ObjectInputStream leerppl = new ObjectInputStream(new FileInputStream(datos));
            while (true) {
                try {
                    registrarppl = (PPL) leerppl.readObject();
                    ppl.add(registrarppl);

                    for (int i = 0; i < ppl.size(); i++) {
                        if (ppl.get(i).getCedula() == ci) {
                            switch (agra) {
                                case 1:
                                    System.out.println("Agravante leve se le restara 2 dia ala semana para visitas..");
                                    ppl.get(i).setDiasVisita(ppl.get(i).getDiasVisita() - 2);

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
                        }
                    }

                } catch (EOFException e) {
                    System.err.println("Su archivo esta vacio...");
                    break;
                }
                try {

                    ObjectOutputStream nuevoppl = new ObjectOutputStream(new FileOutputStream(datos));
                    nuevoppl.writeObject(ppl);

                } catch (IOException e) {
                    System.err.println("Error.....");
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {
            System.err.println("");
        }
    }

}
