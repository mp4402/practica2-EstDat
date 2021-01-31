import java.util.*;

public class practica2_pu
{   
    static Scanner teclado = new Scanner(System.in);
    static float[] debitos = new float [20];
    static float[] creditos = new float [20];
    static int contadorDebitos = 0;
    static int contadorCreditos = 0;
    static float totalDebitos = 0;
    static float totalCreditos = 0;

    public static void main(String[]args)
    {
        int control = 0;
        int opcion = 0;
        while (control == 0)
        {
            System.out.print("Bienvenido\n1. Realizar un debito\n2. Realizar un credito\n3. Mostral el total de Debitos\n4. Motrar el total de Creditos\n5.Mostrar el saldo total\n6.Mostrar el promedio de Debitos\n7. Mostrar el Debito mas grande\n8. Mostrar el total de creditos y debitos realizados\n9. Imprimir los elementos de los arrays\n10.Eliminar creditos\nSeleccione una opcion: ");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1:
                    realizarDebitos();
                    break;
                case 2:
                    realizarCreditos();
                    break;
                case 3:
                    mostrarDebitos();
                    break;
                case 4:
                    mostrarCreditos();
                    break;
                case 5:
                    mostrarSaldo();
                    break;
                case 6:
                    promedioDebitos();
                    break;
                case 7:
                    debitoMayor();
                    break;
                case 8:
                    totalOperaciones();
                    break;
                case 9:
                    mostrarArreglos();
                    break;
                case 10:
                    eliminarCreditos();
                    break;
                default:
                    System.out.println("Por favor ingrese una opción valida");
                    break;
            }
        }
    }
    private static void realizarDebitos()
    {
        if (contadorDebitos < 20)
        {
            System.out.print("Ingrese el monto a debitar: ");
            debitos[contadorDebitos] = teclado.nextFloat();
            totalDebitos+= debitos[contadorDebitos];
            System.out.println("El número ingresado a los debitos fue: " + debitos[contadorDebitos]);
            contadorDebitos++;
        }
        else
        {
            System.out.println("Ya llegó al límite de Debitos, lo sentimos, actualmente el índice del array es: " + contadorDebitos);
        }
    }
    private static void realizarCreditos()
    {
        if (contadorCreditos < 20)
        {
            System.out.print("Ingrese el monto a acreditar: ");
            creditos[contadorCreditos] = teclado.nextFloat();
            totalCreditos+= creditos[contadorCreditos];
            System.out.print("El valor ingresado a los creditos fue: " + creditos[contadorCreditos]);
            contadorCreditos++;
        }
        else
        {
            System.out.println("Ya llegó al límite de Creditos, lo sentimos, actualmente el índice del array es: " + contadorCreditos);
        }
    }
    private static void mostrarDebitos()
    {
        System.out.println("El total de Debitos es: " + totalDebitos);
    }
    private static void mostrarCreditos()
    {
        System.out.println("El total de Creditos es: " + totalCreditos);
    }
    private static void mostrarSaldo()
    {
        System.out.println("El saldo es: " + (totalCreditos-totalDebitos));
    }
    private static void promedioDebitos()
    {
        System.out.println("El promedio de los debitos realizados es: " + (totalDebitos/contadorDebitos));
    }
    private static void debitoMayor()
    {
        float noMayor = 0;
        for (int x = 0; x < contadorDebitos; x++)
        {
            System.out.println("Monto: " + debitos[contadorDebitos]);
            if (debitos[x] > noMayor)
            {
                noMayor = debitos[x];
                System.out.println("Valor mayor encontrado: " + noMayor);
            }
        }
        System.out.println("El monto de Debito más grande es: " + noMayor);
    }
    private static void totalOperaciones()
    {
        System.out.println("El total de debitos realizados es: "+ contadorDebitos + "\nEl total de creditos realizados es: " + contadorCreditos + "\nEl total de operaciones realizadas es: " + (contadorCreditos+contadorDebitos));
    }
    private static void mostrarArreglos()
    {
        for(int x = 0; x < contadorCreditos; x++)
        {
            System.out.println("Credito No."+(x+1)+": " + creditos[x]);
        }
        for(int x = 0; x < contadorDebitos; x++)
        {
            System.out.println("Debito No."+(x+1)+": " + debitos[x]);
        }
    }
    private static void eliminarCreditos()
    {
        int noCredito = 0;
        for(int x = 0; x < contadorCreditos; x++)
        {
            System.out.println("Credito No."+(x+1)+": " + creditos[x]);
        }
        System.out.print("Ingrese el No. del crédito que desea eliminar: "); 
        noCredito = teclado.nextInt();
        totalCreditos -= creditos[(noCredito-1)];
        creditos[(noCredito-1)] = 0;
        for(int x = (noCredito-1); x < contadorCreditos; x++)
        {
            if(x < 20)
            {
                creditos[x] = creditos [x+1];
                creditos[x+1]=0;
            }
        }
        contadorCreditos --;
        mostrarDebitos();
        mostrarCreditos();
        mostrarSaldo();
        promedioDebitos();
        debitoMayor();
        totalOperaciones();
        System.out.println("Estado actual de los arrays: ");
        mostrarArreglos();
    }
}
