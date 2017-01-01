/**
 * Created by Tomas Wändahl on 2016-12-31.
 * All rights reserved.
 * Yeah.
 */

package se.kth.vandahl.project2;

import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;

public class Main {
    public static void main (String[] args) throws Exception {
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        Driver.run(searchEngine);
    }
}
