package com.byon.gorilla.algorithms;

import java.util.*;

public class MeshMessage {

    Map<String, String[]> network = new HashMap<String, String[]>() {{
        put("Min", new String[]{"William", "Jayden", "Omar"});
        put("William", new String[]{"Min", "Noam"});
        put("Jayden", new String[]{"Min", "Amelia", "Ren", "Noam"});
        put("Ren", new String[]{"Jayden", "Omar"});
        put("Amelia", new String[]{"Jayden", "Adam", "Miguel"});
        put("Adam", new String[]{"Amelia", "Miguel", "Sofia", "Lucas"});
        put("Miguel", new String[]{"Amelia", "Adam", "Liam", "Nathan"});
        put("Noam", new String[]{"Nathan", "Jayden", "William"});
        put("Omar", new String[]{"Ren", "Min", "Scott"});
    }};

    public List<String> shortestPathToReceiver(String sender, String receiver) {

        Map<String, String> getOrigin = new HashMap();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        queue.offer(sender);

        boolean canFindPath = false;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            String[] neighbors = network.get(curr);

            for (String neighbor : neighbors) {

                if (!visited.contains(neighbor)) {
                    getOrigin.put(neighbor, curr);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }

                if (neighbor.equals(receiver)) {
                    canFindPath = true;
                }

            }
            if(canFindPath) break;
        }

        if (canFindPath) {
            String currReceiver = receiver;

            while (currReceiver != sender) {
                result.add(0, currReceiver);
                currReceiver = getOrigin.get(currReceiver);
            }

            result.add(0, sender);
        }

        return result;

    }

    public static void main(String[] args) {
        MeshMessage runner = new MeshMessage();
        List<String> result = runner.shortestPathToReceiver("Jayden", "Adam");
        for(String curr : result){
            System.out.println(curr);
        }
    }


}
