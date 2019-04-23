import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph extends JFrame {
    private LinkedList<Double> x = new LinkedList();
    private LinkedList<Double> y= new LinkedList();
    public FileHandler fileHandler;
    public LinkedList<dataObject> historyData = new LinkedList();
    public String title ;
    public String xAxis;
    public String yAxis ; 
    public String legend;

    public void initUI() {
        XYDataset dataset = createDataset(legend);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
        setTitle(title);
        setLocationRelativeTo(null);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void SetXData(){
        switch(xAxis.toLowerCase()){
            case "model number":
                for(dataObject o: historyData){
                    x.add(Double.valueOf(o.modelNumber));
                } 
                break;
            case "star age":
                for(dataObject o: historyData){
                    Double.valueOf(o.starAge);
                } 
                break;
            case "star age day":
                for(dataObject o: historyData){
                    Double.valueOf(o.starAge);
                } 
                break;
            case "rsp phase":
                for(dataObject o: historyData){
                    Double.valueOf(o.starAge);
                } 
                break;
                
        }
    }

    public void SetX(LinkedList x){
        this.x = x;
    }
    public void SetY(LinkedList y){
        this.y = y;
    }
    public void SetTitle(String title){
        this.title = title;
    }
    public void SetXAxis(String xAxis){
        this.xAxis = xAxis;
    }
    public void SetYAxis(String yAxis){
        this.yAxis = yAxis;
    }
    public void SetLegend(String legend){
        this.legend = legend;
    }
    
    private XYDataset createDataset(String dataName) {
        x.add(18.0);
        x.add(25.0);
        x.add(27.0);
        y.add(8000.0);
        y.add(47000.0);
        y.add(50000.0);
        XYSeries series = new XYSeries(dataName);
        for(int i = 0; i < x.size(); i++){
            series.add(x.get(i), y.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                title, 
                xAxis, 
                yAxis, 
                dataset, 
                PlotOrientation.VERTICAL,
                true, 
                true, 
                false 
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle(title,
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;

    }

}
