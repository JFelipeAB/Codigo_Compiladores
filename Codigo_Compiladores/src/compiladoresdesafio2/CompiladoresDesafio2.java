package compiladoresdesafio2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CompiladoresDesafio2 {

    /**
     * @author João
     */
    public static void main(String[] args) {

        System.out.print("Bem vindo\n Digite 1 Para arquivo texto no /c: ou informar caminho do arquivo texto\n");
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine();
        if (entrada.equals("1")) {
            entrada = "C:/Compiladores_Desafio2/CompiladoresDesafio2";
            {

                ArrayList<String> palavras = new ArrayList();

                try {
                    try (FileReader fr = new FileReader(entrada + "/java prog.txt")) {
                        try (BufferedReader br = new BufferedReader(fr)) {
                            String linha;

                            while ((linha = br.readLine()) != null) {
                                palavras.add(linha);
                            }
                        }
                    }

                    try (FileWriter fw = new FileWriter(entrada + "/prog - check.txt")) {
                        try (PrintWriter pw = new PrintWriter(fw)) {
                            for (String palavra : palavras) {
                                if(valida(palavra))
                                  pw.println(palavra + " ✓");
                                else
                                    pw.println(palavra + " X");                                
                            }
                            System.out.println("Executado com sucesso");
                        }
                    }
                } catch (IOException erro) {
                    System.out.println(erro.getMessage());
                }
            }
        }
    }
    

    public static boolean valida(String p) {
        
        while (p.contains("[]") || p.contains("()") || p.contains("{}"))
           
            p = p.replaceAll("(\\(\\))|(\\[\\])|(\\{\\})", "");
        return p.isEmpty();
    }
}
