package util.json;

import javax.annotation.PostConstruct;

import util.FileUtils;

/**
 * $Author: minhnd$ 
 **/
public class JsonMultiFileReader {
  
  private String location;
  private String[] file;
  private int currentFile = 0;
  private JsonReader currentReader;
  
  public JsonMultiFileReader() {
  }
  
  public JsonMultiFileReader(String location) throws Exception {
    this.location = location;
    onInit();
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public void setLocation(String loc) {
    this.location = loc;
  }
  
  @PostConstruct
  public void onInit() throws Exception {
    this.file = FileUtils.findFiles(location, ".*\\.json.*");
  }
  
  public <T> T next(Class<T> type) throws Exception {
    if (currentReader == null && currentFile < file.length) {
      String cfile = file[currentFile++];
      currentReader = new JsonReader(cfile);
    }
    
    if (currentReader == null)
      return null;
    T doc = currentReader.read(type);
    if (doc == null) {
      currentReader.close();
      currentReader = null;
      return next(type);
    }
    return doc;
  }
  
  public void close() throws Exception {
    if (currentReader != null)
      currentReader.close();
  }
}
