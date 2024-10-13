/*
Given an array of strings strs, group all anagrams together into sublists.
You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 */

import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] string = {"duh","pots","tops","cat","stop","hat","ill"};
        Solution_AG solucao = new Solution_AG();
        System.out.println(solucao.groupAnagrams(string));
    }
}

class Solution_AG {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> resposta = new ArrayList<>();

        HashMap<String, ArrayList<String>> hash = new HashMap<>();

        for(String str: strs){
            int[] lista_de_caracteres = new int[26];
            for(int i = 0; i < str.length(); i++){
                lista_de_caracteres[str.charAt(i) - 'a']++;
            }
            String chave = Arrays.toString(lista_de_caracteres);

            if(!hash.containsKey(chave)){
                ArrayList<String> lista = new ArrayList<>();
                lista.add(str);
                hash.put(chave, lista);
            }else {
                hash.get(chave).add(str);
            }
        }
        for(String i : hash.keySet()){
            resposta.add(hash.get(i));
        }
        return resposta;
    }
}
