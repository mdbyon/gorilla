package com.byon.gorilla.models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrieTest {


    @Test
    public void trie_smoke_test(){
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");

        assertFalse(trie.search("apps"));
        assertTrue(trie.search("app"));

    }

}