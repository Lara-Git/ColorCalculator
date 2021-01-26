package viewcontroller;

import sample.ColorCode;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.Model;

public class Controller
{
    @FXML TextField txt_Red = new TextField();
    @FXML TextField txt_Green = new TextField();
    @FXML TextField txt_Blue = new TextField();
    @FXML Button btn_colorView = new Button();
    @FXML TextField txtf_hexValue = new TextField();

    public void hdl_Absolute(KeyEvent keyEvent)
    {
        String hexCode = Model.getHex();
        TextField txt_Src = (TextField) keyEvent.getSource();

        if (keyEvent.getCode().getCode() >= 48 && keyEvent.getCode().getCode() <= 57) {

            int value = Integer.parseInt(txt_Src.getText());

            if (txt_Src.getId().contains("Red"))
            {
                Model.changeColorViaAbsoluteValue(ColorCode.RED, value);
            }

            else if (txt_Src.getId().contains("Green")) {
                Model.changeColorViaAbsoluteValue(ColorCode.GREEN, value);
            }

            else
                {
                Model.changeColorViaAbsoluteValue(ColorCode.BLUE, value);
            }

            hexCode = Model.getHex();
            changeColorView(hexCode);
        }
    }

    public void hdl_Relative(Event event) {

        Button btn_selected = (Button) event.getSource();
        String op = btn_selected.getText();
        String btnID = btn_selected.getId();

        if (btnID.contains("red"))
        {
            Model.changeColorViaRelativeValue(ColorCode.RED, op);
            txt_Red.setText("" + Model.getRed());
        }

        else if (btnID.contains("green"))
        {
            Model.changeColorViaRelativeValue(ColorCode.GREEN, op);
            txt_Green.setText("" + Model.getGreen());
        }

        else
            {
            Model.changeColorViaRelativeValue(ColorCode.BLUE, op);
            txt_Blue.setText("" + Model.getBlue());
        }

        changeColorView(Model.getHex());
    }

    //For btn_ColorView
    public void changeColorView(String hexCode)
    {
        btn_colorView.setStyle("-fx-background-color: #" + hexCode + ";");
        txtf_hexValue.setText("#" + hexCode);
    }
}