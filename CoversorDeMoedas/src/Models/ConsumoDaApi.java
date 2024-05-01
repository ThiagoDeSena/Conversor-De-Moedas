package Models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class ConsumoDaApi {


    private String senha = "af0a14e5866a8b0677beb0b2";
    private String endereco = "https://v6.exchangerate-api.com/v6/"+senha+"/latest/USD";
    private ConversaoDeValores conversaoDeValores;
    private Locale locale;
    private Currency currency;
    private NumberFormat formatter;

    public void comunicacaoApi(){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response;


            try {
                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();

                String json = response.body();

                ConversionRates conversionRates = gson.fromJson(json,ConversionRates.class);

                conversaoDeValores = new ConversaoDeValores(conversionRates);


            } catch (IOException | InterruptedException e) {
                throw new RuntimeException("Erro 1: "+e.getMessage());
            }catch (Exception e){
                System.out.println("Erro 2: "+e.getMessage());
            }


    }

    public void usdParaArs(double usd){
        double valor = conversaoDeValores.dolarParaPesoAgentino(usd);
        locale = Locale.forLanguageTag("es-AR"); // Define a localidade (espanhol argentino)
        currency = Currency.getInstance("ARS"); // Define a moeda (peso argentino)

        formatter = NumberFormat.getCurrencyInstance(locale);
        String valorFormatado = formatter.format(currency.getNumericCode() + valor); // Adiciona código numérico da moeda

        System.out.println("O valor de "+usd+" [USD] corresponde a um valor final de " + valorFormatado+" [ARS]\n");
    }

    public void arsParaUsd(double ars){
        double valor = conversaoDeValores.pesoArgentinoParaDolar(ars);
        locale = Locale.US; // Define a localidade (USA)
        currency = Currency.getInstance("USD"); // Define a moeda (dolar Americano)

        formatter = NumberFormat.getCurrencyInstance(locale);
        String valorFormatado = formatter.format(currency.getNumericCode() + valor); // Adiciona código numérico da moeda

        System.out.println("O valor de "+ars+" [ARS] corresponde a um valor final de " + valorFormatado+" [USD]\n");
    }

    public void usdParaBrl(double usd){
        double valor = conversaoDeValores.dolarParaRealBrasileiro(usd);
        Locale localeBR = new Locale("pt", "BR"); // Define a localidade (português brasileiro)

        NumberFormat formatter = NumberFormat.getCurrencyInstance(localeBR);
        String valorFormatado = formatter.format(valor);

        System.out.println("O valor de "+usd+" [USD] corresponde a um valor final de " + valorFormatado+" [BRL]\n");
    }

    public void brlParaUsd(double brl){
        double valor = conversaoDeValores.realBrasileiroParaDolar(brl);
        locale = Locale.US; // Define a localidade (USA)
        currency = Currency.getInstance("USD"); // Define a moeda (dolar Americano)

        formatter = NumberFormat.getCurrencyInstance(locale);
        String valorFormatado = formatter.format(currency.getNumericCode() + valor); // Adiciona código numérico da moeda

        System.out.println("O valor de "+brl+" [BRL] corresponde a um valor final de " + valorFormatado+" [USD]\n");
    }

    public void usdParaCop(double usd){
        double valor = conversaoDeValores.dolarParaPesoColombiano(usd);
        locale = new Locale("es", "CO"); // Define locale (Spanish, Colombia)

        formatter = NumberFormat.getCurrencyInstance(locale);
        String valorFormatado = formatter.format(currency.getNumericCode() + valor); // Adiciona código numérico da moeda

        System.out.println("O valor de "+usd+" [USD] corresponde a um valor final de " + valorFormatado+" [COP]\n");
    }

    public void copParaUsd(double cop){
        double valor = conversaoDeValores.pesoColombianoParaDolar(cop);
        locale = Locale.US; // Define a localidade (USA)
        currency = Currency.getInstance("USD"); // Define a moeda (dolar Americano)

        formatter = NumberFormat.getCurrencyInstance(locale);
        String valorFormatado = formatter.format(currency.getNumericCode() + valor); // Adiciona código numérico da moeda

        System.out.println("O valor de "+cop+" [COP] corresponde a um valor final de " + valorFormatado+" [USD]\n");

    }





}
