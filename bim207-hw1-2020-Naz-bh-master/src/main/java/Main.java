import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    //Betülnaz Hayran-28354853660

    public Main(String fileName, int topN) throws IOException {
        //Complete this constructor

        List<String> list = Arrays.asList((String.valueOf(Files.readAllLines(Paths.get(fileName),
                StandardCharsets.UTF_8)))
                .replaceAll("\\p{Punct}", "").toLowerCase().split("\\s+"));

        System.out.println(list);

        computeAvgLengthByFirstChar(list);

        Set pairs = calculateMinPairDist(list);
    }


    private void computeAvgLengthByFirstChar(List<String> list) {
        //Fill this function

        //I turn it to string
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
            sb.append(", ");
        }
        String str2 = sb.toString();


        // Split the string and store into a List<String>
        List<String> list2 = Arrays.asList(str2.split(",\\s+"));

        // Sort the list
        list2.sort(Comparator.naturalOrder());

        // Use a Map<String, Integer> to store the data
        Map<Character, Double> map = new LinkedHashMap<>();

        for (int i = 0; i < list2.size(); i++) {
            // Get the element and move to the loop counter to the next index
            String element = list2.get(i++);

            double sum = element.length();
            Character ch = element.charAt(0);
            int count = 1;

            // Starting with the next index, iterate the list until you find an element with
            // a different initial letter
            while (i < list2.size() && ch.equals(list2.get(i).charAt(0))) {
                // Add the length of element and move the outer loop counter to the next index
                sum += list2.get(i++).length();
                count++;
            }

            map.put(ch, sum / count);

            // Adjust the the outer loop counter by decrementing by 1
            i--;
        }

        // Display the result
        System.out.println(map);
    }



    private Set calculateMinPairDist(List<String> list) {
        //Fill this function
//        List<String> Token=list;
//        Set Pair = null;
//        for (int i=1;i<=list.size();i++){
//            for (int j=i+1;j<=Token.size();j++){
//                if (Objects.equals(Token.get(i), Token.get(j))) {
//                    continue;
//                }
//                double distance= CalculateTotalDistance(Token.get(i), Token.get(j));
//
//                //Pair+=Pair.add(Pair{Token.get(i), Token.get(j), distance});
//
//            }
//
//        }
//
//        return Pair;
        return null;
    }
//    private double CalculateTotalDistance(String s, String s1){
//
//     return 0 ;
//    }

//    private double getFactor(List<String> list, String term1,String term2){
//        double freq1=0;
//        double freq2=0;
//        double sum=0;
//    for (int i=1;i<=list.size();i++){
//        if (list.get(i)!=term1){
//            continue;
//        }
//        for (int j=i;j<=list.size();j++){
//            if (list.get(j)!=term2){
//                continue;
//            }
//            sum+=j-1;
//            break;
//
//        }
//    }
//
//        return (freq1* freq2)/(1 + Math.log(sum));
//    }



    public static void main(String[] args) throws IOException {
        //private void computeAvgLengthByFirstChar method is here
        new Main(args[0],Integer.parseInt(args[1]));

    }
}

