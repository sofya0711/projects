package Homeworks.Array.DynamicArray;

public class DynamicArray {

    //հիմնական մասիվն է, որի մեջ պահելու ենք ավելացվող էլեմենտները
int[] array = new int[10];

    //մասիվի մեջ ավելացված էլեմենտների քանակը
int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա կանչել extend()
    //և ավելացնել
void add (int value) {
    if (size == array.length) {
        extend();
    }
    array[size++] = value;
}

    private void extend() {
    }

}
