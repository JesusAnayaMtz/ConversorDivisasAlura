import java.util.Scanner;

public class MenuMoneda {
    public void menuIniciar(){
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner leer = new Scanner(System.in);
        double cantidad;
        Moneda moneda;
        String tipoCambio = "";

        int salir = 1;
        System.out.println("Bienvenido/a al conversor de moneda");
        System.out.println();
        try {
            while (salir != 0){
                System.out.println("1) Dolar =>> Peso Mexicano\n2) Peso Mexicano =>> Dolar\n3) Dolar =>> Euro\n" +
                        "4) Euro =>> Dolar\n5) Dolar =>> Libra Esterlina\n6) Libra Esterlina =>> Dolar\n" +
                        "7) Salir");
                System.out.println("Ingrese la opcion deseada");
                var opcion = leer.nextInt();
                switch (opcion){
                    case 1:
                        tipoCambio = "usd/mxn/";
                        break;
                        case 2:
                            tipoCambio = "mxn/usd/";
                            break;
                            case 3:
                                tipoCambio = "usd/eur/";
                                break;
                                case 4:
                                    tipoCambio = "eur/usd/";
                                    break;
                                    case 5:
                                         tipoCambio = "usd/gbp/";
                                        break;
                                        case 6:
                                             tipoCambio = "gbp/usd/";
                                            break;
                                            case 7:
                                                System.out.println("Saliste del sistema");
                                                salir=0;
                                                break;
                    default:
                        System.out.println("opcion no valida seleccione una opcion de la lista");
                        break;
                }
                System.out.println("Ingrese la cantidad a cambiar");
                cantidad = leer.nextDouble();
                moneda = consultaMoneda.ConsultaMoneda(tipoCambio, cantidad);
                System.out.println("El valor de " + cantidad + " " + moneda.base_code() + " a " +moneda.target_code() + " es igual a " + moneda.conversion_result() + " " + moneda.target_code()  + " al dia de hoy");
                System.out.println("1) Desea Consultar Otro Tipo De Cambio----2) Salir");
                salir = leer.nextInt();
                if (salir == 2){
                    System.out.println("Saliste del sistema");
                    salir = 0;
                }

            }
        } catch (Exception e) {
            throw new RuntimeException("Ingrese una opcion numerica o cantidad valida");
        }
    }
}
