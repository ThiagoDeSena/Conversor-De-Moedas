package Models;

import java.text.DecimalFormat;
import java.util.Currency;

public class ConversaoDeValores {

    private double ars;
    private double bob;
    private double brl;
    private double clp;
    private double cop;
    private double usd;
    private DecimalFormat decimalFormat;
    private Currency currency;


    public ConversaoDeValores(ConversionRates conversionRates) {
        this.ars = conversionRates.conversion_rates().ARS();
        this.bob = conversionRates.conversion_rates().BOB();
        this.brl = conversionRates.conversion_rates().BRL();
        this.clp = conversionRates.conversion_rates().CLP();
        this.cop = conversionRates.conversion_rates().COP();
        this.usd = conversionRates.conversion_rates().USD();
    }

    @Override
    public String toString() {
        return "ConversaoDeValores{" +
                "ars=" + ars +
                ", bob=" + bob +
                ", brl=" + brl +
                ", clp=" + clp +
                ", cop=" + cop +
                ", usd=" + usd +
                '}';
    }

    public double dolarParaPesoAgentino(double usd){
        //usd = ars
        //Xusd = Yars
        //Xusd*ars = usd*Yars  =>  Yars = (Xusd*ars)/usd

        double pesoAgentino = (usd*this.ars)/this.usd;
        return pesoAgentino;
    }

    public double pesoArgentinoParaDolar(double ars){
        //ars = usd
        //Xars = Yusd
        //Xars*usd = ars*Yusd   =>  Yusd = (Xars*usd)/ars
        double dolar = (ars*this.usd)/this.ars;
        return dolar;
    }

    public double dolarParaRealBrasileiro(double usd){
        double realBrasileiro = (usd*this.brl)/this.usd;
        return realBrasileiro;
    }

    public double realBrasileiroParaDolar(double brl){
        double dolar = (brl*this.usd)/this.brl;
        return dolar;
    }

    public double dolarParaPesoColombiano(double usd){
        double pesoColombiano = (usd*this.cop)/this.usd;
        return pesoColombiano;
    }

    public double pesoColombianoParaDolar(double cop){
        double dolar = (cop*this.usd)/this.cop;
        return dolar;
    }


}
