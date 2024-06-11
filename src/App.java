
import java.util.Date;
import java.util.Scanner;


import Model.Categoria;
import Model.CategoriaItem;
import Model.Consumo;
import Model.ConsumoServico;
import Model.Funcionario;
import Model.Hospede;
import Model.Item;
import Model.Quarto;
import Model.Reserva;
import Model.Servico;
import Services.CategoriaDataDao;
import Services.CategoriaItemDataDao;
import Services.ConsumoDataDao;
import Services.ConsumoServicoDataDao;
import Services.FuncionarioDataDao;
import Services.HospedeDataDao;
import Services.ItemDataDao;
import Services.QuartaDataDao;
import Services.ReservaDataDao;
import Services.ServicoDataDao;

public class App {
    public static void main(String[] args) throws Exception {

    Categoria categoria = new Categoria("1", "luxo", 50);
    Quarto quarto = new Quarto("5", categoria, "Ativo");
    // Quarto quarto2 = new Quarto("3", categoria, "Ativo");
    QuartaDataDao q1 = new QuartaDataDao();
    
    // q1.editar(quarto);
    // q1.cadastrar(quarto2);
    // q1.cadastrar(quarto);

    Hospede hospede1 = new Hospede("1234", "Luan", "paulo@", "Fortal");
    HospedeDataDao hospedeDao = new HospedeDataDao();
    // hospedeDao.cadastrar(hospede1);
    // hospedeDao.consultar(hospede1);
    // hospedeDao.editar(hospede1);

    Funcionario funcionario1 = new Funcionario("2222222", "Buda", "luan@", "Recepção");
    FuncionarioDataDao funcionarioDao = new FuncionarioDataDao();
    // funcionarioDao.cadastrar(funcionario1);
    // funcionarioDao.consultar(funcionario1);
    // funcionarioDao.editar(funcionario1);

    Categoria categoria1 = new Categoria("1", "simples", 80);
    Categoria categoria2 = new Categoria("2", "simples", 80);
    CategoriaDataDao categoriaDao = new CategoriaDataDao();
    // categoriaDao.cadastrar(categoria1);
    // categoriaDao.cadastrar(categoria2);
    // categoriaDao.consultar(categoria1);

    Item item1 = new Item(1, "Coca", 2);
    ItemDataDao itemDao = new ItemDataDao();
    // itemDao.cadastrar(item1);
    // itemDao.consultar(item1);

    Servico servico1 = new Servico(1, "massagem", 100);
    ServicoDataDao servicoDao = new ServicoDataDao();
    // servicoDao.cadastrar(servico1);

    Reserva reserva1 = new Reserva(1, hospede1, quarto, 110);
    ReservaDataDao reservaDao = new ReservaDataDao();
    // reservaDao.cadastrar(reserva1);

    Consumo consumo = new Consumo(item1, reserva1, 2, new Date());
    ConsumoDataDao consumoDao = new ConsumoDataDao();
    // consumoDao.cadastrar(consumo);
    // consumoDao.consultar(consumo);

    CategoriaItem categoriaItem1 = new CategoriaItem(item1, categoria2, 3);
    CategoriaItemDataDao categoriaItemDao = new CategoriaItemDataDao();

    ConsumoServico consumoServico1 = new ConsumoServico(servico1, reserva1, 2, new Date());
    ConsumoServicoDataDao consumoServicoDao = new ConsumoServicoDataDao();
    
    Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Quarto");
            System.out.println("2. Hospede");
            System.out.println("3. Funcionário");
            System.out.println("4. Serviço");
            System.out.println("5. Reserva");
            System.out.println("6. Item");
            System.out.println("7. Categoria");
            System.out.println("8. Categoria do Item");
            System.out.println("9. Consumo");
            System.out.println("10. Consumo de Serviços");
            System.out.println("11. Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    int opcaoQuarto;
                    do {
                        System.out.println("\nMenu Quarto");
                        System.out.println("1. Cadastrar Quarto");
                        System.out.println("2. Consultar Quarto");
                        System.out.println("3. Listar Quartos");
                        System.out.println("4. Editar Quarto");
                        System.out.println("5. Voltar ao Menu Principal");
                        System.out.println("Escolha uma opção:");
                        opcaoQuarto = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoQuarto) {
                            case 1:
                                System.out.println("Cadastrando Quarto...");
                                q1.cadastrar(quarto);
                                break;
                            case 2:
                                System.out.println("Consultando Quarto...");
                                q1.consultar(quarto);
                                break;
                            case 3:
                                System.out.println("Listando Quartos...");
                                q1.listarTodos(quarto);
                                break;
                            case 4:
                                System.out.println("Editando Quarto...");
                                q1.editar(quarto);
                                break;
                            case 5:
                                System.out.println("Voltar ao menu principal");
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (opcaoQuarto != 5);
                    break;
                case 2:
                int opcaoHospede;
                do {
                    System.out.println("\nMenu Hospede");
                    System.out.println("1. Cadastrar Hospede");
                    System.out.println("2. Consultar Hospede");
                    System.out.println("3. Listar Hospedes");
                    System.out.println("4. Editar Hospede");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoHospede = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoHospede) {
                        case 1:
                            System.out.println("Cadastrando Hospede...");
                            hospedeDao.cadastrar(hospede1);
                            break;
                        case 2:
                            System.out.println("Consultando Hospede...");
                            hospedeDao.consultar(hospede1);
                            break;
                        case 3:
                            System.out.println("Listando Hospedes...");
                            hospedeDao.listarTodos(hospede1);
                            break;
                        case 4:
                            System.out.println("Editando Hospede...");
                            hospedeDao.editar(hospede1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoHospede != 5);
                break;
                case 3:
                int opcaoFuncionario;
                do {
                    System.out.println("\nMenu Funcionário");
                    System.out.println("1. Cadastrar Funcionário");
                    System.out.println("2. Consultar Funcionário");
                    System.out.println("3. Listar Funcionários");
                    System.out.println("4. Editar Funcionário");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoFuncionario = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoFuncionario) {
                        case 1:
                            System.out.println("Cadastrando Funcionário...");
                            funcionarioDao.cadastrar(funcionario1);
                            break;
                        case 2:
                            System.out.println("Consultando Funcionário...");
                            funcionarioDao.consultar(funcionario1);
                            break;
                        case 3:
                            System.out.println("Listando Funcionários...");
                            funcionarioDao.listarTodos(funcionario1);
                            break;
                        case 4:
                            System.out.println("Editando Funcionário...");
                            funcionarioDao.editar(funcionario1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoFuncionario != 5);
                break;
                case 4:
                int opcaoServico;
                do {
                    System.out.println("\nMenu Serviço");
                    System.out.println("1. Cadastrar Serviço");
                    System.out.println("2. Consultar Serviço");
                    System.out.println("3. Listar Serviços");
                    System.out.println("4. Editar Serviço");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoServico = scanner.nextInt();
                    scanner.nextLine();
                    

                    switch (opcaoServico) {
                        case 1:
                            System.out.println("Cadastrando Serviço...");
                            servicoDao.cadastrar(servico1);
                            break;
                        case 2:
                            System.out.println("Consultando Serviço...");
                            servicoDao.consultar(servico1);
                            break;
                        case 3:
                            System.out.println("Listando Serviços...");
                            servicoDao.listarTodos(servico1);
                            break;
                        case 4:
                            System.out.println("Editando Serviço...");
                            servicoDao.editar(servico1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoServico != 5);
                break;
                case 5:
                int opcaoReserva;
                do {
                    System.out.println("\nMenu Reserva");
                    System.out.println("1. Cadastrar Reserva");
                    System.out.println("2. Consultar Reserva");
                    System.out.println("3. Listar Reservas");
                    System.out.println("4. Editar Reserva");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoReserva = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoReserva) {
                        case 1:
                            System.out.println("Cadastrando Reserva...");
                            reservaDao.cadastrar(reserva1);
                            break;
                        case 2:
                            System.out.println("Consultando Reserva...");
                            reservaDao.consultar(reserva1);
                            break;
                        case 3:
                            System.out.println("Listando Reservas...");
                            reservaDao.listarTodos(reserva1);
                            break;
                        case 4:
                            System.out.println("Editando Reserva...");
                            reservaDao.editar(reserva1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoReserva != 5);
                break;

                case 6:
                int opcaoItem;
                do {
                    System.out.println("\nMenu Item");
                    System.out.println("1. Cadastrar Item");
                    System.out.println("2. Consultar Item");
                    System.out.println("3. Listar Itens");
                    System.out.println("4. Editar Item");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoItem = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoItem) {
                        case 1:
                            System.out.println("Cadastrando Iten...");
                            itemDao.cadastrar(item1);
                            break;
                        case 2:
                            System.out.println("Consultando Iten...");
                            itemDao.consultar(item1);
                            break;
                        case 3:
                            System.out.println("Listando Itens...");
                            itemDao.listarTodos(item1);
                            break;
                        case 4:
                            System.out.println("Editando Iten...");
                            itemDao.editar(item1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoItem != 5);
                break;
                case 7:
                int opcaoCategoria;
                do {
                    System.out.println("\nMenu Categoria");
                    System.out.println("1. Cadastrar Categoria");
                    System.out.println("2. Consultar Categoria");
                    System.out.println("3. Listar Categorias");
                    System.out.println("4. Editar Categoria");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoCategoria = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoCategoria) {
                        case 1:
                            System.out.println("Cadastrando Categoria...");
                            categoriaDao.cadastrar(categoria1);
                            break;
                        case 2:
                            System.out.println("Consultando Categoria...");
                            categoriaDao.consultar(categoria1);
                            break;
                        case 3:
                            System.out.println("Listando Categorias...");
                            categoriaDao.listarTodos(categoria1);
                            break;
                        case 4:
                            System.out.println("Editando Categoria...");
                            categoriaDao.editar(categoria1);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoCategoria != 5);
                break;

                case 8:
                int opcaoCatItem;
                    do {
                        System.out.println("\nMenu Categoria do Item");
                        System.out.println("1. Cadastrar Categoria do Item");
                        System.out.println("2. Consultar Categoria do Item");
                        System.out.println("3. Listar Categoria do Itens");
                        System.out.println("4. Editar Categoria do Item");
                        System.out.println("5. Voltar ao Menu Principal");
                        System.out.println("Escolha uma opção:");
                        opcaoCatItem = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoCatItem) {
                            case 1:
                                System.out.println("Cadastrando Categoria do Item..");
                                categoriaItemDao.cadastrar(categoriaItem1);
                                break;
                            case 2:
                                System.out.println("Consultando Categoria do Item..");
                                categoriaItemDao.consultar(categoriaItem1);
                                break;
                            case 3:
                                System.out.println("Listando Categorias do Item...");
                                categoriaItemDao.listarTodos(categoriaItem1);
                                break;
                            case 4:
                                System.out.println("Editando Categoria do Item..");
                                categoriaItemDao.editar(categoriaItem1);
                                break;
                            case 5:
                                System.out.println("Voltar ao menu principal");
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    } while (opcaoCatItem != 5);
                    break;

                case 9:
                int opcaoConsumo;
                do {
                    System.out.println("\nMenu Consumo");
                    System.out.println("1. Cadastrar Consumo");
                    System.out.println("2. Consultar Consumo");
                    System.out.println("3. Listar Consumos");
                    System.out.println("4. Editar Consumo");
                    System.out.println("5. Voltar ao Menu Principal");
                    System.out.println("Escolha uma opção:");
                    opcaoConsumo = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoConsumo) {
                        case 1:
                            System.out.println("Cadastrando Consumo...");
                            consumoDao.cadastrar(consumo);
                            break;
                        case 2:
                            System.out.println("Consultando Consumo...");
                            consumoDao.consultar(consumo);
                            break;
                        case 3:
                            System.out.println("Listando Consumos...");
                            consumoDao.listarTodos(consumo);
                            break;
                        case 4:
                            System.out.println("Editando Consumo...");
                            consumoDao.editar(consumo);
                            break;
                        case 5:
                            System.out.println("Voltar ao menu principal");
                        default:
                            System.out.println("Opção inválida, tente novamente.");
                    }
                } while (opcaoConsumo != 5);
                break;
            case 10:
            int opcaoConsumoServico;
            do {
                System.out.println("\nMenu Quarto");
                System.out.println("1. Cadastrar Consumo de Serviços");
                System.out.println("2. Consultar Consumo de Serviços");
                System.out.println("3. Listar Consumos de Serviços");
                System.out.println("4. Editar Consumo de Serviços");
                System.out.println("5. Voltar ao Menu Principal");
                System.out.println("Escolha uma opção:");
                opcaoConsumoServico = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoConsumoServico) {
                    case 1:
                        System.out.println("Cadastrando Consumo de Serviços...");
                        consumoServicoDao.cadastrar(consumoServico1);
                    
                        break;
                    case 2:
                        System.out.println("Consultando Consumo de Serviços...");
                        consumoServicoDao.consultar(consumoServico1);
                        break;
                    case 3:
                        System.out.println("Listando Consumos de Serviços...");
                        consumoServicoDao.listarTodos(consumoServico1);
                        break;
                    case 4:
                        System.out.println("Editando Consumo de Serviços...");
                        consumoServicoDao.editar(consumoServico1);
                        break;
                    case 5:
                        System.out.println("Voltar ao menu principal");
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } while (opcaoConsumoServico != 5);
            break;
        case 11:
            System.out.println("Saindo...");
            break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 11);

        scanner.close();

    

















































































































































    
    
    
    
}
}