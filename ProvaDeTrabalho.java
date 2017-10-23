package provadetrabalho;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
import java.util.Random;

public class ProvaDeTrabalho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Sortear um número maior que 100.000
        Random rand = new Random();
        
        long valor;
        String entrada, saida, comp;
        int contador = 0;
        
        while(true)
        {
            contador++;
            
            valor = rand.nextLong() + 100000;

            //Obter valor em hexadecimal        
            entrada = Long.toHexString(valor);
            
            //Obter a saída
            saida = ProvaDeTrabalho.sha1(entrada);
            
            System.out.println(entrada + " -> " + saida);
            
            //Fazer a condição de verificação
            comp = saida.substring(33);
            
            if(comp.equals("0000000"))
                break;
        }
        
        System.out.println("");
        System.out.println("String encontrada: " + entrada + " -> " + saida);
        System.out.println("Número de tentativas: " + contador);
    }
        
    public static String sha1(String input)
    {
        String sha1 = null;
        
        try
        {
            MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");
            msgDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msgDigest.digest());
        }
        catch(Exception e)
        {
            System.out.println("Não foi possível realizar a conversão");
        }
        
        return sha1;
    }
    
}
