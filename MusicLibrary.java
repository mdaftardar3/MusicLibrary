import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Paint;
import javafx.scene.paint.ImagePattern;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
/**
    This is the Music Library class.
    @author Mugdha Daftardar
    @version 1.0
*/
public class MusicLibrary extends Application {
    /**
    get background image.
    @return background image
    @throws IOException ioexception
    */
    public BackgroundImage getBackgroundImage()  throws IOException {
        InputStream stream = new FileInputStream("musicImage.jpg");
        Image image = new Image(stream);
        BackgroundSize backgroundSize = new BackgroundSize(1, 1, true, true, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.CENTER, backgroundSize);
        return backgroundImage;
    }
    /**
    get final pane.
    @return pane pane
    @throws IOException ioexception
    */
    public Pane getPane() throws IOException {
        HBox paneForInput = new HBox(10);
        paneForInput.setAlignment(Pos.BOTTOM_CENTER);
        paneForInput.setPadding(new Insets(0, 0, 55, 0));
        TextField tf1 = new TextField();
        tf1.setPromptText("Song name");
        tf1.setFocusTraversable(false);
        tf1.setPrefWidth(140);
        Label lb1 = new Label("Song Name:", tf1);
        lb1.setTextFill(Color.WHITE);
        lb1.setContentDisplay(ContentDisplay.BOTTOM);
        TextField tf2 = new TextField();
        tf2.setPromptText("Album name");
        tf2.setFocusTraversable(false);
        tf2.setPrefWidth(140);
        Label lb2 = new Label("Album Name:", tf2);
        lb2.setTextFill(Color.WHITE);
        lb2.setContentDisplay(ContentDisplay.BOTTOM);
        ComboBox cb = new ComboBox();
        cb.getItems().addAll((Object[]) Genres.values()); ///////////////////////////////////////warning
        cb.setPromptText("Select Song Genre");
        cb.setPrefWidth(140);
        Label lb3 = new Label("Select Song Genre:", cb);
        lb3.setTextFill(Color.WHITE);
        lb3.setContentDisplay(ContentDisplay.BOTTOM);
        Button btn = new Button();
        btn.setText("Add Song");
        btn.setPrefHeight(45);
        paneForInput.getChildren().addAll(lb1, lb2, lb3, btn);
        HBox.setHgrow(paneForInput, Priority.ALWAYS);
        HBox bottomLibrary = new HBox(10);
        bottomLibrary.setAlignment(Pos.CENTER);
        Rectangle r1 = new Rectangle(80, 80);
        r1.setFill(Color.WHITE);
        r1.setStroke(Color.BLACK);
        Text t1 = new Text("Empty");
        StackPane stackPane1 = new StackPane();
        stackPane1.getChildren().addAll(r1, t1);
        Rectangle r2 = new Rectangle(80, 80);
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        Text t2 = new Text("Empty");
        StackPane stackPane2 = new StackPane();
        stackPane2.getChildren().addAll(r2, t2);
        Rectangle r3 = new Rectangle(80, 80);
        r3.setFill(Color.WHITE);
        r3.setStroke(Color.BLACK);
        Text t3 = new Text("Empty");
        StackPane stackPane3 = new StackPane();
        stackPane3.getChildren().addAll(r3, t3);
        bottomLibrary.getChildren().addAll(stackPane1, stackPane2, stackPane3);
        HBox topLibrary = new HBox(10);
        topLibrary.setAlignment(Pos.CENTER);
        Rectangle rt1 = new Rectangle(80, 80);
        rt1.setFill(Color.WHITE);
        rt1.setStroke(Color.BLACK);
        Text tt1 = new Text("Empty");
        StackPane stackPane1Top = new StackPane();
        stackPane1Top.getChildren().addAll(rt1, tt1);
        Rectangle rt2 = new Rectangle(80, 80);
        rt2.setFill(Color.WHITE);
        rt2.setStroke(Color.BLACK);
        Text tt2 = new Text("Empty");
        StackPane stackPane2Top = new StackPane();
        stackPane2Top.getChildren().addAll(rt2, tt2);
        Rectangle rt3 = new Rectangle(80, 80);
        rt3.setFill(Color.WHITE);
        rt3.setStroke(Color.BLACK);
        Text tt3 = new Text("Empty");
        StackPane stackPane3Top = new StackPane();
        stackPane3Top.getChildren().addAll(rt3, tt3);
        topLibrary.getChildren().addAll(stackPane1Top, stackPane2Top, stackPane3Top);
        Text[] libraryTexts = {t1, t2, t3, tt1, tt2, tt3};
        VBox library = new VBox(10);
        library.setAlignment(Pos.CENTER);
        library.getChildren().addAll(bottomLibrary, topLibrary);
        Text t = new Text();
        t.setText("My Music Library");
        t.setFill(Color.WHITE);
        t.setFont(Font.font(30));
        t.setUnderline(true);
        HBox title = new HBox();
        title.setAlignment(Pos.TOP_CENTER);
        title.setPadding(new Insets(110, 0, 0, 0));
        title.getChildren().addAll(t);
        btn.setOnAction(e -> {
            int count = 0;
            int colorCount = 0;
            for (Text text : libraryTexts) {
                colorCount++;
                if (text.getText().equals("Empty")) {
                    String song = (tf1.getText().isEmpty()) ? "Untitled" : tf1.getText();
                    String album = (tf2.getText().isEmpty()) ? "Lover" : tf2.getText();
                    String genre = (cb.getValue() == null) ? "POP" : cb.getValue().toString();
                    tf1.clear();
                    tf2.clear();
                    cb.setValue(null); /////////////////////////////////////////////////////////////warning
                    cb.setPromptText("Select Song Genre");
                    text.setText("\n" + song + "\n" + album + " \n" + genre + "\n");
                    text.setTextAlignment(TextAlignment.CENTER);
                    Font fontBoldItalic = Font.font("SansSerif", FontWeight.BOLD, FontPosture.REGULAR, 15);
                    text.setFont(fontBoldItalic);
                    text.setFill(color(colorCount));
                    break;
                } else {
                    count++;
                }
            }
            if (count == 6) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("Your music library is full!");
                alert.show();
            }
        });
        t1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                t1.setText("Empty");
                t1.setFont(Font.getDefault());
                t1.setFill(Color.BLACK);
            }
        });
        t2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                t2.setText("Empty");
                t2.setFont(Font.getDefault());
                t2.setFill(Color.BLACK);
            }
        });
        t3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                t3.setText("Empty");
                t3.setFont(Font.getDefault());
                t3.setFill(Color.BLACK);
            }
        });
        tt1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                tt1.setText("Empty");
                tt1.setFont(Font.getDefault());
                tt1.setFill(Color.BLACK);
            }
        });
        tt2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                tt2.setText("Empty");
                tt2.setFont(Font.getDefault());
                tt2.setFill(Color.BLACK);
            }
        });
        tt3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                tt3.setText("Empty");
                tt3.setFont(Font.getDefault());
                tt3.setFill(Color.BLACK);
            }
        });
        BorderPane bp = new BorderPane();
        bp.setBottom(paneForInput);
        bp.setCenter(library);
        bp.setTop(title);
        StackPane root = new StackPane();
        root.setBackground(new Background(getBackgroundImage()));
        root.getChildren().addAll(bp);
        return root;
    }
    /**
    swtich for color.
    @param colorCount colorCount
    @return color
    */
    public Color color(int colorCount) {
        switch (colorCount) {
        case 1: return Color.RED;
        case 2: return Color.ORANGE;
        case 3: return Color.GOLD;
        case 4: return Color.GREEN;
        case 5: return Color.BLUE;
        case 6: return Color.PURPLE;
        default: return Color.GRAY;
        }
    }
    /**
    start.
    @param primaryStage primaryStage
    @throws IOException ioexception
    */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws IOException {
        InputStream stream = new FileInputStream("musicImage.jpg");
        Image image = new Image(stream);
        Paint pic = new ImagePattern(image);
        primaryStage.setTitle("My Music Library");
        Scene scene = new Scene(getPane(), image.getWidth() + 10, image.getHeight() + 10);
        //Scene scene = new Scene(getPane(), 450, 200);
        // scene.setFill(pic);
        primaryStage.setScene(scene);
        primaryStage.show(); // Display the stage
    }
    /**
    main.
    @param args argss
    */
    public static void main(String[] args) {
        launch(args);
    }
}