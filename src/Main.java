
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void convertir(String monedaOrigen, double tasaDeConversion, String monedaConvertida){

        Scanner leer=new Scanner(System.in);

        double cantidadMoneda = 0;

        double cantidadFinal = 0;

        if (monedaOrigen.equals("USD")){

            System.out.printf("Ingresa la cantidad a convertir de %s:  ", monedaOrigen);
            cantidadMoneda = leer.nextDouble(); // Cantidad que se desea convertir//


            cantidadFinal = cantidadMoneda * tasaDeConversion;  //equivale a tasas.get(monedaConvertida);

        }else if(monedaConvertida.equals("USD")){

            System.out.printf("Ingresa la cantidad a convertir de %s:  ", monedaOrigen);
            cantidadMoneda = leer.nextDouble(); // Cantidad que se desea convertir//

            cantidadFinal = cantidadMoneda/tasaDeConversion;
        }

        cantidadFinal = (double) Math.round( cantidadFinal * 100d)/100;

        System.out.println("******************************************");
        System.out.println("La cantidad de: "+monedaOrigen+ "convertida es : "+cantidadFinal+" "+monedaConvertida);
        System.out.println("******************************************");
    }


    public static void main (String[] args)throws Exception {

            Map<String, Double> tasas = MyApi.obtenerTasas();



        boolean salir = false;
        while(!salir){

            System.out.println("BIEN VENIDO AL CONVERSOR DE MONEDAS");
            new MenuApp();
            System.out.println("Ingrese una opcion");
            Scanner leer = new Scanner(System.in);
            char opcion = leer.next().charAt(0);
            leer.nextLine(); // ← Limpia el salto de línea pendiente

            switch (opcion){
                case '1':
                    convertir("USD",tasas.get("ARS"), "ARS");
                    break;
                case '2':
                    convertir("ARS",tasas.get("ARS"),"USD");
                    break;
                case '3':
                    convertir("USD",tasas.get("BRL"),"BRL");
                    break;
                case '4':
                    convertir("COP", tasas.get("BRL"),"USD");
                    break;
                case '5':
                    convertir("USD", tasas.get("COP"),"COP");
                    break;
                case '6':
                    convertir("COP", tasas.get("COP"),"USD");
                    break;
                case '7':
                        String monedaOrigen1 = "";
                        String monedaConvertida1 = "";

                        System.out.println("Ingrese la moneda original que desea Convertir, según el código ISO:");
                        monedaOrigen1 = leer.nextLine().trim().toUpperCase();


                        System.out.print("Introduce la moneda de destino (ej: MXN): ");
                        monedaConvertida1 = leer.nextLine().trim().toUpperCase();
                    if (!tasas.containsKey(monedaOrigen1) || !tasas.containsKey(monedaConvertida1)) {
                        System.out.println("Moneda no válida. Asegúrate de usar códigos ISO válidos.");
                        break;
                    }

                        System.out.printf("Ingresa la cantidad a convertir de %s:  ", monedaOrigen1);

                        double cantidadMoneda1 = leer.nextDouble(); // Cantidad que se desea convertir//

                        double enUSD= cantidadMoneda1 / tasas.get(monedaOrigen1);

                        double cantidadFinal = enUSD * tasas.get(monedaConvertida1);

                        cantidadFinal = (double) Math.round( cantidadFinal * 100d)/100;

                        System.out.println("******************************************");
                        System.out.println("La cantidad de: "+monedaOrigen1+ "convertida es : "+cantidadFinal+" "+monedaConvertida1);
                        System.out.println("******************************************");

                    break;
                case '8':
                    System.out.println("Finalizando el programa. ¡Hasta luego!");
                     salir = true;
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
        }
    }
}