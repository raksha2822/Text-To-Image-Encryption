
package securityfxml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author ayseg
 */

import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javax.crypto.NoSuchPaddingException;


public class FXMLDocumentController implements Initializable {
    
    List<String> lstFile;
    List<String> lstFile2;
    @FXML
    private Button button;
    
    @FXML
    private ImageView image;

    @FXML
    private Button button2;

    @FXML
    private Label singleFile;
    
    @FXML
    private Label singleFile2;

    @FXML
    private Button button1;

    @FXML
    private void addScene(ActionEvent event)throws IOException{
        Parent view2 = FXMLLoader.load(getClass().getResource("FXMLDocument2.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
        
    }
    
    @FXML
    private void addScene2(ActionEvent event)throws IOException{
        Parent view3 = FXMLLoader.load(getClass().getResource("FXMLDocument3.fxml"));
        Scene scene3 = new Scene(view3);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
        
    }
    @FXML
    void fileChooser(ActionEvent event) {
        FileChooser fchooser = new FileChooser();
        fchooser.getExtensionFilters().add(new ExtensionFilter("Jpg Files", lstFile));
        File f = fchooser.showOpenDialog(null);
        
        if( f != null){
            singleFile.setText(f.getAbsolutePath());
        }
    }
    
    @FXML
    void encryptData(ActionEvent event) {
        try{
            FileInputStream file = new FileInputStream(singleFile.getText());
            FileOutputStream outStream = new FileOutputStream("EncryptedImage.jpg");
            byte k[] = "Cldjı45S5cK3u23".getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
            Alert a1 = new Alert(Alert.AlertType.WARNING);
            a1.setContentText("The JPG file encryption is succesful");
            a1.setHeaderText(null);
            a1.show();
            
        }catch(IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e){
        }
        
    }

    @FXML
    void decryptData(ActionEvent event) {
        try{
            FileInputStream file = new FileInputStream(singleFile.getText());            
            FileOutputStream outStream = new FileOutputStream("DecryptedImage.jpg");
            byte k[] = "Cldjı45S5cK3u23".getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Information DialogBox");
            a2.setContentText("The JPG file decryption is succesful");
            a2.setHeaderText(null);
            a2.show();
            
        }catch(IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e){
        
        }

    }
     @FXML
    void fileChooser2(ActionEvent event) {
        FileChooser fchooser = new FileChooser();
        fchooser.getExtensionFilters().add(new ExtensionFilter("Text Files", lstFile2));
        File f = fchooser.showOpenDialog(null);
        
        if( f != null){
            singleFile2.setText(f.getAbsolutePath());
        }
    }
  
     @FXML
    void encryptText(ActionEvent event) {
         try{
            FileInputStream file = new FileInputStream(singleFile2.getText());
            FileOutputStream outStream = new FileOutputStream("EncryptedText.txt");
            byte k[] = "Cldjı45S5cK3u23".getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.ENCRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
            Alert a1 = new Alert(Alert.AlertType.WARNING);
            a1.setContentText("The TXT file encryption is succesful");
            a1.setHeaderText(null);
            a1.show();
            
        }catch(IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e){
        }
        
    }

    @FXML
    void decryptText(ActionEvent event) {
        try{
            FileInputStream file = new FileInputStream(singleFile2.getText());            
            FileOutputStream outStream = new FileOutputStream("DecryptedText.txt");
            byte k[] = "Cldjı45S5cK3u23".getBytes();
            SecretKeySpec key = new SecretKeySpec(k,"AES");
            Cipher enc = Cipher.getInstance("AES");
            enc.init(Cipher.DECRYPT_MODE, key);
            CipherOutputStream cos = new CipherOutputStream(outStream, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf, 0, read);
            }
            file.close();
            outStream.flush();
            cos.close();
            
            Alert a2 = new Alert(Alert.AlertType.WARNING);
            a2.setTitle("Information DialogBox");
            a2.setContentText("The TXT file decryption is succesful");
            a2.setHeaderText(null);
            a2.show();
            
        }catch(IOException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e){
        
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        lstFile = new ArrayList<>();
        lstFile.add("*.jpg");
        lstFile.add("*.JPG");
        lstFile.add("*.jpeg");
        lstFile.add("*.JPEG");
        lstFile.add("*.png");
        lstFile.add("*.PNG");
        
        lstFile2 = new ArrayList<>();
        lstFile2.add("*.txt");
        lstFile2.add("*.TXT");

    }
}
