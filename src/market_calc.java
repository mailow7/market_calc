import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class market_calc {

    public static void main(String[] args) {

        ArrayList<Integer> datalist = new ArrayList();

        try
        {
            FileReader fr = new FileReader("c:\\temp\\WunderFund_data.csv");
            BufferedReader br = new BufferedReader(fr);
            String stringRead= br.readLine();
            stringRead = br.readLine();

            String index;
            Integer foo = 0;

            while( stringRead != null )
            {
                StringTokenizer st = new StringTokenizer(stringRead, ",");
                index = st.nextToken( );


                try {
                    foo = Integer.parseInt(st.nextToken());
                } catch (NumberFormatException e) {
                    //No problem this time, but still it is good practice to care about exceptions.
                    //Never trust user input :)
                    //Do something! Anything to handle the exception.

                }

                datalist.add(foo);
                stringRead = br.readLine();

            }
            br.close( );
        }
        catch(IOException ioe){
            System.out.println(ioe);
        }
int i = 1;
int buy = 0;
int  morecount;
int  amount_buy = 0;
int  amount_sell = 0;
int icount = datalist.size();
int amounts = 0;

        for (Integer item : datalist) { //перебираем все элементы
            morecount = 0; //обнуляем количество следующих элементов больше текущего
            // Берем элемент
            // сравниваем со следующими
            // если есть больше
            // считаем сколько штук
            for(int x = i;x<icount;x++){ //перебераем все последующие элементы
                if(datalist.get(x)>item){ //если элемент больше исследуемого
                    morecount++; // увеличиваем счетчик количества следующих элементов больше текущего
                }
            }
            if(morecount>buy){ // если таких элементов больше чем уже куплено
                buy++; // увеличиваем счетчик покупок
                amount_buy = amount_buy + item; //прибавляем покупку
            }
            else{
                if(item<datalist.get(icount-1)){
                    buy++;
                    amount_buy = amount_buy + item;
                }else {
                    if(buy>0) {
                        buy--;
                        amount_sell = amount_sell + item;
                    }
                }
            }
            //
            // если количество больше чем в буй
            // прибавляем буй
            // ПОКУПАЕМ
            // Если меньше чем в буй
            // проверяем если больше последнего
            // ПОКУПАЕМ
            // если нет больше
            // и буй больше нуля ПРОДАЕМ
            // если есть равно
            //ПРОПУСКАЕМ
            //
i++;
        }
        System.out.println(amount_sell);
        System.out.println(amount_buy);
        System.out.println(datalist.get(icount-1));
        System.out.println(buy);
        System.out.println(buy * datalist.get(icount-1));

        amounts = amount_sell - amount_buy + (buy * datalist.get(icount-1));
        System.out.println(amounts);

    }
}
