class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> Max_heap=new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);

            }else{
                hm.put(ch,1);
            }
        }
        Max_heap.addAll(hm.entrySet());
        StringBuilder sb=new StringBuilder();
        while(!Max_heap.isEmpty()){
            Map.Entry<Character,Integer> entry =Max_heap.poll();
            char ch = entry.getKey();
            int freq = entry.getValue();

            while (freq-- > 0) {
                sb.append(ch);
            }
        }

        return sb.toString();

        }
        

        
    }
