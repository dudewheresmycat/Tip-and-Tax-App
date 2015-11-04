package tipAndTaxMain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TipAndTaxController {
	private double taxConstant = 0.06;
	private double tipConstant = 0.00;
	private double taxAmount;
	private double tipAmount;
	private double cost;
	

    @FXML
    private Label outputLabel1;
    
    @FXML
    private Label outputLabel3;

    @FXML
    private Label outputLabel2;

    @FXML
    private Label invalidLabel;

    @FXML
    private Button CalculateTotal;

    @FXML
    private TextField userInput;

    @FXML
    private ToggleGroup tips;
    
    @FXML
    private RadioButton checkToAddTip1;

    @FXML
    private RadioButton checkToAddTip2;
 
    @FXML
    private RadioButton checkToAddTip3;
    
    @FXML
    private RadioButton noTip;

    @FXML
    void e80101(ActionEvent event) {

    }
    
    @FXML
    void checkListener(ActionEvent event) {
    	if(checkToAddTip1.isSelected()){
    		tipConstant = 0.20;
    	}else if(checkToAddTip2.isSelected()){
    		tipConstant = 0.15;
    	}else if(checkToAddTip3.isSelected()){
    		tipConstant = 0.10;
    	}else if(noTip.isSelected()){
    		tipConstant = 0.00;
    	}
    }
   


    @FXML
    void buttonListener(ActionEvent event) {
    	invalidLabel.setVisible(false);
    	try{
    		cost = Double.parseDouble(userInput.getText());
    		
    	}catch(NumberFormatException e){
    		invalidLabel.setVisible(true);
    	}
    	
    	// tax
    	taxAmount = cost * taxConstant;
    	String taxOut = String.format("$%,.02f", taxAmount);
    	outputLabel1.setText(taxOut);
    	// tip
    	tipAmount = cost * tipConstant;
    	String tipOut = String.format("$%,.02f", tipAmount);
    	outputLabel2.setText(tipOut);
    	// total
    	double total = cost+taxAmount+tipAmount;
    	String totalOut = String.format("$%,.02f", total);
    	outputLabel3.setText(totalOut);
    }

}
