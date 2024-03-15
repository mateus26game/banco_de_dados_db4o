package pacote_novo;

import com.db4o.ObjectContainer;

import java.util.Scanner;

public class menu_opcao_editar {

    public static void Menu_pcao_editar(ObjectContainer db, Scanner entrada){

        int numero;
        System.out.println("====================================================");
        System.out.println("             Escolha uma das opções:");
        System.out.println("====================================================");
        System.out.println("1 - editar o nome");
        System.out.println("2 - editar curso ");
        System.out.println("3 - editar tudo");
        System.out.println("====================================================");

        numero = Integer.parseInt(entrada.nextLine());

        switch (numero) {

            case 1:

                editar_nome.Editar_nome(db,entrada);

                break;

            case 2:

                editar_Curso.Editar_Curso(db,entrada);

                break;

            case 3:

                editar_tudo.Editar_tudo(db, entrada);

                break;

            case 4 :

                System.out.println("===========================================");
                System.out.println("vc saiu do banco de dados");
                System.out.println("===========================================");
                System.exit(0);


            default:
                System.out.println("======================================");
                System.out.println("Opção inválida. Tente novamente.");
                System.out.println("======================================");
                System.exit(0);


        }

    }

}
