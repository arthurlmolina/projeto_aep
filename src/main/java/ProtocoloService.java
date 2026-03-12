import java.util.List;
import java.util.Scanner;

public class ProtocoloService {

    Scanner scanner = new Scanner(System.in);

    public void criarProtocolo(List<Protocolo> listaProtocolo){

        scanner.nextLine();

        System.out.println("Tipo do problema:");
        System.out.println("1 - Buraco na rua");
        System.out.println("2 - Iluminação pública");
        System.out.println("3 - Lixo");
        int tipo = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Descrição do problema:");
        String descricao = scanner.nextLine();

        System.out.println("CEP:");
        String cep = scanner.nextLine();

        System.out.println("Endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Número:");
        int numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Bairro:");
        String bairro = scanner.nextLine();

        System.out.println("Complemento (opcional):");
        String opcional = scanner.nextLine();

        Protocolo novo = new Protocolo(
                tipo,
                descricao,
                cep,
                endereco,
                numero,
                bairro,
                opcional
        );

        listaProtocolo.add(novo);

        System.out.println("Protocolo criado com sucesso!");
    }

    public void listarProtocolos(List<Protocolo> listaProtocolo){

        if(listaProtocolo.isEmpty()){
            System.out.println("Nenhum protocolo registrado.");
            return;
        }

        for(Protocolo p : listaProtocolo){

            System.out.println("---------------------------");

            System.out.println("Tipo: " + p.getTipo());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("CEP: " + p.getCep());
            System.out.println("Endereço: " + p.getEndereco());
            System.out.println("Número: " + p.getNumero());
            System.out.println("Bairro: " + p.getBairro());
            System.out.println("Complemento: " + p.getOpcional());

        }

    }
}