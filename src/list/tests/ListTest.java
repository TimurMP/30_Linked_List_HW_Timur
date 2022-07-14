package list.tests;

import list.interfaces.IList;
import list.model.MyLinkedList;
import org.junit.jupiter.api.Test;


class ListTest {

    @Test
    void test() {
        IList<Integer> list = new MyLinkedList<>();

        System.out.println("Size: "+ list.size());
        list.add(2);
        list.add(7);
        list.add(3);
        list.add(5);
        list.add(null);
        list.add(7);
        System.out.println("Size: "+ list.size());


//
//
        System.out.println(list.get(0));
//        System.out.println(list.get(4));
//        System.out.println("---------");
//        System.out.println(list.indexOf(7));
//        System.out.println(list.indexOf(null));
//
//        System.out.println(list.lastIndexOf(7));
//        System.out.println(list.contains(11));
//        System.out.println(list.isEmpty());
//        System.out.println("---------");
//
//        list.remove((Integer)3);
//        System.out.println(list.contains(3));
//        list.set(4, 11);
//        System.out.println(list.get(4));

//
//        System.out.println("Size after adding elements: "+ list.size());
//
        System.out.println("Iterator:");
        for (Integer element : list) {
            System.out.println(element);

        }
//        System.out.println("=============");
//        System.out.println();
//
//        System.out.println("Size before add(int index, E element): "+ list.size());
//        list.add(6, 2555);
//        list.add(5, null);
//        System.out.println("Size after add(int index, E element): "+ list.size());
//        list.add(7, 1555);
//
//        System.out.println("Iterator:  after add(int index, E element):");
//        for (Integer element : list) {
//            System.out.println(element);
//
//        }
//        System.out.println("=============");
//        System.out.println();

//        System.out.println("Size before clear "+ list.size());
//        list.clear();
//        System.out.println("Size after clear "+ list.size());
//
//
//        list.add(555);
//        list.add(666);
//        list.add(777);
//        list.add(888);
//        System.out.println("New elements after clear: "+ list.size());
//
//        for (Integer element : list) {
//            System.out.println(element);
//
//        }

    }





}