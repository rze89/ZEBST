
public class ZEBSTItemType implements Comparable {

	protected String name;

	//empty constructor
public ZEBSTItemType(){
	}
public ZEBSTItemType(String name){
	this.name = name;
}
public String getName(){
	//return the name of the item
	return name;
}

public void setName(String name){
	//sets the name of the item
	this.name = name;
}
public int compareToIgnoreCase(ZEBSTItemType zeitemtype){
	//cannot use built into comparetoIgnoreCase method so this compares with the itemType we create
	return getName().compareToIgnoreCase(zeitemtype.getName());
}

public boolean equalsIgnoreCase(ZEBSTItemType zeitemtype) {
	//cannot use built into equalstoIgnoreCase method so this compares with the itemType we create

	return getName().equalsIgnoreCase(zeitemtype.getName());
}
public String toString(){
	return getName();
}
@Override
public int compareTo(Object arg0) {
	return 0;
}
}


