package wang.mogujun.csdnplus.event;

public class DrawerItemClickEvent {

    private int preIndex;
    private int selectedIndex;

    public DrawerItemClickEvent(int preIndex, int selectedIndex) {
        this.preIndex = preIndex;
        this.selectedIndex = selectedIndex;
    }

    public int getPreIndex() {
        return preIndex;
    }

    public void setPreIndex(int preIndex) {
        this.preIndex = preIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }
}