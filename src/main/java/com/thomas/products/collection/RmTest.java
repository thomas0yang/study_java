package com.thomas.products.collection;

import java.util.*;

public class RmTest {
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Item(i, "yangyang" + i));
        }
        System.err.println(list);


        Set<Item> set = new HashSet<>();
        set.add(list.get(0));

        Iterator<Item> iterator = list.iterator();
        while(iterator.hasNext()){
            Item request = (Item)iterator.next();
            if(set.contains(request)) {
                iterator.remove();
            }
            request.setI(request.getI() + 10);
            request.setName(request.getName() + 10);
        }
        System.err.println(list);
    }


    private static class Item{
        private int i;
        private String name;
        public Item(int i, String name) {
            this.i = i;
            this.name = name;
        }

        public int getI() {
            return i;
        }

        public String getName() {
            return name;
        }

        public void setI(int i) {
            this.i = i;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (i != item.i) return false;
            return name != null ? name.equals(item.name) : item.name == null;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "i=" + i +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
