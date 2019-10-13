package br.com.codenation;

public class Main {

    public static void main(String[] args) {

        Main obj = new Main();

        System.out.println(obj.soma(8, 7));
        System.out.println(obj.imparPar(8));

        int[] array = {5, 0, 3, 8, 4, 9, 7, 1, 2, 6};
        String[] stringArray = {"Curso Java", "Java Dev", "Menu Array", "Java Array", "Ja-va"};
        String fraseToBeReplaced = "Minha primeira aula.";
        obj.intArrays(array);
        obj.findAndReplace(stringArray);
        obj.printArray(stringArray);
        obj.replaceChar(fraseToBeReplaced);

    }

    public int soma(int number1, int number2) {

        return number1 + number2;

    }

    public boolean imparPar(int number) {

        return number % 2 == 0;

    }

    public void intArrays(int[] array) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 7) {
                System.out.println("Encontrado");
                break;
            }
        }
    }

    public String[] findAndReplace(String[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("Java")) {
                array[i] = array[i].replace("Java", "Codenation");
            }
        }
        return array;
    }

    public void printArray(String[] array){
        for (int i = 0; i < array.length; i++) {
               System.out.println(array[i]);
            }
    }

    public String replaceChar(String frase){

        char[] cFrase = frase.toCharArray();
        String newString = "";

        for (int i = 1; i < cFrase.length; i++) {
            if(i%3==0){
                System.out.println(cFrase[i]);
                newString = newString.concat("AULA1");
            } else {
                newString = newString.concat(Character.toString(cFrase[i]));
            }
        }
        System.out.println(newString);
        return  newString;
    }
}
