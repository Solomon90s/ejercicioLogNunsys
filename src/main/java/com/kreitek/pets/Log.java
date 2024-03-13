package com.kreitek.pets;

public class Log {

    private static int contador = 0;

    public static void debug(String mensaje){
        contador++;
        String mensajeLog;
        mensajeLog = String.format("[debug][%d] - %s", contador, mensaje);
        System.out.println(mensajeLog);
        
    }
}
