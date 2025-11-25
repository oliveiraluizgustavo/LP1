import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;



public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ======== TELA PRINCIPAL DO PROGRAMA =========
        Scene scenePrincipal = new Scene(criarTelaPrincipal(), 800, 650);

        // ======== TELA INICIAL =========
        VBox telaInicial = new VBox(20);
        telaInicial.setPadding(new Insets(20));
        telaInicial.setAlignment(Pos.CENTER);

        Label bemVindo = new Label("Bem-vindo ao Programa");
        bemVindo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Label instrucoes = new Label("Aperte o botão para continuar");

        Button botaoContinuar = new Button("Continuar");
        botaoContinuar.setStyle("-fx-font-size: 16px;");

        // Ao clicar → troca para a tela principal
        botaoContinuar.setOnAction(e -> {
            primaryStage.setScene(scenePrincipal);
        });

        telaInicial.getChildren().addAll(bemVindo, instrucoes, botaoContinuar);

        // Cena inicial
        Scene sceneInicial = new Scene(telaInicial, 800, 650);

        primaryStage.setTitle("Tela Inicial");
        primaryStage.setScene(sceneInicial);
        primaryStage.show();
    }


    private Parent criarTelaPrincipal() {


        TabPane tabPane = new TabPane();

        Tab tabMusica = new Tab("Música", criarAbaMusica());
        tabMusica.setClosable(false);

        Tab tabGerenciar = new Tab("Gerenciar", criarAbaGerenciar());
        tabGerenciar.setClosable(false);

        tabPane.getTabs().addAll(tabMusica, tabGerenciar);


        return tabPane;
    }

    private Node criarAbaMusica() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("Música"));
        root.getChildren().add(criarFormulario("América", "Desenho", "Tempo", "Ferramenta"));
        root.getChildren().add(criarFormulario("Barco", "Tamanho", "Estilo", "Cor"));
        root.getChildren().add(criarFormulario("Futuro", "Astronave", "Destino", "Sentimento"));
        return new ScrollPane(root);
    }

    private Node criarAbaGerenciar() {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // TÍTULO
        Label titulo = new Label("Gerenciar Registros");
        titulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // TABELA
        TableView<Musica> tabela = new TableView<>();

        TableColumn<Musica, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(50);

        TableColumn<Musica, String> colTitulo = new TableColumn<>("Título");
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colTitulo.setPrefWidth(150);

        TableColumn<Musica, String> colA1 = new TableColumn<>("Atributo 1");
        colA1.setCellValueFactory(new PropertyValueFactory<>("atributo1"));
        colA1.setPrefWidth(150);

        TableColumn<Musica, String> colA2 = new TableColumn<>("Atributo 2");
        colA2.setCellValueFactory(new PropertyValueFactory<>("atributo2"));
        colA2.setPrefWidth(150);

        TableColumn<Musica, String> colA3 = new TableColumn<>("Atributo 3");
        colA3.setCellValueFactory(new PropertyValueFactory<>("atributo3"));
        colA3.setPrefWidth(150);

        tabela.getColumns().addAll(colId, colTitulo, colA1, colA2, colA3);

        // FUNÇÃO RECARREGAR
        Button btnRecarregar = new Button("Recarregar");
        btnRecarregar.setOnAction(e -> {
            tabela.getItems().setAll(MusicaDAO.read());
        });

        // BOTÃO EXCLUIR
        Button btnExcluir = new Button("Excluir Selecionado");
        btnExcluir.setOnAction(e -> {
            Musica selecionada = tabela.getSelectionModel().getSelectedItem();
            if (selecionada != null) {
                MusicaDAO.delete(selecionada.getId());
                tabela.getItems().setAll(MusicaDAO.read());
            }
        });

        // BOTÃO ATUALIZAR
        Button btnEditar = new Button("Editar Selecionado");
        btnEditar.setOnAction(e -> {

            Musica selecionada = tabela.getSelectionModel().getSelectedItem();
            if (selecionada == null) return;

            // JANELA DE EDIÇÃO
            Stage janelaEdicao = new Stage();
            VBox box = new VBox(10);
            box.setPadding(new Insets(10));

            TextField tf1 = new TextField(selecionada.getAtributo1());
            TextField tf2 = new TextField(selecionada.getAtributo2());
            TextField tf3 = new TextField(selecionada.getAtributo3());

            Button salvar = new Button("Salvar Alterações");
            salvar.setOnAction(ev -> {
                selecionada.setAtributo1(tf1.getText());
                selecionada.setAtributo2(tf2.getText());
                selecionada.setAtributo3(tf3.getText());

                MusicaDAO.update(selecionada);
                tabela.getItems().setAll(MusicaDAO.read());
                janelaEdicao.close();
            });

            box.getChildren().addAll(new Label("Editar atributos:"), tf1, tf2, tf3, salvar);

            janelaEdicao.setScene(new Scene(box, 300, 250));
            janelaEdicao.setTitle("Editar Registro");
            janelaEdicao.show();
        });

        HBox botoes = new HBox(10, btnRecarregar, btnEditar, btnExcluir);

        root.getChildren().addAll(titulo, tabela, botoes);

        return new ScrollPane(root);
    }


    private VBox criarFormulario(String titulo, String a1, String a2, String a3) {
        VBox box = new VBox(5);
        box.setPadding(new Insets(5));
        box.setStyle("-fx-border-color: black; -fx-padding: 5;");

        Label label = new Label("Objeto: " + titulo);
        TextField f1 = new TextField(); f1.setPromptText(a1);
        TextField f2 = new TextField(); f2.setPromptText(a2);
        TextField f3 = new TextField(); f3.setPromptText(a3);
        Label resultado = new Label();

        Button salvar = new Button("Salvar " + titulo);

        salvar.setOnAction(e -> {

            // impedir salvar campos vazios
            if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty()) {
                resultado.setText("Preencha todos os campos!");
                return;
            }

            // criar objeto Musica
            Musica musica = new Musica(
                    titulo,
                    f1.getText(),
                    f2.getText(),
                    f3.getText()
            );

            // salvar no banco
            MusicaDAO.create(musica);

            resultado.setText("Salvo no MySQL!");

            f1.clear();
            f2.clear();
            f3.clear();

        });


        box.getChildren().addAll(label, f1, f2, f3, salvar, resultado);
        return box;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
