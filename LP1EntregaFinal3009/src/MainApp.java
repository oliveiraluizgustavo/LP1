import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;


public class MainApp extends Application {

    private static final String NOME_ARQUIVO_CSV = "dados.csv";

    @Override
    public void start(Stage primaryStage) {
        inicializarArquivoCSV();

        TabPane tabPane = new TabPane();


        Tab tab1 = new Tab("Exercício 1 - Cálculo Média", criarAbaMedia());

        Tab tab2 = new Tab("Exercício 2 - Doodle", criarAbaDoodle());
        Tab tab3 = new Tab("Exercício 3 - Vic Muniz", criarAbaVicMuniz());
        Tab tab4 = new Tab("Exercício 4 - Música", criarAbaMusica());
        Tab tab5 = new Tab("Exercício 5 - Vídeo", criarAbaVideo());

        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);

        Scene scene = new Scene(tabPane, 800, 600);


        primaryStage.setTitle("Entrega Final - LP1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Node criarAbaMedia() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome do Aluno");

        TextField p1Field = new TextField();
        p1Field.setPromptText("Digite P1");

        TextField e1Field = new TextField();
        e1Field.setPromptText("Digite E1");

        TextField e2Field = new TextField();
        e2Field.setPromptText("Digite E2");

        TextField xField = new TextField();
        xField.setPromptText("Digite X (Ponto Extra)");

        TextField subField = new TextField();
        subField.setPromptText("Digite SUB");

        TextField apiField = new TextField();
        apiField.setPromptText("Digite API");

        Label resultado = new Label("O resultado aparecerá aqui.");
        resultado.setStyle("-fx-font-weight: bold;");

        Button calcularBtn = new Button("Calcular Média");
        calcularBtn.setOnAction(e -> {
            try {
                String nome = nomeField.getText();
                String p1Str = p1Field.getText().replace(',', '.');
                String e1Str = e1Field.getText().replace(',', '.');
                String e2Str = e2Field.getText().replace(',', '.');
                String xStr = xField.getText().replace(',', '.');
                String subStr = subField.getText().replace(',', '.');
                String apiStr = apiField.getText().replace(',', '.');

                if (nome.trim().isEmpty() || p1Str.trim().isEmpty() || e1Str.trim().isEmpty() || e2Str.trim().isEmpty() ||
                        xStr.trim().isEmpty() || subStr.trim().isEmpty() || apiStr.trim().isEmpty()) {
                    resultado.setText("Erro: Preencha todos os campos.");
                    return;
                }

                double P1 = Double.parseDouble(p1Str);
                double E1 = Double.parseDouble(e1Str);
                double E2 = Double.parseDouble(e2Str);
                double X = Double.parseDouble(xStr);
                double SUB = Double.parseDouble(subStr);
                double API = Double.parseDouble(apiStr);


                double notaBase = P1 * 0.5 + E1 * 0.2 + E2 * 0.3 + X + SUB * 0.15;
                double parte1 = notaBase * 0.5;
                double parte2 = (notaBase > 5.9) ? (API * 0.5) : 0;
                double media = parte1 + parte2;


                String mediaFormatada = String.format(Locale.forLanguageTag("pt-BR"), "%.2f", media);
                resultado.setText("A média final de " + nome + " é: " + mediaFormatada);

                salvarEmCSV("MediaCalculada", nome, p1Str, e1Str, e2Str, xStr, subStr, apiStr, mediaFormatada);

            } catch (NumberFormatException ex) {
                resultado.setText("Erro: Verifique se os valores são números válidos.");
            }
        });

        root.getChildren().addAll(nomeField, p1Field, e1Field, e2Field, xField, subField, apiField, calcularBtn, resultado);
        return new ScrollPane(root);
    }



    private Node criarAbaDoodle() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("Exercício 2 - Imagem Doodle"));
        root.getChildren().add(criarFormulario("Bicicleta", "QuantidadeMarchas", "Cor", "Modelo"));
        root.getChildren().add(criarFormulario("Planeta", "Tamanho", "Tipo", "PossuiVida"));
        root.getChildren().add(criarFormulario("Teatro", "Gênero", "Enredo", "Duração"));
        return new ScrollPane(root);
    }

    private Node criarAbaVicMuniz() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("3.1 - Imagem Lampedusa"));
        root.getChildren().add(criarFormulario("Barco (Lampedusa)", "Tipo", "Comprimento", "Cor"));
        root.getChildren().add(criarFormulario("Mar", "Profundidade", "Temperatura", "TemOndas"));
        root.getChildren().add(criarFormulario("Prédio", "Altura", "QuantidadeAndares", "Endereço"));
        root.getChildren().add(new Label("3.2 - Imagem Torre Eiffel"));
        root.getChildren().add(criarFormulario("Árvore", "Altura", "Espécie", "Cor"));
        root.getChildren().add(criarFormulario("Pessoa", "Sexo", "Nome", "Idade"));
        root.getChildren().add(criarFormulario("Torre", "Tamanho", "Material", "Tipo"));
        return new ScrollPane(root);
    }

    private Node criarAbaMusica() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("Exercício 4 - Música"));
        root.getChildren().add(criarFormulario("América", "Desenho", "Tempo", "Ferramenta"));
        root.getChildren().add(criarFormulario("Barco (Música)", "Tamanho", "Estilo", "Cor"));
        root.getChildren().add(criarFormulario("Futuro", "Astronave", "Destino", "Sentimento"));
        return new ScrollPane(root);
    }

    private Node criarAbaVideo() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("Exercício 5 - Vídeo"));
        root.getChildren().add(criarFormulario("Bola", "Modelo", "Modalidade", "Circunferência"));
        root.getChildren().add(criarFormulario("Desenho", "Tipo", "Cor", "Tamanho"));
        root.getChildren().add(criarFormulario("Porta", "Tamanho", "Material", "Cor"));
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
            String v1 = f1.getText();
            String v2 = f2.getText();
            String v3 = f3.getText();
            resultado.setText(titulo + " salvo: " + v1 + ", " + v2 + ", " + v3);
            salvarEmCSV(titulo, v1, v2, v3);
        });

        box.getChildren().addAll(label, f1, f2, f3, salvar, resultado);
        return box;
    }

    private void inicializarArquivoCSV() {
        File csvFile = new File(NOME_ARQUIVO_CSV);
        if (!csvFile.exists()) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(csvFile))) {
                pw.println("TipoDeObjeto,Dado1,Dado2,Dado3,Dado4,Dado5,Dado6,Dado7,Resultado");
            } catch (IOException e) {
                System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
            }
        }
    }

    private void salvarEmCSV(String tipo, String... dados) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(NOME_ARQUIVO_CSV, true))) {
            StringBuilder sb = new StringBuilder();
            sb.append(tipo);
            for (String dado : dados) {
                sb.append(",");
                if (dado.contains(",")) {
                    sb.append("\"").append(dado).append("\"");
                } else {
                    sb.append(dado);
                }
            }
            pw.println(sb.toString());
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Arquivo");
            alert.setHeaderText("Não foi possível salvar os dados.");
            alert.setContentText("Ocorreu um erro ao tentar escrever no arquivo " + NOME_ARQUIVO_CSV);
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}