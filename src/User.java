import java.util.*;


public class User implements Comparable<User> {
    static Set<User> usersV = new TreeSet<>();
    static ArrayList<Produckt> goodsUser = new ArrayList<>();

    String userName;
    String userPhone;
    String userMail;
    String password;


    public User(String userName, String userFome, String userMail, String password) {
        this.userName = userName;
        this.userPhone = userFome;
        this.userMail = userMail;
        this.password = password;
    }

    public ArrayList<Produckt> getGoodsUser() {
        double nasenka = 1.3;
        for (Produckt tmp : Sklad.goods) {
            tmp.price *= nasenka;
            goodsUser.add(tmp);
        }
        return goodsUser;
    }

    @Override
    public String toString() {
        return "Имя пользователя -'" + userName + '\'' +
                ", телефон пользователя -'" + userPhone + '\'' +
                ", электронная почта -'" + userMail + '\'' +
                ", пароль -" + password + '\'';
    }


    public void addUser(User user) {
        for (User temp : usersV) {
            if (temp.userName.equals(user.userName) && temp.userMail.equals(user.userMail)) {
                System.out.println("Пользователь " + temp.userName + " с электонной почтой - " + temp.userMail + " уже существует ");
                System.out.println();
            }
        }
        usersV.add(user);

    }

    public void reportUser(String userName, String pass) {
        if (userName.equals("Admin") && pass == "7777") {
            System.out.println("Все пользователи в базе");
            {
                for (User temp : usersV) {
                    System.out.println(temp);
                }
            }
        } else System.out.println("\n" + "Для посмотра списка пользователей введите правильное имя и пароль" + "\n");


    }

//    public void reportUser(String userName, String pass) {
//        ArrayList<User>sortUser=new ArrayList<>();
//        if (userName.equals("Admin")&& pass == "7777") {
//            System.out.println("Все пользователи в базе");
//            sortUser.addAll(usersV);}
//        else System.out.println("\n" + "Для посмотра списка пользователей введите правильное имя и пароль"+"\n");
//
//        System.out.println(sortUser);
//        Collections.sort(sortUser, new SortedByName());
//        System.out.println(sortUser);
//    }


    public void reportUserPass(String userName, String password) {
        for (User temp : usersV) {
            if (temp.userName.equals(userName) && temp.password.equals(password)) {
                System.out.println("Ваш логин и пароль");
                System.out.println(temp);
            }
        }
    }

    public void changePass(String userName, String password, String newPass) {
        for (User tmp : usersV) {
            if (tmp.userName.equals(userName) && tmp.password.equals(password)) {
                usersV.remove(tmp);
                tmp.password = newPass;
                usersV.add(tmp);
                System.out.println();
                System.out.println("Пароль пользователя - " + tmp.userName + " был замененен на -" + newPass);
                System.out.println();

            }
        }
    }

    public Collection<Produckt> searchName(String name, Collection<Produckt> searchNam) {
        Vector<Produckt> sName = new Vector<>();
        for (Produckt tmp : searchNam) {
            if (tmp.name.equals(name))
                sName.add(tmp);
        }
        if (sName.isEmpty()) {
            System.out.println("Что то не так с наименованием товара. Выводим весь товар.");
            searchNam.addAll(searchNam);
        }

        return sName;
    }


    public Collection<Produckt> searchCategory(Category category, Collection<Produckt> searchCat) {
        Vector<Produckt> sCategory = new Vector<>();
        for (Produckt tmp : searchCat) {
            if (tmp.category.equals(category))
                sCategory.add(tmp);
        }
        return sCategory;
    }

    public Collection<Produckt> searchPrice(int z, Collection<Produckt> searchPric) {
        ArrayList<Produckt> sPrice = new ArrayList<>();
        for (Produckt tmp : searchPric) {
                sPrice.add(tmp);
        switch (z) {
            case 1:
                Collections.sort(sPrice, new SortedByPrice());
                break;
            case 2:
                Collections.sort(sPrice, new SortedByPrice1());
                break;


        }}
        return sPrice;
    }

//    public Collection<Produckt> searchPrice(int price, Collection<Produckt> searchPric) {
//        Vector<Produckt> sPrice = new Vector<>();
//        for (Produckt tmp : searchPric) {
//            if (tmp.price == price)
//                sPrice.add(tmp);
//        }
//        if (sPrice.isEmpty()) {
//            System.out.println("Что то не так с ценой. Выводим весь товар.");
//            sPrice.addAll(searchPric);
//        }
//
//        return sPrice;
//    }

//    @Override
//    public int compareTo(User t) {
//        int reU = 0;
//        boolean flag = !this.userName.equals(t.userName) ||
//                !this.userMail.equals(t.userMail);
//
//        if (flag) reU = 1;
//
//        return reU;
//    }

        @Override
        public int compareTo (User t){
            return (this.userName.compareTo(t.userName) * this.userMail.compareTo(t.userMail) + this.userPhone.compareTo(t.userPhone));

        }

    }

    //class SortedByName implements Comparator<User> {
//    public int compare(User obj1, User obj2) {
//
//        String str1 = obj1.userName;
//        String str2 = obj2.userName;
//
//        return str1.compareTo(str2);
//    }
//}
    class SortedByPrice implements Comparator<Produckt> {

        public int compare(Produckt t1, Produckt t2) {

            int price1 = t1.price;
            int price2 = t2.price;

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    class SortedByPrice1 implements Comparator<Produckt> {

        public int compare(Produckt t1, Produckt t2) {

            int price1 = t2.price;
            int price2 = t1.price;

            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

