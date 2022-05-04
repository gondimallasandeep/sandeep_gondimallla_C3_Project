import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        int openTime = this.getCurrentTime().compareTo(this.openingTime);
        int closeTime = this.closingTime.compareTo(this.getCurrentTime());
        if(openTime > 0 && closeTime > 0)
            return true;
        else
            return false;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        menu.add(new Item("Sweet Corn Soup",20));
        menu.add(new Item("Gobi Manjuria",100));
        menu.add(new Item("Baby Corn Manjuria",120));
        menu.add(new Item("Tomato Soup",50));
        menu.add(new Item("Veg Fried Rice",100));
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
