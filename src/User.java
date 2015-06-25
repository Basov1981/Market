import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;


public class User implements Comparable<User> {
    static Set<User> usersV = new TreeSet<>();
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
        if (userName.equals("Admin")&& pass == "7777") {
            System.out.println("Все пользователи в базе");
            for (User temp : usersV)
                System.out.println(temp);
        } else System.out.println("\n" + "Для посмотра списка пользователей введите правильное имя и пароль"+"\n");
    }


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
            sName.addAll(Sklad.goods);
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


    public Collection<Produckt> searchPrice(int price, Collection<Produckt> searchPric) {
        Vector<Produckt> sPrice = new Vector<>();
        for (Produckt tmp : searchPric) {
            if (tmp.price == price)
                sPrice.add(tmp);
        }
        if (sPrice.isEmpty()) {
            System.out.println("Что то не так с ценой. Выводим весь товар.");
            sPrice.addAll(Sklad.goods);
        }
        return sPrice;
    }

    @Override
    public int compareTo(User t) {
        int reU = 0;
        boolean flag = !this.userName.equals(t.userName) ||
                !this.userMail.equals(t.userMail);

        if (flag) reU = 1;

        return reU;
    }

}
