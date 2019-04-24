
public class dataObject{
        public String modelNumber, starAge, starAgeDay, rspPhase, rspGreekM, 
                rspGreekMAA, rspDeltaR, rspDeltaMag, rspPeriodDays, 
                rspNumPeriods, logDtSec, radius, logR, vSurfKmS, vSurfDivEsc, 
                vDivSurf, vDivMax, maxAbsVDiv, dtDiv, luminosity, logL, 
                effectiveT, logG, logTeff, photosphereL, photosphereR, 
                photosphereT, photosphereKms, photosphereDivCs, numRetries;

        
        public void ConvertData(){
           Double temp;
           temp = Double.parseDouble(this.starAge);
           this.starAge = String.valueOf(temp);
           
           temp = Double.parseDouble(this.starAgeDay);
           this.starAgeDay = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspPhase);
           this.rspPhase = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspGreekM);
           this.rspGreekM = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspGreekMAA);
           this.rspGreekMAA = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspDeltaR);
           this.rspDeltaR = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspDeltaMag);
           this.rspDeltaMag = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspPeriodDays);
           this.rspPeriodDays = String.valueOf(temp);
           
           temp = Double.parseDouble(this.rspNumPeriods);
           this.rspNumPeriods = String.valueOf(temp);
           
           temp = Double.parseDouble(this.logDtSec);
           this.logDtSec = String.valueOf(temp);
           
           temp = Double.parseDouble(this.radius);
           this.radius = String.valueOf(temp);
           
           temp = Double.parseDouble(this.logR);
           this.logR = String.valueOf(temp);
           
           temp = Double.parseDouble(this.vSurfKmS);
           this.vSurfKmS = String.valueOf(temp);
           
           temp = Double.parseDouble(this.vSurfDivEsc);
           this.vSurfDivEsc = String.valueOf(temp);
           
           temp = Double.parseDouble(this.vDivSurf);
           this.vDivSurf = String.valueOf(temp);
           
           temp = Double.parseDouble(this.vDivMax);
           this.vDivMax = String.valueOf(temp);
           
           temp = Double.parseDouble(this.maxAbsVDiv);
           this.maxAbsVDiv = String.valueOf(temp);
           
           temp = Double.parseDouble(this.dtDiv);
           this.dtDiv = String.valueOf(temp);
           
           temp = Double.parseDouble(this.luminosity);
           this.luminosity = String.valueOf(temp);
           
           temp = Double.parseDouble(this.logL);
           this.logL = String.valueOf(temp);
           
           temp = Double.parseDouble(this.effectiveT);
           this.effectiveT = String.valueOf(temp);
           
           temp = Double.parseDouble(this.logG);
           this.logG = String.valueOf(temp);
           
           temp = Double.parseDouble(this.logTeff);
           this.logTeff = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereL);
           this.photosphereL = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereR);
           this.photosphereR = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereT);
           this.photosphereT = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereR);
           this.photosphereR = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereKms);
           this.photosphereKms = String.valueOf(temp);
           
           temp = Double.parseDouble(this.photosphereDivCs);
           this.photosphereDivCs = String.valueOf(temp);   
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
