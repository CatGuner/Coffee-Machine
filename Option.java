package machine;

public enum Option{
    ESPRESSO("1"),
    LATTE("2"),
    CAPPUCCINO("3"),
    BACK("back");

    private final String action;

    Option(String action) {
        this.action = action;
    }

    public String getAction(){
        return action;
    }

    public static Option findOption(String name){
        for (Option o : values()){
            if (name.equals(o.action))
                return (o);
        }
        return BACK;
    }

}