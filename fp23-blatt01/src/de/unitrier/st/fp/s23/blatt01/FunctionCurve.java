package de.unitrier.st.fp.s23.blatt01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class FunctionCurve extends Application
{
    public FunctionCurve() { }

    @Override
    public void start(Stage stage)
    {
        int width = 670;
        int height = 520;
        FlowPane p = new FlowPane();

        Scene scene = new Scene(p, width, height);

        Button btnReset = new Button("Reset"); //wichtig!! Button muss der Klasse javafx.scene.control angehören
        Button btnDraw = new Button("Draw");

        CheckBox cbColor = new CheckBox("Green"); // wichtig!! Button muss der Klasse javafx.scene.control angehören

        Slider lineWidth = new Slider();



        Spinner<Double> s1 = new Spinner(); //<Double> damit z.b. s1.getValue() unten funktionert
        Spinner<Double> s2 = new Spinner();
        Spinner<Double> s3 = new Spinner();
        Spinner<Double> s4 = new Spinner();

        s1.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE,Double.MAX_VALUE,1,0.5)); //alle vier rufen die Methode
        s2.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE,Double.MAX_VALUE,1,0.5)); //vom Spinner auf(=setValueFactory)
        s3.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE,Double.MAX_VALUE,1,0.5)); //und erstellen im Parameter direkt
        s4.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(Double.MIN_VALUE,Double.MAX_VALUE,1,0.5)); //ein SpinnerValueFactory
        //die ersten zwei Werte sind obere und untere Schranken, viereter Paramter ist der Anfangsswert und der dritte ist die Schrittweite


        FunctionCanvas canvas = new FunctionCanvas();

        canvas.setWidth(width);
        canvas.setHeight(height);
        canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue()); //getvalue ist eine Objektmethode der Klasse Spinner und kriegt die Zahl dadrin
        //als Double. Funktionert nur wenn der Spinner als Liste deklariert is vom Typ Double. Siehe oben

        btnReset.setOnAction(e -> {
            s1.getValueFactory().setValue(1.0); //So kann den Wert des Spinners umändern über .getValueFactory().setValue(0.0)
            s2.getValueFactory().setValue(1.0); //Der Parameter braucht analog zu getValue() ein Double Wert
            s3.getValueFactory().setValue(1.0);
            s4.getValueFactory().setValue(1.0);


            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.setGraphColor(Color.BLACK);
            canvas.drawFunctionCurve();

        });

        btnDraw.setOnAction(e -> {
            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.drawFunctionCurve();
        });


        //Ab hier kommen die Listener. Wichtig ist, dass Listener oft mit ...Property arbeitet. Das heißt er taucht meistens oft
        //wenn davor eine Methode ...Property aufruft. Wie hier unten(s1.valueProperty().addListener...)

        s1.valueProperty().addListener(e-> {
            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.drawFunctionCurve();
        });
        s2.valueProperty().addListener(e-> {
            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.drawFunctionCurve();
        });
        s3.valueProperty().addListener(e-> {
            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.drawFunctionCurve();
        });
        s4.valueProperty().addListener(e-> {
            canvas.setFunctionParameters(s1.getValue(),s2.getValue(),s3.getValue(),s4.getValue());
            canvas.drawFunctionCurve();
        });

        stage.widthProperty().addListener(e -> { //Wichtig: Wie oben bei den Listenern von den Spinnern braucht man hier auch iwas Prop erty.
            canvas.setWidth(stage.getWidth());   //Man kann am Fenster selber (stage) ein Lisenter setzen der die Fensetergröße anpasst
            canvas.drawFunctionCurve(); //sobald sich das Fenster verändert. Entsprechend der Fenstergröße dann
        });stage.heightProperty().addListener(e -> {
            canvas.setHeight(stage.getHeight());
            canvas.drawFunctionCurve();
        });

        cbColor.setOnAction(e -> {  //Checkbox (nochmal: Der Klasse javafx.scene.control kann setOnAction annehmen

            if(cbColor.isSelected()) { //Merken: isSelected!!
                canvas.setGraphColor(Color.GREEN);
            }
            else {
                canvas.setGraphColor(Color.BLACK);

            }
            canvas.drawFunctionCurve();
        });

        lineWidth.valueProperty().addListener(e->{ //Wie die Spinner braucht das ein Listener. Wieder: mit Property arbeiten damti Listner auftaucht
            canvas.setLineWidth(lineWidth.getValue()); //Slider haben einen Wert von 0 bis 100 und zwar als double Werte
            canvas.drawFunctionCurve();

        });


        canvas.drawFunctionCurve();
        p.getChildren().addAll(s1,s2,s3,s4,btnReset,btnDraw,cbColor,lineWidth, canvas); //Am besten hier am Ende tun dann muss man keine Sorgen macahe dass man was
                                                                        //was dadrunter initialisiert. Reihefolge beeinflusst die Anordung in der GUI

        stage.setTitle(this.getClass().getSimpleName());
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
