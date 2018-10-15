/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pmart;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Kasuni Gaveshika
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txt_productname;
    
    @FXML
    private Label label;
    @FXML
    private TextField txt_quantity;
    @FXML
    private TextField txt_pricein;
    @FXML
    private TextField txt_priceout;
    @FXML
    private Label label1;
    @FXML
    private Label label11;
    @FXML
    private Label label111;
    
    private Connection con= null;
    private PreparedStatement pst = null;
    
    @FXML
    private void handleAddProduct(ActionEvent event) throws SQLException {
        String sql ="INSERT INTO product (`product_name`, `quantity`, `priceIn`, `priceOut`) VALUES (?,?,?,?)";
       String product_name=txt_productname.getText();
       short quantity = Short.valueOf(txt_quantity.getText());
       double priceIn = Double.valueOf(txt_pricein.getText());
       double priceOut = Double.valueOf(txt_priceout.getText());
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, product_name);
            pst.setShort(2, quantity);
            pst.setDouble(3, priceIn);
            pst.setDouble(4, priceOut);
            
            int i = pst.executeUpdate();
            if(i==1)
                System.out.println("data entered successfully");
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            pst.close();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       con = dba.Dbconnection.pmartConnection(); // TODO
    }    
    
}
