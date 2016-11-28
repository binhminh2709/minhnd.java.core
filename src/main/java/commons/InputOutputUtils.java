package commons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.Test;

public class InputOutputUtils {
  
  /**http://o7planning.org/web/fe/default/vi/document/9386/huong-dan-su-dung-commons-io*/
  /**
   * http://commons.apache.org/proper/commons-io/javadocs/api-release/org/apache/commons/io/IOUtils.html
   * */
  @Test
  public void testReadURLNormal() throws MalformedURLException, IOException {
    InputStream in = new URL("http://commons.apache.org").openStream();
    try {
      InputStreamReader inR = new InputStreamReader(in);
      BufferedReader buf = new BufferedReader(inR);
      String line;
      while ((line = buf.readLine()) != null) {
        System.out.println(line);
      }
    } finally {
      in.close();
    }
  }
  
  @Test
  public void testReadUtils() throws MalformedURLException, IOException {
    InputStream in = new URL("http://commons.apache.org").openStream();
    try {
      System.out.println(IOUtils.toString(in));
    } finally {
      IOUtils.closeQuietly(in);
    }
  }
  
  /**
   * http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileUtils.html
   * */
  @Test
  public void testReadFileNormal() throws IOException {
    File file = new File("D:/test.txt");
    List<String> lines = FileUtils.readLines(file);
    
    for (String s : lines) {
      System.out.println(s);
    }
  }
  
  @Test
  public void testReadFileUtils() {
    try {
      // E:/test.txt chưa có trên hệ thống.
      File testFile = new File("E:/test.txt");
      
      // Lấy ra thời gian sửa đổi lần cuối của file.
      
      long fileTimestamp = testFile.lastModified();
      System.out.println("Time in milis " + fileTimestamp);
      
      // Sử dụng method touch(...)
      // Nếu file chưa tồn tại nó sẽ tạo ra file rỗng
      // Và thay đổi thời gian sửa lần cuối của file bằng thời gian hiện tại.
      FileUtils.touch(testFile);
      
      System.out.println("Time in milis updated " + testFile.lastModified());
      
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  
  @Test
  public void testCopy() {
    File srcDir = new File("C:/test");
    File destDir = new File("D:/test/abc");
    try {
      FileUtils.copyDirectory(srcDir, destDir);
      //FileUtils.copyFile(srcFile, destFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
  * FilenameUtils ▴
  *	Class FilenameUtils có method hữu ích để làm việc với tên tập tin mà không sử dụng các đối tượng File.
  *	Class này nhằm mục đích phù hợp ở giữa Unix và Windows, để hỗ trợ quá trình chuyển đổi giữa các môi
  *	trường tổng hợp (chẳng hạn như di chuyển từ môi trường lập trình phát triển sang môi trường sản phẩm
  *	hoàn chỉnh).
  *	FilenameUtils javadoc:
  *	http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FilenameUtils.html
  * */
  @Test
  public void testFileName() {
    String filename = "C:/commons/io/../lang/project.xml";
    String normalized = FilenameUtils.normalize(filename);
    System.out.println(normalized);
  }
  
  /**
   *  7-FileSystemUtils ▴
   *  Class FileSystemUtils có các method hữu ích để làm việc với hệ thống tập tin để truy cập vào
   *  các chức năng không được hỗ trợ bởi JDK. Hiện tại, class này mới chỉ có các method để có được
   *  không gian trống trên ổ đĩa. Chú ý là nó sử dụng các lệnh command line.
   *  Không sử dụng mã tự nhiên (native code).
   *  http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileSystemUtils.html
   * */
  @Test
  public void testFileSystemUtilsFreeSpaceKb() {
    try {
      Long kb = FileSystemUtils.freeSpaceKb("C:/");
      System.out.println("Free Space: " + kb + "KB");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * 8-Line iterator 
   * Class org.apache.commons.io.LineIterator Cung cấp một cách linh hoạt để làm việc với một tập tin
   * dựa trên dòng. Một ví dụ có thể được tạo ra trực tiếp, hoặc thông qua các method của FileUtils
   * hoặc IOUtils
   * @throws IOException 
   * */
  @Test
  public void testLineIterator() throws IOException {
    File file = new File("~/minhnd");
    LineIterator it = FileUtils.lineIterator(file, "UTF-8");
    try {
      while (it.hasNext()) {
        String line = it.nextLine();
        // / do something with line
        if (line != null && line.startsWith("##")) {
          System.out.println(line.substring(2));
        }
      }
    } finally {
      LineIterator.closeQuietly(it);
    }
  }
  
  /**
   * 9- File filters (Bộ lọc file)
   * 
   * Package org.apache.commons.io.filefilter định nghĩa ra một interface (IOFileFilter)
   * nó là kết hợp của cả 2 interface  java.io.FileFilter và java.io.FilenameFilter.
   * Bên cạnh đó nó có sẵn một loạt các class triển khai từ IOFileFilter để bạn sẵn sàng
   * sử dụng, và nó cũng có class (FileFilterUtils) tiện dụng cho phép bạn kết hợp các bộ
   * lọc (filters) đó với nhau để tạo ra bộ lọc mới. Chúng được sử dụng để lọc danh sách
   * file theo yêu cầu của bạn hoặc sử dụng trong FileDialog
   * 
   * http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/filefilter/package-summary.html
   * 
   * */
  
  /**
   * java.io.FileFilter có thể được dùng để bạn lọc lấy ra các File theo ý mình trong 1 thư
   * mục nào đó. Nhưng sẽ là tốt hơn nếu bạn sử dụng các class có trong package
   * org.apache.commons.io.filefilter
   * */
  
  @Test
  public void testFileFilter() {
    
    FileFilter filter = new MyFileFilter();
    
    File dir = new File("C:/test");
    
    // Lấy ra danh sách file có phần mở rộng js hoặc css
    File[] list = dir.listFiles(filter);
    
    for (File file : list) {
      System.out.println("File " + file.getAbsolutePath());
    }
  }
  
  //Bộ lọc chấp nhận các file kiểu (*.js , *.css)
  static class MyFileFilter implements FileFilter {
    
    @Override
    public boolean accept(File pathname) {
      String abstractPath = pathname.getAbsolutePath();
      
      if (abstractPath.endsWith(".js") || abstractPath.endsWith(".css")) {
        return true;
      }
      return false;
    }
  }
  
  /**
  * class SuffixFileFilter, nằm trong package org.apache.commons.io.filefilter
  * FileFilterExample2.java
  * HiddenFileFilterExample.java
  * */
  
  @Test
  public void testFileFilter2() {
    File dir = new File("C:/test");
    String[] files = dir.list(HiddenFileFilter.HIDDEN);
    for (int i = 0; i < files.length; i++) {
      System.out.println(files[i]);
    }
  }
  
  @Test
  public void testFileFIlter3() {
    String[] suffixs = new String[] { ".js", ".css" };
    FileFilter filter = new SuffixFileFilter(suffixs);
    
    File dir = new File("C:/test");
    
    // Danh sách các file có phần mở rộng js hoặc css nằm trong thư mục C:/test
    File[] list = dir.listFiles(filter);
    
    for (File file : list) {
      System.out.println("File " + file.getAbsolutePath());
    }
  }
  
  @Test
  public void testCombineTwoFilter() {
    String[] suffixs = new String[] { ".js", ".css" };
    IOFileFilter filter1 = new SuffixFileFilter(suffixs);
    //
    IOFileFilter filter2 = HiddenFileFilter.VISIBLE;
    //
    // Bộ lọc mới chấp nhận các file có đuôi js, css và phải là file không ẩn.
    IOFileFilter newFilter = FileFilterUtils.andFileFilter(filter1, filter2);
    
    File dir = new File("C:/test");
    
    File[] list = dir.listFiles((FileFilter) newFilter);
    
    for (File file : list) {
      System.out.println("File " + file.getAbsolutePath());
    }
  }
  
  /**
   * 10- File comparators (Bộ so sánh File) 
   * Package org.apache.commons.io.comparator cung cấp một số class thi hành interface java.util.Comparator sử dụng để so sánh các đối tượng java.io.File. Các bộ so sánh (comparators) này có thể dùng để sắp xếp danh sách hoặc một mảng các file.
  	http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/comparator/package-summary.html
   * */
  
  @Test
  public void testSizeFileComparator() {
    // Thư mục hiện tại (Thư mục của project)
    File directory = new File(".");
    File[] files = directory.listFiles();
    
    System.out.println("Sap xep mac dinh");
    displayFiles(files);
    
    Arrays.sort(files, SizeFileComparator.SIZE_COMPARATOR);
    System.out.println("\nSizeFileComparator.SIZE_COMPARATOR (Tang dan, thu muc coi nhu kich thuoc bang 0)");
    displayFiles(files);
    
    Arrays.sort(files, SizeFileComparator.SIZE_REVERSE);
    System.out.println("\nSizeFileComparator.SIZE_REVERSE (Giam dan, thu muc coi nhu kich thuoc bang 0)");
    displayFiles(files);
    
    Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_COMPARATOR);
    System.out.println("\nSizeFileComparator.SIZE_SUMDIR_COMPARATOR (Tang dan, su dung kich thuoc thu muc)");
    displayFilesWithDirectorySizes(files);
    
    Arrays.sort(files, SizeFileComparator.SIZE_SUMDIR_REVERSE);
    System.out.println("\nSizeFileComparator.SIZE_SUMDIR_REVERSE (Giam dan, su dung kich thuoc thu muc)");
    displayFilesWithDirectorySizes(files);
  }
  
  public static void displayFiles(File[] files) {
    for (File file : files) {
      System.out.printf("%-20s Size:" + file.length() + "\n", file.getName());
    }
  }
  
  public static void displayFilesWithDirectorySizes(File[] files) {
    for (File file : files) {
      if (file.isDirectory()) {
        System.out.printf("%-20s Size:" + FileUtils.sizeOfDirectory(file) + "\n", file.getName());
      } else {
        System.out.printf("%-20s Size:" + file.length() + "\n", file.getName());
      }
    }
  }
  
  /**
  *	1- Streams (Luồng vào ra dữ liệu) ▴
  *	Package org.apache.commons.io.input và org.apache.commons.io.output chứa một vài các class sử lý vào ra dữ liệu. Chúng bao gồm:
  *	http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/input/package-summary.html
  *	http://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/output/package-summary.html
  * */
}
