package de.unitrier.st.fp.s23.blatt07;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static java.lang.System.out;

public final class PiTrial extends Application implements Runnable
{
    private Label estimatePiLabel;
    private Label trialCountLabel;
    private Label totalTimeLabel;

    public PiTrial() {}

    private static BorderPane createBorderPane(String leftLabelText, Node right)
    {
        Label label = new Label(leftLabelText);
        BorderPane pane = new BorderPane();
        pane.setLeft(label);
        pane.setRight(right);
        pane.setBorder(new Border(new BorderStroke(Color.LIGHTGREY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        return pane;
    }

    @Override
    public void start(Stage stage)
    {
        final int width = 400;
        final int height = 220;

        VBox vbox = new VBox();
        ObservableList<Node> vboxChildren = vbox.getChildren();

        vboxChildren.add(createBorderPane("  Actual value of pi: ", new Label(String.format("%.15f  ", Math.PI))));

        estimatePiLabel = new Label(String.format("%.15f  ", 0f));
        vboxChildren.add(createBorderPane("  Approximated value of pi: ", estimatePiLabel));

        trialCountLabel = new Label(String.format("%d  ", 0));
        vboxChildren.add(createBorderPane("  Number of trials: ", trialCountLabel));

        totalTimeLabel = new Label();
        vboxChildren.add(createBorderPane("  Total time elapsed (sec): ", totalTimeLabel));

        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5.);
        vbox.setPadding(new Insets(0, 5, 0, 5));

        Scene scene = new Scene(vbox, width, height);

        stage.setTitle(this.getClass().getSimpleName());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.centerOnScreen();

        initPiTrial();
        Thread thr = new Thread(this);
        thr.start();

        stage.setOnCloseRequest(event -> thr.interrupt());

        stage.show();

        start = System.nanoTime();
        initPiTrial();
        initThreads();
    }

    private void initPiTrial()
    {
        trials = 0;
        inCircle = 0;
        timeElapsed = 0;
        totalTimeLabel.setText("n/a  ");
    }

    private void initThreads()
    {
        long start = System.nanoTime();

        for (int i = 0; i < 3; i++)
        {
            new PiTrialThread(this, Integer.MAX_VALUE / 3).start();
        }
        timeElapsed += System.nanoTime() - start;
    }

    private long start;
    private long timeElapsed;
    private long trials;
    private long inCircle;

    private boolean update;

    void addTrials(long trials, long inCircle)
    {
        this.trials += trials;
        this.inCircle += inCircle;
        this.update = true;
    }

    void threadDone()
    {
        out.printf("%s done\n", Thread.currentThread());
        Platform.runLater(() ->
                totalTimeLabel.setText(String.format("%.3f  ", (double) (timeElapsed + (System
                        .nanoTime() - start)) / 1E9))
        );
    }

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted())
        {
            try
            {
                while (!update)
                {
                    Thread.sleep(50);
                }
                Platform.runLater(() -> {
                            estimatePiLabel.setText(String.format("%.15f  ", 4 * ((double) inCircle / trials)));
                            trialCountLabel.setText(String.format("%d  ", trials));
                        }
                );
                update = false;
            } catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
}
