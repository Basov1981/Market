/**
 * Created by ice on 30.06.15.
 */
public class Zvit {
    int sum = 0;
    int sum1 = 0;

    public void dayZvit() {
        for (Produckt tmp : Sklad.goods) {
            for (Order tmp1 : Order.userBasket) {
                if (tmp.name.equals(tmp1.name) && tmp.syzeItem.equals(tmp1.syzeItem) && tmp.manufacture.equals(tmp1.manufacture)) {
                    tmp.items -= tmp1.salesitem;
                    sum += tmp.price * tmp1.salesitem;
                    sum1 += tmp1.price * tmp1.salesitem;
                }
            }

        }
        System.out.println();
//        System.out.println(" Продано товара по отпускным ценам на "+sum+" грн.");
//        System.out.println(" Продано товара по входяшей цене на "+sum1+" грн.");
//        System.out.println();
        System.out.println("Сегодня мы заработали - " + (sum - sum1) + " грн.");
        System.out.println();
    }

}
