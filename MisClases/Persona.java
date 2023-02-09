//Librerias de java y paquete MisClases.

package MisClases;
import java.time.Year;
import java.util.Scanner;

//Creacion de la clase persona.

public class Persona {
    
//Declaracion de variables.

   private int edad;
   private String nombre;
   private String apellidos;
   private int anyoNac;
   private String correo;
   private int id;
        
//Constructor de Persona.   

   public Persona(String nombre, String apellidos, int anyoNac, String correo, int id){
   
       this.nombre = nombre;
       this.apellidos = apellidos;
       this.anyoNac = anyoNac;
       this.correo = correo;
       this.id = id;
       this.edad = Year.now().getValue() - anyoNac; 
   
   }


//Get y Set de cada variable necesaria.

       
public int getEdad(){  return this.edad;   } 
public String getNombre() {    return this.nombre; }
public String getApellidos(){  return this.apellidos;  }
public int getnyoNac(){    return this.anyoNac; }
public String getCorreo(){ return this.correo; }
public int getId(){    return this.id;     }   


//En el caso de setanyoNac. Utilizo la funcion de java time Year para calcular la edad a partir del anyo de nacimiento. 

public void setNombre(String nombre) {     this.nombre= nombre ; }
public void setApellidos(String apellidos){   this.apellidos=apellidos;  }
public void setanyoNac(int anyoNac){   
    
    this.anyoNac=anyoNac; 

this.edad= Year.now().getValue() - this.anyoNac;

}
public void  setCorreo(String correo){  this.correo=correo; }
public void setId(int id){     this.id=id;     }   
   

//Override de la funcion toString para que al llamarla en la actividad 4_1 me pongo cada uno de los datos separados.

@Override

public String toString(){

return this.nombre + " , "  +this.apellidos+ " , "  +this.anyoNac+ " , " +this.correo+ " , "  +this.id+ " , "  +this.edad+ " \n";

}


}
