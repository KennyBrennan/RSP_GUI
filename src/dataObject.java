import java.text.DecimalFormat;
import java.text.NumberFormat;

public class dataObject{
        public String modelNumber, starAge, starAgeDay, rspPhase, rspGreekM, 
                rspGreekMAA, rspDeltaR, rspDeltaMag, rspPeriodDays, 
                rspNumPeriods, logDtSec, radius, logR, vSurfKmS, vSurfDivEsc, 
                vDivSurf, vDivMax, maxAbsVDiv, dtDiv, luminosity, logL, 
                effectiveT, logG, logTeff, photosphereL, photosphereR, 
                photosphereT, photosphereKms, photosphereDivCs, numRetries;

        
        public void ConvertData(){
           NumberFormat formatter = new DecimalFormat("###.####");  
           Double temp;
           temp = Double.valueOf(this.starAge);
           this.starAge = formatter.format(temp);
           
           temp = Double.valueOf(this.starAgeDay);
           this.starAgeDay = formatter.format(temp);
           
           temp = Double.valueOf(this.rspPhase);
           this.rspPhase = formatter.format(temp);
           
           temp = Double.valueOf(this.rspGreekM);
           this.rspGreekM = formatter.format(temp);
           
           temp = Double.valueOf(this.rspGreekMAA);
           this.rspGreekMAA = formatter.format(temp);
           
           temp = Double.valueOf(this.rspDeltaR);
           this.rspDeltaR = formatter.format(temp);
           
           temp = Double.valueOf(this.rspDeltaMag);
           this.rspDeltaMag = formatter.format(temp);
           
           temp = Double.valueOf(this.rspPeriodDays);
           this.rspPeriodDays = formatter.format(temp);
           
           temp = Double.valueOf(this.rspNumPeriods);
           this.rspNumPeriods = formatter.format(temp);
           
           temp = Double.valueOf(this.logDtSec);
           this.logDtSec = formatter.format(temp);
           
           temp = Double.valueOf(this.radius);
           this.radius = formatter.format(temp);
           
           temp = Double.valueOf(this.logR);
           this.logR = formatter.format(temp);
           
           temp = Double.valueOf(this.vSurfKmS);
           this.vSurfKmS = formatter.format(temp);
           
           temp = Double.valueOf(this.vSurfDivEsc);
           this.vSurfDivEsc = formatter.format(temp);
           
           temp = Double.valueOf(this.vDivSurf);
           this.vDivSurf = formatter.format(temp);
           
           temp = Double.valueOf(this.vDivMax);
           this.vDivMax = formatter.format(temp);
           
           temp = Double.valueOf(this.maxAbsVDiv);
           this.maxAbsVDiv = formatter.format(temp);
           
           temp = Double.valueOf(this.dtDiv);
           this.dtDiv = formatter.format(temp);
           
           temp = Double.valueOf(this.luminosity);
           this.luminosity = formatter.format(temp);
           
           temp = Double.valueOf(this.logL);
           this.logL = formatter.format(temp);
           
           temp = Double.valueOf(this.effectiveT);
           this.effectiveT = formatter.format(temp);
           
           temp = Double.valueOf(this.logG);
           this.logG = formatter.format(temp);
           
           temp = Double.valueOf(this.logTeff);
           this.logTeff = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereL);
           this.photosphereL = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereR);
           this.photosphereR = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereT);
           this.photosphereT = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereR);
           this.photosphereR = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereKms);
           this.photosphereKms = formatter.format(temp);
           
           temp = Double.valueOf(this.photosphereDivCs);
           this.photosphereDivCs = formatter.format(temp);    
        }
        
        public void printData(){
            ConvertData();
            System.out.println("modelNumber " + modelNumber);
            System.out.println("starAge " + starAge);
            System.out.println("starAgeDay " + starAgeDay);
            System.out.println("rspPhase " + rspPhase);
            System.out.println("rspGreekM " + rspGreekM);
            System.out.println("rspGreekMAA " + rspGreekMAA);
            System.out.println("rspDeltaR " + rspDeltaR);
            System.out.println("rspDeltaMag " + rspDeltaMag);
            System.out.println("rspPeriodDays " + rspPeriodDays);
            System.out.println("rspNumPeriods " + rspNumPeriods);
            System.out.println("logDtSec " + logDtSec);
            System.out.println("radius " + radius);
            System.out.println("logR " + logR);
            System.out.println("vSurfKmS " + vSurfKmS);
            System.out.println("vSurfDivEsc " + vSurfDivEsc);
            System.out.println("vDivSurf " + vDivSurf);
            System.out.println("vDivMax " + vDivMax);
            System.out.println("maxAbsVDiv " + maxAbsVDiv);
            System.out.println("dtDiv " + dtDiv);
            System.out.println("luminosity " + luminosity);
            System.out.println("logL " + logL);
            System.out.println("effectiveT " + effectiveT);
            System.out.println("logG " + logG);
            System.out.println("logTeff " + logTeff);
            System.out.println("photosphereL " + photosphereL);
            System.out.println("photosphereR " + photosphereR);
            System.out.println("photosphereT " + photosphereT);
            System.out.println("photosphereKms " + photosphereKms);
            System.out.println("photosphereDivCs " + photosphereDivCs);
            System.out.println("numRetries " + numRetries);
            System.out.println("--------------------------------------------");
        }
    }
