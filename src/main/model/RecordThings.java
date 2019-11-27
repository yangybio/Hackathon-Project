package model;

import java.io.IOException;

public interface RecordThings {

    //MODIFIES:file
    //EFFECT: record data to file
    public void record(String file) throws IOException;

}
