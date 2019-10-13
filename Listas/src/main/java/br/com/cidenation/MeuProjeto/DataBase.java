package br.com.cidenation.MeuProjeto;

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private List<String> names = new ArrayList<>();

    public void addName(String name){
        names.add(name);
    }

    public void printNames2(char letter){
        for(String name : names){
            if(name.charAt(0) == letter){
                System.out.println(name);
            }
        }
    }

    public void printAll(){
        names.forEach(System.out::println);
    }

    public void printNames(char letter){
        names.forEach(item->{
            if(letter == (item.charAt(0))){
                System.out.println(item);
            }
        });
    }

    public void removeFromList(String letter){
        names.removeIf(g -> g.toLowerCase().contains(letter.toLowerCase()));
    }

}
