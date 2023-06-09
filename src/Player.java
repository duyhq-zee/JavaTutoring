public class Player {
    private String name;
    private float credit;
    private int age;
    private int no;

    private String level;

    public Player(String name, float credit, int age, int no) {
        this.name = name;
        this.credit = credit;
        this.age = age;
        this.no = no;

        calculateLevel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
        calculateLevel();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getLevel() {
        return level;
    }

    public void calculateLevel(){
        if (credit < 1000) {
            level = "Edge";
        } else if (credit < 1500) {
            level = "Common";
        } else if (credit < 2000) {
            level = "Core";
        } else {
            level = "All Star";
        }
    }
}