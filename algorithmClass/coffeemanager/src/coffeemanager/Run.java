package coffeemanager;

import coffeemanager.domain.account.Account;
import coffeemanager.domain.coffee.Coffee;
import coffeemanager.domain.coffee.SeasonCoffee;
import coffeemanager.presentation.Menu;

import java.time.Month;

public class Run {

    public static void main(String[] args) {
        Coffee[] coffees = {
                new Coffee("americano", 1000, 500, 10, 3, 0),
                new Coffee("mocha", 2000, 1000, 10, 3, 0),
                new Coffee("latte", 3000, 1500, 10, 3, 0),
                new Coffee("frupuchino", 4000, 2000, 10, 3, 0),
                new SeasonCoffee("팥빙수", 4500, 2500, 10, 30, 0, new Month[]{Month.MARCH, Month.APRIL})};

        Account.getInstance(100000);
        new Menu(coffees).menu();

    }
}
