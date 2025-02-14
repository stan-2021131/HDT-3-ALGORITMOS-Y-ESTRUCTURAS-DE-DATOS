
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class FileControl {

    //Generación de enteros, necesita la cantidad y el rango de los números
    public Integer[] generateNumbers(int cant, int min, int max){
        Integer[] list = new Integer[cant];
        for(int i = 0; i<cant;i++){
            int randNum = ThreadLocalRandom.current().nextInt(min, max+1);
            list[i] = randNum;
        }
        return list;
    }

    //Trae la lista de enteros desde el txt
    @SuppressWarnings("null")
    public Integer[] loadList(String fileName){
        Integer[] list = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if((line = bufferedReader.readLine()) != null){
                String[] data = line.split(" ");
                list = new Integer[data.length];
                for(int i=0; i<data.length; i++){
                    if (data[i].matches("\\d+")) {
                        list[i] = Integer.valueOf(data[i]);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading line: " + e.getMessage());
        }
        return list;
    }


    //Escritura de la lista de enteros en el txt
    public String writeList(String fileName, Integer[] list){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            //Convierte la lista de Integers a una linea de texto, separando con espacios los valores
            String line = Arrays.stream(list).map(String::valueOf).reduce((a, b) -> a + " " + b).orElse("");
            bufferedWriter.write(line);
            return "The list is added to txt";
        } catch (Exception e) {
            System.out.println("Error writing line: " + e.getMessage());
        }
        return "Error adding list";
    }
}
