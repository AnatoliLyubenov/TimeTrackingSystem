package services;

import models.Protocol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class SortMapByKey {
    public static TreeMap<String, ArrayList<Protocol>> getSortedTreeMap(HashMap<String, ArrayList<Protocol>> employeeProtocols){
        TreeMap<String, ArrayList<Protocol>>sortedTreeMap=new TreeMap<String, ArrayList<Protocol>>();
        sortedTreeMap.putAll(employeeProtocols); // copying Map to TreeMap
        return sortedTreeMap;
    }
}
