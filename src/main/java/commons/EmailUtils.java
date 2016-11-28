package commons;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.junit.Test;

public class EmailUtils {
  
  public static final String MY_EMAIL = "yourEmail@gmail.com";
  public static final String MY_PASSWORD = "your password";
  public static final String FRIEND_EMAIL = "friendEmail@gmail.com";
  
  /**
   * Commons Email là một thư viện Java của Apache liên quan tới Email. Trong thực tế để
   * làm việc với Java Email bạn có thể sử dụng JavaMail API đã được tích hợp sẵn trong JDK6.
   * Commons Email đơn giản chỉ là giúp bạn làm việc với JavaMail API dễ dàng hơn, nó không
   * thay thế cho JavaMail API.
   * */
  
  //----------------------4- Gửi email đơn giản----------------------
  @Test
  public void testSimpleTextEmail() {
    try {
      Email email = new SimpleEmail();
      
      // Cấu hình thông tin Email Server
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
      
      // Với gmail cái này là bắt buộc.
      email.setSSLOnConnect(true);
      
      // Người gửi
      email.setFrom(MY_EMAIL);
      
      // Tiêu đề
      email.setSubject("Test Email");
      
      // Nội dung email
      email.setMsg("This is a test mail ... :-)");
      
      // Người nhận
      email.addTo(FRIEND_EMAIL);
      email.send();
      System.out.println("Sent!!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //----------------------5- Gửi Email có đính kèm----------------------
  
  @Test
  public void testEmailWithAttachment() {
    try {
      // Tạo một đối tượng đính kèm
      EmailAttachment attachment = new EmailAttachment();
      attachment.setPath("C:/mypictures/map-vietnam.png");
      attachment.setDisposition(EmailAttachment.ATTACHMENT);
      attachment.setDescription("Vietnam Map");
      attachment.setName("Map");
      
      // Tạo đối tượng Email
      MultiPartEmail email = new MultiPartEmail();
      
      // Cấu hình
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      email.setSSLOnConnect(true);
      email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
      
      email.setFrom(MY_EMAIL, "TRAN");
      email.addTo(FRIEND_EMAIL, "Hong");
      
      email.setSubject("The Map");
      email.setMsg("Here is the map you wanted");
      
      // Thêm đính kèm
      email.attach(attachment);
      
      // Gửi email
      email.send();
      
      System.out.println("Sent!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * Gửi Email có đính kèm từ một đường dẫn trên mạng
   * */
  @Test
  public void testEmailWithAttachment2() {
    try {
      // Tạo đối tượng đính kèm
      EmailAttachment attachment = new EmailAttachment();
      attachment.setURL(new URL("http://www.apache.org/images/asf_logo_wide.gif"));
      attachment.setDisposition(EmailAttachment.ATTACHMENT);
      attachment.setDescription("Apache logo");
      attachment.setName("Apache logo");
      
      // Tạo đối tượng email
      MultiPartEmail email = new MultiPartEmail();
      
      // Cấu hình
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      email.setSSLOnConnect(true);
      email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
      
      email.setFrom(MY_EMAIL, "TRAN");
      email.addTo(FRIEND_EMAIL, "Hong");
      
      email.setSubject("The logo");
      email.setMsg("Here is Apache's logo");
      
      // Thêm đính kèm
      email.attach(attachment);
      
      // Gửi email
      email.send();
      
      System.out.println("Sent!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //----------------------6- Gửi Email có định dạng HTML----------------------
  @Test
  public void testSendHtmlEmail() {
    try {
      // Tạo đối tượng Email
      HtmlEmail email = new HtmlEmail();
      
      // Cấu hình
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
      email.setSSLOnConnect(true);
      email.setFrom(MY_EMAIL, "TRAN");
      
      // Người nhận
      email.addTo(FRIEND_EMAIL);
      
      // Tiêu đề
      email.setSubject("Test Sending HTML formatted email");
      
      // Nhúng image và lấy ra ID của nội dung (Content-ID)
      URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
      String cid = email.embed(url, "Apache logo");
      
      // Sét nội dung email định dạng HTML.
      email.setHtmlMsg("<html><h2>The apache logo</h2>  <img src=\"cid:" + cid + "\"></html>");
      
      // Thiết lập các thông báo thay thế
      // (Trong trường hợp chương trình đọc mail của người nhận ko hỗ trợ đọc HTML Email)
      email.setTextMsg("Your email client does not support HTML messages");
      
      // Gửi email
      email.send();
      
      System.out.println("Sent!!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //----------------------7- Gửi Email định dạng HTML nhúng thêm ảnh----------------------
  @Test
  public void testSendHtmlEmbedImageEmail() {
    try {
      // Mẫu  nội dung Email gửi đi.
      // Ở đây Img có đường dẫn tương đối  (**)
      String htmlEmailTemplate = "<h2>Hello!</h2>" + "This is Apache Logo <br/>"
          + "<img src='proper/commons-email/images/commons-logo.png'/>";
      
      // Tạo đối tượng Email.
      ImageHtmlEmail email = new ImageHtmlEmail();
      
      // Cấu hình
      email.setHostName("smtp.googlemail.com");
      email.setSmtpPort(465);
      email.setAuthenticator(new DefaultAuthenticator(MY_EMAIL, MY_PASSWORD));
      
      email.setSSLOnConnect(true);
      email.setFrom(MY_EMAIL, "TRAN");
      
      email.addTo(FRIEND_EMAIL);
      email.setSubject("Sending HTML formatted email with embedded images");
      
      // Định nghĩa URL cơ sở để xác định đúng vị trí nguồn dữ liệu (img,..)
      // (Trong trường hợp nó có đường dẫn tương đối, ví dụ Img trên)
      URL url = new URL("http://commons.apache.org");
      
      email.setDataSourceResolver(new DataSourceUrlResolver(url));
      
      // Sét nội dung email
      email.setHtmlMsg(htmlEmailTemplate);
      
      // Sét đặt nội dung thay thế.
      // (Trong trường hợp chương trình đọc email của người nhận ko hỗ trợ HTML).
      email.setTextMsg("Your email client does not support HTML messages");
      
      // Gửi email
      email.send();
      
      System.out.println("Sent!!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
