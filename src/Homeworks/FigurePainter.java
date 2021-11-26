package Homeworks;

public class FigurePainter {

    public static void main(String[] args) {

//        Գրել կոդ, որը կպատկերի այս եռանկյունը։
//         *
//         *      *
//         *      * *
//         *      * * *
//         *      * * * *

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();

//         * Գրել կոդ, որը կպատկերի այս եռանկյունը։
//         *
//         *              *
//         *            * *
//         *          * * *
//         *        * * * *
//         *
//         * */
        for (int i = 0; i < 5; i++) {
            for (int k = 5; k > i; k--) {
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
//* Գրել կոդ, որը կպատկերի այս եռանկյունը։
//         *
//         *       * * * *
//         *       * * *
//         *       * *
//         *       *
//         *
//         * */
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
//        4,Գրել կոդ, որը կպատկերի այս եռանկյունը։
//         * * * *
//           * * *
//             * *
//               *

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();

        }

        //5,Գրել կոդ, որը կպատկերի այս պատկերը։
//              *
//             * *
//            * * *
//           * * * *
//            * * *
//             * *
//              *
        for (int i = 0; i < 5; i++) {
            for (int k = 5; k > i; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("  ");
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 3; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println();


    }

}
