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
    private LinkedList<Double> y = new LinkedList();
    public LinkedList<dataObject> historyData = new LinkedList();
    public FileHandler fileHandler;
    public String title;
    public String xAxis;
    public String yAxis; 
    public String legend;
    public int modelNumStart= 0, modelNumEnd = 0;
    
    public void initUI() {
        historyData = fileHandler.ParseHistory();
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
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                    x.add(Double.valueOf(historyData.get(i).modelNumber));
                } 
                break;
            case "star age":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).starAge));
                } 
                break;
            case "star age day":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).starAgeDay));
                } 
                break;
            case "rsp phase":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspPhase));
                } 
                break;
            case "rsp greek m":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspGreekM));
                } 
                break;
            case "rsp greek m avg abs":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspGreekMAA));
                } 
                break;
            case "rsp delta r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspDeltaR));
                } 
                break;
            case "rsp delta mag":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspDeltaMag));
                } 
                break;
            case "rsp period days":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspPeriodDays));
                } 
                break;
            case "rsp num periods":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).rspNumPeriods));
                } 
                break;
            case "log dt sec":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).logDtSec));
                } 
                break;
            case "radius":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).radius));
                } 
                break;
            case "log r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).logR));
                } 
                break;
            case "vsurf kms":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).vSurfKmS));
                } 
                break;
            case "vsurf div escape v":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).vSurfDivEsc));
                } 
                break;
            case "vdiv surf":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).vDivSurf));
                } 
                break;
                
            case "vdiv max":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).vDivMax));
                } 
                break;
            case "max abs div":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).maxAbsVDiv));
                } 
                break;
            case "dt div":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).dtDiv));
                } 
                break;
            case "luminosity":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).luminosity));
                } 
                break;
            case "log l":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).logL));
                } 
                break;
            case "effective t":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).effectiveT));
                } 
                break;                
            case "log g":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).logG));
                } 
                break;                               
            case "log teff":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).logTeff));
                } 
                break;                               
            case "photosphere l":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).photosphereL));
                } 
                break;                                               
            case "photosphere r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).photosphereR));
                } 
                break;                               
            case "photosphere t":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).photosphereT));
                } 
                break;                               
            case "photosphere kms":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).photosphereKms));
                } 
                break;                               
            case "photosphere div cs":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     x.add(Double.valueOf(historyData.get(i).photosphereDivCs));
                } 
                break;
        }
    }
    public void SetYData(){
        switch(yAxis.toLowerCase()){
            case "model number":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                    y.add(Double.valueOf(historyData.get(i).modelNumber));
                } 
                break;
            case "star age":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).starAge));
                } 
                break;
            case "star age day":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).starAgeDay));
                } 
                break;
            case "rsp phase":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspPhase));
                } 
                break;
            case "rsp greek m":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspGreekM));
                } 
                break;
            case "rsp greek m avg abs":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspGreekMAA));
                } 
                break;
            case "rsp delta r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspDeltaR));
                } 
                break;
            case "rsp delta mag":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspDeltaMag));
                } 
                break;
            case "rsp period days":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspPeriodDays));
                } 
                break;
            case "rsp num periods":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).rspNumPeriods));
                } 
                break;
            case "log dt sec":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).logDtSec));
                } 
                break;
            case "radius":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).radius));
                } 
                break;
            case "log r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).logR));
                } 
                break;
            case "vsurf kms":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).vSurfKmS));
                } 
                break;
            case "vsurf div escape v":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).vSurfDivEsc));
                } 
                break;
            case "vdiv surf":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).vDivSurf));
                } 
                break;
                
            case "vdiv max":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).vDivMax));
                } 
                break;
            case "max abs div":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).maxAbsVDiv));
                } 
                break;
            case "dt div":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).dtDiv));
                } 
                break;
            case "luminosity":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).luminosity));
                } 
                break;
            case "log l":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).logL));
                } 
                break;
            case "effective t":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).effectiveT));
                } 
                break;                
            case "log g":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).logG));
                } 
                break;                               
            case "log teff":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).logTeff));
                } 
                break;                               
            case "photosphere l":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).photosphereL));
                } 
                break;                                               
            case "photosphere r":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).photosphereR));
                } 
                break;                               
            case "photosphere t":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).photosphereT));
                } 
                break;                               
            case "photosphere kms":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).photosphereKms));
                } 
                break;                               
            case "photosphere div cs":
                for(int i = modelNumStart; i <= modelNumEnd; i++){
                     y.add(Double.valueOf(historyData.get(i).photosphereDivCs));
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
        SetXData();
        SetYData();
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
