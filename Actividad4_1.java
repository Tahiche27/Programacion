//Importamos las librerias de java.


import java.util.Scanner;
import java.io.File;
import MisClases.Persona;
import java.util.ArrayList;
import java.io.FileWriter;

//Apartado donde se crean todas las funciones necesarias para las opciones.

public class Actividad4_1 {

//Creacion del ArrayList de la clase Persona, personas.

    static ArrayList<Persona> personas = new ArrayList<>();


//Creacion de la funcion cargar lista donde se agrega el informe.txt y se van guardando los datos.  
    static void cargarlista(){
        try{
                
                File fichero = new File("informe.txt");
                Scanner scan = new Scanner(fichero);
                
                String linea = new String();

                
            while(scan.hasNextLine()){
                
                linea = scan.nextLine();
                String[] propiedades = linea.split(",");
                
                personas.add(new Persona(propiedades[0].trim(), propiedades[1].trim(), Integer.parseInt(propiedades[2].trim()), propiedades[3].trim(), Integer.parseInt(propiedades[4].trim())));
            
            }
           
           scan.close();
        
        }catch(Exception ex){
        
        System.out.println(ex.getMessage());
        
        }
    }

//Primera funcion de sumar una nueva persona y recogida de datos por orden de la primera persona.

    static void sumarPersona(){

            Scanner scan = new Scanner(System.in);

            System.out.print("Dame el nombre de la persona: ");
            
            String nombre = scan.nextLine();

            System.out.print("Dame los apellidos de la persona: ");
            
            String apellidos = scan.nextLine();

            System.out.print("Dame el anyo de nacimiento de la persona: ");
            
            int anyo = scan.nextInt();

            System.out.print("Dame el id de la persona: ");
            
            int id_per = scan.nextInt();

            System.out.print("Dame el correo de la persona: ");
            
            scan.nextLine();

            String correo = scan.nextLine();
                    
            personas.add(new Persona(nombre, apellidos, anyo, correo, id_per));

    }


//Creacion de la funcion listado.Imprime todos los datos del Array personas.

    static void listado(){

        for(int i= 0; i<personas.size();i++){

            System.out.println(personas.get(i));



        }

    }


//Funcion de buscar persona. Creamos las variables i(para bucle), encontrado como booleano para saber si se ha hallado una coincidencia, e id para que la introduzca el usuario para la busqueda.

    static void buscarPersona(){

        Scanner scan = new Scanner(System.in);

        int i = 0;

        boolean encontrado = false;

        System.out.print("Introduzca el id de la persona: ");

        int id = scan.nextInt();


//Bucle para que se recorra el array list de personas, si se encuentra una id igual a la solicitada previamente, se imprime la persona y se termina la busqueda.

        while(!encontrado && i<personas.size()){

            if(personas.get(i).getId()==id){

                encontrado = true;

                System.out.print(personas.get(i));

                   
            }

                i++;
        }

        if(!encontrado){

            System.out.println("\n No se ha encontrado la id solicitada.\n");


        }

    }

//Funcion que crea el archivo con los datos impresos de las personas ingresadas. 

    static void generarFichero(){


    try{

        FileWriter fichero2 = new FileWriter("informe.txt");

        for(int i= 0; i<personas.size();i++){
        
            
            fichero2.write(personas.get(i).toString());
            


        }

fichero2.close();

}catch(Exception ex){


    System.out.println(ex.getMessage());


}

    }

//Uso de una funcion para que muestre el menu. Se carga el archivo con el nombre args.txt y se van escaneando las lineas.

     static String showMenu(){      

        String lineas = new String();
    
        try{
                
                File fichero = new File("args.txt");
                 Scanner scan = new Scanner(fichero);
                

            while(scan.hasNextLine()){
                

                lineas += scan.nextLine()+"\n";
                 

            }
           
           scan.close();
        
        }catch(Exception ex){
        
        System.out.println(ex.getMessage());
        
        }

        return lineas;
     }



//Main del programa. Se declaran variables de menu, opcion y escaner.



    public static void main(String args[]) {
       

        int opcion = 0;
        String menu=showMenu();
        Scanner scan = new Scanner(System.in);
        cargarlista();


//Do while para mostrar el menu siempre que la opcion seleccionada no sea 5. 

        do{
        

        
        System.out.println(menu);

        System.out.print("Seleccione la opcion: ");

            opcion = scan.nextInt();


        switch(opcion){


//Opcion de agregar persona.

            case 1:

                sumarPersona();




                 break;

//Opcion de generar listado. 


            case 2:

                listado();

                break;



//Opcion de buscar por id.

            case 3:

                buscarPersona();

                break;

//Opcion de generar el fichero.                

            case 4:


                generarFichero();

                break;

//Opcion de salir del programa.

            case 5:

            System.out.println("Chao.");

                break;


//Ultima opcion default por si no se introduce una de las opciones pedidas.

            default:

                System.out.println("Opcion no valida");


        }


        }while(opcion!= 5);
        
        
    }
}
