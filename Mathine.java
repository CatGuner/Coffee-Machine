package machine;


class Machine{
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    private boolean checkEmount (int water, int milk, int coffeeBeans){
        return this.water >= water && this.milk >= milk && this.coffeeBeans >= coffeeBeans && this.cups > 0;
    }

    private String status(int water, int milk, int coffeeBeans){
        if (this.water < water){
            return "Sorry, not enough water!\n";
        } else if (this.milk < milk){
            return "Sorry, not enough milk!\n";
        } else if (this.coffeeBeans < coffeeBeans){
            return "Sorry, not enough coffee beans!\n";
        } else if (this.cups == 0){
            return "Sorry, not enough disposable cups!\n";
        } else{
            return "I have enough resources, making you a coffee!\n";
        }
    }

    public Machine(int water, int milk, int coffeeBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    public void buy(Option option){
        switch (option){
            case ESPRESSO:
                System.out.println(status(250, 0, 16));
                if (checkEmount(250, 0, 16)) {
                    this.water -= 250;
                    this.coffeeBeans -= 16;
                    --this.cups;
                    this.money += 4;
                }
                break;
            case LATTE:
                System.out.println(status(350, 75, 20));
                if (checkEmount(350, 75, 20)){
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffeeBeans -= 20;
                    --this.cups;
                    this.money += 7;
                }
                break;
            case CAPPUCCINO:
                System.out.println(status(200, 100, 12));
                if (checkEmount(200, 100, 12)){
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffeeBeans -= 12;
                    --this.cups;
                    this.money += 6;
                }
                break;
            default:
                System.out.println("Error option");
        }

    }

    public void fill(int water, int milk, int coffeeBeans, int cups){
        this.water += water;
        this.milk += milk;
        this.cups += cups;
        this.coffeeBeans += coffeeBeans;
    }

    public void take(){
        System.out.println("I gave you $"+this.money);
        this.money = 0;
    }

    @Override
    public String toString() {
        return  water + " of water\n" +
                milk + " of milk\n" +
                coffeeBeans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money";
    }


}
