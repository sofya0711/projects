package Homeworks.Array;

public class CharArrayClass {
//     1) Ունենք հետևյալ մասիվը՝
//      char[] text = {' ',' ','b','a','r','e','v',' ',' '};
//      Տվյալ օրինակում կարող ենք կամայական քանակի պռաբելներ դնել թե սկզբից թե վերջից չկենտրոնանաք
//      որ երկու հատ է դրված։ Պետք է գրել կոդ, որը text մասիվից կստանա char[] result մասիվ, որը կլինի նույն տեքստը,
//      առանց պռաբելների(իրար կողք կտպի barev)։

    void removeSpace(char[] text) {

        int beginIndex = 0;
        int endIndex = text.length - 1;
        while (beginIndex < endIndex && text[beginIndex] == ' ') {
            beginIndex++;
        }
        while (endIndex > beginIndex && text[endIndex] == ' ') {
            endIndex--;
        }
        char[] result = new char[(endIndex - beginIndex) + 1];
        int index = 0;
        for (int i = beginIndex; i < endIndex + 1; i++) {
            result[index++] = text[i];

        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

        }

//        for (int i = 0; i < text.length; i++) {
//            if (text[i] != ' ') {
//                System.out.print(text[i]);
//            }
//        }
    }


    //      2) Ունենք հետևյալ մասիվը՝
//      char[] bolola = {'b','o','l','o','l','a'};
//      ունենք նաև մի սինվոլ՝ char c = 'o';
//      Պետք է գրել լոգիկա, որը կհաշվի թե քանի հատ կա c-փոփոխականից մեր մասիվի մեջ, ու տպել այդ քանակը։

    void countChar(char[] text) {

        char c = 'o';
        int num = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i] == c) {
                num++;
            }
        }
        System.out.println(num);
    }

    //      3) Ունենք հետևյալ մասիվը՝
//      char[] bolola = {'b','o','l','o','l','a'};
//      պետք է գրել կոդ, որը կտպի մեջտեղի 2 սինվոլները։

    void middleTwoSimbol(char[] text) {

        System.out.print(text[text.length / 2]);
        System.out.println(text[text.length / 2 + 1]);
    }

    //      4) Ունենք հետևյալ մասիվը՝
//      char[] bolola = {'b','o','l','o','l','a'};
//      պետք է տպենք true եթե մեր մասիվը վերջանում է ly-ով, եթե ոչ՝ false

    void lyIsExist(char[] text) {


        if (text[text.length - 1] == 'y' && text[text.length - 2] == 'l') {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    //      5) Ունենք հետևյալ մասիվը՝
//      char[] babola = {'b','a','b','o','l','a'};
    //Տպում ենք true եթե տեքստը պարունակում է bob բառը, բայց o-ի տեղը կարող է լինել ցանկացած սինվոլ։
    //օր․ abcbob → true, b9b -> true, բայց ասենք bac-> false

    void bobExist(char[] text) {

        boolean bob = false;
        for (int i = 0; i < text.length - 2; i++) {
            if (text[i] == 'b' && text[i + 2] == 'b') {
                bob = true;
            }
        }
        System.out.println(bob);
    }
}
