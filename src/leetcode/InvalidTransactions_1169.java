package leetcode;

import java.util.*;

public class InvalidTransactions_1169 {

    private class Transaction {
        public String name;
        public int time;
        public int amount;
        public String city;
        public Transaction(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
    }
    public List<String> invalidTransactions(String[] transactions) {

        Set<String> s = new LinkedHashSet<>();
        HashMap<String, String> transHistory = new HashMap<>();
        Transaction[] transactions1 = new Transaction[transactions.length];
        for(int i=0;  i<transactions.length; i++) {
            String data[] = transactions[i].split(",");
            transactions1[i] = new Transaction(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3]);
        }

        for(int  i=0; i<transactions1.length; i++){
            if(transactions1[i].amount > 1000) {
                s.add(transactions[i]);
                transHistory.put(transactions1[i].name, transactions[i]);
            } else if(!transHistory.containsKey(transactions1[i].name)) {
                transHistory.put(transactions1[i].name, transactions[i]);
            } else if(transHistory.containsKey(transactions1[i].name)){
                int transactionTime = Integer.parseInt(transHistory.get(transactions1[i].name).split(",")[1]);
                String city = transHistory.get(transactions1[i].name).split(",")[3];
                if(!transactions1[i].city.equals(city) && Math.abs(transactions1[i].time-transactionTime) <=60) {
                    s.add(transHistory.get(transactions1[i].name));
                    s.add(transactions[i]);
                    transHistory.remove(transactions1[i].name);
                } else {
                    transHistory.put(transactions1[i].name, transactions[i]);
                }
            }
        }
        return  new ArrayList<>(s);
    }

    public static void main(String[] args) {
        String[] transactions = {"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"};
        System.out.println(new InvalidTransactions_1169().invalidTransactions(transactions));


    }
}
