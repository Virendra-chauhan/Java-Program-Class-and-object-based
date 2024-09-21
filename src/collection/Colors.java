package collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
    public class Colors {
        private ArrayList<String> colors;

        Colors(){
            colors = new ArrayList<>();
        }

        public void addColors(String color){
            colors.add(color);
            System.out.println("added...\n");
        }

        public void insertColors(int position, String color){
            colors.add(position ,color);
            System.out.println("added...\n");
        }

        public void specificElement(int index){
            System.out.println(colors.get(index)+ "\n");
        }

        public void updateElement(int index , String string){
            colors.set(index, string);
            System.out.println("Updated...\n");
        }

        public void removeElement(int index){
            colors.remove(index);
            System.out.println("removed... \n");
        }

        public void searchElement(String element){
            if (colors.contains(element)){
                System.out.println(element + " color exists.\n");
            }else {
                System.out.println(element + " color does not exists.\n");
            }
        }

        public void sortElements(){
            System.out.println("Before sorting : " + colors);
            Collections.sort(colors);
            System.out.println("After sorting : " + colors + "\n");
        }

        public void copyElements(){
            System.out.println("First Array  List : " + colors);
//     ArrayList<String>  list2 =  (ArrayList<String>) colors.clone();
            ArrayList<String> list2 = new ArrayList<>();
            list2.add("1");
            list2.add("2");
            list2.add("3");
            list2.add("4");
            System.out.println("Second Array List : " + list2);
            Collections.copy(list2, colors);

            System.out.println("New Array List : " + list2);
        }

        public void shuffleElements(){
            System.out.println("Before Shuffle Elements : " + colors);
            Collections.shuffle(colors);
            System.out.println("After Shuffle Elements : " + colors);
        }

        public void reverseElements(){
            System.out.println("Before Reverse Elements : " + colors);
            Collections.reverse(colors);
            System.out.println("After Reverse Elements : " + colors);
        }

        public void extractElements(int num1, int num2){
            System.out.println("Before Extract Elements : " + colors);
            List<String> list1 = colors.subList(num1, num2);

            System.out.println("After Extract Elements : " + list1);
        }

        public void compareLists(){
                ArrayList<String> l1 = new ArrayList<>();
                l1.add("Red");
                l1.add("Yellow");
                l1.add("Black");
                l1.add("White");

                ArrayList<String> l2 = new ArrayList<>();

                for (String s : colors){
                    l2.add(l1.contains(s) ? "yes" : "no");
                }

            System.out.println("First List : " + colors);
            System.out.println("Second List : " + l1);
            System.out.println("Final Result : " + l2);
        }

        public void swapElements(int first, int second){
            System.out.println("Before Swapping : " + colors);
            colors.set(first, colors.set(second, colors.get(first)));
//            Collections.swap(colors, first, second);
            System.out.println("After Swapping : " + colors);

        }

        public void joinLists(){
            ArrayList<String> l1 = new ArrayList<>();

        }


        public void display(){
            System.out.print("Colors : ");
            for (String s : colors){
                System.out.print(s + ", ");
            }
            System.out.println("\n");
        }
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            Colors colors1 = new Colors();

            while(true){
                System.out.println("1. Add Colors.");
                System.out.println("2. Add colors to specific position.");
                System.out.println("3. Retrieve an element.");
                System.out.println("4. Update an element.");
                System.out.println("5. Remove an element.");
                System.out.println("6. Search an element.");
                System.out.println("7. Sort List Elements.");
                System.out.println("8. Copy all Elements into another Array.");
                System.out.println("9. Shuffle Elements.");
                System.out.println("10. Reverse Elements.");
                System.out.println("11. Extract Elements.");
                System.out.println("12. Compare Lists.");
                System.out.println("13. Swap Elements.");
                System.out.println("14. Display All Colors.");
                System.out.println("15. Exit");
                System.out.print("Enter Choice : ");
                int num = sc.nextInt();

                switch (num){

                    case 1 :
                        System.out.print("Enter color Name : ");
                        sc.nextLine();
                        String str = sc.nextLine();
                        colors1.addColors(str);
                        break;

                    case 2 :
                        System.out.print("Enter Position : ");
                        int no = sc.nextInt();
                        System.out.print("Enter color Name : ");
                        sc.nextLine();
                        String str1 = sc.nextLine();
                        colors1.insertColors(no, str1);
                        break;

                    case 3 :
                        System.out.print("Enter index position : ");
                        int index = sc.nextInt();
                        colors1.specificElement(index);
                        break;

                    case 4 :
                        System.out.print("Enter Position : ");
                        int in = sc.nextInt();
                        System.out.print("Enter color Name : ");
                        sc.nextLine();
                        String str2 = sc.nextLine();
                        colors1.updateElement(in, str2);
                        break;

                    case 5 :
                        System.out.print("Enter index position for remove : ");
                        int ind = sc.nextInt();
                        colors1.removeElement(ind);
                        break;

                    case 6 :
                        System.out.print("Enter color Name : ");
                        sc.nextLine();
                        String str11 = sc.nextLine();
                        colors1.searchElement(str11);
                        break;

                    case 7 :
                        colors1.sortElements();
                        break;

                    case 8 :
                        colors1.copyElements();
                        break;

                    case 9 :
                        colors1.shuffleElements();
                        break;

                    case 10 :
                        colors1.reverseElements();
                        break;

                    case 11 :
                        System.out.print("Enter first Position : ");
                        int first = sc.nextInt();
                        System.out.print("Enter last position : ");
                        int last = sc.nextInt();
                        colors1.extractElements(first, last);
                        break;

                    case 12 :
                        colors1.compareLists();
                        break;

                    case 13 :
                        System.out.print("Enter first Position : ");
                        int f = sc.nextInt();
                        System.out.print("Enter second position : ");
                        int s = sc.nextInt();
                        colors1.swapElements(f, s);
                        break;

                    case 14 :
                        colors1.display();
                        break;

                    case 15 :
                        System.out.println("Thank You!");
                        exit(0);
                        break;

                    default :
                        System.out.println("Invalid Choice...");
                }
            }
        }
    }
    
