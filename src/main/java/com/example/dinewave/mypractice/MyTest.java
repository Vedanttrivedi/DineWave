package com.example.dinewave.mypractice;

import java.util.*;

class Demo{
  String s1="hello";
  Demo()
  {
    System.out.println("Demo class");
  }
  public void play(){
    System.out.println("Play Demo");
  }
}

class Sample extends Demo
{

  static
  {
    System.out.println("Static block");
  }

  {
    System.out.println("instance block");
  }
  Sample()
   {
    System.out.println("Sample class");
  }
}

public class MyTest extends Demo
{
  String s1 = "HHH";

  public void play(){
    System.out.println("play mytest");
  }
  public static void main(String[] args) {
//    Demo d = new MyTest();
//    MyTest m1 = new MyTest();
//
//    System.out.println(d.s1);
//    System.out.println(m1.s1);
//
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    list.add(2, 99);
    System.out.println(list);
    List<String> lister = Arrays.asList("A", "B", "C");
    lister.set(1, "D");
    PriorityQueue q;
    System.out.println(lister);
    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    set.add(1);
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(1,1);
    System.out.println(set);

    List<Integer> l1 = new ArrayList<>();
    var iterator = list.iterator();
    var it2 = list.listIterator();
    while (it2.hasNext())
    {
      System.out.println("ITT"+it2.next());
      it2.remove();
    }
    System.out.println("After list "+list);

  }
}
