package sistemacarcelario;

import clases.PPL;
import java.io.File;
import java.util.ArrayList;

public class ControlPPL {
    File datos;
    PPL registrarppl;
    ArrayList<PPL> ppl;

    public ControlPPL() {
        datos = new File("ppl.data");
        ppl = new ArrayList<>();
    }
    
    public void nuevoPPL(String nombre, int edad, long cedula, String fechaIn){
        ppl.add(new PPL(nombre,edad,cedula, fechaIn));
    }
    public void mostrarPPL(){
        
    }
    public void controlVisitas(int num){
        
    }
    
}
