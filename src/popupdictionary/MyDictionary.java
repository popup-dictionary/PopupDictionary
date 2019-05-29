/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popupdictionary;

import rita.wordnet.RiWordnet;

/**
 *
 * @author u1950905
 */
public class MyDictionary {
    public MyDictionary()
    {
    }
    public String wordsearch(String word)
    {
        RiWordnet wn = new RiWordnet();
        String pos=wn.getBestPos(word);
        String def = wn.getDescription(word, pos);
        return def;
    }
}