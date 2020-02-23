package string;

import java.util.*;

/**
 * Created by joe wang on 2017/4/29.
 */
public class FindBuildOrder {
    /**
     * Each map key is a build target
     * The value of that key is a list of all dependencies of that build target
     */
    private static Map<String, List<String>> dependencies = new HashMap();
    static {
        dependencies.put("A", Arrays.asList("B", "C"));
        dependencies.put("B", Arrays.asList("C", "D"));
        dependencies.put("C", Arrays.asList("D", "E", "F"));
        dependencies.put("J", Arrays.asList("K"));
    }
    //  A
    // |  \
    // B -> C
    // |
    // D


    // example output:
    List<String> exampleOutput =
            Arrays.asList("K", "J", "D", "E", "F", "C", "B", "A");

    /*
     * return a list of all targets in the map, such that
     * 1. each target is built only after all its dependencies
     * 2. each target and dependency is built exactly once
     */
    static Map<String, Boolean> map = new HashMap<String, Boolean>();
    static List<String> result = new ArrayList();

    static List<String> findBuildOrder(Map<String, List<String>> dependencyMap) {
        if (dependencyMap == null || dependencyMap.size() == 0) {
            return null;
        }
        Set<String> keySet = dependencyMap.keySet();
        List<String> keyList = new ArrayList(keySet);
        Collections.sort(keyList);
        for (int i = keyList.size() - 1; i >= 0; i --) {
            String key = keyList.get(i);
            deepFind(dependencyMap, key);
            if (!map.containsKey(key)){
                result.add(key);
                map.put(key, true);
            }
        }
        return result;


    }

    static void deepFind(Map<String, List<String>> dependencyMap, String key) {
        if (!dependencyMap.containsKey(key) && !map.containsKey(key)) {
            map.put(key, true);
            result.add(key);
            return;
        }else if (map.containsKey(key)) {
            return;
        }
        for (String keyInList : dependencyMap.get(key)) {
            deepFind(dependencyMap, keyInList);
            if (!map.containsKey(keyInList)){
                result.add(keyInList);
                map.put(keyInList, true);
            }
        }

    }



    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java 8.");

        // for (String string : strings) {
        //   System.out.println(string);
        // }
        List<String> output = findBuildOrder(dependencies);
        System.out.println(output);
    }
}
