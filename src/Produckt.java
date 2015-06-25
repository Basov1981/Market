import java.util.Date;

enum Manufacture {
    Галичина, Carlsberg, Оболонь
}

enum Category {
    Пиво, Молочная_продукция
}

enum SyzeItem {
    Пакет_1л, Пакет_0_5л, Бутылка_0_5л, Бутылка_0_33л
}

public class Produckt implements Comparable<Produckt> {
    String name;
    Manufacture manufacture;
    Date dateGreat;
    Category category;
    SyzeItem syzeItem;
    int price;
    int dateFinal;
    int items;

    public Produckt(String name, Manufacture manufacture, Date dateGreat, Category category, SyzeItem syzeItem, int price, int dateFynal, int items) {
        this.name = name;
        this.dateGreat = dateGreat;
        this.manufacture = manufacture;
        this.category = category;
        this.syzeItem = syzeItem;
        this.price = price;
        this.dateFinal = dateFynal;
        this.items = items;
    }


    @Override
    public int compareTo(Produckt t) {
        int res = 0;
        boolean flag = !this.name.equals(t.name) ||
                !this.manufacture.equals(t.manufacture) ||
                t.price != this.price;

        if (flag) res = 1;
        else {
            if (t.items != items) {
                for (int r = 0; r < 1; r++) {
                    int it;
                    it = (t.items += items);
                    items = it;
                }
            } else {
                int it = items;
                for (int r = 0; r < 1; r++) {
                    it += (items) - t.items;
                    items = it;

                }
            }

        }
        return res;
    }

    @Override
    public String toString() {
        return

                " товар - " + name + " " +
                        " производитель - " + manufacture + " " +
                        " дата выпуска - " + dateGreat + " " +
                        " категория - " + category + " " +
                        " упаковка - " + syzeItem + " " +
                        " цена - " + price + " грн.  " +
                        " срок хранения - " + dateFinal + " дней " +
                        " количество - " + items + "\n";

    }
}
