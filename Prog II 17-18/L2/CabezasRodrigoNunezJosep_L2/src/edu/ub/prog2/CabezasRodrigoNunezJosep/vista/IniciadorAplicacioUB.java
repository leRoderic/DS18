package edu.ub.prog2.CabezasRodrigoNunezJosep.vista;
import edu.ub.prog2.utils.AplicacioException;
import java.util.*;

public class IniciadorAplicacioUB {

    public static void main(String[] args) throws AplicacioException, ClassNotFoundException {
        Scanner sc=new Scanner(System.in);
        AplicacioUB2 aplicacio=new AplicacioUB2();
        aplicacio.gestioAplicacioUB(sc);
    }
}
