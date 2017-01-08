import java.util.ArrayList;
import java.util.List;

import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;


public class TinySearchEngine implements TinySearchEngineBase {
    public ArrayList<Words> words;

    // Create wordlist upon object-creation
    public TinySearchEngine() {
        words = new ArrayList<Words>();
    }

    @Override
    public void insert(Word word, Attributes attr) {
        // Check if index is currently empty
        if (words.isEmpty()) {
            Words wordToStore = new Words(word.word);
            wordToStore.storeDoc(attr.document);
            words.add(wordToStore);
        } else {
            int index;
            index = findIndex(word.word, words, 0, words.size() - 1);
            // Check if word is currently in the index
            if ((words.get(index).word).equalsIgnoreCase(word.word)) {
                words.get(index).storeDoc(attr.document);
            } else {
                Words wordToStore = new Words(word.word);
                wordToStore.storeDoc(attr.document);
                words.add(index, wordToStore);
            }
        }
    }

    @Override
    public List<Document> search(String string) {
        int index;
        index = searchIndex(string, words, 0, words.size() - 1);

        if (words.get(index).word.equalsIgnoreCase(string)) {
            return words.get(index).getDocs();
        } else {
            return null;
        }
    }

    public int findIndex(String key, ArrayList<Words> words, int lo, int hi) {
        if (hi <= lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = (words.get(mid).word).compareTo(key);
        if (cmp > 0) {
            return findIndex(key, words, lo, mid);
        } else if (cmp < 0) {
            return findIndex(key, words, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public int searchIndex(String key, ArrayList<Words> words, int lo, int hi) {
        if (hi <= lo) {
            return lo - 1;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = (words.get(mid).word).compareTo(key);
        if (cmp > 0) {
            return searchIndex(key, words, lo, mid);
        } else if (cmp < 0) {
            return searchIndex(key, words, mid + 1, hi);
        } else {
            return mid;
        }
    }
}
