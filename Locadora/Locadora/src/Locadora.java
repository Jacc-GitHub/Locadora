import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Queue;
import java.util.Stack;
import domain.Cliente;
import domain.Carro;

public class Locadora {
    public static Stack<String> relatorioDeLocacao = new Stack<>();
    public static Stack<Carro> pilhaCarros = new Stack<Carro>();
    public static Carro[] carros = new Carro[10];
    public static Queue<Cliente> filaCliente = new ArrayDeque<>();


    public static void main(String[] args) {

        carros[0] = new Carro("Fiat", "Toro", "Preto", "AAA-1234", 100.00, true);
        carros[1] = new Carro("Toyota", "Hilux SW4", "Cinza chumbo", "AAA-4321", 150.00, true);
        carros[2] = new Carro("Fiat", "Toro", "Preto", "AAA-0002", 101.00, true);
        carros[3] = new Carro("Fiat", "Toro", "Cinza chumbo", "AAA-0002", 152.00, false);
        carros[4] = new Carro("Fiat", "Toro", "Preto", "AAA-0003", 102.00, false);
        carros[5] = new Carro("Fiat", "Hilux SW4 #5", "Cinza chumbo", "AAA-0003", 160.00, false);
        carros[6] = new Carro("Fiat", "Toro", "Preto", "AAA-0004", 104.00, true);
        carros[7] = new Carro("Fiat", "Toro", "Cinza chumbo", "AAA-0004", 155.00, false);
        carros[8] = new Carro("Fiat", "Toro", "Preto", "AAA-0005", 103.00, false);
        carros[9] = new Carro("Toyota", "Hilux SW4 #5", "Cinza chumbo", "AAA-0005", 160.00, false);

        // Imprimir Relatório de Carros para locação
        System.out.println("-".repeat(60));
        System.out.println("++++++++++++++ Relatório de Carros para locação  +++++++++++++");
        System.out.println("-".repeat(60));
        for (Carro carro : carros) {
            System.out.println(carro.toString());
        }

        filaCliente.add( new Cliente("000.000.000-01", "## Cliente 1 ##", "(00) 000-0001", "Rua 1", "Toro"));
        filaCliente.add( new Cliente("000.000.000-02", "## Cliente 2 ##", "(00) 000-0002", "Rua 2", "Hilux SW4"));
        filaCliente.add( new Cliente("000.000.000-03", "## Cliente 3 ##", "(00) 000-0003", "Rua 3", "Toro"));
        filaCliente.add( new Cliente("000.000.000-04", "## Cliente 4 ##", "(00) 000-0004", "Rua 4", "Hilux SW4"));
        filaCliente.add( new Cliente("000.000.000-05", "## Cliente 5 ##", "(00) 000-0005", "Rua 5", "Toro"));
        filaCliente.add( new Cliente("000.000.000-06", "## Cliente 6 ##", "(00) 000-0006", "Rua 6", "Hilux SW4"));
        filaCliente.add( new Cliente("000.000.000-07", "## Cliente 7 ##", "(00) 000-0007", "Rua 7", "Toro"));
        filaCliente.add( new Cliente("000.000.000-07", "## Cliente 8 ##", "(00) 000-0008", "Rua 8", "Hilux SW4"));
        filaCliente.add( new Cliente("000.000.000-09", "## Cliente 9 ##", "(00) 000-0009", "Rua 9", "Toro"));

        // Imprimir fila de clientes e carros desejados
        System.out.println("-".repeat(60));
        System.out.println("++++++++++++++++ Clientes na fila de espera ++++++++++++++++");
        System.out.println("-".repeat(60));
        for(Cliente cliente:filaCliente) {
            System.out.println("Nome: " + cliente.getNome() + " - Carro Desejado: " + cliente.getModeloDesejado());
        }

        // Locar carros disponíveis para os clientes
        System.out.println("-".repeat(60));
        System.out.println("+++++ Locar carros para os Clientes da fila de espera +++++");
        System.out.println("-".repeat(60));

        Queue<Cliente> filaClienteNaoLocado = new ArrayDeque<>();

        for (Cliente cliente : filaCliente) {
            Boolean clienteAtendido = false;
            for (Carro carro : carros) {
                if (carro.getModelo().equals(cliente.getModeloDesejado()) && carro.isDisponivel()) {
                    locarCarro(cliente, carro);
                    clienteAtendido = true;
                    break;
                }

            }
            if (!clienteAtendido) {
                filaClienteNaoLocado.add(cliente);
            }
        }

        filaCliente = filaClienteNaoLocado;

        // Imprimir Relatório de Carros para locação
        System.out.println("-".repeat(60));
        System.out.println("++++++++++++++ Relatório de Carros para locação  +++++++++++++");
        System.out.println("-".repeat(60));
        for (Carro carro : carros) {
            System.out.println(carro.toString());
        }

        // Imprimir clientes ainda não atendidos
        System.out.println("-".repeat(60));
        System.out.println("++++++++ Clientes na fila de espera - Não atendidos ++++++++");
        System.out.println("-".repeat(60));
        for(Cliente cliente:filaCliente) {
            System.out.println("Nome: " + cliente.getNome() + " - Carro Desejado: " + cliente.getModeloDesejado());
        }
    }

    public static void tirarClienteDaFila() {
        filaCliente.remove();
    }

    public static void locarCarro(Cliente cliente, Carro carro) {
        carro.setDisponivel(false);
        System.out.println("Nome: " + cliente.getNome() +
                " - Carro Desejado: " + cliente.getModeloDesejado() + " - Locado Carro Placa: " + carro.getPlaca());
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss"); //formatar a data como 12/04/2022 às 16:37:15
        relatorioDeLocacao.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " + carro.getMarca() + ", " + carro.getModelo() + ", " + carro.getPlaca() + ", foi EMPRESTADO para " + cliente.getNome());
    }
    public static void devolverCarro(Cliente cliente, Carro carro) {
        carro.setDisponivel(true);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à's' HH:mm:ss"); //formatar a data como 12/04/2022 às 16:37:15
        relatorioDeLocacao.push(dateFormat.format(Calendar.getInstance().getTime()) + ": Carro " + carro.getMarca() + ", " + carro.getModelo() + ", " + carro.getPlaca() + ", foi DEVOLVIDO para " + cliente.getNome());
    }
}
