package edu.wpi.teamname.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoanController {

  @FXML private TextField loanAmountInput;
  @FXML private TextField rateInput;
  @FXML private TextField numMonthsInput;
  @FXML private Label paymentLabel;

  @FXML
  private void calcPayment(ActionEvent actionEvent) {
    double loanAmount = Double.parseDouble(loanAmountInput.getText());
    double rate = Double.parseDouble(rateInput.getText());
    double numMonths = Double.parseDouble(numMonthsInput.getText());

    double monthlyPayment = loanAmount * Math.pow((1 + (rate / numMonths)), numMonths) / numMonths;

    paymentLabel.setText(String.format("Monthly Payment: %.2f", monthlyPayment));
  }
}
