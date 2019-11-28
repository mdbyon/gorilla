package com.byon.gorilla.models;

import java.util.HashMap;

class Trie {

    Character val;
    HashMap<Character, Trie> childrenMap;

    /** Initialize your data structure here. */
    public Trie() {
        this.val = '\0';
        this.childrenMap = new HashMap<Character, Trie>();
    }

    public Trie(Character val){
        this.val = val;
        this.childrenMap = new HashMap<Character, Trie>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char [] letters =  word.toCharArray();
        Trie root = this;
        Trie curr = root;

        for(char letter: letters){
            if(!curr.childrenMap.containsKey(letter)){
                curr.childrenMap.put(letter, new Trie(letter));
            }
            curr = curr.childrenMap.get(letter);
        }
        curr.childrenMap.put('*', new Trie('*'));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char [] letters = word.toCharArray();

        Trie curr = this;
        for(Character letter : letters){
            if(!curr.childrenMap.containsKey(letter)) return false;

            curr = curr.childrenMap.get(letter);
        }
        return curr.childrenMap.containsKey('*');
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char [] letters = prefix.toCharArray();
        Trie curr = this;

        for(char letter : letters){
            if(!curr.childrenMap.containsKey(letter)) return false;

            curr = curr.childrenMap.get(letter);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */