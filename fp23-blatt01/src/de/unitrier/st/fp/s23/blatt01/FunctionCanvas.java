package de.unitrier.st.fp.s23.blatt01;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

final class FunctionCanvas extends Canvas
{

    private double c1 = 1, d1 = 0, c2 = 1, d2 = 0;

    void setFunctionParameters(double c1, double d1, double c2, double d2)
    {
        this.c1 = c1;
        this.d1 = d1;
        this.c2 = c2;
        this.d2 = d2;
    }

    FunctionCanvas() {}

    private static final float v = 244f / 255;
    private static final Color backGroundColor = Color.color(v, v, v);
    private static final int yOffset = 20;
    private Color graphColor;
    private double LineWidth;


    public void setGraphColor(Color graphColor) {
        this.graphColor = graphColor;
    }

    public Color getGraphColor() {
        return graphColor;
    }

    public void setLineWidth(double lineWidth) {
        LineWidth = lineWidth;
    }

    public double getLineWidth() {
        return LineWidth;
    }

    void drawFunctionCurve()
    {
        GraphicsContext gc = getGraphicsContext2D();
        //float v = 244f / 255;
        gc.setFill(backGroundColor);
        gc.fillRect(0, 0, getWidth(), getHeight());


        double h = this.getHeight() - 2 * yOffset;
        int xOffset = 40;
        double w = this.getWidth() - 2 * xOffset;
        double yZero = yOffset + h / 2;
        gc.setFill(Color.BLACK);
        gc.fillText("f(x)", xOffset - 30, yOffset);
        gc.fillText("0", xOffset - 25, yZero + 5);
        gc.fillText("2\u03c0", xOffset + w - 5, yZero - 5);
        gc.setLineWidth(1.0);
        gc.setStroke(Color.GRAY);
        gc.strokeLine(xOffset, yOffset, xOffset, yOffset + h);
        gc.strokeLine(xOffset, yZero, xOffset + w, yZero);
        gc.fillText(">", xOffset+w, yZero); //In Graphical Context Text einzufügen. Parameter: String, x, y
        gc.fillText("^",xOffset-3, yZero-h/2); //In Graphical Context Text einzufügen. Parameter: String, x, y
        gc.setLineWidth(getLineWidth());
        gc.setStroke(getGraphColor());

        for (int x = 0; x < w; x++)
        {
            int y = (int) ((h / 2) * sinCosFunc(x * 2 * Math.PI / w));
            gc.strokeLine(xOffset + x, yZero - y, xOffset + x, yZero - y);
        }
    }

    private double sinCosFunc(double x)
    {
        return Math.sin(c1 * x + d1) * Math.cos(c2 * x + d2);
    }
}
