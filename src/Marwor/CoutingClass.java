package Marwor;

import javax.swing.*;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;

/**
 * Created by HP on 2017-04-04.
 */
public class CoutingClass {
    private double height;
    private double length;
    private double angle;
    private double percent;
    private int ExceptionCounter=0;//if there are 3 or more exception program haven't enough data
    public CoutingClass(String hig,String wid,String ang,String pro){
        try{
            height =parseDouble(hig);
        }
        catch(NullPointerException e){
            height =0;
            ExceptionCounter++;
        }
        catch(NumberFormatException n){
            //nieformatowalny
            ExceptionCounter++;
        }
        try{
            length =parseDouble(wid);
        }
        catch(NullPointerException ex){
            length =0;
            ExceptionCounter++;
        }
        catch(NumberFormatException nu){
            //wyjatek z nieformatowalnym
            ExceptionCounter++;
        }
        try{
            angle =parseDouble(ang);
        }
        catch(NullPointerException exc){
            angle =0;
            ExceptionCounter++;
        }
        catch(NumberFormatException num){
            //wyjatek z niekonwertowalnym wpisem
            ExceptionCounter++;
        }
        try{
            percent =parseDouble(pro);
        }
        catch(NullPointerException exce){
            percent =0;
            ExceptionCounter++;
        }
        catch(NumberFormatException numb){
            //nieformatowalny
            ExceptionCounter++;
        }

    }
    public boolean EnoughData(){
        if(ExceptionCounter>2){
            ExceptionCounter=0;
            return false;
        }
        else{
            ExceptionCounter=0;
            return true;
        }
    }
    public double CountingAngle(){
        if(angle==0){
            if (height!=0&& length !=0){
                angle =toDegrees(atan(height / length));
                return angle;
            }
            if(height!=0&&percent!=0){
                angle=toDegrees(atan(height/(height*100/percent)));
                return angle;
            }
            if(length !=0&&percent!=0){
                angle=toDegrees(atan((length *(percent/100))/ length));
                return angle;
            }

        }
        else{
            return angle;
        }
        return angle;
    }
    public double CountingHeight(){
       if(height==0){
           if(length !=0&&angle!=0){
               angle=toRadians(angle);
               height= length *tan(angle);
               return height;
           }
           if(length !=0&&percent!=0){
               height= length *(percent/100);
               return height;
           }
           if(percent!=0&&angle!=0){
               JOptionPane.showMessageDialog(null, "We need height or length of ramp to count something");
               height=0;
               return height;
           }

       }
       else{
           return height;
       }
        return height;
    }
    public double CountingLength(){
        if(length ==0){
            if(height!=0&&angle!=0){
                length =height/tan(toRadians(angle));
                return length;
            }
            if(height!=0&&percent!=0){
                length =height*100/percent;
                return length;

        }
        else{
            return length;
        }

    }
        return length;
    }
    public double CountingPercent(){
        if(percent==0){
            if(length !=0&&height!=0){
                percent=(height/ length)*100;
                return percent;
            }
            if(length !=0&&angle!=0){
                percent=(tan(toRadians(angle))/ length)*100;
                return percent;
            }
            if(height!=0&&angle!=0){
                percent=(height/(height/tan(toRadians(angle))))*100;
                return percent;
            }
        }
        else{
            return percent;
        }
        return percent;
    }
}
